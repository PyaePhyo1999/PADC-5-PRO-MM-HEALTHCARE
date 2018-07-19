package com.example.acer.healthcaremm.data.vos

import com.google.gson.annotations.SerializedName

/**
 * Created by Acer on 7/12/2018.
 */
class AuthorVO {

    @SerializedName("author-id")
    var authorId : Int? = null

    @SerializedName("author-name")
    var authorName : String ? = null

    @SerializedName("author-picture")
    var authorPic : String? = null

}