package com.example.acer.healthcaremm.data.model

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.content.Context
import com.example.acer.healthcaremm.data.vos.HealthCareVO
import com.example.acer.healthcaremm.network.GetHealthCareResponse
import com.example.acer.healthcaremm.utils.AppConstant
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/**
 * Created by Acer on 7/12/2018.
 */
class HealthCareModel private constructor(context: Context) : BaseModel(context) {
    companion object {
        private var INSTANT: HealthCareModel? = null
        fun getInstant(context: Context): HealthCareModel {
            if (INSTANT == null) {
                INSTANT = HealthCareModel(context)
            }
            val i = INSTANT
            return i!!
        }
    }
    fun initNewsAppModel(context : Context) {
        INSTANT = HealthCareModel(context)
    }

    fun startLoadHealthCare(mHealthCare: MutableLiveData<List<HealthCareVO>>, mErrorLd: MutableLiveData<String>) {
        mTheApi.loadHealthCare(AppConstant.ACCESS_TOKEN)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Observer<GetHealthCareResponse> {
                    override fun onSubscribe(d: Disposable) {

                    }

                    override fun onComplete() {
                    }

                    override fun onError(e: Throwable) {
                        mErrorLd.value = e.message
                    }

                    override fun onNext( getHealthCareResponse : GetHealthCareResponse) {
                        if (getHealthCareResponse.getHealthCare().isNotEmpty()) {
                            persistenceHealthCare(getHealthCareResponse.getHealthCare())
                            mHealthCare.value = getHealthCareResponse.getHealthCare()
                        }
                        else{
                            mErrorLd.value = "Error Message"
                        }
                    }
                })

    }

    fun persistenceHealthCare(mHealthCare : List<HealthCareVO>){
        mDatabase.clearAllTables()
        mDatabase.healthCareDao().insertHCInfo(mHealthCare)
    }

    fun getAllLiveHealthCareData() : LiveData<List<HealthCareVO>>{
        return mDatabase.healthCareDao().getAllHealthCareLiveData()
    }


}