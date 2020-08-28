package com.one46health.medis.ui

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.*
import com.one46health.medis.R


class IndividualHouseData : AppCompatActivity() {

    private var mHouseholdNo: TextView? = null
    private var mHhhName: TextView? = null
    private var mMembersNo: TextView? = null
    private var mWateraccess: TextView? = null
    private var mFuctionalLatrines: TextView? = null
    private var mRefuseDisposal: TextView? = null
    private var mTreatedWater: TextView? = null
    private var mHandwashing: TextView? = null
    private var mRootRef: DatabaseReference? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_individual_house_data)
        mHouseholdNo = findViewById(R.id.house_hold_id);
        mHhhName = findViewById(R.id.hhh_name);
        mMembersNo = findViewById(R.id.members_no);
        mWateraccess = findViewById(R.id.tv_water_access);
        mFuctionalLatrines = findViewById(R.id.tv_functional_latrines);
        mRefuseDisposal = findViewById(R.id.tv_refuse_disposal);
        mTreatedWater = findViewById(R.id.tv_treated_water);
        mHandwashing = findViewById(R.id.tv_hand_washing);

        mRootRef = FirebaseDatabase.getInstance().reference
            .child("MedIS").child("household data").child("household_number")
            .child("Individual_code")


        mRootRef!!.addListenerForSingleValueEvent(object : ValueEventListener {

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val householdNumber = dataSnapshot.getValue(String::class.java)
                val houseHeadName = dataSnapshot.getValue(String::class.java)
                val value = dataSnapshot.getValue(String::class.java)
                val waterAccess = dataSnapshot.getValue(String::class.java)
                val fuctionalLatrines = dataSnapshot.getValue(String::class.java)
                val treatedWater = dataSnapshot.getValue(String::class.java)
                val handwashingFacility = dataSnapshot.getValue(String::class.java)
                val disposalFacility = dataSnapshot.getValue(String::class.java)


                mHouseholdNo!!.text = householdNumber
                mHhhName!!.text = houseHeadName
                mMembersNo!!.text = value
                mWateraccess!!.text = waterAccess
                mFuctionalLatrines!!.text = fuctionalLatrines
                mTreatedWater!!.text = treatedWater
                mRefuseDisposal!!.text = handwashingFacility
                mHandwashing!!.text = disposalFacility
            }

            override fun onCancelled(databaseError: DatabaseError) {
                Toast.makeText(this@IndividualHouseData, "Error fetching data", Toast.LENGTH_LONG)
                    .show()
            }
        })

        
    }


}
