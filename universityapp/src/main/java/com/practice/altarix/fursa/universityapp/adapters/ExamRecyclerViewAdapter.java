package com.practice.altarix.fursa.universityapp.adapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.practice.altarix.fursa.universityapp.R;
import com.practice.altarix.fursa.universityapp.data.ExamDTO;

import java.util.List;

public class ExamRecyclerViewAdapter extends RecyclerView.Adapter<ExamRecyclerViewAdapter.ExamViewHolder> {
    private List<ExamDTO> examDTOList;
    @Override
    public ExamViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.exam_item, parent, false);
        return new ExamRecyclerViewAdapter.ExamViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ExamViewHolder holder, int position) {
        ExamDTO examDTO = examDTOList.get(position);

        holder.tvExamDay.setText(examDTO.examDay);
        holder.tvExamAuditory.setText(String.valueOf(examDTO.examAuditory));
        holder.tvExamLesson.setText(examDTO.examLesson);
        holder.tvExamType.setText(examDTO.examType);
        holder.tvExamTime.setText(examDTO.examTime);
        holder.tvExamTeacher.setText(examDTO.examTeacher);
    }

    public void add(List<ExamDTO> examDTOList) {
        this.examDTOList = examDTOList;
    }

    @Override
    public int getItemCount() {
        return examDTOList.size();
    }

    public class ExamViewHolder extends RecyclerView.ViewHolder {
        CardView examCard;
        TextView tvExamDay, tvExamTime, tvExamTeacher, tvExamType, tvExamLesson, tvExamAuditory;
        public ExamViewHolder(View itemView) {
            super(itemView);
            examCard = (CardView) itemView.findViewById(R.id.examCard);
            tvExamDay = (TextView) itemView.findViewById(R.id.tv_exam_day);
            tvExamTime = (TextView) itemView.findViewById(R.id.tv_exam_time);
            tvExamTeacher = (TextView) itemView.findViewById(R.id.tv_exam_teacher);
            tvExamType = (TextView) itemView.findViewById(R.id.tv_exam_type);
            tvExamLesson = (TextView) itemView.findViewById(R.id.tv_exam_lesson);
            tvExamAuditory = (TextView) itemView.findViewById(R.id.tv_exam_auditory);
        }
    }
}
