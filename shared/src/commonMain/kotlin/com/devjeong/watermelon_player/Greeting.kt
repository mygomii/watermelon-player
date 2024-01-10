package com.devjeong.watermelon_player

import kotlinx.coroutines.flow.Flow

class Greeting {
    private val platform: Platform = getPlatform()

    fun greet(): String {
        return "Hello, ${platform.name}!"
    }

    fun test(): Flow<Int> {
        return platform.getFlow()
    }
}