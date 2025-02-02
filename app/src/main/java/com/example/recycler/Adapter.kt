package com.example.recycler

import Item
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter(
    private val context: Context,
    private val itemList: List<Item>
) : RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder>() {

    inner class RecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val headingTextView: TextView = itemView.findViewById(R.id.headingTextView)
        val textTextView: TextView = itemView.findViewById(R.id.textTextView)

        init {
            // Set click listener for each item
            itemView.setOnClickListener {
                // Show toast with the heading of the clicked item
                val heading = itemList[adapterPosition].heading
                Toast.makeText(context, "You clicked: $heading", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.views, parent, false)
        return RecyclerViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        val item = itemList[position]
        holder.imageView.setImageResource(item.imageResId)
        holder.headingTextView.text = item.heading
        holder.textTextView.text = item.text
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}
