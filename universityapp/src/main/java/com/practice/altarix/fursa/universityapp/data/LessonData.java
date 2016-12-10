package com.practice.altarix.fursa.universityapp.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xxx on 07.12.16.
 */

public class LessonData {
    public String type;
    public String lesson;
    public String teacher;
    public String time;
    public int auditory;

    public LessonData(String type, String lesson, String teacher, String time, int auditory) {
        this.type = type;
        this.lesson = lesson;
        this.teacher = teacher;
        this.time = time;
        this.auditory = auditory;
    }



}
