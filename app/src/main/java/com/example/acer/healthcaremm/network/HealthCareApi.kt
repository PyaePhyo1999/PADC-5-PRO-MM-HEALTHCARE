package com.example.acer.healthcaremm.network

import android.database.Observable
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import java.util.*

/**
 * Created by Acer on 7/12/2018.
 */
interface HealthCareApi {
    @FormUrlEncoded
    @POST("GetHealthcareInfo.php")
    fun loadHealthCare(@Field("access_token") accessToken : String) : io.reactivex.Observable<GetHealthCareResponse>
}