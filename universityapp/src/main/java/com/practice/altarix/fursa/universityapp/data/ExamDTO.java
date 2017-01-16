package com.practice.altarix.fursa.universityapp.data;


public class ExamDTO {
    public String examTeacher;
    public String examTime;
    public String examType;
    public String examLesson;
    public int examAuditory;
    public String examDay;

    public ExamDTO(String examTeacher, String examTime, String examType, String examLesson, int examAuditory, String examDay) {
        this.examTeacher = examTeacher;
        this.examTime = examTime;
        this.examType = examType;
        this.examLesson = examLesson;
        this.examAuditory = examAuditory;
        this.examDay = examDay;
    }
    public String getExamTeacher() {
        return examTeacher;
    }

    public void setExamTeacher(String examTeacher) {
        this.examTeacher = examTeacher;
    }

    public String getExamTime() {
        return examTime;
    }

    public void setExamTime(String examTime) {
        this.examTime = examTime;
    }

    public String getExamType() {
        return examType;
    }

    public void setExamType(String examType) {
        this.examType = examType;
    }

    public String getExamLesson() {
        return examLesson;
    }

    public void setExamLesson(String examLesson) {
        this.examLesson = examLesson;
    }

    public int getExamAuditory() {
        return examAuditory;
    }

    public void setExamAuditory(int examAuditory) {
        this.examAuditory = examAuditory;
    }

    public String getExamDay() {
        return examDay;
    }

    public void setExamDay(String examDay) {
        this.examDay = examDay;
    }


}
