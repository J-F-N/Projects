package com.japps.inhome

import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CardAdapter(private val cardData: Array<String>) :
        RecyclerView.Adapter<CardAdapter.CardViewHolder>() {

    class CardViewHolder(val textView : TextView) : RecyclerView.ViewHolder(textView)
}