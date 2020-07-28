package com.example.inhome;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    public AlarmManager alarmManager;
    private RecyclerView alarmRecyclerView;
    private RecyclerView.LayoutManager alarmLayoutManager;
    private ImageButton addButton;
    public AlarmAdapter alarmRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        alarmManager = new AlarmManager();

       buildRecycler();
       buildGUIElements();
    }

    public void buildRecycler() {

        alarmRecyclerView = findViewById(R.id.recycler_alarm);
        alarmLayoutManager = new LinearLayoutManager(this);

        alarmRecyclerView.setHasFixedSize(true);
        alarmRecyclerAdapter = new AlarmAdapter(alarmManager.shareList());
        alarmRecyclerView.setLayoutManager(alarmLayoutManager);
        alarmRecyclerView.setAdapter(alarmRecyclerAdapter);
    }

    public void buildGUIElements() {

        addButton = (ImageButton) findViewById(R.id.button_add);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddAlarmActivity.class);



                startActivity(intent);
            }
        });
    }
}