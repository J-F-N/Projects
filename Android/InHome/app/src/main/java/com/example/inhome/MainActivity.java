package com.example.inhome;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView alarmRecycler;
    private RecyclerView.Adapter alarmAdapter;
    private RecyclerView.LayoutManager alarmLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<card> cardList = new ArrayList<>();
        cardList.add(new card(R.drawable.ic_baseline_access_alarm_24, "Alarm 1", "today"));
        cardList.add(new card(R.drawable.ic_baseline_access_alarm_24, "Alarm 2", "Teusday"));
        cardList.add(new card(R.drawable.ic_baseline_access_alarm_24, "Alarm 3", "July 14th"));
        cardList.add(new card(R.drawable.ic_baseline_access_alarm_24, "Alarm 4", "whenever"));
        cardList.add(new card(R.drawable.ic_baseline_access_alarm_24, "Alarm 5", "never"));
    }
}