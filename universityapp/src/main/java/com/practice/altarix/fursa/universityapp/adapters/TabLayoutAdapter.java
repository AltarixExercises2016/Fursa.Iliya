package com.practice.altarix.fursa.universityapp.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.practice.altarix.fursa.universityapp.R;
import com.practice.altarix.fursa.universityapp.fragments.MondayFragment;

import java.util.ArrayList;
import java.util.Arrays;


public class TabLayoutAdapter extends FragmentPagerAdapter{
    private ArrayList<String> tabs;

    public TabLayoutAdapter(FragmentManager fm) {
        super(fm);

        tabs = new ArrayList<>(Arrays.asList("Понедельник",
                "Вторник",
                "Cреда",
                "Четверг",
                "Пятница",
                "Суббота"));


    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabs.get(position);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return MondayFragment.getInstance();
            case 1:
                return MondayFragment.getInstance();
            case 2:
                return MondayFragment.getInstance();
            case 3:
                return MondayFragment.getInstance();
            case 4:
                return MondayFragment.getInstance();
            case 5:
                return MondayFragment.getInstance();
        }
        return null;
    }

    @Override
    public int getCount() {
        return tabs.size();
    }
}
