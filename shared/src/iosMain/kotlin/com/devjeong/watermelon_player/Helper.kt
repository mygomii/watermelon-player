package com.devjeong.watermelon_player

import com.devjeong.watermelon_player.di.appModule
import com.devjeong.watermelon_player.di.iosViewModelModule
import org.koin.core.context.startKoin

fun initKoin() {
    val koinApp = startKoin {
        modules(appModule() + iosViewModelModule)
    }.koin
}