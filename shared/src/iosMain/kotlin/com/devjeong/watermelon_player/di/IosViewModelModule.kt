package com.devjeong.watermelon_player.di

import com.devjeong.watermelon_player.player.CommonMusicPlayer
import com.devjeong.watermelon_player.presentaions.MusicListPresenter
import org.koin.dsl.module

val iosViewModelModule = module {
    single { CommonMusicPlayer() }
    single { MusicListPresenter() }
}