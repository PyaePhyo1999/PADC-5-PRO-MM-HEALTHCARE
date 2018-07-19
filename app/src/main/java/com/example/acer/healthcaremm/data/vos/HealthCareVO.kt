package com.example.acer.healthcaremm.data.vos

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Embedded
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/**
 * Created by Acer on 7/12/2018.
 */
@Entity(tableName = "HealthCare")
class HealthCareVO {

    @PrimaryKey(autoGenerate = true)
    var appId : Long?=null

    @ColumnInfo(name = "health-Care-Id")
    @SerializedName("id")
    var healthCareId: Int? = null

    @ColumnInfo(name = "title")
    @SerializedName("title")
    var title: String? = null

    @ColumnInfo(name = "image")
    @SerializedName("image")
    var image: String? = null


    @Embedded
    @SerializedName("author")
    var author: AuthorVO? = null

    @ColumnInfo(name = "short-Description")
    @SerializedName("short-description")
    var shortDesc: String? = null

    @ColumnInfo(name = "published-Date")
    @SerializedName("published-date")
    var pubDate: String? = null

    @ColumnInfo(name = "complete-Url")
    @SerializedName("complete-url")
    var completeUrl: String? = null

    @ColumnInfo(name = "info-Type")
    @SerializedName("info-type")
    var infoType: String? = null


}