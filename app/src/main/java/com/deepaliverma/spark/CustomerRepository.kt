package com.deepaliverma.spark

import androidx.lifecycle.LiveData
import androidx.room.Dao

class CustomerRepository(private val userDao: UserDao) {

    val allCustomers : LiveData<List<User>> = userDao.getAllUser()

    suspend fun insert(user: User){
        userDao.insert(user)
    }

    suspend fun update(amount:Int,number:String){
        userDao.updateUser(amount,number)
    }


}