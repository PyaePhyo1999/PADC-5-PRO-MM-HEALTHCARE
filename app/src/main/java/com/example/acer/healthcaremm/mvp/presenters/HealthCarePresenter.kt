package com.example.acer.healthcaremm.mvp.presenters

import android.arch.lifecycle.LifecycleService
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.content.Context
import com.example.acer.healthcaremm.data.model.HealthCareModel
import com.example.acer.healthcaremm.data.vos.HealthCareVO
import com.example.acer.healthcaremm.delegates.HealthCareDelegate
import com.example.acer.healthcaremm.mvp.views.HealthCareView

/**
 * Created by Acer on 7/12/2018.
 */
class HealthCarePresenter : BasePresenter<HealthCareView>() , HealthCareDelegate{

    override fun onTapHealthCare(healthCare: HealthCareVO?) {
         mView.onTapHealthCareUrl(healthCare!!.completeUrl!!)
    }

    private lateinit var mHealthCareLd : MutableLiveData<List<HealthCareVO>>
     lateinit var errorLd : MutableLiveData<String>
    override fun initPresenter(mView: HealthCareView,context: Context) {
        super.initPresenter(mView,context)
        mHealthCareLd = MutableLiveData()
        errorLd = MutableLiveData()
        HealthCareModel.getInstant(context).startLoadHealthCare(mHealthCareLd,errorLd)
    }
    fun getHealthCareLd (): LiveData<List<HealthCareVO>>{
        return HealthCareModel.getInstant(context).getAllLiveHealthCareData()
    }

}