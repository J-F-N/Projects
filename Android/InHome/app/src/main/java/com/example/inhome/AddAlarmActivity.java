package com.example.inhome;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import java.util.Arrays;


public class AddAlarmActivity extends AppCompatActivity {

    public final String TITLE = "title";
    public final String DESCRIPTION = "description";
    long[] dateList;

    ViewPager2 viewPager;
    TabLayout tabLayout;
    Button submitButton;
    Button cancelButton;
    EditText inputDescription;
    EditText inputTitle;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_alarm);

        buildFragments();
        buildGUIElements();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {

            if (resultCode == RESULT_OK) {

                assert data != null;
                dateList = data.getLongArrayExtra("dates");

                Toast.makeText(AddAlarmActivity.this, Arrays.toString(dateList), Toast.LENGTH_SHORT).show();
            }

            if (resultCode == RESULT_CANCELED) {
                Toast.makeText(AddAlarmActivity.this, "Press DONE after selecting dates...", Toast.LENGTH_SHORT).show();
            }
        }
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
                if(inputTitle.getText().toString().equals("")) {
                    Toast.makeText(AddAlarmActivity.this, "Please add a title...", Toast.LENGTH_SHORT).show();
                }

                 else if(inputDescription.getText().toString().equals("")) {
                    Toast.makeText(AddAlarmActivity.this, "Please add a description...", Toast.LENGTH_SHORT).show();
                }

                else if(dateList.length == 0) {
                    Toast.makeText(AddAlarmActivity.this, "Please select at least one date...", Toast.LENGTH_SHORT).show();
                }

                else {
                    String title = inputTitle.getText().toString();
                    String description = inputDescription.getText().toString();

                    //todo get the remainder of data and instantiate new alarm

                   finish();
                }
            }
        });
    }
}

