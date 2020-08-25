package com.one46health.medis.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.one46health.medis.R
import com.one46health.medis.model.DataHolder
import com.one46health.medis.views.HouseHoldViewHolder
import kotlinx.android.synthetic.main.activity_house_hold.*
import kotlinx.android.synthetic.main.house_hold_bar.*


class HouseHoldActivity : AppCompatActivity() {
    private lateinit var linearLayoutManager: LinearLayoutManager
    private var btnAdd: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_house_hold)

//        btnAdd!! = findViewById<TextView>(R.id.add_data)

        add_data!!.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this@HouseHoldActivity, AddHouseHold::class.java))
        })

        linearLayoutManager = LinearLayoutManager(this)
        data_recycler_view.layoutManager = linearLayoutManager


        val mRef = FirebaseDatabase.getInstance().reference
            .child("MedIS").child("household data").child("household_number")
            .child("Individual_code");
        val query: DatabaseReference =
            FirebaseDatabase.getInstance().reference.child("MedIS").child(
                "household data"
            ).child("household_number")
                .child("Individual_code");
        val options = FirebaseRecyclerOptions.Builder<DataHolder>()
            .setQuery(query, DataHolder::class.java)
            .build()


        var firebaseRecyclerAdapter =
            object : FirebaseRecyclerAdapter<DataHolder, HouseHoldViewHolder>(
                options
            ) {
                override fun onCreateViewHolder(
                    parent: ViewGroup,
                    viewType: Int
                ): HouseHoldViewHolder {
                    val view: View = LayoutInflater.from(parent.context)
                        .inflate(R.layout.custom_recycler_data_columns, parent, false)
                    return HouseHoldViewHolder(view)
                }

                override fun onBindViewHolder(
                    holder: HouseHoldViewHolder,
                    position: Int,
                    model: DataHolder
                ) {
                    model.getHhhName()?.let { holder.setHhhName(it) };
                    model.getIssue()?.let { holder.setStatus(it) };
                    model.getDataDate()?.let { holder.setDataDate(it) };
                }

            }
        data_recycler_view.setHasFixedSize(true);
        data_recycler_view.layoutManager = LinearLayoutManager(this);
        data_recycler_view.adapter = firebaseRecyclerAdapter;

    }

    @Override
    override fun onStop() {
        super.onStop();
//        firebaseRecyclerAdapter.stopListening();
    }

    @Override
    override fun onStart() {
        super.onStart();
//        firebaseRecyclerAdapter.startListening();
    }


}