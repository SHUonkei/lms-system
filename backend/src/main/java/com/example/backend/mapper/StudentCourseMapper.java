package com.example.backend.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import com.example.backend.model.StudentCourseModel;
@Mapper
public interface StudentCourseMapper {
    @Insert("INSERT INTO courses(STUDENT_ID, COURSE_ID)"
            + "VALUES(#{Student_Id}, #{Course_Id})")
    int insert(StudentCourseModel model);

    @Select("SELECT * FROM student_courses where COURSE_ID = #{Course_Id}")
    List<StudentCourseModel> selectByCourseId(String Course_Id);

    @Select("SELECT * FROM student_courses where STUDENT_ID = #{Student_Id}")
    List<StudentCourseModel> selectByStudentId(String Student_Id);
    
    @Delete("DELETE FROM courses WHERE ID = #{Id}")
    int delete(String Id);
}