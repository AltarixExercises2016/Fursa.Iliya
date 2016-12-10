package com.practice.altarix.fursa.universityapp.dto;

import android.text.Editable;

/**
 * Created by xxx on 28.11.16.
 */

public class LessonModel {
    String type;
    String teacher;
    String day;
    String lection;
    String time;
    int auditory;

    public LessonModel(String type, int auditory, String time, String lection, String teacher, String day) {
        this.type = type;
        this.time = time;
        this.lection = lection;
        this.teacher = teacher;
        this.day = day;
        this.auditory = auditory;
    }

    public LessonModel() {

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getLection() {
        return lection;
    }

    public void setLection(String lection) {
        this.lection = lection;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }


    public int getAuditory() {
        return auditory;
    }

    public void setAuditory(int auditory) {
        this.auditory = auditory;
    }
}
