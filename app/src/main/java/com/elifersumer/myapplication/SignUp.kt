package com.elifersumer.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.elifersumer.myapplication.databinding.ActivitySignUpBinding


class SignUp : AppCompatActivity() {
    private lateinit var binding:ActivitySignUpBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySignUpBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)

    }

    fun signUpClicked(view: View){
        val intent = Intent(this@SignUp , Sorular::class.java)
        startActivity(intent)
    }
}
