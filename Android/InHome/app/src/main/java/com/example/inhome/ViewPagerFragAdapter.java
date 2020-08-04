/**************************ViewPagerFragAdapter*************************
 Description: FragmentStateAdapter subclass used to handle creation of
 and management of FragmentDate and FragmentWeekly objects.
 ***********************************************************************
 Created Date: 07/15/2020
 ***********************************************************************
 Author: John Neigel
 ***********************************************************************
 Last Edit: 07/28/2020
 **********************************************************************/
package com.example.inhome;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerFragAdapter extends FragmentStateAdapter {

    // ArrayList to store reference to FragmentWeekly object. Needed for later retrieval
    // of FragmentWeekly instance.
    public List<FragmentWeekly> fragmentList = new ArrayList<>();

    private final int numFrags = 2;

    // constructor
    public ViewPagerFragAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {

        super(fragmentManager, lifecycle);
    }

    /***************************createFragment****************************
     Description: Method to instantiate a new FragmentWeekly or
     FragmentDate based on the current position of the TabView layout.
     FragmentWeekly objects are additionally stored in an ArrayList
     for later reference and retrieval of View data.
     *********************************************************************
     Params:
     int    position    Used to indicate the current tab selected in the TabLayout.
     *********************************************************************
     Return: Fragment
     ********************************************************************/
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

    // get the current number of Fragment subclasses managed by the adapter.
    @Override
    public int getItemCount() {
        return numFrags;
    }

}
