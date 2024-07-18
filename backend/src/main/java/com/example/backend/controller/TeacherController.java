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

import com.example.backend.model.TeacherModel;
import com.example.backend.service.TeacherService;

@Controller
public class TeacherController {
    private final TeacherService TeacherService;

    public TeacherController(TeacherService TeacherService) {
        this.TeacherService = TeacherService;

    }

    @RequestMapping("teacher/new")
    public String addTeacher(Model model) {
        model.addAttribute("teacher", new TeacherModel());
        return "NewTeacher.html";
    }

    @PostMapping("teacher/new")
    public String create(@Validated @ModelAttribute TeacherModel Teacher, Model model) {
        TeacherService.insert(Teacher);
        return "redirect:Teacherlist";
    }

    @GetMapping("teacher/list")
    public String displayTeachers(Model model) {
        List<TeacherModel> teachers = TeacherService.selectAll();
        model.addAttribute("teachers", teachers);
        return "TeacherList.html";
    }

    @RequestMapping("teacher/edit")
    public String edit(@ModelAttribute TeacherModel Teacher, Model model) {
        TeacherModel teacherModel = TeacherService.selectById(Teacher.getId());
        model.addAttribute("teacher", teacherModel);
        return "EditTeacher.html";
    }

    @PostMapping("teacher/edit")
    public String update(@Validated @ModelAttribute TeacherModel Teacher, Model model) {
        TeacherService.update(Teacher);
        return "redirect:Teacherlist";
    }

    @RequestMapping("teacher/delete")
    public String delete(@RequestParam("Id") String id, Model model) {
        TeacherService.delete(id);
        return "redirect:Teacherlist";
    }
}