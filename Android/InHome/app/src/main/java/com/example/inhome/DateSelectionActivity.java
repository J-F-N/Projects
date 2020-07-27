package com.example.inhome;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.squareup.timessquare.CalendarPickerView;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class DateSelectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_selection);

        Calendar nextYear = Calendar.getInstance();
        nextYear.add(Calendar.YEAR, 1);

        final CalendarPickerView calendar = (CalendarPickerView) findViewById(R.id.calendar);
        Date today = new Date();
        calendar.init(today, nextYear.getTime())
                .inMode(CalendarPickerView.SelectionMode.MULTIPLE)
                .withSelectedDate(today);

        calendar.getSelectedDates();

        calendar.setOnDateSelectedListener(new CalendarPickerView.OnDateSelectedListener() {
            @Override
            public void onDateSelected(Date date) {

                Calendar calSelected = Calendar.getInstance();
                calSelected.setTime(date);

                String selectedDate = "" + calSelected.get(Calendar.DAY_OF_MONTH);
                String selectedMonth = "" + calSelected.get(Calendar.MONTH);
                String selectedYear = "" + calSelected.get(Calendar.YEAR);

            }

            @Override
            public void onDateUnselected(Date date) {

            }
        });
    }
}
