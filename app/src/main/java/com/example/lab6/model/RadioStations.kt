package com.example.lab6.model

import androidx.media3.common.MediaItem

class RadioStations {

    val stations : List<MediaItem> = listOf(
        MediaItem.fromUri("http://amber.streamguys.com:6050/live"),
        MediaItem.fromUri("http://playerservices.streamtheworld.com/api/livestream-redirect/WNPRFM.mp3"),
        MediaItem.fromUri("https://stream3477.egihosting.com:8002"),
        MediaItem.fromUri("http://crystalout.surfernetwork.com:8001/WBMW_MP3"),
        MediaItem.fromUri("http://playerservices.streamtheworld.com/api/livestream-redirect/WEZNFM.mp3")
    )

}