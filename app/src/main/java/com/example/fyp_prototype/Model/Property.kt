package com.example.fyp_prototype.Model

class Property(val PropertyID : String,val location : String,val price : Double,val area : String, val postcode : Int, val accommodation:String,val preference:String,val leaseTerm:String,val propertyName:String,val rentalType:String,val status:String,val releaseDateTime:String,val userID:String){

    constructor() : this("","",0.0,"",0,"","","","","","","",""){

    }

}