package com.example.arttestapp.ui.screen2

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.arttestapp.repo.AppRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SecondScreenViewModel @Inject constructor(
    private val repository: AppRepository
): ViewModel() {
    var userAge by mutableStateOf("")
        private set

    fun updateUserAgeValue(newValue: String) {
        userAge = newValue
    }
    fun saveUserAge() = viewModelScope.launch {
        if (userAge.isNotEmpty()) {
            repository.saveUserAge(userAge.toInt())

        }
    }
}