package com.example.backend.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import com.example.backend.model.TeacherModel;
@Mapper
public interface TeacherMapper {
    @Insert("INSERT INTO teachers(ID, NAME, EMAIL)"
            + "VALUES(#{Id}, #{Name}, #{Email})")
    int insert(TeacherModel model);

    @Select("SELECT * FROM teachers")
    List<TeacherModel> selectAll();

    @Select("SELECT * FROM teachers WHERE ID = #{Id}")
    TeacherModel selectById(String Id);

    @Update("UPDATE teachers SET NAME = #{Name}, EMAIL = #{Email} WHERE ID = #{Id}")
    int update(TeacherModel model);

    @Delete("DELETE FROM teachers WHERE ID = #{Id}")
    int delete(String Id);
}