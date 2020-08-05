/**************************FragmentWeekly*******************************
 Description: Subclass of Fragment used to instantiate a custom Fragment
 object containing views and objects to retrieve user inputted data.
 FragmentWeekly represents the Fragment for accepting user input data
 for a new AlarmWeekly object.
 ***********************************************************************
 Created Date: 07/18/2020
 ***********************************************************************
 Author: John Neigel
 ***********************************************************************
 Last Edit: 07/28/2020
 **********************************************************************/
package com.example.inhome;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentWeekly extends Fragment {

    // Checkbox objects for obtaining which days of the week the user
    // would like to have the alarm sound.
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

        // inflate the view initially, since we need to assign views to their objects
        View view = inflater.inflate(R.layout.fragment_weekly, container, false);

        // assign views to objects
        monday = view.findViewById(R.id.check_monday);
        tuesday = view.findViewById(R.id.check_tuesday);
        wednesday = view.findViewById(R.id.check_wednesday);
        thursday = view.findViewById(R.id.check_thursday);
        friday = view.findViewById(R.id.check_friday);
        saturday = view.findViewById(R.id.check_saturday);
        sunday = view.findViewById(R.id.check_sunday);

        // return the view for display to user
        return view;
    }

    // factory method needed by ViewPagerFragAdapter for instantiation of new Fragment objects.
    public static FragmentWeekly newInstance() {

        Bundle args = new Bundle();
        FragmentWeekly fragment = new FragmentWeekly();
        fragment.setArguments(args);
        return fragment;
    }

    /***************************reportDays********************************
     Description: Method to validate user input. Checks to see which
     checkboxes are selected for the alarms days of the week.
     *********************************************************************
     Params: N/A
     *********************************************************************
     Return: boolean[]  Size 7 array with each index of the array
     representing whether a day is checked for alarm sounding. Index
     0 represents Monday.
     ********************************************************************/
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
            dayArray[2] = true;
        else
            dayArray[2] = false;

        if(thursday.isChecked())
            dayArray[3] = true;
        else
            dayArray[3] = false;

        if(friday.isChecked())
            dayArray[4] = true;
        else
            dayArray[4] = false;

        if(saturday.isChecked())
            dayArray[5] = true;
        else
            dayArray[5] = false;

        if(sunday.isChecked())
            dayArray[6] = true;
        else
            dayArray[6] = false;

        return dayArray;
    }
}