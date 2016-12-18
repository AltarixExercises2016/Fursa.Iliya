package com.practice.altarix.fursa.universityapp.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.practice.altarix.fursa.universityapp.R;
import com.practice.altarix.fursa.universityapp.activities.MainActivity;
import com.practice.altarix.fursa.universityapp.adapters.RecyclerViewAdapter;
import com.practice.altarix.fursa.universityapp.data.LessonData;
import com.practice.altarix.fursa.universityapp.dialogs.AddLessonDialogFragment;
import com.practice.altarix.fursa.universityapp.dto.DbManager;

import java.util.ArrayList;
import java.util.List;


public class SaturdayFragment extends Fragment implements View.OnTouchListener {
    public RecyclerView recyclerView;
    public RecyclerViewAdapter recyclerViewAdapter;
    private LinearLayoutManager linearLayoutManager;
    private DbManager dbManager;
    private List<LessonData> lessons;

    public static Fragment newInstance() {
        Bundle args = new Bundle();
        SaturdayFragment fragment = new SaturdayFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sat_fragment, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.sat_rv);
        linearLayoutManager = new LinearLayoutManager(this.getActivity());
        lessons = new ArrayList<>();
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setOnTouchListener(this);
        recyclerViewAdapter = new RecyclerViewAdapter();
        recyclerViewAdapter.add(initMockData());
        recyclerView.setAdapter(recyclerViewAdapter);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        Toast.makeText(this.getActivity(), "Clicked!", Toast.LENGTH_SHORT).show();
        return false;
    }

    private List<LessonData> initMockData() {
        dbManager = new DbManager();
        lessons = dbManager.selectLessonsByDay("Суббота", getActivity());
        return lessons;
    }


}
