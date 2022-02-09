package com.anizmocreations.tenpercenttask.repository

import com.anizmocreations.tenpercenttask.repository.remote.APIService

/**
 * This class contains all the data retrieval methods, at the moment there is only method but when
 * the application scales and there is a need to add a Room DB then this repository can serve as
 * a single class that can be used to retrieve all the data by doing method calls.
 */
class MainRepository constructor(private val retrofitService: APIService) {

    /**
     * Fetches all the topics from network call, irrespective of them being featured or not.
     */
    fun getAllTopics() = retrofitService.getAllTopics()

}