
package com.example.backend.model;

import lombok.Data;

@Data
public class TimetableModel {
    private String dayOfWeek;
    private String timePeriod;
    private String courseName;

    // Getter and Setter for dayOfWeek
    public String getDayOfWeek() {
        return dayOfWeek;
    }
    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    // Getter and Setter for timePeriod
    public String getTimePeriod() {
        return timePeriod;
    }
    public void setTimePeriod(String timePeriod) {
        this.timePeriod = timePeriod;
    }

    // Getter and Setter for courseName
    public String getCourseName() {
        return courseName;
    }
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}

