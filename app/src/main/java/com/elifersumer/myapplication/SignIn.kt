package com.elifersumer.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.elifersumer.myapplication.databinding.ActivitySignInBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_sign_in.*
import kotlinx.android.synthetic.main.activity_sign_up.*
import kotlinx.serialization.ExperimentalSerializationApi



class SignIn : AppCompatActivity() {
    private lateinit var binding:ActivitySignInBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var firestore:FirebaseFirestore



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySignInBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)

        auth = FirebaseAuth.getInstance()
        firestore = Firebase.firestore





    }

    fun signInClicked(view: View){
        val email=binding.txtEmail.text.toString()
        val password=binding.textViewPassw.text.toString()

        if( email.equals("") || password.equals("")){
            Toast.makeText(this,"Lütfen email ve şifre giriniz.", Toast.LENGTH_LONG).show()
        }else{
            auth.signInWithEmailAndPassword(email,password).addOnSuccessListener {
                val intent = Intent(this,navbar::class.java)
                startActivity(intent)






            }.addOnFailureListener {
                Toast.makeText(this,it.localizedMessage, Toast.LENGTH_LONG).show()
            }
        }
    }
    fun signup_OnClick(view:View){
        val intent = Intent(this,SignUp::class.java)
        startActivity(intent)
    }
}
