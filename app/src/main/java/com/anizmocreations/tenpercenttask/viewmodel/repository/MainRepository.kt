package com.anizmocreations.tenpercenttask.viewmodel.repository

import com.anizmocreations.tenpercenttask.viewmodel.repository.remote.APIService

class MainRepository constructor(private val retrofitService: APIService) {

    fun getAllTopics() = retrofitService.getAllTopics()

}