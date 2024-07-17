package com.example.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.mapper.UserMapper;
import com.example.backend.model.UserModel;

@Service
public class UserService {

    private final UserMapper dao;

    @Autowired
    public UserService(UserMapper dao) {
        this.dao = dao;
    }

    public boolean insert(UserModel user) {
        return dao.insert(user) > 0;
    }

    public List<UserModel> selectAll() {
        return dao.selectAll();
    }

    public UserModel selectById(String id) {
        return dao.selectById(id);
    }

    public boolean update(UserModel user) {
        return dao.update(user) > 0;
    }

    public boolean delete(String id) {
        return dao.delete(id) > 0;
    }
}