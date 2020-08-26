package com.sarchimarcus.bukstore.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Volumes(
    @SerializedName("kind")
    @Expose
    val kind:String,

    @SerializedName("items")
    @Expose
    val books:List<Item>

)



