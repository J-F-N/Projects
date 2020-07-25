package com.example.inhome;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPagerFragAdapter extends FragmentStateAdapter {

    private final int numFrags = 2;

    public ViewPagerFragAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {

        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        if(position == 0)
            return FragmentWeekly.newInstance();
        else
            return FragmentDate.newInstance();
    }

    @Override
    public int getItemCount() {
        return numFrags;
    }
}
