package com.example.arttestapp.ui.screen3

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.arttestapp.datastore.UserPreferences
import com.example.arttestapp.repo.AppRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ThirdScreenViewModel @Inject constructor(
    private val repository: AppRepository
) : ViewModel() {
    private val _userPreferences = repository.userPreferences
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(), UserPreferences("name", 0))

    val userPreferences: StateFlow<UserPreferences> = _userPreferences
}