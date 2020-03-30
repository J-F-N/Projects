 package com.japps.inhome

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_reminder.*

 class ReminderActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reminder)

        btnAddReminder.setOnClickListener {

            val intent = Intent(applicationContext, AddReminderActivity :: class.java)
            startActivity(intent)
        }
    }
 }