package com.example.backend.service;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.springframework.stereotype.Service;
import com.example.backend.mapper.TimetableMapper;
import com.example.backend.model.TimetableModel;

@Service
public class TimetableService {
    private final TimetableMapper timetableMapper;

    public TimetableService(TimetableMapper timetableMapper) {
        this.timetableMapper = timetableMapper;
    }

    public Map<String, Map<String, String>> getTimetableForStudent(String studentId) {
      List<TimetableModel> timetableList = timetableMapper.selectTimetableByStudentId(studentId);
      Map<String, Map<String, String>> timetable = new HashMap<>();
  
      for (TimetableModel timeslot : timetableList) {
          if (timeslot != null) {
              String dayOfWeek = timeslot.getDayOfWeek();
              if (dayOfWeek != null) {
                  timetable.computeIfAbsent(dayOfWeek, k -> new HashMap<>())
                           .put(timeslot.getTimePeriod(), timeslot.getCourseName());
              }
          }
      }
      
       // デバッグ用の出力：timetableの内容を確認
      System.out.println("Timetable contents:");
      timetable.forEach((key, value) -> {
        System.out.println("Day: " + key);
        value.forEach((period, courseName) -> System.out.println(period + ": " + courseName));
      });
      return timetable;
  }
}