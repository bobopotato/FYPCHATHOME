package com.example.fyp_prototype

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.method.PasswordTransformationMethod
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : AppCompatActivity() {
    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        showPassword.setOnClickListener {
            //showPassword.setBackgroundColor(R.color.colorPrimary)
            if(showPassword.tag=="gray"){
                showPassword.setBackgroundResource(R.drawable.ic_eye_blue)
                passwordText.setTransformationMethod(null)
                showPassword.tag = "blue"
            }
            else{
                showPassword.setBackgroundResource(R.drawable.ic_eye_gray)
                passwordText.setTransformationMethod(PasswordTransformationMethod())
                showPassword.tag = "gray"
            }
            Toast.makeText(this, "abc", Toast.LENGTH_SHORT).show()
        }
    }
}