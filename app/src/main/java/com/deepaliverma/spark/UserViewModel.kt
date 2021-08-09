package com.deepaliverma.spark

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class UserViewModel(application: Application):AndroidViewModel(application) {

      private val repository:CustomerRepository
     val allCustomersNow:LiveData<List<User>>

    init {
        val dao=AppDatabase.getDatabase(application).userDao()
        repository= CustomerRepository(dao)
        allCustomersNow=repository.allCustomers
        }
       fun insertUser(user: User)=viewModelScope.launch {
       repository.insert(user)

    }
    fun updateUser(amount:Int,number:String)=viewModelScope.launch {
        repository.update(amount,number)

    }



}



