package com.example.compose_mp.viewmodel

import com.example.compose_mp.model.Consulta

sealed class UiState_mp {
    object Loading : UiState_mp()
    data class Error(val message: String) : UiState_mp()
    data class Success(val data: List<Consulta>) : UiState_mp()
}
