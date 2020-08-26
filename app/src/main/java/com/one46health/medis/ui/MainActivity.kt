package com.one46health.medis.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.one46health.medis.R
import com.one46health.medis.ui.household.HouseHoldActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        house_hold.setOnClickListener {
            startActivity(Intent(this, HouseHoldActivity::class.java))
        }
        referral.setOnClickListener { Toast.makeText(this,"Referral", Toast.LENGTH_SHORT).show() }
        reports.setOnClickListener { Toast.makeText(this,"Reports", Toast.LENGTH_SHORT).show() }
        e_learning.setOnClickListener { Toast.makeText(this,"E-learning", Toast.LENGTH_SHORT).show() }
        events.setOnClickListener { Toast.makeText(this,"Events", Toast.LENGTH_SHORT).show() }
    }

}