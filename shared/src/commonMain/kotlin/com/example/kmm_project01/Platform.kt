package com.example.kmm_project01

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform