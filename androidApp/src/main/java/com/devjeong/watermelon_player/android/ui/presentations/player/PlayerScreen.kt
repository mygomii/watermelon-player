package com.devjeong.watermelon_player.android.ui.presentations.player

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.devjeong.watermelon_player.android.ui.presentations.player.components.ContentImage
import com.devjeong.watermelon_player.android.ui.presentations.player.components.CurrentTimeTextField
import com.devjeong.watermelon_player.android.ui.presentations.player.components.CustomProgressBar
import com.devjeong.watermelon_player.android.ui.presentations.player.components.CustomTopAppBar
import com.devjeong.watermelon_player.android.ui.presentations.player.components.LikeButton
import com.devjeong.watermelon_player.android.ui.presentations.player.components.MusicControlButtons
import com.devjeong.watermelon_player.android.ui.presentations.player.components.SongInfo
import com.devjeong.watermelon_player.android.ui.presentations.playlist.PlayListViewModel

@Composable
fun PlayerScreen(
    navController: NavController,
    playListViewModel: PlayListViewModel,
    musicId: Int
) {
    val music = playListViewModel.musicListViewModel.findMusicById(musicId)


    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp)
    ) {
        CustomTopAppBar(navController)

        ContentImage(imageResId = music!!.imgUrl)

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 36.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            SongInfo(title = music.title, artist = music.artists)
            LikeButton(
                initialIsLiked = music.like,
                onClick = { newLikeStatus ->
                    playListViewModel.musicListViewModel.toggleMusicLike(music.id)
                }
            )
        }

        Box(
            modifier = Modifier
                .padding(top = 24.dp)
                .fillMaxWidth()
                .background(Color.LightGray)
                .height(4.dp)
        ) {
            CustomProgressBar(0.5f, "0:33", music.duration)
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            CurrentTimeTextField("00:32", music.duration)
        }
        MusicControlButtons()
    }
}