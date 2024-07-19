package com.example.backend.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import com.example.backend.model.StudentCourseModel;
import com.example.backend.model.StudentCourseJoinStudentModel;

@Mapper
public interface StudentCourseMapper {
    @Insert("INSERT INTO student_courses(STUDENT_ID, COURSE_ID)"
            + "VALUES(#{Student_Id}, #{Course_Id})")
    int insert(StudentCourseModel model);

    @Select("SELECT * FROM student_courses where COURSE_ID = #{Course_Id}")
    List<StudentCourseModel> selectByCourseId(String Course_Id);

    @Select("SELECT sc.STUDENT_ID, sc.COURSE_ID, s.NAME as STUDENT_NAME FROM student_courses sc join students s on sc.STUDENT_ID = s.ID where sc.COURSE_ID = #{Course_Id}")
    List<StudentCourseJoinStudentModel> selectByCourseIdWithStudent(String Course_Id);

    @Select("SELECT * FROM student_courses where STUDENT_ID = #{Student_Id}")
    List<StudentCourseModel> selectByStudentId(String Student_Id);
    
    @Delete("DELETE FROM student_courses WHERE STUDENT_ID = #{StudentId} and COURSE_ID = #{Course_Id}")
    int delete(String StudentId, String Course_Id);

    @Select("SELECT COUNT(*) FROM student_courses sc " +
            "JOIN course_timeslots cts ON sc.COURSE_ID = cts.COURSE_ID " +
            "WHERE sc.STUDENT_ID = #{studentId} " +
            "AND cts.DAY_OF_WEEK = #{dayOfWeek} " +
            "AND cts.TIME_PERIOD = #{timePeriod}")
    int checkStudentConflict(@Param("studentId") String studentId, 
                             @Param("dayOfWeek") String dayOfWeek, 
                             @Param("timePeriod") String timePeriod);
}