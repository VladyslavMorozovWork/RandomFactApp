package com.example.randomfactapp.api

import com.example.randomfactapp.api.models.ApiResponse
import com.example.randomfactapp.api.models.ApiRandomFactResponse
import retrofit2.http.GET
import retrofit2.http.Path

typealias GenericResponse<S> = ApiResponse<S, Unit>

interface RandomFactService {
    @GET("/{number}?json")
    suspend fun getAskedFact(
        @Path("number") number: Long
    ): GenericResponse<ApiRandomFactResponse>

    @GET("/random/math?json")
    suspend fun getRandomFact(): GenericResponse<ApiRandomFactResponse>
}