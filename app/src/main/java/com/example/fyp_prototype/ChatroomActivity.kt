package com.example.fyp_prototype

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.example.fyp_prototype.Adapter.chatViewPagerAdapter
import com.example.fyp_prototype.Adapter.fragmentAdapter
import kotlinx.android.synthetic.main.activity_chatroom.*
import kotlinx.android.synthetic.main.activity_detail_post.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.toolbar

class ChatroomActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chatroom)

        setSupportActionBar(toolbar as Toolbar?)
        supportActionBar?.setTitle("Chatroom")
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        viewPagerChat.adapter= chatViewPagerAdapter(supportFragmentManager)
        tabLayoutChat.setupWithViewPager(viewPagerChat)
    }
}