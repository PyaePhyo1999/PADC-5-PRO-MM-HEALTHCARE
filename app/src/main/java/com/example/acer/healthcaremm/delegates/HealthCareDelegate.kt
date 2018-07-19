package com.example.acer.healthcaremm.delegates

import com.example.acer.healthcaremm.data.vos.HealthCareVO

/**
 * Created by Acer on 7/12/2018.
 */
interface HealthCareDelegate {
    fun onTapHealthCare(healthCare : HealthCareVO?)
}