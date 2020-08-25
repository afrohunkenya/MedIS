package com.one46health.medis.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.GridView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.one46health.medis.R
import com.one46health.medis.adapters.MainCardAdapter
import com.one46health.medis.model.MainCardItem

class MainActivity : AppCompatActivity(), AdapterView.OnItemClickListener {

    private var arrayList: ArrayList<MainCardItem>? = null
    private var gridView: GridView? = null
    private var mainCardAdapter: MainCardAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        gridView = findViewById(R.id.main_gridview_list)
        arrayList = ArrayList()
        arrayList = setMainTabs()
        mainCardAdapter = MainCardAdapter(applicationContext, arrayList!!)
        gridView?.adapter = mainCardAdapter
        gridView?.onItemClickListener = this
    }

    private fun setMainTabs(): ArrayList<MainCardItem> {
        var arrayList: ArrayList<MainCardItem> = ArrayList()
        arrayList.add(MainCardItem(R.drawable.house_hold, "House Holds"))
        arrayList.add(MainCardItem(R.drawable.refferal_img, "Referrals"))
        arrayList.add(MainCardItem(R.drawable.report_img, "Reports"))
        arrayList.add(MainCardItem(R.drawable.elearning_img, "E-Learning"))
        arrayList.add(MainCardItem(R.drawable.events_img, "Events"))

        return arrayList
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        var items: MainCardItem = arrayList!!.get(position)
        startActivity(Intent(this, HouseHoldActivity::class.java))
        Toast.makeText(applicationContext, items.name, Toast.LENGTH_LONG).show()
    }
}