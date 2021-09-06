package com.elifersumer.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import androidx.databinding.DataBindingUtil
import com.elifersumer.myapplication.databinding.ActivityHisseBinding
import kotlinx.android.synthetic.main.activity_hisse.*
import kotlinx.android.synthetic.main.fragment_emirgiris.*

class HisseActivity : AppCompatActivity() {
    lateinit var binding : ActivityHisseBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_hisse)
        hisse_adi.text = getIntent().getStringExtra("Hisse adi")
        hisse_cost.text = getIntent().getStringExtra("Hisse cost")


    }
}