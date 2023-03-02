package com.example.randomfactapp.domain.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.example.randomfactapp.domain.models.UiFactModel

@Dao
interface RandomFactDao {
    @Insert(onConflict = REPLACE)
    suspend fun insertFacts(factsList: List<UiFactModel>)

    @Insert(onConflict = REPLACE)
    suspend fun insertFact(fact: UiFactModel)

    @Query("SELECT * FROM UiFactModel")
    suspend fun getAllFacts(): List<UiFactModel>

    @Query("DELETE FROM UiFactModel")
    suspend fun nukeTable()
}