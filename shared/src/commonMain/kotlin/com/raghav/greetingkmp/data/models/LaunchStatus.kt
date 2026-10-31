package com.raghav.greetingkmp.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LaunchStatus(
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String,
)
