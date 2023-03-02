package com.example.randomfactapp.api.models

import com.google.gson.annotations.SerializedName

data class ApiRandomFactResponse(
    @SerializedName("text")
    val text: String,
    @SerializedName("number")
    val number: Long,
    @SerializedName("found")
    val isFound: Boolean
)