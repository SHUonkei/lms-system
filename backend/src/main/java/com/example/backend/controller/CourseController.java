package com.example.backend.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.backend.model.CourseModel;
import com.example.backend.service.CourseService;
import com.example.backend.service.TeacherService;
import com.example.backend.model.CourseTeacherModel;

import com.example.backend.model.TeacherModel;

@Controller
public class CourseController {
    private final CourseService courseService;
    private final TeacherService teacherService;

    public CourseController(CourseService courseService, TeacherService teacherService) {
        this.courseService = courseService;
        this.teacherService = teacherService;
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
}