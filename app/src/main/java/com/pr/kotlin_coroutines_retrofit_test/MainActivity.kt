package com.pr.kotlin_coroutines_retrofit_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.pr.kotlin_coruotines_retrofit.Api
import com.pr.kotlin_coruotines_retrofit.Post
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textview=findViewById<TextView>(R.id.textview1)

        val retrofit=Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val api:Api=retrofit.create()

        GlobalScope.launch(Dispatchers.IO) {
            val response=api.getposts().awaitResponse()
            if (response.isSuccessful){
                Log.d("PR7", "onCreate: 200")
                withContext(Dispatchers.Main){
                    textview.text=response.code().toString()
                }
            }


        }




    }
}