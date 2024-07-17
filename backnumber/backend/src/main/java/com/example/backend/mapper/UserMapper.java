package com.example.backend.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import com.example.backend.model.UserModel;

@Mapper
@Component
public interface UserMapper {
    @Insert("INSERT INTO USER(ID, NAME, EMAIL)"
            + "VALUES(#{ID}, #{NAME}, #{EMAIL})")
    int insert(UserModel model);

    @Select("SELECT * FROM USER")
    List<UserModel> selectAll();
}