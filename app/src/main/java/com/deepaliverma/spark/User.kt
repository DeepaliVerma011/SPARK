package com.deepaliverma.spark

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users_table")
data class User(
    var name:String,
    var number:String,
    var amount:Int,
    @PrimaryKey(autoGenerate = true)
    val id:Long=0L
)