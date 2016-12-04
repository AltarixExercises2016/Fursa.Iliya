package com.practice.altarix.fursa.universityapp.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.practice.altarix.fursa.universityapp.R;

/**
 * Created by xxx on 03.12.16.
 */

public class MondayFragment extends Fragment {
    public static MondayFragment getInstance() {
        Bundle args = new Bundle();
        MondayFragment mondayFragment = new MondayFragment();
        mondayFragment.setArguments(args);

        return mondayFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mon_fragment, container, false);
        return view;
    }

}
