package com.example.acer.healthcaremm.persistance.TypeConverter

import android.arch.persistence.room.TypeConverter
import com.example.acer.healthcaremm.data.vos.AuthorVO
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 * Created by Acer on 7/13/2018.
 */
class AuthorTypeConverter {
    @TypeConverter
     fun toString (author : AuthorVO) : String {
        return Gson().toJson(author)
    }
    fun toAuthor(author: String) : AuthorVO
    {
        val listType = object : TypeToken<AuthorVO>(){}.type
        return Gson().fromJson(author,listType)
    }

}