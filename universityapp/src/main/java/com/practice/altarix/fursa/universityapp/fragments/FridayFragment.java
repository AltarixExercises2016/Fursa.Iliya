package com.practice.altarix.fursa.universityapp.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.practice.altarix.fursa.universityapp.R;
import com.practice.altarix.fursa.universityapp.adapters.RecyclerViewAdapter;
import com.practice.altarix.fursa.universityapp.data.Days;
import com.practice.altarix.fursa.universityapp.data.LessonData;
import com.practice.altarix.fursa.universityapp.dto.DbManager;

import java.util.List;

public class FridayFragment extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    private LinearLayoutManager linearLayoutManager;
    private List<LessonData> lessons;

    public static Fragment newInstance() {
        Bundle args = new Bundle();
        FridayFragment fragment = new FridayFragment();
        fragment.setArguments(args);
        return fragment;
    }

   public List<LessonData> initLessons() {
       DbManager dbManager = new DbManager();
       lessons = dbManager.getLessonsByDay(Days.FRIDAY, getActivity());
       return lessons;
   }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fri_fragment, container, false);

        recyclerView = (RecyclerView)view.findViewById(R.id.fri_rv);
        linearLayoutManager = new LinearLayoutManager(this.getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerViewAdapter = new RecyclerViewAdapter();
        recyclerViewAdapter.add(initLessons());
        recyclerView.setAdapter(recyclerViewAdapter);

        return view;
    }


}
