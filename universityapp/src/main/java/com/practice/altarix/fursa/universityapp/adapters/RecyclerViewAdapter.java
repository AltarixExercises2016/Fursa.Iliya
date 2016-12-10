package com.practice.altarix.fursa.universityapp.adapters;


import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.practice.altarix.fursa.universityapp.R;
import com.practice.altarix.fursa.universityapp.data.LessonData;

import java.util.ArrayList;
import java.util.List;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.LessonViewHolder> {
    private List<LessonData> lessonList;

    public RecyclerViewAdapter(List<LessonData> lessonList) {
        this.lessonList = lessonList;

    }



    public static class LessonViewHolder extends RecyclerView.ViewHolder {
        CardView lessonCard;
        TextView tvType, tvTeacher, tvAuditory, tvTime, tvLesson;

        public LessonViewHolder(View itemView) {
            super(itemView);

            lessonCard = (CardView)itemView.findViewById(R.id.cv);
            tvType = (TextView)itemView.findViewById(R.id.tv_type);
            tvTeacher = (TextView)itemView.findViewById(R.id.tv_teacher);
            tvAuditory = (TextView)itemView.findViewById(R.id.tv_auditory);
            tvTime = (TextView)itemView.findViewById(R.id.tv_time);
            tvLesson = (TextView)itemView.findViewById(R.id.tv_lesson);
            
            


        }
    }

    @Override
    public LessonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card, parent, false);
        return new LessonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(LessonViewHolder holder, int position) {
        holder.tvLesson.setText(lessonList.get(position).lesson);
        holder.tvAuditory.setText(String.valueOf(lessonList.get(position).auditory));
        holder.tvTime.setText(lessonList.get(position).time);
        holder.tvTeacher.setText(lessonList.get(position).teacher);
        holder.tvType.setText(lessonList.get(position).type);

    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return lessonList.size();
    }


}


