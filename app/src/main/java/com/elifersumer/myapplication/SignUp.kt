package com.elifersumer.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.elifersumer.myapplication.data.DataManager
import com.elifersumer.myapplication.databinding.ActivitySignUpBinding


class SignUp : AppCompatActivity() {
    private lateinit var binding:ActivitySignUpBinding
    private lateinit var dbManager: DataManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySignUpBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)

    }

    fun signUpClicked(view: View){
        val firstName=binding.firstname.text.toString()
        val lastName=binding.lastname.text.toString()
        val tckn=binding.tckn.text.toString().toInt()
        val phone=binding.phoneNum.text.toString().toInt()
        val password=binding.password.text.toString().toInt()

        if(firstName.equals("") || lastName.equals("") || tckn.equals("") || password.equals("") || phone.equals("")){
            Toast.makeText(this,"Kayıt olmak için boş alanları doldurunuz.",Toast.LENGTH_LONG).show()
        }else{
            dbManager.setData(firstName,lastName,tckn,phone,password)

        }
    }
}