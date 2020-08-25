package com.one46health.medis.views

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.one46health.medis.R


class HouseHoldViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
    var mView: View? = null
    private var mhouseHeadName: TextView? = null
    private var mHouseholdNumber: TextView? = null
    private var mDateofData: TextView? = null

    fun UsersViewHolder(itemView: View) {
        mView = itemView;
    }

    fun setHouseHeadName(houseHeadName: String) {
        mhouseHeadName =  mView?.findViewById(R.id.tv_name_column);
        mhouseHeadName?.text = houseHeadName.toString();
    }

    fun setHouseholdNumber(householdNumber: String) {
        mHouseholdNumber = mView?.findViewById(R.id.tv_status_column);
        mHouseholdNumber?.text = householdNumber;

    }

    fun setDateofData(dateofData: String) {
         mDateofData = mView?.findViewById(R.id.tv_status_column);
        mDateofData?.text = dateofData;

    }
}