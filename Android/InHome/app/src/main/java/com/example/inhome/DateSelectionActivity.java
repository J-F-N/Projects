package com.example.inhome;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.squareup.timessquare.CalendarPickerView;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateSelectionActivity extends AppCompatActivity {

public final String DATES = "dates";
    List<Date> selectedDates;
    Button buttonDone;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_selection);

        buildGUIElements();

    }

    public void buildGUIElements() {

        buttonDone = findViewById(R.id.button_done);
        Calendar nextYear = Calendar.getInstance();
        nextYear.add(Calendar.YEAR, 1);

        final CalendarPickerView calendar = (CalendarPickerView) findViewById(R.id.calendar);
        Date today = new Date();
        calendar.init(today, nextYear.getTime())
                .inMode(CalendarPickerView.SelectionMode.MULTIPLE)
                .withSelectedDate(today);

        buttonDone.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent intent = new Intent(DateSelectionActivity.this, AddAlarmActivity.class);

/*                selectedDates = (ArrayList<Date>) calendar.getSelectedDates();

                intent.putExtra("Dates", (ArrayList<Date>) selectedDates);*/

                startActivity(intent);
            }
        });
    }
}
