package com.one46health.medis.views

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.one46health.medis.R


class HouseHoldViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
    var mView: View? = null
    private var mHhhName: TextView? = null
    private var mStatus: TextView? = null
    private var mDataDate: TextView? = null

    fun UsersViewHolder(itemView: View) {
        mView = itemView;
    }

    fun setHhhName(hhhName: String) {
        mHhhName = mView?.findViewById(R.id.name_hhh_column);
        mHhhName?.text = hhhName;
    }

    fun setStatus(status: String) {
        mStatus = mView?.findViewById(R.id.status_column);
        mStatus?.text = status;

    }

    fun setDataDate(dataDate: String) {
        mDataDate = mView?.findViewById(R.id.date_column);
        mDataDate?.text = dataDate;

    }
}