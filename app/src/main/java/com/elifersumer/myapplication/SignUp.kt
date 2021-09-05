package com.elifersumer.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.elifersumer.myapplication.data.DbConnection
import com.elifersumer.myapplication.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import java.sql.Connection
import java.sql.SQLException
import java.sql.Statement

class SignUp : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var binding:ActivitySignUpBinding
    private lateinit var firestore: FirebaseFirestore
    private lateinit var dbConnection:DbConnection

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySignUpBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)

        //auth=FirebaseAuth.getInstance()
        //firestore = Firebase.firestore
    }

    fun signUpClicked(view: View){
        val firstName=binding.firstname.text.toString()
        val lastName=binding.lastname.text.toString()
        val tckn=binding.tckn.text.toString()
        val phone=binding.phoneNum.text.toString()
        val password=binding.password.text.toString()

        if(firstName.equals("") || lastName.equals("") || tckn.equals("") || password.equals("") || phone.equals("")){
            Toast.makeText(this,"Kayıt olmak için boş alanları doldurunuz.",Toast.LENGTH_LONG).show()
        }else{
            var dbConnection:DbConnection ?=null
            val con : Connection? = dbConnection?.Conn()

            if(con==null){
                val error : String ="Error in sql connection"
            }else {
                try{
                    val statement = con.createStatement()

                    statement.executeQuery("INSERT INTO customers(first_name) VALUES('"+firstName+"') ")
                    statement.executeQuery("INSERT INTO customers(last_name) VALUES('"+lastName+"') ")
                    statement.executeQuery("INSERT INTO customers(tc_no) VALUES('"+tckn+"') ")
                    statement.executeQuery("INSERT INTO customers(phone) VALUES('"+phone+"') ")
                    statement.executeQuery("INSERT INTO customers(password) VALUES('"+password+"') ")

                }catch (ex : SQLException){
                    Log.e("error", ex.message.toString())
                }
            }


            /*auth.createUserWithEmailAndPassword(email,password).addOnSuccessListener {
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
            }*/
        }
    }
}