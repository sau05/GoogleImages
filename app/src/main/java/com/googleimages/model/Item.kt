package com.googleimages.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



class Item {

    @SerializedName("kind")
    @Expose
    val kind: String? = null
    @SerializedName("title")
    @Expose
    val title: String? = null
    @SerializedName("htmlTitle")
    @Expose
    val htmlTitle: String? = null
    @SerializedName("link")
    @Expose
    val link: String? = null
    @SerializedName("displayLink")
    @Expose
    val displayLink: String? = null
    @SerializedName("snippet")
    @Expose
    val snippet: String? = null
    @SerializedName("htmlSnippet")
    @Expose
    val htmlSnippet: String? = null
    @SerializedName("cacheId")
    @Expose
    val cacheId: String? = null
//    @SerializedName("formattedUrl")
//    @Expose
//    val formattedUrl: String? = null
//    @SerializedName("htmlFormattedUrl")
//    @Expose
//    val htmlFormattedUrl: String? = null
    @SerializedName("pagemap")
    @Expose
    val pagemap: Pagemap? = null
}