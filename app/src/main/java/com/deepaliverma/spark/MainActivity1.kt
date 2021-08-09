package com.deepaliverma.spark

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main1.*


class MainActivity1 : AppCompatActivity() {
    private lateinit var viewModel: UserViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main1)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "All Payee"

        AppDatabase.getDatabase(this)

        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = CustomerAdapter(this)
        recyclerView.adapter = adapter


        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        ).get(UserViewModel::class.java)



        viewModel.allCustomersNow.observe(this, Observer { list ->
            list?.let {
                adapter.updateList(it)
            }

        })

        viewModel.apply {
            insertUser(User("Deepali Verma", "8888888888", 10000, 1))
            insertUser(User("Shweta Kumari", "7777777777", 10001, 2))
            insertUser(User("Khushi Rajput", "6666666666", 10002, 3))
            insertUser(User("Abhinav Joshi", "5555555555", 10003, 4))
            insertUser(User("Sakshi Tiwari", "4444444444", 10004, 5))
            insertUser(User("Alia Bhatt", "2222222222", 10005, 6))
            insertUser(User("Tara sharma", "1111111111", 10006, 7))
            insertUser(User("Pooja chaudhary", "9999999999", 10007, 8))
            insertUser(User("Jhankar Sharma", "0000000000", 10008, 9))
            insertUser(User("Ananya Pandey", "1212121212", 10009, 10))
        }


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.one) {
            val i = Intent(this, History::class.java)
            startActivity(i)
        } else if (item.itemId == R.id.two) {
            val i = Intent(this, tnc::class.java)
            startActivity(i)
        }
        return super.onOptionsItemSelected(item)
    }

}