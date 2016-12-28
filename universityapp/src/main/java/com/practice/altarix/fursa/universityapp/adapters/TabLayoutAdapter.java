package com.practice.altarix.fursa.universityapp.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.practice.altarix.fursa.universityapp.data.Days;
import com.practice.altarix.fursa.universityapp.fragments.MondayFragment;
import com.practice.altarix.fursa.universityapp.fragments.FridayFragment;
import com.practice.altarix.fursa.universityapp.fragments.SaturdayFragment;
import com.practice.altarix.fursa.universityapp.fragments.ThursdayFragment;
import com.practice.altarix.fursa.universityapp.fragments.TuesdayFragment;
import com.practice.altarix.fursa.universityapp.fragments.WednesdayFragment;

import java.util.ArrayList;
import java.util.Arrays;


public class TabLayoutAdapter extends FragmentPagerAdapter {
    private ArrayList<String> tabs;

    public TabLayoutAdapter(FragmentManager fm) {
        super(fm);
        tabs = new ArrayList<>(Arrays.asList(
                Days.MONDAY,
                Days.TUESDAY,
                Days.WEDNESDAY,
                Days.THURSDAY,
                Days.FRIDAY,
                Days.SATURDAY));
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabs.get(position);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return MondayFragment.newInstance();
            case 1:
                return TuesdayFragment.newInstance();
            case 2:
                return WednesdayFragment.newInstance();
            case 3:
                return ThursdayFragment.newInstance();
            case 4:
                return FridayFragment.newInstance();
            case 5:
                return SaturdayFragment.newInstance();
        }
        return null;
    }

    @Override
    public int getCount() {
        return tabs.size();
    }

}
