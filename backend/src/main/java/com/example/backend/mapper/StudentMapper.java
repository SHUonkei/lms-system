package com.example.backend.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import com.example.backend.model.StudentModel;
@Mapper
public interface StudentMapper {
    @Insert("INSERT INTO students(ID, NAME, EMAIL)"
            + "VALUES(#{Id}, #{Name}, #{Email})")
    int insert(StudentModel model);

    @Select("SELECT * FROM students")
    List<StudentModel> selectAll();

    @Select("SELECT * FROM students WHERE ID = #{Id}")
    StudentModel selectById(String Id);

    @Update("UPDATE students SET NAME = #{Name}, EMAIL = #{Email} WHERE ID = #{Id}")
    int update(StudentModel model);

    @Delete("DELETE FROM students WHERE ID = #{Id}")
    int delete(String Id);
}