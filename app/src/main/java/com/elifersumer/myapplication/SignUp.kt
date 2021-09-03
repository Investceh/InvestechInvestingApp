package com.elifersumer.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.elifersumer.myapplication.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class SignUp : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var binding:ActivitySignUpBinding
    private lateinit var firestore: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySignUpBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)

        auth=FirebaseAuth.getInstance()
        firestore = Firebase.firestore
    }

    fun signUpClicked(view: View){
        val name=binding.name.text.toString()
        val email=binding.email.text.toString()
        val tckn=binding.tckn.text.toString()
        val phone=binding.phoneNum.text.toString()
        val password=binding.password.text.toString()

        if(name.equals("") || email.equals("") || tckn.equals("") || password.equals("") || phone.equals("")){
            Toast.makeText(this,"Kayıt olmak için boş alanları doldurunuz.",Toast.LENGTH_LONG).show()
        }else{
            auth.createUserWithEmailAndPassword(email,password).addOnSuccessListener {
                val intent = Intent(this@SignUp , Sorular::class.java)
                startActivity(intent)
                finish()

                val userMap= hashMapOf<String,Any>()
                userMap.put("userEmail",auth.currentUser!!.email!!)
                userMap.put("userName", name)
                userMap.put("tckn",tckn)

                firestore.collection("Users")
                    .add(userMap)
                    .addOnSuccessListener {
                        finish()
                    }
                    .addOnFailureListener {
                        Toast.makeText(this,it.localizedMessage,Toast.LENGTH_LONG).show()
                    }
            }.addOnFailureListener {
                Toast.makeText(this,it.localizedMessage,Toast.LENGTH_LONG).show()
            }
        }
    }
}