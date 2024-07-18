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

import com.example.backend.service.CourseService;
import com.example.backend.service.TeacherService;
import com.example.backend.model.StudentModel;
import com.example.backend.model.CourseModel;
import com.example.backend.model.CourseTeacherModel;
import com.example.backend.model.TeacherModel;
import com.example.backend.model.StudentCourseModel;
import com.example.backend.service.StudentService;
import com.example.backend.service.StudentCourseService;
import com.example.backend.model.StudentCourseJoinStudentModel;

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
    public String create(@Validated @ModelAttribute StudentCourseModel studentcourse, Model model) {
        //debud
        System.out.println("studentcourse" + studentcourse);
        studentCourseService.insert(studentcourse);
        return "redirect:list?Id=" + studentcourse.getCourse_Id();
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