package com.example.fyp_prototype

import android.content.Context
import android.content.Intent.getIntent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fyp_prototype.Adapter.HomeAdapter
import com.example.fyp_prototype.Model.Property
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*


class HomeFragment : Fragment() {

    lateinit var ref : DatabaseReference
    lateinit var propertyList : MutableList<Property>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root: View = inflater.inflate(R.layout.fragment_home, container, false)


        propertyList = mutableListOf()

        addToList()




        return root
    }


    private fun addToList(){
        ref = FirebaseDatabase.getInstance().getReference("Property")
        ref.addValueEventListener(object:ValueEventListener{
            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()){
                    propertyList.clear()
                    for (h in snapshot.children){
                        val property = h.getValue(Property::class.java)
                        propertyList.add(property!!)
                        //Log.d(tag,propertyList.toString())

                    }

                    val mLayoutManager = LinearLayoutManager(context)
                    mLayoutManager.reverseLayout = true

                    recycler_view.layoutManager = mLayoutManager
                    recycler_view.scrollToPosition(propertyList.size-1)
                    recycler_view.adapter = HomeAdapter(propertyList)
                }
            }

        })

    }

}