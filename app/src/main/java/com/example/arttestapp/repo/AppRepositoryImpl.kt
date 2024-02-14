package com.example.arttestapp.repo

import com.example.arttestapp.datastore.PreferencesManager
import com.example.arttestapp.datastore.UserPreferences
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AppRepositoryImpl @Inject constructor(
    private val preferencesManager: PreferencesManager
) : AppRepository {

    private val _userPreferencesFlow: Flow<UserPreferences> = preferencesManager.savedUserData
    override val userPreferences: Flow<UserPreferences>
        get() = _userPreferencesFlow

    override suspend fun saveUserName(userName: String) {
        preferencesManager.saveUserName(userName)
    }

    override suspend fun saveUserAge(userAge: Int) {
        preferencesManager.saveUserAge(userAge)
    }
}