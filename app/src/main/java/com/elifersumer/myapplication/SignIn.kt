package com.elifersumer.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.elifersumer.myapplication.databinding.ActivitySignInBinding


class SignIn : AppCompatActivity() {
    private lateinit var binding:ActivitySignInBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySignInBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)


    }

    fun signInClicked(view: View){

        val intent = Intent(this,navbar::class.java)
        startActivity(intent)


    }
    fun signup_OnClick(view:View){
        val intent = Intent(this,SignUp::class.java)
        startActivity(intent)
    }
}