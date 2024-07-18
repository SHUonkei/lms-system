
package com.example.backend.model;

import lombok.Data;

@Data
public class TimetableModel {
    private String Day_Of_Week;
    private String time_Period;
    private String course_Name;
    private String course_id;

    // Getter and Setter for Day_Of_Week
    public String getDay_Of_Week() {
        return Day_Of_Week;
    }
    public void setDay_Of_Week(String Day_Of_Week) {
        this.Day_Of_Week = Day_Of_Week;
    }

    // Getter and Setter for time_Period
    public String gettime_Period() {
        return time_Period;
    }
    public void settime_Period(String time_Period) {
        this.time_Period = time_Period;
    }

    // Getter and Setter for course_Name
    public String getcourse_Name() {
        return course_Name;
    }
    public void setcourse_Name(String course_Name) {
        this.course_Name = course_Name;
    }

    // Getter and Setter for course_id
    public String getcourse_id() {
        return course_id;
    }
    public void setcourse_id(String course_id) {
        this.course_id = course_id;
    }
}

