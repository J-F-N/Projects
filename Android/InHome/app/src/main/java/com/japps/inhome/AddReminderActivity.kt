package com.japps.inhome
import android.os.Bundle
import android.widget.CalendarView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class AddReminderActivity : AppCompatActivity() {

    //components for tab management
    lateinit var tabLayout: TabLayout
    lateinit var viewPager: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_reminder)
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);

        //instantiate and link viewpager to adapter
        viewPager = findViewById(R.id.viewPager)
        viewPager.adapter = TabAdapter(this)

        tabLayout = findViewById(R.id.tabLayout)

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when(position) {
                0 -> tab.text = "Weekly"
                else -> tab.text = "Date"
            }
        }.attach()
    }
}