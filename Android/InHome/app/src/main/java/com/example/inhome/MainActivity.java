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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        alarmManager = new AlarmManager();
        RecyclerView alarmRecyclerView = findViewById(R.id.recycler_alarm);
        RecyclerView.LayoutManager alarmLayoutManager = new LinearLayoutManager(this);
        ImageButton addButton = (ImageButton) findViewById(R.id.button_add);

        alarmRecyclerView.setHasFixedSize(true);
        RecyclerView.Adapter alarmRecyclerAdapter = new alarmAdapter(alarmManager.shareList());
        alarmRecyclerView.setLayoutManager(alarmLayoutManager);
        alarmRecyclerView.setAdapter(alarmRecyclerAdapter);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddAlarmActivity.class);

                startActivity(intent);
            }
        });
    }
}