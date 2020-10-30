package com.example.fyp_prototype.Adapter

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.fyp_prototype.Model.Property
import com.example.fyp_prototype.R
import com.example.fyp_prototype.detailPost
import com.google.firebase.database.*
import com.squareup.picasso.Picasso


class HomeAdapter(val property : MutableList<Property>): RecyclerView.Adapter<HomeAdapter.MyViewHolder>() {

    lateinit var ref:DatabaseReference


    inner class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        var txt_username:TextView=itemView.findViewById<TextView>(R.id.txtUsername);
        var txt_price:TextView=itemView.findViewById<TextView>(R.id.txtPrice);
        var txt_location:TextView=itemView.findViewById<TextView>(R.id.txtLocation);
        var txt_propertyName:TextView=itemView.findViewById<TextView>(R.id.txtPropertyName);
        var img_user: ImageView = itemView.findViewById<ImageView>(R.id.imgProfile);
        var img_property: ImageView = itemView.findViewById<ImageView>(R.id.imgProperty);
        var txt_dateTime:TextView=itemView.findViewById<TextView>(R.id.txtDateTime);


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.property_layout_item,parent,false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return property.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.txt_dateTime.text=property[position].releaseDateTime
        holder.txt_location.text=property[position].location
        if(property[position].rentalType.toString().equals("long")) {
            holder.txt_price.text = "RM"+property[position].price.toString()+"/month"
        }else{
            holder.txt_price.text = "RM"+property[position].price.toString()+"/day"
        }
        holder.txt_propertyName.text=property[position].propertyName
        ref= FirebaseDatabase.getInstance().getReference("Users")

        ref.addValueEventListener(object: ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()){
                    for(h in snapshot.children){
                        if(h.child("userID").getValue().toString().equals(property[position].userID)){
                            holder.txt_username.text=h.child("fullName").getValue().toString()
                            Picasso.get().load(h.child("image").getValue().toString()).into(holder.img_user)
                        }

                    }
                }
            }

        })

        ref=FirebaseDatabase.getInstance().getReference("PropertyImage")
        ref.addValueEventListener(object:ValueEventListener{
            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()){

                    for(h in snapshot.children){
                        if(h.child("propertyID").getValue().toString().equals(property[position].PropertyID) && h.child("ImageName").getValue().toString().equals("image1")){
                            Picasso.get().load(h.child("ImageSource").getValue().toString()).into(holder.img_property)
                        }
                    }
                }
            }

        })

        holder.img_property.setOnClickListener{
            val intent = Intent(holder.img_property.context, detailPost::class.java)
            intent.putExtra("selectedPosition", property[position].PropertyID)
            holder.img_property.context.startActivity(intent)
        }

    }
}