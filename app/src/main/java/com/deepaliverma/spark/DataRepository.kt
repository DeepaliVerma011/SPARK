package com.deepaliverma.spark

import androidx.lifecycle.LiveData

class DataRepository(private val datadao: DataDao) {

    val allData : LiveData<List<Data>> = datadao.getAllData()

    suspend fun insert(data: Data){
        datadao.insert(data)
    }


}