package com.example.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.backend.mapper.TeacherMapper;
import com.example.backend.model.TeacherModel;

@Service
public class TeacherService {

    private final TeacherMapper dao;

    public TeacherService(TeacherMapper dao) {
        this.dao = dao;
    }

    public boolean insert(TeacherModel teacher) {
        if (teacher.getId().equals("") || teacher.getName().equals("") || teacher.getEmail().equals("")){
            return false;
        }
        return dao.insert(teacher) > 0;
    }

    public List<TeacherModel> selectAll() {
        return dao.selectAll();
    }

    public TeacherModel selectById(String id) {
        return dao.selectById(id);
    }

    public boolean update(TeacherModel student) {
        return dao.update(student) > 0;
    }

    public boolean delete(String id) {
        return dao.delete(id) > 0;
    }
    public List<TeacherModel> searchByName(String name) {
        return dao.searchByName(name);
    }
}