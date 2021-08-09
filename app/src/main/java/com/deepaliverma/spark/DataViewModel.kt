package com.deepaliverma.spark

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class DataViewModel(application: Application): AndroidViewModel(application) {

    private val repository:DataRepository
    val allDataNow: LiveData<List<Data>>

    init {
        val dao=DataDatabase.getDatabase(application).dataDao()
        repository= DataRepository(dao)
        allDataNow=repository.allData
    }
    fun insertData(data: Data)=viewModelScope.launch {
        repository.insert(data)

    }



}
