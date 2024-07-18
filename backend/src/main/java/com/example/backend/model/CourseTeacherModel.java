package com.example.backend.model;
import lombok.Data;

@Data
public class CourseTeacherModel {
    private String Id;
    private String Name;
    private String Teacher_Name;
    private String Room;

    public String getId() {
        return Id;
    }
    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }

    public String getTeacher_Name() {
        return Teacher_Name;
    }
    public void setTeacher_Name(String teacher_name) {
        Teacher_Name = teacher_name;
    }

    public String getRoom() {
        return Room;
    }
    public void setRoom(String room) {
        Room = room;
    }
}