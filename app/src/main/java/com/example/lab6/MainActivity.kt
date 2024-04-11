package com.example.lab6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.media3.exoplayer.ExoPlayer
import com.example.lab6.views.AVScreenViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val audioPlayer = ExoPlayer.Builder(this).build()
        val videoPlayer = ExoPlayer.Builder(this).build()

        val avViewModel : AVScreenViewModel by viewModels<AVScreenViewModel>()

        avViewModel.videoExoPlayer = videoPlayer
        avViewModel.radioExoPlayer = audioPlayer

        super.onCreate(savedInstanceState)

        setContent {
            AVScreen(name = "AV", avViewModel)
        }
    }
}
