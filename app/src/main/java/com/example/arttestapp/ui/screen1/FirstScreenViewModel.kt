package com.example.arttestapp.ui.screen1

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.arttestapp.repo.AppRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FirstScreenViewModel @Inject constructor(
    private val repository: AppRepository
): ViewModel() {

    var userName by mutableStateOf("")
        private set

    fun updateUserNameValue(newValue: String) {
        userName = newValue
    }
    fun saveUserName() = viewModelScope.launch {
        repository.saveUserName(userName)
    }
}