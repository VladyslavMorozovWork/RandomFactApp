package com.example.randomfactapp.di

import android.content.Context
import androidx.room.Room
import com.example.randomfactapp.domain.room.RandomFactDao
import com.example.randomfactapp.domain.room.RandomFactDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {
    @Provides
    fun provideDao(randomFactDatabase: RandomFactDatabase): RandomFactDao {
        return randomFactDatabase.RandomFactDao()
    }

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext applicationContext: Context): RandomFactDatabase {
        return Room.databaseBuilder(
            applicationContext,
            RandomFactDatabase::class.java,
            "RandomFactDb"
        ).build()
    }
}