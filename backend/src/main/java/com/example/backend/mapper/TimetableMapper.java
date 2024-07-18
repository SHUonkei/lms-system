package com.example.backend.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import com.example.backend.model.TimetableModel;

@Mapper
public interface TimetableMapper {
    @Select("SELECT ct.DAY_OF_WEEK, ct.TIME_PERIOD, c.NAME AS COURSE_NAME " +
            "FROM student_courses sc " +
            "JOIN course_timeslots ct ON sc.COURSE_ID = ct.COURSE_ID " +
            "JOIN courses c ON c.ID = ct.COURSE_ID " +
            "WHERE sc.STUDENT_ID = #{studentId}")
    List<TimetableModel> selectTimetableByStudentId(String studentId);
}