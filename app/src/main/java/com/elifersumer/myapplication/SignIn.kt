package com.elifersumer.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.elifersumer.myapplication.data.Customer
import com.elifersumer.myapplication.data.DataManager
import com.elifersumer.myapplication.databinding.ActivitySignInBinding


class SignIn : AppCompatActivity() {
    private lateinit var binding:ActivitySignInBinding
    private lateinit var customer: Customer
    private lateinit var dbManager: DataManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySignInBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)
    }

    fun signInClicked(view: View){
        val tckn=binding.txtTckn.text.toString().toInt()
        val password=binding.textViewPassw.text.toString().toInt()

        customer=dbManager.getData(tckn, this)

        if( tckn==null || password==null){
            Toast.makeText(this,"Lütfen TCKN ve şifre giriniz.", Toast.LENGTH_LONG).show()
        }else{
                if(tckn==customer.tcNo && password==customer.password) {
                    //auth.signInWithEmailAndPassword(email,password).addOnSuccessListener {
                    val intent = Intent(this, navbar::class.java)
                    startActivity(intent)
                }else{
                    Toast.makeText(this,"Hatalı TCKN veya şifre!",Toast.LENGTH_LONG).show()
                }
        }
    }
    fun signup_OnClick(view:View){
        val intent = Intent(this,SignUp::class.java)
        startActivity(intent)
    }
}