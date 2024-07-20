package com.example.backend.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.backend.model.StudentModel;
import com.example.backend.service.StudentService;
import com.example.backend.service.TimetableService;

@Controller
public class StudentController {
    private final StudentService studentService;
    private final TimetableService timetableService;

    public StudentController(StudentService studentService, TimetableService timetableService) {
        this.studentService = studentService;
        this.timetableService = timetableService;
    }

    @RequestMapping("/new")
    public String addStudent(Model model) {
        model.addAttribute("student", new StudentModel());
        return "NewStudent.html";
    }

    @PostMapping("/new")
    public String create(@Validated @ModelAttribute("student") StudentModel student, BindingResult result, Model model) {
        if (studentService.selectById(student.getId()) != null) {
            model.addAttribute("errorMessage", "id is duplicated.");
            model.addAttribute("student", new StudentModel());
            return "NewStudent.html";
        }

        if (result.hasErrors()) {
            model.addAttribute("student", new StudentModel());
            return "NewStudent.html";
        }

        if (studentService.insert(student) == false) {
            model.addAttribute("errorMessage", "Fulfill all inputs.");
            model.addAttribute("student", new StudentModel());
            return "NewStudent.html";
        }
        return "redirect:studentlist";
    }

    @GetMapping("/studentlist")
    public String displayStudents(Model model) {
        List<StudentModel> students = studentService.selectAll();
        model.addAttribute("students", students);
        model.addAttribute("student", new StudentModel()); 
        return "StudentList.html";
    }

    @RequestMapping("/edit")
    public String edit(@ModelAttribute StudentModel student, Model model) {
        StudentModel studentModel = studentService.selectById(student.getId());
        model.addAttribute("student", studentModel);
        return "EditStudent.html";
    }

    @PostMapping("/edit")
    public String update(@Validated @ModelAttribute StudentModel student, Model model) {
        studentService.update(student);
        return "redirect:studentlist";
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam("Id") String id, Model model) {
        studentService.delete(id);
        return "redirect:studentlist";
    }

    @GetMapping("/timetable")
    public String displayTimetable(@RequestParam("Id") String studentId, Model model) {
        Map<String, Map<String, String>> timetable = timetableService.getTimetableForStudent(studentId);
        model.addAttribute("timetable", timetable);
        return "Timetable.html";
    }

    @GetMapping("/search")
    public String searchStudents(@RequestParam("name") String name, Model model) {
        List<StudentModel> students = studentService.searchByName(name);
        model.addAttribute("students", students);
        return "StudentList.html";
    }
}