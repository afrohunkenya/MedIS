package com.one46health.medis.adapters

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.one46health.medis.R
import com.one46health.medis.model.MainCardItem

class MainCardAdapter(var context: Context, var arrayList: ArrayList<MainCardItem>) :
    BaseAdapter() {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var view: View = View.inflate(context, R.layout.main_pg_cards, null)
        var mainTabs: ImageView = view.findViewById(R.id.main_tabs_img)
        var names: TextView = view.findViewById(R.id.tv_description)

        var listItem: MainCardItem = arrayList.get(position)
        mainTabs.setImageResource(listItem.mainTabs!!)
        names.text = listItem.name

        return view
    }

    override fun getItem(position: Int): MainCardItem {
        return arrayList.get(position)

    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return arrayList.size
    }


}