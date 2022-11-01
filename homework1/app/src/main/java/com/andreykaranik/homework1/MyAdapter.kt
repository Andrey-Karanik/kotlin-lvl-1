package com.andreykaranik.homework1

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val squareItemList : List<SquareItem>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.textView.text = position.toString()
        if (position % 2 == 0) {
            holder.cardView.setBackgroundColor(Color.RED)
        } else {
            holder.cardView.setBackgroundColor(Color.BLUE)
        }
    }

    override fun getItemCount(): Int {
        return squareItemList.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView : TextView = itemView.findViewById(R.id.textView)
        val cardView : CardView = itemView.findViewById(R.id.cardView)
    }
}
