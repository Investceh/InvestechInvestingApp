package com.elifersumer.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.elifersumer.myapplication.Database.CanceledOrder
import com.elifersumer.myapplication.Database.DoneOrder
import com.elifersumer.myapplication.Database.Helpers.CanceledDbHelper
import com.elifersumer.myapplication.Database.Helpers.DoneDbHelper
import com.elifersumer.myapplication.Database.Helpers.WaitingDbHelper
import com.elifersumer.myapplication.Database.WaitingOrder
import com.elifersumer.myapplication.databinding.ActivitySignInBinding


class SignIn : AppCompatActivity() {
    private lateinit var binding:ActivitySignInBinding
    val db by lazy { WaitingDbHelper(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySignInBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)
    }

    fun signInClicked(view: View){
       /* this.deleteDatabase(db.databaseName)*/
       /*var doneOrder = WaitingOrder("a",5,12.40,"a")
        db.insertData(doneOrder)*/
        val intent = Intent(this,BottomNavigation::class.java)
        startActivity(intent)


    }
    fun signup_OnClick(view:View){
        val intent = Intent(this,SignUp::class.java)
        startActivity(intent)
    }
}