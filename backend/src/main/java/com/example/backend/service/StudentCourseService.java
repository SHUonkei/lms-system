package com.example.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.backend.mapper.StudentCourseMapper;
import com.example.backend.model.StudentCourseModel;
import com.example.backend.model.CourseTeacherModel;

@Service
public class StudentCourseService {

    private final StudentCourseMapper dao;

    public StudentCourseService(StudentCourseMapper dao) {
        this.dao = dao;
    }

    public boolean insert(StudentCourseModel studentCourse) {
        return dao.insert(studentCourse) > 0;
    }

    public List<StudentCourseModel> selectByStudentId(String Student_Id) {
        return dao.selectByStudentId(Student_Id);
    }

    public List<StudentCourseModel> selectByCourseId(String Course_Id) {
        return dao.selectByCourseId(Course_Id);
    }

    public boolean delete(String id) {
        return dao.delete(id) > 0;
    }
}
