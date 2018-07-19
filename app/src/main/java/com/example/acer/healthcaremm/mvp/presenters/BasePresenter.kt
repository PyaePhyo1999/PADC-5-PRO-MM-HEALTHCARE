package com.example.acer.healthcaremm.mvp.presenters

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.content.Context
import com.example.acer.healthcaremm.mvp.views.BaseView

/**
 * Created by Acer on 7/12/2018.
 */
abstract class BasePresenter<T : BaseView>: ViewModel() {
     lateinit var mView : T
     lateinit var context : Context
     lateinit var mErrorLd : MutableLiveData<String>
     open fun initPresenter (mView : T,context : Context){
        this.mView = mView
         this.context = context
        mErrorLd = MutableLiveData()
    }
    fun getErrorLd() : LiveData<String>{
        return mErrorLd
    }



}