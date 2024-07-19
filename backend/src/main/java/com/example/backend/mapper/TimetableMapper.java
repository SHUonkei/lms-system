package com.example.backend.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.backend.model.TimetableModel;

@Mapper
public interface TimetableMapper {
    @Select("SELECT ct.DAY_OF_WEEK, ct.TIME_PERIOD, c.NAME AS COURSE_NAME, c.ID AS COURSE_ID " +
            "FROM student_courses sc " +
            "JOIN course_timeslots ct ON sc.COURSE_ID = ct.COURSE_ID " +
            "JOIN courses c ON c.ID = ct.COURSE_ID " +
            "WHERE sc.STUDENT_ID = #{studentId}")
    List<TimetableModel> selectTimetableByStudentId(String studentId);

    @Select("SELECT ct.DAY_OF_WEEK, ct.TIME_PERIOD, c.NAME AS COURSE_NAME, c.ID AS COURSE_ID " +
        "FROM courses c " +
        "JOIN course_timeslots ct ON c.ID = ct.COURSE_ID " +
        "WHERE c.TEACHER_ID = #{teacherId}")
List<TimetableModel> selectTimetableByTeacherId(String teacherId);

    @Select("SELECT ct.DAY_OF_WEEK, ct.TIME_PERIOD, c.NAME AS COURSE_NAME, c.ID AS COURSE_ID " +
            "FROM course_timeslots ct " +
            "JOIN courses c ON c.ID = ct.COURSE_ID " +
            "WHERE ct.COURSE_ID = #{courseId}")
    List<TimetableModel> selectTimetableByCourseId(String courseId);

    @Delete("DELETE FROM course_timeslots WHERE COURSE_ID = #{courseId} AND DAY_OF_WEEK = #{day} AND TIME_PERIOD = #{period}")
    void deleteTimetableEntry(String courseId, String day, String period);

    @Insert("INSERT INTO course_timeslots (COURSE_ID, DAY_OF_WEEK, TIME_PERIOD) VALUES (#{courseId}, #{day}, #{period})")
    void insertTimetableEntry(String courseId, String day, String period);

    @Select("SELECT EXISTS(SELECT 1 FROM course_timeslots WHERE COURSE_ID = #{courseId} AND DAY_OF_WEEK = #{day} AND TIME_PERIOD = #{period})")
    boolean checkTimetableEntryExists(String courseId, String day, String period);
}