package com.raghav.greetingkmp

import com.raghav.greetingkmp.data.remote.GetSuccessfulLaunch
import com.raghav.greetingkmp.data.remote.httpClient
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlin.random.Random
import kotlin.time.Duration.Companion.seconds

class Greeting(
    private val getSuccessfulLaunch: GetSuccessfulLaunch
) {
    private val platform = getPlatform()

    fun greet(): Flow<String> = flow {
        emit(if (Random.nextBoolean()) "Hi!" else "Hello!")
        delay(1.seconds)
        emit("Guess what is this! > ${platform.name.reversed()}")
        emit(getSuccessfulLaunch.launchPhrase())
    }
}
