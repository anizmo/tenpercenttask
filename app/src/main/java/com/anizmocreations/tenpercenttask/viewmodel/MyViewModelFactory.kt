package com.anizmocreations.tenpercenttask.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.anizmocreations.tenpercenttask.viewmodel.repository.MainRepository

class MyViewModelFactory constructor(private val repository: MainRepository)
    : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(TopicViewModel::class.java)) {
            TopicViewModel(this.repository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}