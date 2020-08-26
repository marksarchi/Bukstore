package com.sarchimarcus.bukstore.models

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Item (
    @SerializedName("id")
    @Expose
    val id:String,

    @SerializedName("volumeInfo")
    @Expose
    val book:Book):Parcelable