package com.example.lesson11

import retrofit2.Call
import retrofit2.http.*

public interface ApiService {
    @GET("todos/")
    fun getTodos(): Call<List<ToDo>>

    @GET("todos/{id}/")
    fun getTodoById(@Path("id") todoId: Int): Call<ToDo>

    @GET("todos/")
    fun getTodosByUserId(@Query("userId") userId: Int ): Call<List<ToDo>>

    @FormUrlEncoded
    @POST("todos/")
    fun addTodo(
        @Field("userId") userId: Int,
        @Field("title") title: String,
        @Field("completed") completed: Boolean
    ): Call<ToDo>
}

