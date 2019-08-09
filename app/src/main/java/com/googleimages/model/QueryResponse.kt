package com.googleimages.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



class QueryResponse {

    @SerializedName("items")
    @Expose
    val items: List<Item>? = null
}