package com.example.lab6.views

import androidx.lifecycle.ViewModel
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import com.example.lab6.model.RadioStations

class AudioScreenViewModel : ViewModel() {

    lateinit var player : ExoPlayer

    val stations : List<MediaItem> = listOf(
        MediaItem.fromUri("http://amber.streamguys.com:6050/live"),
        MediaItem.fromUri("http://playerservices.streamtheworld.com/api/livestream-redirect/WNPRFM.mp3"),
        MediaItem.fromUri("https://stream3477.egihosting.com:8002"),
        MediaItem.fromUri("http://crystalout.surfernetwork.com:8001/WBMW_MP3"),
        MediaItem.fromUri("http://playerservices.streamtheworld.com/api/livestream-redirect/WEZNFM.mp3")
    )

    fun radioSetUp() {
        player.setMediaItems(stations, true)
        player.prepare()
    }

    fun audioPlay() {
        player.play()
    }

    fun audioPause() {
        player.pause()
    }

    fun audioStop() {
        player.stop()
    }

    fun audioNext() {
        player.stop()
        player.seekToNextMediaItem()
        player.prepare()
        player.play()
    }
}