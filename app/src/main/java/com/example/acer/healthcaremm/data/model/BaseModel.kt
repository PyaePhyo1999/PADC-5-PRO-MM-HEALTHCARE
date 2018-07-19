package com.example.acer.healthcaremm.data.model

import android.content.Context
import com.example.acer.healthcaremm.network.HealthCareApi
import com.example.acer.healthcaremm.persistance.AppDatabase
import com.google.gson.Gson
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by Acer on 7/12/2018.
 */
abstract class BaseModel protected constructor(context: Context) {

    protected var mTheApi : HealthCareApi
    protected var mDatabase : AppDatabase

    init {
        val okHttpClient = OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build()
        val retrofit = Retrofit.Builder()
                .baseUrl("http://padcmyanmar.com/padc-5/mm-healthcare/")
                .addConverterFactory(GsonConverterFactory.create(Gson()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build()
        mTheApi = retrofit.create<HealthCareApi>(HealthCareApi::class.java)
        mDatabase = AppDatabase.getDatabase(context)
    }
}