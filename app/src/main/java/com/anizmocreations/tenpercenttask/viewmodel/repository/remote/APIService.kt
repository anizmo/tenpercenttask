package com.anizmocreations.tenpercenttask.viewmodel.repository.remote

import com.anizmocreations.tenpercenttask.model.TopicResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface APIService {

    @GET("topics.json")
    fun getAllTopics() : Call<TopicResponse>

    companion object {

        val BASE_URL = "https://tenpercent-interview-project.s3.amazonaws.com/"

        var retrofitService: APIService? = null

        fun getInstance() : APIService {

            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(APIService::class.java)
            }
            return retrofitService!!
        }
    }

}