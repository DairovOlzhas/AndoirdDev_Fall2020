package com.example.lesson11

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    var todoList = mutableListOf<ToDo>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .connectTimeout(30, TimeUnit.SECONDS)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

        val apiService = retrofit.create(ApiService::class.java)

//        apiService.getTodos().enqueue(object : Callback<List<ToDo>> {
//            override fun onFailure(call: Call<List<ToDo>>, t: Throwable) {
//                Log.e("error", t.message.toString())
//            }
//            override fun onResponse(call: Call<List<ToDo>>, response: Response<List<ToDo>>) {
//                Log.e("Response size: ", response.body()!!.size.toString())
//                todoList.addAll(response.body()!!)
//            }
//        })
//
//        apiService.getTodoById(1).enqueue(object : Callback<ToDo> {
//            override fun onFailure(call: Call<ToDo>, t: Throwable) {
//                Log.e("error", t.message.toString())
//            }
//            override fun onResponse(call: Call<ToDo>, response: Response<ToDo>) {
//                Log.e("Response size: ", response.body()!!.toString())
//            }
//        })

        apiService.addTodo(2, "Do something", false).enqueue(object : Callback<ToDo> {
            override fun onFailure(call: Call<ToDo>, t: Throwable) {
                Log.e("error", t.message.toString())
            }
            override fun onResponse(call: Call<ToDo>, response: Response<ToDo>) {
                Log.e("POST Response size: ", response.body()!!.toString())
            }
        })
    }
}