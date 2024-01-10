package com.devjeong.watermelon_player.presentaions

import com.devjeong.watermelon_player.player.CommonMusicPlayer
import com.devjeong.watermelon_player.presentations.MusicListViewModel
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class MusicListPresenter() : KoinComponent {
    private val musicListViewModel: MusicListViewModel by inject()
    private val commonMusicPlayer: CommonMusicPlayer by inject()

    fun getList() {
        musicListViewModel.musicList.value
    }
    fun play() {
        commonMusicPlayer.play()
    }

}