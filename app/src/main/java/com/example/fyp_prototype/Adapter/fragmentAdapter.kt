package com.example.fyp_prototype.Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.fyp_prototype.Fragment.AccomFragment
import com.example.fyp_prototype.Fragment.PreFragment

class fragmentAdapter(fm: FragmentManager):FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        when(position){
            0->{return AccomFragment()}
            1->{return PreFragment()}
            else -> {return AccomFragment()}
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when(position){
            0->{return "Accommodations"}
            1->{return "Preferences"}
        }
        return super.getPageTitle(position)
    }

    override fun getCount(): Int {
        return 2
    }
}