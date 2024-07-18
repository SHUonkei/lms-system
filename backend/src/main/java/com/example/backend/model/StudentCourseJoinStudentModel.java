package com.example.backend.model;
import lombok.Data;

@Data
public class StudentCourseJoinStudentModel  {
    private String Student_Id;
    private String Course_Id;
    private String Student_Name;

    public String getStudent_Id() {
        return Student_Id;
    }
    public void setStudent_Id(String id) {
        Student_Id = id;
    }

    public String getCourse_Id() {
        return Course_Id;
    }
    public void setCourse_Id(String id) {
        Course_Id = id;
    }

    public String getStudent_Name() {
        return Student_Name;
    }
    
    public void setStudent_Name(String name) {
        Student_Name =  name;
    }
}