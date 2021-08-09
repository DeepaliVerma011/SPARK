package com.deepaliverma.spark

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(user: User)

    @Query("Select * from users_table order by id ASC")
    fun getAllUser(): LiveData<List<User>>

   @Query("Update users_table Set amount=:amount1 where number=:number1")
   suspend fun updateUser(amount1:Int,number1:String)
}


