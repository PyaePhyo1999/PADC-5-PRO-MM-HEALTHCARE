package com.example.acer.healthcaremm.adapters

import android.content.ClipData
import android.content.Context
import android.view.View
import android.view.ViewGroup
import com.example.acer.healthcaremm.R
import com.example.acer.healthcaremm.data.vos.HealthCareVO
import com.example.acer.healthcaremm.delegates.HealthCareDelegate
import com.example.acer.healthcaremm.viewholders.BaseViewHolder
import com.example.acer.healthcaremm.viewholders.ItemHealthCareViewHolder
import java.util.*

/**
 * Created by Acer on 7/11/2018.
 */
class HealthCareAdapter(context : Context,private val mDelegate : HealthCareDelegate) : BaseRecyclerAdapter<ItemHealthCareViewHolder,HealthCareVO>(context) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHealthCareViewHolder {
        var view = mLayoutInflator.inflate(R.layout.item_health_care,parent,false)
        return ItemHealthCareViewHolder(view,mDelegate)

    }

}