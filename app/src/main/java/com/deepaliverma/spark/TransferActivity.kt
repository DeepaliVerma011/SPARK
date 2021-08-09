package com.deepaliverma.spark

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.activity_transfer.*
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*


class TransferActivity : AppCompatActivity() {

    val format: SimpleDateFormat = SimpleDateFormat("HH:mm:ss")
    private lateinit var alertDialogBuilder: MaterialAlertDialogBuilder
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transfer)

        val intent = intent
        val name = intent.getStringExtra("1")
        val number = intent.getStringExtra("2")
        val amount = intent.getIntExtra("3", 0).toString()


        name11.text = name
        number11.text = number
        amount11.text = amount

        transferButton.setOnClickListener {
            if (transfermoney11.text.isNullOrEmpty()) {
                Toast.makeText(this, "Please enter amount to transfer!", Toast.LENGTH_SHORT).show()

            } else if (transfermoney11.text.isNotEmpty()) {
                val money11 = transfermoney11.text
                alertDialogBuilder = MaterialAlertDialogBuilder(this).apply {
                    setTitle("MONEY TRANSFER")
                    setMessage("Do you want to transfer $money11 rupees to $name from your Spark bank account ?")
                    setPositiveButton("Ok") { _, _ ->
                        showSplashActivity()
                    }

                    setNegativeButton("Cancel") { dialog, _ ->
                        dialog.dismiss()
                    }

                    setCancelable(false)
                    create()
                    show()
                }
            }
        }


    }

    private fun showSplashActivity() {
        startActivity(
            Intent(this, TransferSplash::class.java).putExtra("1",name11.text)
                .putExtra("2",transfermoney11.text.toString())
                .putExtra("3",format.format(Calendar.getInstance().time))
                .putExtra("4",DateFormat.getDateInstance(DateFormat.FULL).format(Calendar.getInstance().time))
                .putExtra("5",amount11.text)
                .putExtra("6",number11.text)
        )
        finish()
    }
}
