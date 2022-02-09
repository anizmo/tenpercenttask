package com.anizmocreations.tenpercenttask.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.anizmocreations.tenpercenttask.model.Topic
import com.anizmocreations.tenpercenttask.model.TopicResponse
import com.anizmocreations.tenpercenttask.viewmodel.repository.MainRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TopicViewModel(private val repository: MainRepository) : ViewModel() {

    val errorMessage = MutableLiveData<String>()
    private val featuredTopics = MutableLiveData<List<Topic>>()

    fun getFeaturedTopicsLiveData(): MutableLiveData<List<Topic>>{
        return featuredTopics
    }

    fun getTopics() {
        val response = repository.getAllTopics()
        response.enqueue(object : Callback<TopicResponse> {
            override fun onResponse(call: Call<TopicResponse>, response: Response<TopicResponse>) {
                featuredTopics.postValue(response.body()?.topics?.filter{ it.featured == true })
            }

            override fun onFailure(call: Call<TopicResponse>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }

}