package com.practice.altarix.fursa.universityapp.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.practice.altarix.fursa.universityapp.R;


public class MainActivityFragment extends Fragment {
    public static Fragment newInstance(Context context) {
        MainActivityFragment f = new MainActivityFragment();
        return f;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.content_main, container, false);
        return view;
    }
}
