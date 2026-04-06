package com.example.blackonyx

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform