package com.example.fyp_prototype.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.fyp_prototype.Adapter.accomAdapter
import com.example.fyp_prototype.R
import kotlinx.android.synthetic.main.fragment_accom.view.*
import kotlinx.android.synthetic.main.fragment_pre.view.*


class PreFragment : Fragment() {
    lateinit var preList : MutableList<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root: View = inflater.inflate(R.layout.fragment_pre, container, false)

        preList=mutableListOf()
        preList.add("pre1")
        preList.add("pre2")
        preList.add("pre3")
        preList.add("pre1")
        preList.add("pre2")
        preList.add("pre3")
        preList.add("pre2")
        preList.add("pre3")

        val gridLayoutManager= GridLayoutManager(context,2,GridLayoutManager.VERTICAL,false)
        root.preRecycler.layoutManager = gridLayoutManager
        root.preRecycler.adapter= accomAdapter(preList)

        return root
    }
}