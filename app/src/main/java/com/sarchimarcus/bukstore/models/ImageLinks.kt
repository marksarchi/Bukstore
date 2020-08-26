package com.sarchimarcus.bukstore.models

import android.os.Parcelable
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


@Parcelize
class ImageLinks :Parcelable{
    @SerializedName("smallThumbnail")
    @Expose
    private val smallThumbnail: String? = null

    @SerializedName("thumbnail")
    @Expose
    private val thumbnailUrl: String? = null

    fun getThumbnail(): String? {
        return thumbnailUrl
    }
}