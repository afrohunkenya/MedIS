package com.one46health.medis.ui.household

import android.util.Log
import androidx.lifecycle.ViewModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener

class HouseHoldViewModel : ViewModel(){

    fun getHouseHoldData(reference: DatabaseReference) {

        val listener = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val data = snapshot.value
                Log.d("HouseHold", "onDataChange: $data")
            }

            override fun onCancelled(error: DatabaseError) {
                Log.e("HouseHold", "onCancelled: $error")
            }
        }
        reference.addValueEventListener(listener)
    }

}