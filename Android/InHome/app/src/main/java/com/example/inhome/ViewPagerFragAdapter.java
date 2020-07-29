package com.example.inhome;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerFragAdapter extends FragmentStateAdapter {

    public List<FragmentWeekly> fragmentList = new ArrayList<>();
    private final int numFrags = 2;

    public ViewPagerFragAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {

        super(fragmentManager, lifecycle);
    }


    @NonNull
    @Override
    public Fragment createFragment(int position) {

        if(position == 0) {

            FragmentWeekly fragment = FragmentWeekly.newInstance();

            fragmentList.add(fragment);

            return fragment;
        }
        else {
            FragmentDate fragment = FragmentDate.newInstance();
            return fragment;
        }
    }



    @Override
    public int getItemCount() {
        return numFrags;
    }

}
