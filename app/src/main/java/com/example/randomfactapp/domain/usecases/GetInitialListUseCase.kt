package com.example.randomfactapp.domain.usecases

import com.example.randomfactapp.domain.models.UiFactModel
import com.example.randomfactapp.domain.room.RandomFactDao
import javax.inject.Inject

class GetInitialListUseCase @Inject constructor(
    private val dao: RandomFactDao
) {
    suspend operator fun invoke(): List<UiFactModel> {
        return dao.getAllFacts()
    }
}