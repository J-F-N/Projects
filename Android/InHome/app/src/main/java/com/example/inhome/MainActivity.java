package com.example.inhome;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.Arrays;

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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {

            if (resultCode == RESULT_OK) {

                Alarm alarm = data.getParcelableExtra("alarm");
                alarmManager.addAlarm(alarm);

                alarmRecyclerAdapter.notifyDataSetChanged();

                Toast.makeText(MainActivity.this, "Added Alarm " + alarm.title, Toast.LENGTH_SHORT).show();
            }

            if (resultCode == RESULT_CANCELED) {
                Toast.makeText(MainActivity.this, "Cancelled Adding Alarm", Toast.LENGTH_SHORT).show();
            }
        }
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

                startActivityForResult(intent, 1);
            }
        });
    }
}