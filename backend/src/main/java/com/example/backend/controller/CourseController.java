package com.example.backend.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.validation.BindingResult;

import com.example.backend.model.CourseModel;
import com.example.backend.service.CourseService;
import com.example.backend.service.TeacherService;
import com.example.backend.model.CourseTeacherModel;
import com.example.backend.model.StudentModel;
import com.example.backend.model.TeacherModel;
import com.example.backend.model.TimetableModel;
import com.example.backend.service.TimetableService;

@Controller
public class CourseController {
    private final CourseService courseService;
    private final TeacherService teacherService;
    private final TimetableService timetableService;

    public CourseController(CourseService courseService, TeacherService teacherService, TimetableService timetableService) {
        this.courseService = courseService;
        this.teacherService = teacherService;
        this.timetableService = timetableService;
    }
    @RequestMapping("course/new")
    public String addCourse(Model model) {
        List<TeacherModel> teachers = teacherService.selectAll();

        model.addAttribute("course", new CourseModel());
        model.addAttribute("teachers", teachers);

        return "NewCourse.html";
    }

    @PostMapping("course/new")
    public String create(@Validated @ModelAttribute CourseModel course, Model model) {
        courseService.insert(course);
        return "redirect:list";
    }

    @GetMapping("course/list")
    public String displayCourses(Model model) {
        List<CourseModel> courses = courseService.selectAll();
        List<CourseTeacherModel> courseTeachers = courseService.selectAllWithTeacherName();
        model.addAttribute("courses", courses);
        model.addAttribute("courseTeachers", courseTeachers);
        return "CourseList.html";
    }

    @RequestMapping("course/edit")
    public String edit(@ModelAttribute CourseModel course, Model model) {
        CourseModel courseModel = courseService.selectById(course.getId());
        List<TeacherModel> teachers = teacherService.selectAll();
        model.addAttribute("course", courseModel);
        model.addAttribute("teachers", teachers);
        return "EditCourse.html";
    }

    @PostMapping("course/edit")
    public String update(@Validated @ModelAttribute CourseModel course, Model model) {
        courseService.update(course);
        return "redirect:list";
    }

    @RequestMapping("course/delete")
    public String delete(@RequestParam("Id") String id, Model model) {
        courseService.delete(id);
        return "redirect:list";
    }

    @GetMapping("course/timetable")
    public String displayTimetable(@RequestParam("Id") String courseId, Model model) {
        Map<String, Map<String, String>> timetable = timetableService.getTimetableForCourse(courseId);
        List<String> dayOfWeek = List.of("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday");
        List<String> timePeriod = List.of("1", "2", "3", "4", "5");
    
        List<String> registeredCombinations = timetableService.getRegisteredCombinations(courseId);
    
        model.addAttribute("dayOfWeek", dayOfWeek);
        model.addAttribute("timetable", timetable);
        model.addAttribute("courseId", courseId);
        model.addAttribute("timePeriod", timePeriod);
        model.addAttribute("registeredCombinations", registeredCombinations); // 追加
        return "CourseTimetable";
    }

    @PostMapping("course/updateTimetable")
    public String updateTimetable(@RequestParam String courseId,
                                  @RequestParam String day,
                                  @RequestParam String period) {
        timetableService.updateTimetable(courseId, day, period);
        return "redirect:/course/timetable?Id=" + courseId;
    }

    @PostMapping("course/deletePeriod")
    public String deletePeriod(@RequestParam String courseId,
                               @RequestParam String combination) {
        String[] parts = combination.split(" - Period ");
        String day = parts[0];
        String period = parts[1];
        timetableService.deletePeriod(courseId, day, period);
        return "redirect:/course/timetable?Id=" + courseId;
    }

    @GetMapping("/course/search")
    public String searchCourses(@RequestParam("name") String name, Model model) {
        List<CourseModel> courses = courseService.searchByName(name);
        model.addAttribute("courses", courses);
        List<CourseTeacherModel> courseTeachers = courseService.searchByNameWithTeacherName(name);
        model.addAttribute("courseTeachers", courseTeachers);
        return "CourseList.html";
    }
}