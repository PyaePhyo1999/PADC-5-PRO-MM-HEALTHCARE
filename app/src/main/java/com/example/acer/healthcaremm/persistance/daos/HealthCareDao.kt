package com.example.acer.healthcaremm.persistance.daos

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.example.acer.healthcaremm.data.vos.HealthCareVO

/**
 * Created by Acer on 7/13/2018.
 */
@Dao
interface HealthCareDao {
    @get:Query("SELECT * FROM HealthCare")
    val allHealthCareInfo: List<HealthCareVO>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertHCInfo(newsVO: List<HealthCareVO>)

    @Query("SELECT * FROM HealthCare ")
    fun getAllHealthCareLiveData() : LiveData<List<HealthCareVO>>
}