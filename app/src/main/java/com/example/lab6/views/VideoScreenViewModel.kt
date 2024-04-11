package com.example.lab6.views

import androidx.lifecycle.ViewModel
import androidx.media3.common.MediaItem
import androidx.media3.common.MediaItem.fromUri
import androidx.media3.exoplayer.ExoPlayer

class VideoScreenViewModel : ViewModel() {

    lateinit var player: ExoPlayer

    val mediaItem = MediaItem.fromUri("https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4")

    fun videoSetUp(){
        player.setMediaItem(mediaItem)
        player.prepare()
    }

    fun videoPlay(){
        player.play()
    }

    fun videoPause() {
        player.pause()
    }

    fun videoStop() {
        player.stop()
    }
}
