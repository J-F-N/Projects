 package com.japps.inhome

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

 class ReminderActivity : AppCompatActivity() {

    private lateinit var recyclerView : RecyclerView
     private lateinit var viewAdapter : RecyclerView.Adapter<>
     private lateinit var viewManager : RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reminder)

        viewManager = LinearLayoutManager(this)
        viewAdapter = CardAdapter(cardData)

        recyclerView = findViewById<RecyclerView>(R.id.cardRecycler)
    }
}
