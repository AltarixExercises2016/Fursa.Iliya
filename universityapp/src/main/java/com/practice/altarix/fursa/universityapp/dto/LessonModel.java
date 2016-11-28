package com.practice.altarix.fursa.universityapp.dto;

/**
 * Created by xxx on 28.11.16.
 */

public class LessonModel {
    String type;
    String teacher;
    String day;
    String lection;
    String time;
    String comment;

    public LessonModel(String type, String comment, String time, String lection, String teacher, String day) {
        this.type = type;
        this.comment = comment;
        this.time = time;
        this.lection = lection;
        this.teacher = teacher;
        this.day = day;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
