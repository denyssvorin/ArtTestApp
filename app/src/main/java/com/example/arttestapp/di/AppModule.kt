package com.example.arttestapp.di

import android.content.Context
import com.example.arttestapp.datastore.PreferencesManager
import com.example.arttestapp.repo.AppRepository
import com.example.arttestapp.repo.AppRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideRepository(preferencesManager: PreferencesManager): AppRepository =
        AppRepositoryImpl(preferencesManager)
}