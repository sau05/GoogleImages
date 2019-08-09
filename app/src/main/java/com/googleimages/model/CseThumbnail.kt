package com.googleimages.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



class CseThumbnail {

    @SerializedName("width")
    @Expose
    val width: String? = null
    @SerializedName("height")
    @Expose
    val height: String? = null
    @SerializedName("src")
    @Expose
    val src: String? = null
}
