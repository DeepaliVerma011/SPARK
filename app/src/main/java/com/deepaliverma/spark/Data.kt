package com.deepaliverma.spark

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "data_table")
data class Data(
    var name:String,
    var amount:String,
    var date:String,
    var time:String,
    @PrimaryKey(autoGenerate = true)
    val id:Long=0L
)