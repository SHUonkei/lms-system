package com.example.backend.service;

import java.util.ArrayList;
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
        return convertToMap(timetableList);
    }

    public Map<String, Map<String, String>> getTimetableForTeacher(String teacherId) {
        List<TimetableModel> timetableList = timetableMapper.selectTimetableByTeacherId(teacherId);
        return convertToMap(timetableList);
    }

    private Map<String, Map<String, String>> convertToMap(List<TimetableModel> timetableList) {
        Map<String, Map<String, String>> timetable = new HashMap<>();

        for (TimetableModel timeslot : timetableList) {
            if (timeslot != null) {
                String dayOfWeek = timeslot.getDay_Of_Week();
                if (dayOfWeek != null) {
                    Map<String, String> dayMap = timetable.computeIfAbsent(dayOfWeek, k -> new HashMap<>());
                    String existingContent = dayMap.get(timeslot.gettime_Period());
                    String newContent = timeslot.getcourse_Name();
                    if (existingContent != null) {
                        newContent = existingContent + ", " + newContent;
                    }
                    dayMap.put(timeslot.gettime_Period(), newContent);
                }
            }
        }

        return timetable;
    }

    public Map<String, Map<String, String>> getTimetableForCourse(String courseId) {
        List<TimetableModel> timetableList = timetableMapper.selectTimetableByCourseId(courseId);
        return convertToMap(timetableList);
    }

    public void deletePeriod(String courseId, String day, String period) {
        timetableMapper.deleteTimetableEntry(courseId, day, period);
    }
    
    public void updateTimetable(String courseId, String day, String period) {
        if (timetableMapper.checkTimetableEntryExists(courseId, day, period)) {
            timetableMapper.deleteTimetableEntry(courseId, day, period);
        } else {
            timetableMapper.insertTimetableEntry(courseId, day, period);
        }
    }

    public List<String> getRegisteredCombinations(String courseId) {
        Map<String, Map<String, String>> timetable = getTimetableForCourse(courseId);
        List<String> registeredCombinations = new ArrayList<>();

        for (Map.Entry<String, Map<String, String>> entry : timetable.entrySet()) {
            String day = entry.getKey();
            Map<String, String> periods = entry.getValue();
            for (String period : periods.keySet()) {
                registeredCombinations.add(day + " - Period " + period);
            }
        }
        return registeredCombinations;
    }
}