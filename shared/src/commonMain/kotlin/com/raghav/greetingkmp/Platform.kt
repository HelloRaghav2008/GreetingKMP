package com.raghav.greetingkmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform