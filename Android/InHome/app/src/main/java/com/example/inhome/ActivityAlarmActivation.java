package com.example.inhome;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ActivityAlarmActivation extends AppCompatActivity {

    MediaPlayer player;
    Button buttonAckowledge;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_activation);

        Intent intent = getIntent();
        int alarmID = intent.getIntExtra("id", -1);

        player = new MediaPlayer();
        buildGUI();

        Toast.makeText(ActivityAlarmActivation.this, "This is alarm : " + alarmID, Toast.LENGTH_LONG).show();

    }

    public void buildGUI() {

        buttonAckowledge = findViewById(R.id.button_acknowledge);

        buttonAckowledge.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
