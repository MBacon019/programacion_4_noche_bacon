package com.example.compose.viewmodel

import com.example.catalogo.model.Producto

sealed class UiState {
    object Loading : UiState()
    data class Error(val message: String) : UiState()
    data class Success(val data: List<Producto>) : UiState()
}
