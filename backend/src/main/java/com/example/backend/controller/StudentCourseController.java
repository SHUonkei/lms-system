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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.backend.model.StudentCourseJoinStudentModel;
import com.example.backend.model.StudentCourseModel;
import com.example.backend.model.StudentModel;
import com.example.backend.service.CourseService;
import com.example.backend.service.StudentCourseService;
import com.example.backend.service.StudentService;

@Controller
public class StudentCourseController {
    private final CourseService courseService;
    private final StudentService studentService;
    private final StudentCourseService studentCourseService;

    public StudentCourseController(CourseService courseService, StudentService studentService, StudentCourseService studentCourseService) {
        this.courseService = courseService;
        this.studentService = studentService;
        this.studentCourseService = studentCourseService;
    }
    @RequestMapping("studentcourse/new")
    public String addCourse(@RequestParam("Id") String id, Model model) {
        List<StudentModel> students = studentService.selectAll();
        StudentCourseModel studentcourse = new StudentCourseModel();
        studentcourse.setCourse_Id(id);
        model.addAttribute("studentcourse", studentcourse);
        model.addAttribute("students", students);
        model.addAttribute("courseId", id);
        model.addAttribute("courseName", courseService.selectById(id).getName());

        return "NewStudentCourse.html";
    }

    @PostMapping("studentcourse/new")
    public String create(@Validated @ModelAttribute StudentCourseModel studentcourse, @RequestParam("Course_Id") String id, Model model, RedirectAttributes redirectAttributes) {
        System.out.println("studentcourse" + studentcourse);
        if(!studentCourseService.insert(studentcourse)) {
            redirectAttributes.addFlashAttribute("errorMessage", "Fulfill all inputs.");
            redirectAttributes.addFlashAttribute("studentcourse", new StudentCourseModel());
            redirectAttributes.addFlashAttribute("students", studentService.selectAll());
            redirectAttributes.addFlashAttribute("courseId", id);
            redirectAttributes.addFlashAttribute("courseName", courseService.selectById(id).getName());    
            return "redirect:new?Id=" + id;
        }
        return "redirect:list?Id=" + id;
    }

    @GetMapping("studentcourse/list")
    public String displayCourses(@RequestParam("Id") String id,  Model model) {
        List<StudentModel> students = studentService.selectAll();
        List<StudentCourseModel> studentCourses = studentCourseService.selectByCourseId(id);
        List<StudentCourseJoinStudentModel> studentCourseJoinStudents = studentCourseService.selectByCourseIdWithStudent(id);
        model.addAttribute("students", students);
        model.addAttribute("studentCourses", studentCourses);
        model.addAttribute("studentCourseJoinStudents", studentCourseJoinStudents);
        model.addAttribute("courseId", id);
        return "StudentCourseList.html";
    }

    @RequestMapping("studentcourse/delete")
    public String delete(@RequestParam("CourseId") String CourseId, @RequestParam("StudentId") String StudentId, Model model) {
        studentCourseService.delete(StudentId,CourseId);
        return "redirect:list?Id=" + CourseId;
    }
}