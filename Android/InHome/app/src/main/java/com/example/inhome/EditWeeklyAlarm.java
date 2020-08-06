package com.example.inhome;

import android.Manifest;
import android.content.pm.PackageManager;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TimePicker;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

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
}
