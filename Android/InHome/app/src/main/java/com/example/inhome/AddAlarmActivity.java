/**************************AddAlarmActivity****************************************
 Description: Activity class to drive the adding of a new alarm. This
 activity hosts a tab view utilizing a ViewPager2 to display 2 fragments
 within the tabs. Each tab is used for a different scheduling mode for
 the alarms.
 ***********************************************************************
 Created Date: 07/28/2020
 ***********************************************************************
 Author: John Neigel
 ***********************************************************************
 Last Edit: 08/08/2020
 **********************************************************************/

package com.example.inhome;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TimePicker;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class AddAlarmActivity extends AppCompatActivity {

    private final int REQUEST_RECORD_AUDIO_PERMISSION = 0;

    ArrayList<Long> dateList;       // list used to store selected dates from the calendar
    ViewPagerFragAdapter adapter;   // adapter to control display of fragment views
    ViewPager2 viewPager;           // ViewPager2 to be used with above adapter
    TabLayout tabLayout;            // used to house tabs for each of the views
    Button submitButton;            // button to attempt creating new alarm
    Button cancelButton;            // button to cancel adding alarm and return to MainActivity
    EditText inputDescription;      // view for alarm description
    EditText inputTitle;            // view for alarm title
    TimePicker timePicker;          // widget for selecting alarm time
    ImageButton recordButton;       // starts and stops the MediaRecorder
    MediaRecorder recorder;         // object to activate device microphone and record audio
    String audioFilePath;           // temp filepath for the audio recording
    ImageButton buttonPlay;         // button for playback of audio recording
    Calendar alarmCalendar;         // calendar to pass to the AlarmManager


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_alarm);

        dateList = new ArrayList<Long>();


        recorder = new MediaRecorder();
        audioFilePath = getExternalFilesDir(null) + "audio_recording";

        //check current permissions from the user. If not granted, request permission.
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this, new String[] { Manifest.permission.RECORD_AUDIO}, REQUEST_RECORD_AUDIO_PERMISSION);

            //if permissions are denied, display message and return to MainActivity.
            if(ActivityCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) == PackageManager.PERMISSION_DENIED) {

                Toast.makeText(AddAlarmActivity.this, "This app requires this permission for you to record and store " +
                        "the recording of your voice for the alarm. This Application will not use the Microphone or record " +
                        "any time outside of you pressing the record button for a new alarm.", Toast.LENGTH_LONG).show();

                finish();
            }
        }

        //configure the recorder
        recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        recorder.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB);
        recorder.setOutputFile(audioFilePath);


        buildFragments();
        buildGUIElements();
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // check which activity we are returning from
        if (requestCode == 1) {

            // if we returned properly from the activity
            if (resultCode == RESULT_OK) {

                // get the long dates from the intent
                long[] returnArray = data.getLongArrayExtra("dates");

                for (long i: returnArray) {
                    dateList.add(i);
                }

                Toast.makeText(AddAlarmActivity.this, dateList.toString(), Toast.LENGTH_SHORT).show();
            }

            if (resultCode == RESULT_CANCELED) {
                Toast.makeText(AddAlarmActivity.this, "Press DONE to add dates...", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void buildFragments() {

        // link object with their XML views
        viewPager = findViewById(R.id.viewpager2);
        tabLayout = findViewById(R.id.fragment_tabs);

        // instantiate a new adapter to handle fragments
        adapter = new ViewPagerFragAdapter(this.getSupportFragmentManager(), this.getLifecycle());

        // set the adapter for the viewpager
        viewPager.setAdapter(adapter);

        // configure the tabs and link it with the viewpager
        new TabLayoutMediator(tabLayout, viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {

                if(position == 0)
                    tab.setText("Weekly");
                else
                    tab.setText("Date");

            }
        }).attach();
    }

    public void buildGUIElements() {

        // set up objects with their XML views
        submitButton = findViewById(R.id.button_submit);
        cancelButton = findViewById(R.id.button_cancel);
        inputDescription = findViewById(R.id.input_description);
        inputTitle = findViewById(R.id.input_title);
        timePicker = findViewById(R.id.timePicker);
        recordButton = findViewById(R.id.button_record);
        buttonPlay = findViewById(R.id.button_play);
        buttonPlay.setEnabled(false);                               // initially disabled since there is no recording yet

        // listener for when user want to finish creating the new alarm
        submitButton.setOnClickListener(new View.OnClickListener() {

            File audioFile = new File(audioFilePath);

            @Override
            public void onClick(View view) {

                // check empty fields and prompt for input
                if(inputTitle.getText().toString().equals("")) {
                    Toast.makeText(AddAlarmActivity.this, "Please add a title...", Toast.LENGTH_SHORT).show();
                }

                 else if(inputDescription.getText().toString().equals("")) {
                    Toast.makeText(AddAlarmActivity.this, "Please add a description...", Toast.LENGTH_SHORT).show();
                }

                else if(tabLayout.getSelectedTabPosition() == 1 && dateList.size() == 0) {
                    Toast.makeText(AddAlarmActivity.this, "Please select at least one date...", Toast.LENGTH_SHORT).show();
                }

                else if(!audioFile.exists()) {
                    Toast.makeText(AddAlarmActivity.this, "Please record a message for the alarm...", Toast.LENGTH_SHORT).show();
                }

                // all fields are filled, start obtaining values
                else {

                    String title = inputTitle.getText().toString();
                    String description = inputDescription.getText().toString();
                    int hour = timePicker.getHour();
                    int minute = timePicker.getMinute();

                    // if this is weekly tab
                    if(tabLayout.getSelectedTabPosition() == 0) {

                        final FragmentWeekly fragmentWeekly = adapter.fragmentList.get(0);

                        AlarmWeekly alarm = new AlarmWeekly();

                        alarm.setTitle(title);
                        alarm.setDescription(description);
                        alarm.setHour(hour);
                        alarm.setMinute(minute);
                        alarm.setAlarmImage(R.drawable.ic_baseline_access_alarm_24);

                        // get the user selected days from the fragment
                        alarm.setDays(fragmentWeekly.reportDays());

                        Intent resultIntent = new Intent(AddAlarmActivity.this, MainActivity.class);

                        resultIntent.putExtra("alarm", alarm);                              // attach the new alarm to the intent
                        resultIntent.putExtra("audioFilePath", audioFilePath.toString());   // attach the file path for the audio recording

                        // schedule the alarm with the AlarmManager
                        Intent alarmIntent = new Intent(AddAlarmActivity.this, AlarmReceiver.class);

                        // instantiate the calendar to pass to the AlarmManager and give user values
                        alarmCalendar = Calendar.getInstance();

                        // todo finish this
/*                        alarmCalendar.set(Calendar.HOUR_OF_DAY, hour);
                        alarmCalendar.set(Calendar.MINUTE, minute);
                        alarmCalendar.set(Calendar.MONTH, )*/



                        setResult(RESULT_OK, resultIntent);

                        finish();
                    }

                    // if this is date tab
                    else if(tabLayout.getSelectedTabPosition() == 1) {

                        AlarmDate alarm = new AlarmDate();

                        alarm.setTitle(title);
                        alarm.setDescription(description);
                        alarm.setHour(hour);
                        alarm.setMinute(minute);
                        alarm.setAlarmImage(R.drawable.ic_baseline_access_alarm_24);

                        alarm.setDateArrayList(dateList);

                        Intent resultIntent = new Intent(AddAlarmActivity.this, MainActivity.class);

                        resultIntent.putExtra("alarm", alarm);
                        resultIntent.putExtra("audioFilePath", audioFilePath);

                        setResult(RESULT_OK, resultIntent);
                        finish();
                    }
                }
            }
        });

        // if the user clicks the cancel button we exit to last activity
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
            }
        });

        // user has clicked the record button
        recordButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

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

    public List<Long> getDateList() {

        return dateList;
    }
}