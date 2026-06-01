
package com.example.compose.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.catalogo.model.Producto
import com.example.catalogo.model.productosDeMuestra
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ProductosViewModel : ViewModel() {

    private val _productos = MutableStateFlow<List<Producto>>(emptyList())
    val productos: StateFlow<List<Producto>> = _productos.asStateFlow()

    private val _busqueda = MutableStateFlow("")
    val busqueda: StateFlow<String> = _busqueda.asStateFlow()

    private val _cargando = MutableStateFlow(false)
    val cargando: StateFlow<Boolean> = _cargando.asStateFlow()

    private val _uiState = MutableStateFlow<UiState>(UiState.Loading)
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    private var todosLosProductos: List<Producto> = emptyList()

    init {
        cargarProductos()
    }

    fun cargarProductos(simularError: Boolean = false) {
        viewModelScope.launch {
            _cargando.value = true
            _uiState.value = UiState.Loading
            delay(800)
            if (simularError) {
                _uiState.value = UiState.Error("No se pudo conectar al servidor")
                _cargando.value = false
            } else {
                todosLosProductos = productosDeMuestra
                _productos.value = todosLosProductos
                _uiState.value = UiState.Success(todosLosProductos)
                _cargando.value = false
            }
        }
    }

    fun actualizarBusqueda(query: String) {
        _busqueda.value = query
        val filtered = if (query.isBlank()) {
            todosLosProductos
        } else {
            todosLosProductos.filter {
                it.nombre.contains(query, ignoreCase = true) ||
                        it.categoria.contains(query, ignoreCase = true)
            }
        }
        _productos.value = filtered
        if (_uiState.value is UiState.Success) {
            _uiState.value = UiState.Success(filtered)
        }
    }

    fun recargar() { cargarProductos() }
}
