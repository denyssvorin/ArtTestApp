package com.example.arttestapp.datastore

import android.content.Context
import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

// At the top level of your kotlin file:
val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

data class UserPreferences(val name: String, val age: Int)
@Singleton
class PreferencesManager @Inject constructor(@ApplicationContext private val context: Context) {

    val savedUserData = context.dataStore.data
        .catch { exception ->
            if(exception is IOException) {
                Log.e("TAG", "Error message ${exception.message}")
                emit(emptyPreferences())
            } else {
                throw exception
            }
        }
        .map { preferences: Preferences ->
            val userName = preferences[NAME_KEY] ?: "name"
            val userAge = preferences[AGE_KEY] ?: 0
            UserPreferences(userName, userAge)
        }

    suspend fun saveUserName(newValue: String) {
        context.dataStore.edit { settings ->
            settings[NAME_KEY] = newValue
        }
    }

    suspend fun saveUserAge(newValue: Int) {
        context.dataStore.edit { settings ->
            settings[AGE_KEY] = newValue
        }
    }

    companion object PrefKeys {
        val NAME_KEY = stringPreferencesKey("NAME_KEY")
        val AGE_KEY = intPreferencesKey("AGE_KEY")
    }
}