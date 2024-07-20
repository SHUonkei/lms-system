package com.example.backend.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import com.example.backend.model.CourseModel;
import com.example.backend.model.CourseTeacherModel;
import com.example.backend.model.StudentModel;
@Mapper
public interface CourseMapper {
    @Insert("INSERT INTO courses(ID, NAME, TEACHER_ID, ROOM)"
            + "VALUES(#{Id}, #{Name}, #{Teacher_Id}, #{Room})")
    int insert(CourseModel model);

    @Select("SELECT * FROM courses")
    List<CourseModel> selectAll();
 
    @Select("SELECT c.ID, c.NAME , c.ROOM, t.NAME as TEACHER_NAME FROM courses c join teachers t on t.ID=c.TEACHER_ID")
    List<CourseTeacherModel> selectAllWithTeacherName();

    @Select("SELECT * FROM courses WHERE ID = #{Id}")
    CourseModel selectById(String Id);

    @Update("UPDATE courses SET NAME = #{Name}, TEACHER_ID = #{Teacher_Id}, ROOM = #{Room} WHERE ID = #{Id}")
    int update(CourseModel model);

    @Delete("DELETE FROM courses WHERE ID = #{Id}")
    int delete(String Id);

    @Select("SELECT * FROM courses WHERE NAME LIKE '%' || #{name} || '%'")
    List<CourseModel> searchByName(String name);

    @Select("SELECT c.ID, c.NAME , c.ROOM, t.NAME as TEACHER_NAME FROM courses c join teachers t on t.ID=c.TEACHER_ID WHERE c.NAME LIKE '%' || #{name} || '%'")
    List<CourseTeacherModel> searchByNameWithTeacherName(String name);

}