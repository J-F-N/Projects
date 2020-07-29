package com.example.inhome;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.Objects;


public class FragmentWeekly extends Fragment {

    public CheckBox monday;
    public CheckBox tuesday;
    public CheckBox wednesday;
    public CheckBox thursday;
    public CheckBox friday;
    public CheckBox saturday;
    public CheckBox sunday;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_weekly, container, false);

        monday = view.findViewById(R.id.check_monday);
        tuesday = view.findViewById(R.id.check_tuesday);
        wednesday = view.findViewById(R.id.check_wednesday);
        thursday = view.findViewById(R.id.check_thursday);
        friday = view.findViewById(R.id.check_friday);
        saturday = view.findViewById(R.id.check_saturday);
        sunday = view.findViewById(R.id.check_sunday);

        return view;
    }

    public static FragmentWeekly newInstance() {

        Bundle args = new Bundle();
        FragmentWeekly fragment = new FragmentWeekly();
        fragment.setArguments(args);
        return fragment;
    }

    public boolean[] reportDays() {

        boolean[] dayArray = new boolean[7];

        if(monday.isChecked())
            dayArray[0] = true;
        else
            dayArray[0] = false;

        if(tuesday.isChecked())
            dayArray[1] = true;
        else
            dayArray[1] = false;

        if(wednesday.isChecked())
            dayArray[1] = true;
        else
            dayArray[1] = false;

        if(thursday.isChecked())
            dayArray[1] = true;
        else
            dayArray[1] = false;

        if(friday.isChecked())
            dayArray[1] = true;
        else
            dayArray[1] = false;

        if(saturday.isChecked())
            dayArray[1] = true;
        else
            dayArray[1] = false;

        if(sunday.isChecked())
            dayArray[1] = true;
        else
            dayArray[1] = false;

        return dayArray;
    }
}