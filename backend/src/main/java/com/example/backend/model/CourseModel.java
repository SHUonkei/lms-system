package com.example.backend.model;
import lombok.Data;

@Data
public class CourseModel {
    private String Id;
    private String Name;
    private String Teacher_Id;
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

    public String getTeacher_Id() {
        return Teacher_Id;
    }
    public void setTeacher_Id(String teacher_id) {
        Teacher_Id = teacher_id;
    }

    public String getRoom() {
        return Room;
    }
    public void setRoom(String room) {
        Room = room;
    }
}