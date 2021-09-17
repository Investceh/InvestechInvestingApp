package com.elifersumer.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.elifersumer.myapplication.Database.AccountInfo
import com.elifersumer.myapplication.Database.Helper.DbHelper
import com.elifersumer.myapplication.Database.Managers.AccDbManager
import com.elifersumer.myapplication.Database.Managers.CanceledDbManager
import com.elifersumer.myapplication.Database.Managers.DoneDbManager
import com.elifersumer.myapplication.Database.Managers.WaitingDbManager
import com.elifersumer.myapplication.Database.WaitingOrder
import com.elifersumer.myapplication.databinding.ActivitySignInBinding


class SignIn : AppCompatActivity() {


    val db by lazy { DbHelper(this) }
    private lateinit var binding:ActivitySignInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySignInBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)
        //hehee
    }

    fun signInClicked(view: View){
        val intent = Intent(this,BottomNavigation::class.java)
        startActivity(intent)
    }
    fun signup_OnClick(view:View){
        val intent = Intent(this,SignUp::class.java)
        startActivity(intent)
    }
}