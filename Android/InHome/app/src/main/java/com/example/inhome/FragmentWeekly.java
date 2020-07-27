package com.example.inhome;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class FragmentWeekly extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_weekly, container, false);
    }

    public static FragmentWeekly newInstance() {

        Bundle args = new Bundle();
        FragmentWeekly fragment = new FragmentWeekly();
        fragment.setArguments(args);
        return fragment;
    }


}