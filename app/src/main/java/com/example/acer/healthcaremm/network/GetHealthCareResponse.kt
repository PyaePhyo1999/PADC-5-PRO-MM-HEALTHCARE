package com.example.acer.healthcaremm.network

import com.example.acer.healthcaremm.data.vos.HealthCareVO
import com.google.gson.annotations.SerializedName

/**
 * Created by Acer on 7/12/2018.
 */
class GetHealthCareResponse {
    @SerializedName("code")
    var code : Int? = null

    @SerializedName("message")
    var message : String? = null

    @SerializedName("healthcare-info")
    private var healthCare : List<HealthCareVO>? = null

    fun getHealthCare() : List<HealthCareVO>{
        if (healthCare==null){
            healthCare = ArrayList()
        }
        val i = healthCare
        return i!!
    }
}