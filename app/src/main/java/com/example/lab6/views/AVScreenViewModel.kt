package com.example.lab6.views

import androidx.lifecycle.ViewModel
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import androidx.media3.exoplayer.ExoPlayer

class AVScreenViewModel : ViewModel() {
    lateinit var radioExoPlayer : ExoPlayer
    lateinit var videoExoPlayer : ExoPlayer

    val stations : List<MediaItem> = listOf(
        MediaItem.fromUri("http://amber.streamguys.com:6050/live"),
        MediaItem.fromUri("http://playerservices.streamtheworld.com/api/livestream-redirect/WNPRFM.mp3"),
        MediaItem.fromUri("https://stream3477.egihosting.com:8002"),
        MediaItem.fromUri("http://crystalout.surfernetwork.com:8001/WBMW_MP3"),
        MediaItem.fromUri("http://playerservices.streamtheworld.com/api/livestream-redirect/WEZNFM.mp3")
    )

    fun radioSetUp() {
        radioExoPlayer.setMediaItems(stations, true)
        radioExoPlayer.repeatMode = Player.REPEAT_MODE_ALL
        radioExoPlayer.prepare()
    }

    fun audioPlay() {
        radioExoPlayer.play()
    }

    fun audioPause() {
        radioExoPlayer.pause()
    }

    fun audioStop() {
        radioExoPlayer.stop()
    }

    fun audioNext() {
        radioExoPlayer.stop()
        radioExoPlayer.seekToNextMediaItem()
        radioExoPlayer.prepare()
        radioExoPlayer.play()
    }

    val videos : List<MediaItem> = listOf(
        MediaItem.fromUri("https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"),
        MediaItem.fromUri("https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ElephantsDream.mp4"),
        MediaItem.fromUri("https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/TearsOfSteel.mp4"),
        MediaItem.fromUri("https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/Sintel.mp4"),
        MediaItem.fromUri("https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerBlazes.mp4"),
    )

    fun videoSetUp(){
        videoExoPlayer.setMediaItems(videos, true)
        videoExoPlayer.repeatMode = Player.REPEAT_MODE_ALL
        videoExoPlayer.prepare()
    }

    fun videoPlay(){
        videoExoPlayer.play()
    }

    fun videoPause() {
        videoExoPlayer.pause()
    }

    fun videoStop() {
        videoExoPlayer.stop()
    }

    fun videoNext() {
        videoExoPlayer.stop()
        videoExoPlayer.seekToNextMediaItem()
        videoExoPlayer.prepare()
        videoExoPlayer.play()
    }
}