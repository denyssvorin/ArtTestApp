package com.example.arttestapp.repo

import com.example.arttestapp.datastore.UserPreferences
import kotlinx.coroutines.flow.Flow

interface AppRepository {
    suspend fun saveUserName(userName: String)
    suspend fun saveUserAge(userAge: Int)
    val userPreferences: Flow<UserPreferences>
}