package com.googleimages.network

import com.googleimages.model.QueryResponse
import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

interface APIInterface {

//    @Header("Content-Type:application/json")
    @GET("v1")
    fun getQueryData(@HeaderMap headers: Map<String,String>,@Query("q") query:String,@Query("cx") cx:String,@Query("key") key:String): Observable<QueryResponse>
}