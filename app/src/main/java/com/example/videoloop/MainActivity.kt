package com.example.videoloop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.videoloop.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var adapter: MyViewPagerFragmentAdapter
    lateinit var binding: ActivityMainBinding
    lateinit var viewPager2: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = MyViewPagerFragmentAdapter(supportFragmentManager, lifecycle)

        viewPager2 = binding.viewPager2

        viewPager2.adapter = adapter
    }
}