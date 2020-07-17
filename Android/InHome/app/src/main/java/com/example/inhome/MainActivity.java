package com.example.inhome;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView alarmRecyclerView;
    private RecyclerView.Adapter alarmRecyclerAdapter;
    private RecyclerView.LayoutManager alarmLayoutManager;
    public AlarmManager alarmManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        alarmManager = new AlarmManager();
        alarmRecyclerView = findViewById(R.id.recycler_alarm);
        alarmRecyclerView.setHasFixedSize(true);
        alarmLayoutManager = new LinearLayoutManager(this);
        alarmRecyclerAdapter = new alarmAdapter(alarmManager.shareList());

        alarmRecyclerView.setLayoutManager(alarmLayoutManager);
        alarmRecyclerView.setAdapter(alarmRecyclerAdapter);
    }
}