package com.example.acer.healthcaremm.persistance

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.Room.databaseBuilder
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.example.acer.healthcaremm.data.vos.HealthCareVO
import com.example.acer.healthcaremm.persistance.daos.HealthCareDao

/**
 * Created by Acer on 7/13/2018.
 */
@Database(entities = arrayOf(HealthCareVO::class),version = 1,exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

   abstract fun healthCareDao(): HealthCareDao
    companion object {
        private  var INSTANT : AppDatabase?= null

        private val DB_NAME : String = "HEALTH_CARE_DB"

        fun getDatabase(context : Context) : AppDatabase {
            if (INSTANT == null){
                 INSTANT = Room.databaseBuilder(context,AppDatabase::class.java, DB_NAME)
                         .allowMainThreadQueries()
                         .build()

            }
            val i = INSTANT
            return i!!
        }
    }

}