package com.example.inhome;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.material.navigation.NavigationView;

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

        final ImageButton addNew = new ImageButton(this);
        addNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNewAlarm();
            }
        });

    }

    public void addNewAlarm (View view) {
        Intent intent = new Intent(this, AddAlarmActivity.class);
        startActivity(intent);
    }
}