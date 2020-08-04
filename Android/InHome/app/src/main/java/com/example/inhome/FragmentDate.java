/**************************FragmentWeekly*******************************
 Description: Subclass of Fragment used to instantiate a custom Fragment
 object containing views and objects to retrieve user inputted data.
 FragmentDate represents the Fragment for accepting user input data
 for a new AlarmDate object.
 ***********************************************************************
 Created Date: 07/18/2020
 ***********************************************************************
 Author: John Neigel
 ***********************************************************************
 Last Edit: 07/28/2020
 **********************************************************************/
package com.example.inhome;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import java.util.Objects;

public class FragmentDate extends Fragment {

    ImageButton dateButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // inflate the view since we need to assign objects and get data
        View view = inflater.inflate(R.layout.fragment_date, container, false);

        dateButton = (ImageButton) view.findViewById(R.id.button_date);

        // this will start the DateSelectionActivity
        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), DateSelectionActivity.class);

                Objects.requireNonNull(getActivity()).startActivityForResult(intent, 1);
            }
        });

        return view;
    }

    // factory method needed by ViewPagerFragAdapter for instantiation of new Fragment objects.
    public static FragmentDate newInstance() {

        Bundle args = new Bundle();
        FragmentDate fragment = new FragmentDate();
        fragment.setArguments(args);
        return fragment;
    }
}