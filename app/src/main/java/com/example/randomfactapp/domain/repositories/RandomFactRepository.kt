package com.example.randomfactapp.domain.repositories

import com.example.randomfactapp.api.GenericResponse
import com.example.randomfactapp.api.RandomFactService
import com.example.randomfactapp.api.models.ApiRandomFactResponse
import javax.inject.Inject

class RandomFactRepository @Inject constructor(
    private val randomFactService: RandomFactService
) {
    suspend fun getFactByNumber(number: Long): GenericResponse<ApiRandomFactResponse> {
        return randomFactService.getAskedFact(number)
    }

    suspend fun getRandomFact(): GenericResponse<ApiRandomFactResponse> {
        return randomFactService.getRandomFact()
    }
}