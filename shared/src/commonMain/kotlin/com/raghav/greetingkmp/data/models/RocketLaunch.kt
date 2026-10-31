package com.raghav.greetingkmp.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RocketLaunch(
    @SerialName("id")
    val id: String,
    @SerialName("name")
    val missionName: String,
    @SerialName("net")
    val launchDateUtc: String,
    @SerialName("status")
    val status: LaunchStatus,
)
