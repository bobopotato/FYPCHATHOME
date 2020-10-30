package com.example.fyp_prototype

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.models.SlideModel
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.example.fyp_prototype.Adapter.HomeAdapter
import com.example.fyp_prototype.Adapter.accomAdapter
import com.example.fyp_prototype.Adapter.fragmentAdapter
import com.example.fyp_prototype.Fragment.AccomFragment
import com.example.fyp_prototype.Model.Property
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_detail_post.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.toolbar
import kotlinx.android.synthetic.main.fragment_accom.*
import kotlinx.android.synthetic.main.fragment_home.*

class detailPost : AppCompatActivity() {
    lateinit var ref: DatabaseReference
    lateinit var query: Query

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_post)
        setSupportActionBar(toolbar as Toolbar?)
        supportActionBar?.setTitle("Property Details")
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //val slideModels:List<SlideModel>




        val slideModels=ArrayList<SlideModel>()

        val selectedPropertyID=intent.getStringExtra("selectedPosition")

        val imageSlider = findViewById<ImageSlider>(R.id.imgProperty)

        query= FirebaseDatabase.getInstance().getReference("PropertyImage").orderByChild("ImageName")
        query.addValueEventListener(object:ValueEventListener{
            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()) {
                    for (h in snapshot.children) {
                        if(h.child("propertyID").getValue().toString().equals(selectedPropertyID)){
                            slideModels.add(SlideModel(h.child("ImageSource").getValue().toString()))
                        }
                        imageSlider.setImageList(slideModels,ScaleTypes.CENTER_CROP)

                    }
                }
            }

        })




        detailViewPager.adapter= fragmentAdapter(supportFragmentManager)
        detailsTabLayout.setupWithViewPager(detailViewPager)

    }
}