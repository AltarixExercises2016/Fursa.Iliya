package com.practice.altarix.fursa.universityapp.adapters;


import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import com.practice.altarix.fursa.universityapp.R;
import com.practice.altarix.fursa.universityapp.data.LessonData;

import java.util.List;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.LessonViewHolder> {
    private List<LessonData> lessonList;

    public RecyclerViewAdapter() {
    }

    @Override
    public LessonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card, parent, false);
        return new LessonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(LessonViewHolder holder, int position) {
        LessonData data = lessonList.get(position);

        holder.tvLesson.setText(String.valueOf(data.lesson));
        holder.tvAuditory.setText(String.valueOf(data.auditory));
        holder.tvTime.setText(String.valueOf(data.time));
        holder.tvTeacher.setText(String.valueOf(data.teacher));
        holder.tvType.setText(String.valueOf(data.type));

    }

    public void add(List<LessonData> lessonList) {
        this.lessonList = lessonList;
    }

    @Override
    public int getItemCount() {
        return lessonList.size();
    }

    public static class LessonViewHolder extends RecyclerView.ViewHolder implements AdapterView.OnLongClickListener {
        CardView lessonCard;
        TextView tvType, tvTeacher, tvAuditory, tvTime, tvLesson;

        public LessonViewHolder(View itemView) {
            super(itemView);

            itemView.setOnLongClickListener(this);
            lessonCard = (CardView) itemView.findViewById(R.id.cv);
            tvType = (TextView) itemView.findViewById(R.id.tv_type);
            tvTeacher = (TextView) itemView.findViewById(R.id.tv_teacher);
            tvAuditory = (TextView) itemView.findViewById(R.id.tv_auditory);
            tvTime = (TextView) itemView.findViewById(R.id.tv_time);
            tvLesson = (TextView) itemView.findViewById(R.id.tv_lesson);
        }


        @Override
        public boolean onLongClick(View view) {

            return false;
        }
    }

}


