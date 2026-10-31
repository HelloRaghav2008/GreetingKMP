package com.raghav.greetingkmp.di

import com.raghav.greetingkmp.Greeting
import com.raghav.greetingkmp.data.remote.GetSuccessfulLaunch
import com.raghav.greetingkmp.data.remote.httpClient
import io.ktor.client.*
import org.koin.dsl.module
import org.koin.plugin.module.dsl.single

val appModule = module {
    single<HttpClient> { httpClient() }
    single<GetSuccessfulLaunch>()
    single<Greeting>()
}
