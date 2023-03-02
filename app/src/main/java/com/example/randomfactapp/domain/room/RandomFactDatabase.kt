package com.example.randomfactapp.domain.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.randomfactapp.domain.models.UiFactModel

@Database(
    entities = [UiFactModel::class],
    version = 1
)
abstract class RandomFactDatabase : RoomDatabase() {
    abstract fun RandomFactDao(): RandomFactDao
}