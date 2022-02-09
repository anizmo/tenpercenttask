package com.anizmocreations.tenpercenttask.repository.remote

import com.anizmocreations.tenpercenttask.model.TopicResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

/**
 * This interface represents the APIs that are called for the course of this application along with
 * the initialisation of Retrofit Client used for calling the APIs.
 */
interface APIService {

    @GET("topics.json")
    fun getAllTopics(): Call<TopicResponse>

    companion object {

        private const val BASE_URL = "https://tenpercent-interview-project.s3.amazonaws.com/"

        private var retrofitService: APIService? = null

        /**
         * Returns the instance of the APIService interface that contains the retrofit client used
         * to call the API methods.
         */
        fun getInstance(): APIService {

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