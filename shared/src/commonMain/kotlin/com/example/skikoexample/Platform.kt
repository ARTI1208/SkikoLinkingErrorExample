package com.example.skikoexample

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform