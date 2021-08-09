package com.deepaliverma.spark

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import kotlin.collections.ArrayList

class HistoryAdapter(val context:History) :
    RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>() {
    private val array= ArrayList<Data>()
    inner class HistoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvname: TextView = itemView.findViewById(R.id.name22)
        val tvamount: TextView = itemView.findViewById(R.id.amount22)
        val tvdate=itemView.findViewById<TextView>(R.id.date22)
        val tvtime: TextView =itemView.findViewById(R.id.time22)

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HistoryAdapter.HistoryViewHolder{
        val viewHolder = HistoryViewHolder(
            LayoutInflater.from(context).inflate(R.layout.list_item2, parent, false)
        )
        return viewHolder
    }

    override fun onBindViewHolder(holder: HistoryAdapter.HistoryViewHolder, position: Int) {
        val currentUser = array[position]
        holder.tvname.text = currentUser.name
        holder.tvamount.text = currentUser.amount
        holder.tvdate.text=currentUser.date
        holder.tvtime.text=currentUser.time

    }

    override fun getItemCount(): Int {
        return array.size
    }

    fun updateList(newList: List<Data>) {
        array.clear()
        array.addAll(newList)
        notifyDataSetChanged()
    }

}

