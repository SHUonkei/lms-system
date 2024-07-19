package com.example.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.backend.mapper.CourseMapper;
import com.example.backend.model.CourseModel;
import com.example.backend.model.CourseTeacherModel;
import com.example.backend.model.CourseTimeSlotModel;

@Service
public class CourseService {

    private final CourseMapper dao;

    public CourseService(CourseMapper dao) {
        this.dao = dao;
    }
    public List<CourseTimeSlotModel> getCourseTimeSlots(String courseId) {
        return dao.selectTimeSlotsByCourseId(courseId);
    }

    public boolean insert(CourseModel course) {
        return dao.insert(course) > 0;
    }

    public List<CourseModel> selectAll() {
        return dao.selectAll();
    }

    public List<CourseTeacherModel> selectAllWithTeacherName() {
        return dao.selectAllWithTeacherName();
    }

    public CourseModel selectById(String id) {
        return dao.selectById(id);
    }

    public boolean update(CourseModel course) {
        return dao.update(course) > 0;
    }

    public boolean delete(String id) {
        return dao.delete(id) > 0;
    }
}