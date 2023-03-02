package com.example.randomfactapp.domain.usecases

import com.example.randomfactapp.api.models.ApiResponse
import com.example.randomfactapp.domain.models.UiFactModel
import com.example.randomfactapp.domain.models.toUiModel
import com.example.randomfactapp.domain.repositories.RandomFactRepository
import com.example.randomfactapp.domain.room.RandomFactDao
import javax.inject.Inject

class GetRandomFactUseCase @Inject constructor(
    private val randomFactRepository: RandomFactRepository,
    private val randomFactDao: RandomFactDao
) {
    suspend operator fun invoke(typeOfCall: TypeOfCall): RandomFactApiResponse {
        val randomFactResponse = when (typeOfCall) {
            is TypeOfCall.CallByNumber -> {
                randomFactRepository.getFactByNumber(typeOfCall.number)
            }
            TypeOfCall.RandomNumberCall -> {
                randomFactRepository.getRandomFact()
            }
        }
        when (randomFactResponse) {
            is ApiResponse.Error.ApiError -> {
                return RandomFactApiResponse.Error
            }
            is ApiResponse.Error.NetworkError -> {
                return RandomFactApiResponse.NetworkError
            }
            is ApiResponse.Error.UnknownError -> {
                return RandomFactApiResponse.NetworkError
            }
            is ApiResponse.Success -> {
                randomFactDao.insertFact(randomFactResponse.body.toUiModel())
                val daoList = randomFactDao.getAllFacts()
                return RandomFactApiResponse.Success(daoList)
            }
        }
    }
}


sealed class RandomFactApiResponse {
    data class Success(val factList: List<UiFactModel>) : RandomFactApiResponse()
    object Error : RandomFactApiResponse()
    object NetworkError : RandomFactApiResponse()
}

sealed class TypeOfCall {
    data class CallByNumber(val number: Long) : TypeOfCall()
    object RandomNumberCall : TypeOfCall()
}
