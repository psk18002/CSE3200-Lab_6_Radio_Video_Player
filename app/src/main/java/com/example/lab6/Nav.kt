package com.example.lab6

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.ui.PlayerView
import com.example.lab6.views.AVScreenViewModel

@Composable
fun AVScreen(name : String, avViewModel : AVScreenViewModel) {
    avViewModel.radioSetUp()
    avViewModel.videoSetUp()

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Video", modifier = Modifier.align(Alignment.CenterHorizontally), fontSize = 20.sp)
        AndroidView(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp),
            factory = { context ->
                PlayerView(context).apply {
                    player = avViewModel.videoExoPlayer
                }
            }
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Button(onClick = {
                if (avViewModel.radioExoPlayer.isPlaying) {
                    avViewModel.radioExoPlayer.volume = 0.0F
                }
                avViewModel.videoExoPlayer.volume = 1.0F
                avViewModel.videoPlay()
            }) {
                Text("Play")
            }
            Spacer(modifier = Modifier.size(10.dp))

            Button(onClick = {avViewModel.videoPause()}) {
                Text("Pause")
            }
            Spacer(modifier = Modifier.size(10.dp))

            Button(onClick = {avViewModel.videoStop()}) {
                Text("Stop")
            }
            Spacer(modifier = Modifier.size(10.dp))

            Button(onClick = { avViewModel.videoNext()}) {
                Text("Next Video")
            }
        }

        Spacer(modifier = Modifier.height(20.dp))
        Text("Radio", modifier = Modifier.align(Alignment.CenterHorizontally), fontSize = 20.sp)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(onClick = {
                if (avViewModel.videoExoPlayer.isPlaying) {
                    avViewModel.videoExoPlayer.volume = 0.0F
                }
                avViewModel.radioExoPlayer.volume = 1.0F
                avViewModel.audioPlay()
            }) {
                Text("Play")
            }
            Spacer(modifier = Modifier.width(10.dp))

            Button(onClick = { avViewModel.audioPause() }) {
                Text("Pause")
            }
            Spacer(modifier = Modifier.width(10.dp))

            Button(onClick = { avViewModel.audioStop() }) {
                Text("Stop")
            }
            Spacer(modifier = Modifier.width(10.dp))

            Button(onClick = { avViewModel.audioNext() }) {
                Text("Next Station")
            }
        }
    }
}