package com.example.inhome;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    private AlarmManager alarmManager;
    private RecyclerView alarmRecyclerView;
    private RecyclerView.LayoutManager alarmLayoutManager;
    private ImageButton addButton;
    private AlarmAdapter alarmRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        alarmManager = new AlarmManager();
        alarmRecyclerView = findViewById(R.id.recycler_alarm);
        alarmLayoutManager = new LinearLayoutManager(this);
        addButton = (ImageButton) findViewById(R.id.button_add);

        alarmRecyclerView.setHasFixedSize(true);
        alarmRecyclerAdapter = new AlarmAdapter(alarmManager.shareList());
        alarmRecyclerView.setLayoutManager(alarmLayoutManager);
        alarmRecyclerView.setAdapter(alarmRecyclerAdapter);

        alarmRecyclerAdapter.setOnItemClickListener(new AlarmAdapter.OnItemClickListener() {

            @Override
            public void onItemClick(int position) {

                //todo change to my apps logic
                alarmManager.getItem(position).changeText("Clicked");
            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddAlarmActivity.class);

                startActivity(intent);
            }
        });
    }
}