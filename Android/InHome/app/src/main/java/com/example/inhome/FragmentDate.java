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

        View view = inflater.inflate(R.layout.fragment_date, container, false);

        dateButton = (ImageButton) view.findViewById(R.id.button_date);

        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), DateSelectionActivity.class);

                Objects.requireNonNull(getActivity()).startActivityForResult(intent, 1);
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