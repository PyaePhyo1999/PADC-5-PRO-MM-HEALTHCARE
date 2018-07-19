package com.example.acer.healthcaremm.viewholders

import android.view.View
import com.bumptech.glide.Glide
import com.example.acer.healthcaremm.data.vos.HealthCareVO
import com.example.acer.healthcaremm.delegates.HealthCareDelegate
import kotlinx.android.synthetic.main.item_health_care.view.*

import java.util.*

/**
 * Created by Acer on 7/11/2018.
 */
class ItemHealthCareViewHolder(itemView : View,private val mDelegate : HealthCareDelegate) : BaseViewHolder<HealthCareVO>(itemView){

    override fun onClick(p0: View?) {
       mDelegate.onTapHealthCare(this.mData)
    }

    override fun setData(data:HealthCareVO) {
        mData = data
        itemView.tvTitleHealthCare!!.text = data.title
        itemView.tvPostedDate!!.text = data.pubDate
        itemView.tvAuthorName!!.text = data.author!!.authorName
        itemView.tvInfoType!!.text = data.infoType
        if (!data.author!!.authorPic!!.isEmpty()){
            itemView.ivAuthor!!.visibility = View.VISIBLE
            Glide.with(itemView.ivAuthor.context)
                    .load(data.author!!.authorPic)
                    .into(itemView.ivAuthor)
        }
        else {
            itemView.ivAuthor!!.visibility = View.GONE
        }
        itemView.tvShortDescription!!.text = data.shortDesc

        if (!data.image!!.isEmpty()){
            itemView.ivHealthCare!!.visibility = View.VISIBLE
            Glide.with(itemView.ivHealthCare.context)
                    .load(data.image)
                    .into(itemView.ivHealthCare)
        }
        else {
            itemView.ivHealthCare!!.visibility = View.GONE
        }

    }


}