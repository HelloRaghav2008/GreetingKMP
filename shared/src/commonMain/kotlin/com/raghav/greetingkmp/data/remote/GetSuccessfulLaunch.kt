package com.raghav.greetingkmp.data.remote

import com.raghav.greetingkmp.data.models.LaunchListResponse
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import kotlin.time.Instant

class GetSuccessfulLaunch(
    private val httpClient: HttpClient,
) {
    suspend fun getDateOfLastSuccessfulLaunch(): String {
        val response: LaunchListResponse =
            httpClient.get(urlString = "https://lldev.thespacedevs.com/2.3.0/launches/previous/?mode=list&limit=10&format=json")
                .body()

        val lastSuccessLaunch = response.results.first { it.status.id == 3 }
        val date = Instant.parse(lastSuccessLaunch.launchDateUtc).toLocalDateTime(TimeZone.currentSystemDefault())
        return "${date.month} ${date.day}, ${date.year}"
    }
    suspend fun launchPhrase(): String =
        try {
            "The last successful launch was on ${getDateOfLastSuccessfulLaunch()} 🚀"
        } catch (e: Exception) {
            println("Exception during getting the date of the last successful launch $e")
            "Error occurred"
        }
}