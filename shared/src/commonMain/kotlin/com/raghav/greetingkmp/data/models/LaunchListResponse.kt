package com.raghav.greetingkmp.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LaunchListResponse(
    @SerialName("results")
    val results: List<RocketLaunch>,
)
