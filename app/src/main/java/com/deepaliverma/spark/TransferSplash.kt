package com.deepaliverma.spark

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.deepaliverma.spark.TransferSplash
import java.util.*

class TransferSplash : AppCompatActivity() {
    lateinit var viewModel: DataViewModel
    lateinit var viewModel1: UserViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash2)

        val intent = intent
        val name = intent.getStringExtra("1")
        val transfer = intent.getStringExtra("2").toString()
        val time = intent.getStringExtra("3")
        val date = intent.getStringExtra("4")
        val amount=intent.getStringExtra("5")

        val number=intent.getStringExtra("6")
        val Noamount= amount?.toInt()
        val Notransfer= transfer.toInt()
        val newAmount= Noamount?.plus(Notransfer)!!

        viewModel = ViewModelProvider(
                this,
        ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        ).get(DataViewModel::class.java)

        viewModel1 = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        ).get(UserViewModel::class.java)

        viewModel.insertData(Data(name.toString(),transfer,time.toString(),date.toString()))
       viewModel1.updateUser(newAmount.toInt(),number.toString())



        Handler().postDelayed({
            val i = Intent(this@TransferSplash, MainActivity1::class.java)
            startActivity(i)

            // close this activity
            finish()
        }, (2 * 1000).toLong()) // wait for 2 seconds
    }


}