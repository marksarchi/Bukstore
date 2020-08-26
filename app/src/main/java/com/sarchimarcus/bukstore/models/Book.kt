package com.sarchimarcus.bukstore.models

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Book (
    @SerializedName("title")
    @Expose
     var title: String,

    @SerializedName("authors")
    @Expose
     val author: List<String>,


@SerializedName("imageLinks")
@Expose
 val imageLinks: ImageLinks,


@SerializedName("publisher")
@Expose
 val publisher: String,

@SerializedName("publishedDate")
@Expose
 val publishedDate: String,

@SerializedName("description")
@Expose
 val description: String
):Parcelable
