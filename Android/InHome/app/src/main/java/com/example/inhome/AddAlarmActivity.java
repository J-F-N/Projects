package com.example.inhome;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;


public class AddAlarmActivity extends AppCompatActivity {

    ViewPager2 viewPager;
    TabLayout tabLayout;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_alarm);

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
}

