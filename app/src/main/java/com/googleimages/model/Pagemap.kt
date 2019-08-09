package com.googleimages.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import android.provider.ContactsContract.CommonDataKinds.Website



class Pagemap {

    @SerializedName("cse_thumbnail")
    @Expose
    val cseThumbnail: List<CseThumbnail>? = null
    @SerializedName("metatags")
    @Expose
    val metatags: List<Metatag>? = null
    @SerializedName("cse_image")
    @Expose
    val cseImage: List<CseImage>? = null
    @SerializedName("website")
    @Expose
    val website: List<Website>? = null
//    @SerializedName("product")
//    @Expose
//    val product: List<Product>? = null
//    @SerializedName("hproduct")
//    @Expose
//    val hproduct: List<Hproduct>? = null
}
