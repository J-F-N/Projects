package com.example.inhome;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.Date;


public class AddAlarmActivity extends AppCompatActivity {

    public final String TITLE = "title";
    public final String DESCRIPTION = "description";

    ViewPager2 viewPager;
    TabLayout tabLayout;
    Button submitButton;
    Button cancelButton;
    TextInputLayout inputDescription;
    TextInputLayout inputTitle;
    Intent intentFromDates;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_alarm);

        buildFragments();

//        ArrayList<Date> dates = intentFromDates.getParcelableExtra("Dates");


    }

    public void buildFragments() {

        viewPager = findViewById(R.id.viewpager2);
        tabLayout = findViewById(R.id.fragment_tabs);
        ViewPagerFragAdapter adapter = new ViewPagerFragAdapter(this.getSupportFragmentManager(), this.getLifecycle());
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

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(inputDescription.getEditText().toString().equals("")
                || inputTitle.getEditText().toString().equals("")) {
                    Toast.makeText(AddAlarmActivity.this, "Please add a title and description", Toast.LENGTH_SHORT).show();
                }
                else {
                    String title = inputTitle.getEditText().toString();
                    String description = inputDescription.getEditText().toString();
                    //todo add other data for mainActivity



                    Intent intent = new Intent(AddAlarmActivity.this, MainActivity.class);
                }



            }
        });
    }
}

