package com.anizmocreations.tenpercenttask.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.anizmocreations.tenpercenttask.repository.MainRepository

/**
 * Returns the appropriate ViewModel as per the class passed to it.
 */
class MyViewModelFactory constructor(private val repository: MainRepository) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(MainRepository::class.java).newInstance(repository)
    }

}