package com.example.videoloop

import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.VideoView
import androidx.fragment.app.Fragment
import com.example.videoloop.databinding.PagerLayout2Binding


class PagerFragment2: Fragment() {

    lateinit var binding: PagerLayout2Binding
    lateinit var videoView: VideoView
    lateinit var mediaPlayer: MediaPlayer
    public var type = "VIDEO_LOCAL"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.pager_layout_2, container)
    }




    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = PagerLayout2Binding.bind(view)

        binding.textView2.text = type
        videoView = binding.videoView2
        videoView.background.alpha = 255

        val videoSource = "android.resource://com.example.videoloop/" + R.raw.video
        videoView.setVideoURI(Uri.parse(videoSource))

        videoView.setOnPreparedListener {
            videoView.background.alpha = 0
            mediaPlayer = it
            val videoRatio = mediaPlayer.videoWidth / mediaPlayer.videoHeight.toFloat()
            val screenRatio = videoView.width / videoView.height.toFloat()
            val scaleX = videoRatio / screenRatio
            if (scaleX >= 1f) {
                videoView.scaleX = scaleX
            } else {
                videoView.scaleY = 1f / scaleX
            }
            mediaPlayer.isLooping = true
            mediaPlayer.start()
        }

    }

    override fun onResume() {
        super.onResume()

    }
}