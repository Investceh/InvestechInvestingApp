package com.elifersumer.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sign_in)



    fun loginOnClick(view: View){

    }

        /*
        val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,landmarkList.map{landmark -> landmark.name })
        binding.listView.adapter = adapter
        binding.listView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            val intent = Intent(this@MainActivity, MainActivity2::class.java)
            intent.putExtra("landmark",landmarkList.get(position))
            startActivity(intent)
        }
        */


    }

}