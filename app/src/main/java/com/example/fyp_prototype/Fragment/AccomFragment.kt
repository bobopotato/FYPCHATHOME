package com.example.fyp_prototype.Fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fyp_prototype.Adapter.accomAdapter
import com.example.fyp_prototype.R
import kotlinx.android.synthetic.main.activity_detail_post.*
import kotlinx.android.synthetic.main.activity_detail_post.view.*
import kotlinx.android.synthetic.main.fragment_accom.*
import kotlinx.android.synthetic.main.fragment_accom.view.*

class AccomFragment : Fragment() {

    lateinit var accomList : MutableList<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root: View = inflater.inflate(R.layout.fragment_accom, container, false)


        accomList=mutableListOf()
        accomList.add("accom1")
        accomList.add("accom2")
        accomList.add("accom3")
        accomList.add("accom1")
        accomList.add("accom2")
        accomList.add("accom3")
        accomList.add("accom1")
        accomList.add("accom2")
        accomList.add("accom3")
        //val mLayoutManager = LinearLayoutManager(context)
        val gridLayoutManager= GridLayoutManager(context,2,GridLayoutManager.VERTICAL,false)
        root.accomRecycler.layoutManager = gridLayoutManager
        root.accomRecycler.adapter= accomAdapter(accomList)

        return root
    }


}