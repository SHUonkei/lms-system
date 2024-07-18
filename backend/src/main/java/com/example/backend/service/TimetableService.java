package com.example.backend.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
              String Day_Of_Week = timeslot.getDay_Of_Week();
              if (Day_Of_Week != null) {
                  timetable.computeIfAbsent(Day_Of_Week, k -> new HashMap<>())
                           .put(timeslot.gettime_Period(), timeslot.getcourse_Name());
              }
          }
      }
      
       // デバッグ用の出力：timetableの内容を確認
      System.out.println("Timetable contents:");
      timetable.forEach((key, value) -> {
        System.out.println("Day: " + key);
        value.forEach((period, course_Name) -> System.out.println(period + ": " + course_Name));
      });
      return timetable;
  }
}