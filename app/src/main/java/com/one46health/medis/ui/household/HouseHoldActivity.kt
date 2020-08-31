package com.one46health.medis.ui.household

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.one46health.medis.R
import com.one46health.medis.adapters.HouseHoldAdapter
import com.one46health.medis.model.DataHolder
import com.one46health.medis.ui.AddHouseHold
import com.one46health.medis.ui.IndividualHouseData
import kotlinx.android.synthetic.main.activity_house_hold.*
import kotlinx.android.synthetic.main.house_hold_bar.*


class HouseHoldActivity : AppCompatActivity() {
    private lateinit var linearLayoutManager: LinearLayoutManager
    private var stat: Any? = null
    private var stot: Any? = null




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_house_hold)

        add_data!!.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this@HouseHoldActivity, AddHouseHold::class.java))
        })

        sample_row!!.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this@HouseHoldActivity, IndividualHouseData::class.java))
        })

        linearLayoutManager = LinearLayoutManager(this)
        data_recycler_view.layoutManager = linearLayoutManager

        val query: DatabaseReference =
            FirebaseDatabase.getInstance().reference.child("MedIS").child(
                "household data"
            ).child("")
                .child("");
        val options: FirebaseRecyclerOptions<DataHolder> = FirebaseRecyclerOptions.Builder<DataHolder>()
            .setQuery(query, DataHolder::class.java)
            .build()

        val houseHoldAdapter = HouseHoldAdapter(options);
        data_recycler_view.adapter = houseHoldAdapter
        houseHoldAdapter.startListening();
//        stat =houseHoldAdapter.startListening();
        stot =houseHoldAdapter.stopListening();

    }
    @Override
    override fun onStart() {
        super.onStart();
//        stat
    }

    @Override
    override fun onStop() {
        super.onStop();
        stot

    }

}