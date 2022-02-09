package com.anizmocreations.tenpercenttask.repository

import com.anizmocreations.tenpercenttask.repository.remote.APIService

/**
 *
 */
class MainRepository constructor(private val retrofitService: APIService) {

    /**
     * Fetches all the topics from network call, irrespective of them being featured or not.
     */
    fun getAllTopics() = retrofitService.getAllTopics()

}