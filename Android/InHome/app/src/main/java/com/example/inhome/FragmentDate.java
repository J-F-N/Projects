package com.example.inhome;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.squareup.timessquare.CalendarPickerView;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class FragmentDate extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        Calendar nextYear = Calendar.getInstance();
        nextYear.add(Calendar.YEAR, 1);

        View view = inflater.inflate(R.layout.fragment_date, container, false);
        CalendarPickerView calendar = (CalendarPickerView) view.findViewById(R.id.calendar);
        Date today = new Date();
        calendar.init(today, nextYear.getTime())
                .inMode(CalendarPickerView.SelectionMode.RANGE)
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

        return view;
    }

    public static FragmentDate newInstance() {

        Bundle args = new Bundle();
        FragmentDate fragment = new FragmentDate();
        fragment.setArguments(args);
        return fragment;
    }
}