package com.one46health.medis.views

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.one46health.medis.R


public class HouseHoldViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var mHouseHeadName: TextView? = null
    var mStatus: TextView? = null
    var mDateofData: TextView? = null

    public fun HouseHoldViewHolder(itemView: View){
        mHouseHeadName =  itemView?.findViewById(R.id.tv_name_column);
        mStatus = itemView?.findViewById(R.id.tv_status_column);
        mDateofData = itemView?.findViewById(R.id.tv_date_column);

    }

}