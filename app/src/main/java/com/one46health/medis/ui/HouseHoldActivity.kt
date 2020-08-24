package com.one46health.medis.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.one46health.medis.R

class HouseHoldActivity : AppCompatActivity() {

    private var btnAdd: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_house_hold)

        btnAdd = findViewById<TextView>(R.id.add_data)

        btnAdd!!.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this@HouseHoldActivity, AddHouseHold::class.java))
        })
    }
}