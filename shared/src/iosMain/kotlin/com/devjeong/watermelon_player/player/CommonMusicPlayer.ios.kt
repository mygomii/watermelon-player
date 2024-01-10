package com.devjeong.watermelon_player.player

import com.devjeong.watermelon_player.models.Music
import kotlinx.cinterop.ExperimentalForeignApi
import platform.AVFAudio.AVAudioSession
import platform.AVFAudio.AVAudioSessionCategoryPlayback
import platform.AVFAudio.setActive
import platform.AVFoundation.AVPlayer
import platform.AVFoundation.AVPlayerItem
import platform.AVFoundation.pause
import platform.AVFoundation.play
import platform.AVFoundation.replaceCurrentItemWithPlayerItem
import platform.Foundation.NSURL

actual class CommonMusicPlayer actual constructor() {
    private val playerItems = mutableListOf<AVPlayerItem>()
    private val avAudioPlayer: AVPlayer = AVPlayer()

    init {
        val music = getMusic()
        playerItems.add(0, AVPlayerItem(uRL = NSURL.URLWithString(URLString = music.streamUrl)!!))
        setUpAudioSession()
    }
    @OptIn(ExperimentalForeignApi::class)
    private fun setUpAudioSession() {
        try {
            val audioSession = AVAudioSession.sharedInstance()
            audioSession.setCategory(AVAudioSessionCategoryPlayback, null)
            audioSession.setActive(true, null)
        } catch (e: Exception) {
            println("Error setting up audio session: ${e.message}")
        }
    }

    actual fun play() {
        val playItem = playerItems[0]
        avAudioPlayer.replaceCurrentItemWithPlayerItem(playItem)
        avAudioPlayer.play()
        print("###### play() ${avAudioPlayer.status}")
    }

    actual fun pause() {
        avAudioPlayer.pause()
    }

    actual fun next() {
    }

    actual fun prev() {
    }

    actual fun play(songIndex: Int) {
    }

    actual fun seekTo(time: Long) {
    }

    actual fun addSongsUrls(songsUrl: List<String>) {

    }

    actual fun cleanUp() {
    }

    actual fun isPlaying(): Boolean {
        return false // TEST;
    }


    private fun getMusic(): Music {
        return Music(
            id = 1,
            title = "Thinkin About You (Radio Edit)",
            artists = "Setze",
            imgUrl = "1.jpeg",
            streamUrl = "https://cdn.pixabay.com/download/audio/2022/12/13/audio_a7eaf8e68b.mp3",
            duration = 1000000,
            createdAt = "2024.01.09",
            like = false
        )
    }

}