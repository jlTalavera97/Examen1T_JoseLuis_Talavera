package com.example.examen1t


import androidx.lifecycle.ViewModel
import com.example.examen1t.ui.theme.ExamenUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


class ExamenViewModel: ViewModel() {

    //estado UI. Esta variable solo es accesible desde dentro del ViewModel
    private val _uiState = MutableStateFlow(ExamenUiState())
    //Esta variable de solo lectura puede ser accedida por la IU
    val uiState: StateFlow<ExamenUiState> = _uiState.asStateFlow()

    fun updateName(name: String){
        _uiState.update { currentState ->
            currentState.copy(
                name = name
            )
        }
    }

    fun updateSurname(surname: String){
        _uiState.update { currentState ->
            currentState.copy(
                surname = surname
            )
        }
    }

    fun updateAge(age: Int){
        _uiState.update { currentState ->
            currentState.copy(
                age = age
            )
        }
    }

    fun updateBirthLocation(birthLocation: String){
        _uiState.update { currentState ->
            currentState.copy(
                birthLocation = birthLocation
            )
        }
    }


}