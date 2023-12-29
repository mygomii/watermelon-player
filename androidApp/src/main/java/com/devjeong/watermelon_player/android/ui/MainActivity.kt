package com.devjeong.watermelon_player.android.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.devjeong.watermelon_player.android.MyApplicationTheme
import com.devjeong.watermelon_player.android.ui.presentations.player.PlayerScreen
import com.devjeong.watermelon_player.android.ui.presentations.playlist.PlayListScreen
import com.devjeong.watermelon_player.presentations.MusicListViewModel
import org.koin.androidx.compose.get

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MusicRoot()
                }
            }
        }
    }
}

@Composable
fun MusicRoot() {
    val navController = rememberNavController()
    val musicListViewModel: MusicListViewModel = get()

    NavHost(
        navController = navController,
        startDestination = "lazyColumnSample"
    ) {
        composable(
            "lazyColumnSample"
        ) {
            PlayListScreen(navController, musicListViewModel)
        }
        composable(
            "PlayerScreen/{musicId}",
            arguments = listOf(navArgument("musicId") { type = NavType.IntType })
        ) { backStackEntry ->
            val musicId = backStackEntry.arguments?.getInt("musicId") ?: -1
            PlayerScreen(navController, musicListViewModel, musicId)
        }
    }
}