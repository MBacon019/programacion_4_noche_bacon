// ConsultasViewModel_mp.kt — ViewModel + StateFlow · Consultas Médicas
package com.example.compose_mp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.compose_mp.model.Consulta
import com.example.compose_mp.model.consultasDeMuestra
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ConsultasViewModel_mp : ViewModel() {

    private val _consultas = MutableStateFlow<List<Consulta>>(emptyList())
    val consultas: StateFlow<List<Consulta>> = _consultas.asStateFlow()

    private val _busqueda = MutableStateFlow("")
    val busqueda: StateFlow<String> = _busqueda.asStateFlow()

    private val _cargando = MutableStateFlow(false)
    val cargando: StateFlow<Boolean> = _cargando.asStateFlow()

    private val _uiState = MutableStateFlow<UiState_mp>(UiState_mp.Loading)
    val uiState: StateFlow<UiState_mp> = _uiState.asStateFlow()

    private var todasLasConsultas: List<Consulta> = emptyList()

    init { cargarConsultas() }

    fun cargarConsultas(simularError: Boolean = false) {
        viewModelScope.launch {
            _cargando.value = true
            _uiState.value  = UiState_mp.Loading
            delay(800)
            if (simularError) {
                _uiState.value  = UiState_mp.Error("No se pudo conectar con el servidor del hospital")
                _cargando.value = false
            } else {
                todasLasConsultas = consultasDeMuestra
                _consultas.value  = todasLasConsultas
                _uiState.value    = UiState_mp.Success(todasLasConsultas)
                _cargando.value   = false
            }
        }
    }

    fun actualizarBusqueda(query: String) {
        _busqueda.value = query
        val filtered = if (query.isBlank()) {
            todasLasConsultas
        } else {
            todasLasConsultas.filter {
                it.paciente.contains(query, ignoreCase = true) ||
                it.medico.contains(query, ignoreCase = true) ||
                it.especialidad.contains(query, ignoreCase = true)
            }
        }
        _consultas.value = filtered
        if (_uiState.value is UiState_mp.Success) {
            _uiState.value = UiState_mp.Success(filtered)
        }
    }

    fun recargar() { cargarConsultas() }
}
