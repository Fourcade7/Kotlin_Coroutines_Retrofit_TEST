package com.pr.kotlin_coruotines_retrofit

import retrofit2.Call
import retrofit2.http.GET

interface Api {


    @GET("posts")
    fun getposts():Call<List<Post>>

}