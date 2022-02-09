package com.anizmocreations.tenpercenttask.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.anizmocreations.tenpercenttask.model.Topic
import com.anizmocreations.tenpercenttask.model.TopicResponse
import com.anizmocreations.tenpercenttask.repository.MainRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * The TopicViewModel provides the LiveData of the topics that are marked as featured. If there is
 * an error then it returns the error String.
 *
 * @param repository - An instance of MainRepository that contains the methods of data retrieval.
 */
class TopicViewModel(private val repository: MainRepository) : ViewModel() {

    private val errorMessage = MutableLiveData<String>()
    private val featuredTopics = MutableLiveData<List<Topic>>()

    /**
     * Returns the MutableLiveData of the list of Topics that have featured marked as true.
     */
    fun getFeaturedTopicsLiveData(): MutableLiveData<List<Topic>> {
        return featuredTopics
    }

    /**
     * If the network call ends in error then the localised message of the error string is returned
     * as LiveData.
     */
    fun getErrorMessageLiveData(): MutableLiveData<String> {
        return errorMessage
    }

    /**
     * Begins the API call to fetch the topics and then returns the filtered list of topics that
     * only contains the featured field as true.
     */
    fun fetchTopics() {
        val response = repository.getAllTopics()
        response.enqueue(object : Callback<TopicResponse> {

            override fun onResponse(call: Call<TopicResponse>, response: Response<TopicResponse>) {
                featuredTopics.postValue(response.body()?.topics?.filter { it.featured == true })
            }

            override fun onFailure(call: Call<TopicResponse>, t: Throwable) {
                errorMessage.postValue(t.localizedMessage)
            }

        })
    }

}