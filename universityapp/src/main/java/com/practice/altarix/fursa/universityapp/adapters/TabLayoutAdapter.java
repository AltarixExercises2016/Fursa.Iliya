package com.practice.altarix.fursa.universityapp.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.practice.altarix.fursa.universityapp.data.Days;
import com.practice.altarix.fursa.universityapp.fragments.DayFragment;

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
                return DayFragment.newInstance(position);
            case 1:
                return DayFragment.newInstance(position);
            case 2:
                return DayFragment.newInstance(position);
            case 3:
                return DayFragment.newInstance(position);
            case 4:
                return DayFragment.newInstance(position);
            case 5:
                return DayFragment.newInstance(position);
        }
        return null;
    }

    @Override
    public int getCount() {
        return tabs.size();
    }

}