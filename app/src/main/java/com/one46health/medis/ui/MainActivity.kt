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
        referral.setOnClickListener {
            startActivity(Intent(this, ReferralActivity::class.java))
        }
        reports.setOnClickListener {
            startActivity(Intent(this, ReportsActivity::class.java))
        }
        e_learning.setOnClickListener {
            startActivity(Intent(this, ReferralActivity::class.java))
        }
        events.setOnClickListener {
            startActivity(Intent(this, EventsActivity::class.java))
        }
    }

}
