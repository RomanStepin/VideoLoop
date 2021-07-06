package com.example.videoloop


import android.annotation.SuppressLint
import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.VideoView
import androidx.fragment.app.Fragment
import com.example.videoloop.databinding.PagerLayout1Binding


class PagerFragment1: Fragment() {

    lateinit var binding: PagerLayout1Binding
    var type = "VIDEO_INTERNET"
    lateinit var videoView: VideoView
    lateinit var mediaPlayer: MediaPlayer
    lateinit var imageView: ImageView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.pager_layout_1, container)
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = PagerLayout1Binding.bind(view)
        videoView = binding.videoView1
        imageView = binding.imageView1


        binding.textView1.text = type
        videoView.setVideoPath("https://vod-progressive.akamaized.net/exp=1625579350~acl=%2Fvimeo-prod-skyfire-std-us%2F01%2F4876%2F7%2F199383367%2F672434766.mp4~hmac=d01a72cbc6d351c141117c004116adf88bfa52dd65bafdd7f0b155bfa4070156/vimeo-prod-skyfire-std-us/01/4876/7/199383367/672434766.mp4?filename=Snowy+Trees+-+7328.mp4")

        videoView.setOnPreparedListener {
            imageView.visibility = View.GONE
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
        imageView.visibility = View.VISIBLE
    }

    override fun onPause() {
        super.onPause()
        imageView.visibility = View.VISIBLE
    }
}