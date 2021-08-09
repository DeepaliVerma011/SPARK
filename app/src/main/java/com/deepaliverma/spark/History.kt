package com.deepaliverma.spark

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main1.*
import kotlinx.android.synthetic.main.activity_transfer.*
import java.util.*

class History : AppCompatActivity() {
    private lateinit var viewModel: DataViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        DataDatabase.getDatabase(this)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = HistoryAdapter(this)
        recyclerView.adapter = adapter

        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        ).get(DataViewModel::class.java)

        viewModel.allDataNow.observe(this, Observer { list ->
            list?.let {
                adapter.updateList(it)
            }

        })

    }
}