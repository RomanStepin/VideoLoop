package com.example.videoloop

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.videoloop.databinding.PagerLayout3Binding


class PagerFragment3: Fragment() {

    lateinit var binding: PagerLayout3Binding

    public var type = "IMAGE_LOCAL"


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.pager_layout_3, container)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = PagerLayout3Binding.bind(view)

        binding.textView3.text = type
    }
}