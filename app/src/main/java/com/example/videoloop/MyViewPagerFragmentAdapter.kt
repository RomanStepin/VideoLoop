package com.example.videoloop

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class MyViewPagerFragmentAdapter(val fm: FragmentManager, val lc: Lifecycle): FragmentStateAdapter(fm, lc) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        when(position) {
            0 -> return PagerFragment1()
            1 -> return PagerFragment2()
            2 -> return PagerFragment3()
            else -> return PagerFragment3()
        }
    }
}