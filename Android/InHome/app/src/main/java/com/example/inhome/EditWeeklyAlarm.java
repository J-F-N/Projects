package com.example.inhome;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TimePicker;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import java.io.File;
import java.io.IOException;

public class EditWeeklyAlarm extends AppCompatActivity {

    Button saveButton;
    Button cancelButton;
    EditText inputDescription;
    EditText inputTitle;
    TimePicker timePicker;
    ImageButton recordButton;
    MediaRecorder recorder;
    String audioFilePath;
    ImageButton buttonPlay;
    public CheckBox monday;
    public CheckBox tuesday;
    public CheckBox wednesday;
    public CheckBox thursday;
    public CheckBox friday;
    public CheckBox saturday;
    public CheckBox sunday;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_weekly_alarm);

        recorder = new MediaRecorder();
        audioFilePath = getExternalFilesDir(null) + "audio_recording";

        recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        recorder.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB);
        recorder.setOutputFile(audioFilePath);

        //todo implement the rest of this
    }

    private void buildGUI() {

        saveButton = findViewById(R.id.button_save);
        cancelButton = findViewById(R.id.button_cancel);
        inputDescription = findViewById(R.id.input_description);
        inputTitle = findViewById(R.id.input_title);
        timePicker = findViewById(R.id.timePicker);
        recordButton = findViewById(R.id.button_record);
        buttonPlay = findViewById(R.id.button_play);

        saveButton.setOnClickListener(new View.OnClickListener() {

            //todo get the existing audio file
            File audioFile = new File(audioFilePath);

            @Override
            public void onClick(View view) {
                if (inputTitle.getText().toString().equals("")) {
                    Toast.makeText(EditWeeklyAlarm.this, "Please add a title...", Toast.LENGTH_SHORT).show();
                } else if (inputDescription.getText().toString().equals("")) {
                    Toast.makeText(EditWeeklyAlarm.this, "Please add a description...", Toast.LENGTH_SHORT).show();
                } else if (!audioFile.exists()) {
                    Toast.makeText(EditWeeklyAlarm.this, "Please record a message for the alarm...", Toast.LENGTH_SHORT).show();
                } else {

                    String title = inputTitle.getText().toString();
                    String description = inputDescription.getText().toString();
                    int hour = timePicker.getHour();
                    int minute = timePicker.getMinute();


                    AlarmWeekly alarm = new AlarmWeekly();

                    alarm.setTitle(title);
                    alarm.setDescription(description);
                    alarm.setHour(hour);
                    alarm.setMinute(minute);
                    alarm.setAlarmImage(R.drawable.ic_baseline_access_alarm_24);


                    Intent resultIntent = new Intent(EditWeeklyAlarm.this, MainActivity.class);

                    resultIntent.putExtra("alarm", alarm);
                    resultIntent.putExtra("audioFilePath", audioFilePath);

                    setResult(RESULT_OK, resultIntent);

                    finish();
                }
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
            }
        });

        recordButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                //todo create media recorder, turn on audio recording, save to db, playback audio recording
                try {

                    recorder.prepare();
                    recorder.start();
                    recordButton.setImageResource(R.drawable.ic_baseline_stop_24);

                    Toast.makeText(getApplicationContext(), "Recording Started", Toast.LENGTH_SHORT).show();

                    recordButton.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View view) {
                            recorder.stop();
                            recordButton.setImageResource(R.drawable.ic_baseline_mic);
                            buttonPlay.setEnabled(true);
                        }
                    });
                } catch (IOException e) {

                    e.printStackTrace();
                }
            }
        });

        buttonPlay.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                final MediaPlayer player = new MediaPlayer();

                try {

                    player.setDataSource(audioFilePath);
                    player.prepare();

                } catch (IOException e) {

                    e.printStackTrace();
                }

                player.start();
                buttonPlay.setClickable(false);
                buttonPlay.setEnabled(false);

                player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {

                        player.release();
                        buttonPlay.setClickable(true);
                        buttonPlay.setEnabled(true);
                    }
                });
            }
        });
    }

    public boolean[] reportDays() {

        boolean[] dayArray = new boolean[7];

        if (monday.isChecked())
            dayArray[0] = true;
        else
            dayArray[0] = false;

        if (tuesday.isChecked())
            dayArray[1] = true;
        else
            dayArray[1] = false;

        if (wednesday.isChecked())
            dayArray[2] = true;
        else
            dayArray[2] = false;

        if (thursday.isChecked())
            dayArray[3] = true;
        else
            dayArray[3] = false;

        if (friday.isChecked())
            dayArray[4] = true;
        else
            dayArray[4] = false;

        if (saturday.isChecked())
            dayArray[5] = true;
        else
            dayArray[5] = false;

        if (sunday.isChecked())
            dayArray[6] = true;
        else
            dayArray[6] = false;

        return dayArray;
    }
}
