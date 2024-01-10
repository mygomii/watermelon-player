package com.devjeong.watermelon_player

import com.devjeong.watermelon_player.core.domain.util.toCommonFlow
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

interface Platform {
    val name: String

    // TEST;

    fun getFlow(): Flow<Int> = flow {
        (1..10).forEach {
            delay(500)
            emit(it)
        }
    }

    fun getCommonFlow() = getFlow().toCommonFlow()
}

expect fun getPlatform(): Platform