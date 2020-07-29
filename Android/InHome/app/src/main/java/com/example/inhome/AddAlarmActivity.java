package com.example.inhome;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.Arrays;


public class AddAlarmActivity extends AppCompatActivity {

    ArrayList<Long> dateList;

    ViewPagerFragAdapter adapter;
    ViewPager2 viewPager;
    TabLayout tabLayout;
    Button submitButton;
    Button cancelButton;
    EditText inputDescription;
    EditText inputTitle;
    TimePicker timePicker;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_alarm);

        dateList = new ArrayList<Long>();

        buildFragments();
        buildGUIElements();
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {

            if (resultCode == RESULT_OK) {

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

        viewPager = findViewById(R.id.viewpager2);
        tabLayout = findViewById(R.id.fragment_tabs);
        adapter = new ViewPagerFragAdapter(this.getSupportFragmentManager(), this.getLifecycle());
        viewPager.setAdapter(adapter);

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

        submitButton = findViewById(R.id.button_submit);
        cancelButton = findViewById(R.id.button_cancel);
        inputDescription = findViewById(R.id.input_description);
        inputTitle = findViewById(R.id.input_title);
        timePicker = findViewById(R.id.timePicker);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(inputTitle.getText().toString().equals("")) {
                    Toast.makeText(AddAlarmActivity.this, "Please add a title...", Toast.LENGTH_SHORT).show();
                }

                 else if(inputDescription.getText().toString().equals("")) {
                    Toast.makeText(AddAlarmActivity.this, "Please add a description...", Toast.LENGTH_SHORT).show();
                }

                else if(tabLayout.getSelectedTabPosition() == 1 && dateList.size() == 0) {
                    Toast.makeText(AddAlarmActivity.this, "Please select at least one date...", Toast.LENGTH_SHORT).show();
                }

                else {

                    String title = inputTitle.getText().toString();
                    String description = inputDescription.getText().toString();
                    int hour = timePicker.getHour();
                    int minute = timePicker.getMinute();

                    if(tabLayout.getSelectedTabPosition() == 0) {

                        final FragmentWeekly fragmentWeekly = adapter.fragmentList.get(0);

                        AlarmWeekly alarm = new AlarmWeekly();

                        alarm.setTitle(title);
                        alarm.setDescription(description);
                        alarm.setHour(hour);
                        alarm.setMinute(minute);
                        alarm.setAlarmImage(R.drawable.ic_baseline_access_alarm_24);

                        alarm.setDays(fragmentWeekly.reportDays());

                        Intent resultIntent = new Intent(AddAlarmActivity.this, MainActivity.class);

                        resultIntent.putExtra("alarm", alarm);

                        setResult(RESULT_OK, resultIntent);
                        finish();
                    }

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

                        setResult(RESULT_OK, resultIntent);
                        finish();
                    }
                }
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
            }
        });
    }
}

