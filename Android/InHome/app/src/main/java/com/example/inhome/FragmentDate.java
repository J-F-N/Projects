package com.example.inhome;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.ImageButton;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.squareup.timessquare.CalendarPickerView;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class FragmentDate extends Fragment {

    ImageButton dateButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_date, container, false);

        dateButton = (ImageButton) view.findViewById(R.id.button_date);

        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), DateSelectionActivity.class);

                startActivity(intent);
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