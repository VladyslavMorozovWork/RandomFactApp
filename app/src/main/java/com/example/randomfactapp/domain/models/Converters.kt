package com.example.randomfactapp.domain.models

import com.example.randomfactapp.api.models.ApiRandomFactResponse

fun ApiRandomFactResponse.toUiModel(): UiFactModel {
    return UiFactModel(
        factText = text,
        number = number,
        isFound = isFound
    )
}