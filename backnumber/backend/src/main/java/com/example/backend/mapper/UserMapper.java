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
public interface UserMapper {
    @Insert("INSERT INTO USER(ID, NAME, EMAIL)"
            + "VALUES(#{Id}, #{Name}, #{Email})")
    int insert(UserModel model);

    @Select("SELECT * FROM USER")
    List<UserModel> selectAll();

    @Select("SELECT * FROM USER WHERE ID = #{Id}")
    UserModel selectById(String Id);

    @Update("UPDATE USER SET NAME = #{Name}, EMAIL = #{Email} WHERE ID = #{Id}")
    int update(UserModel model);

    @Delete("DELETE FROM USER WHERE ID = #{Id}")
    int delete(String Id);
}