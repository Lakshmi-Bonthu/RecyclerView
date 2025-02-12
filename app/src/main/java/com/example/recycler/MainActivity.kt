package com.example.recycler

import Item
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initializing RecyclerView
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)


        val itemList = List(14) { index ->
            Item(
                imageResId = R.drawable.ic_launcher_foreground, // Set a default image or your own
                heading = "Item ${index + 1}",
                text = "This is some description for item ${index + 1}"
            )
        }

        // Setting  RecyclerView with Adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = RecyclerViewAdapter(this, itemList)
    }
}
