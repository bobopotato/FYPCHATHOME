package com.example.fyp_prototype.Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.fyp_prototype.Fragment.AccomFragment
import com.example.fyp_prototype.Fragment.PreFragment
import com.example.fyp_prototype.Fragment.chatUserFragment
import com.example.fyp_prototype.Fragment.chatroomFragment

class chatViewPagerAdapter(fm: FragmentManager): FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        when(position){
            0->{return chatroomFragment()
            }
            1->{return chatUserFragment()
            }
            else -> {return chatroomFragment()
            }
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when(position){
            0->{return "Chat Room"}
            1->{return "User"}
        }
        return super.getPageTitle(position)
    }

    override fun getCount(): Int {
        return 2
    }
}