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

import com.example.backend.model.TeacherModel;
import com.example.backend.service.TeacherService;
import com.example.backend.service.TimetableService;

@Controller
public class TeacherController {
    private final TeacherService teacherService;
    private final TimetableService timetableService;

    public TeacherController(TeacherService teacherService, TimetableService timetableService) {
        this.teacherService = teacherService;
        this.timetableService = timetableService;
    }

    @RequestMapping("teacher/new")
    public String addTeacher(Model model) {
        model.addAttribute("teacher", new TeacherModel());
        return "NewTeacher.html";
    }

    @PostMapping("teacher/new")
    public String create(@Validated @ModelAttribute("teacher") TeacherModel teacher, BindingResult result, Model model) {
        if (teacherService.selectById(teacher.getId()) != null) {
            model.addAttribute("errorMessage", "this id is duplicated.");
            model.addAttribute("teacher", new TeacherModel());
            return "NewTeacher.html";
        }

        if (result.hasErrors()) {
            model.addAttribute("teacher", new TeacherModel());
            return "NewTeacher.html";
        }

        if (teacherService.insert(teacher) == false) {
            model.addAttribute("errorMessage", "Fulfill all inputs.");
            model.addAttribute("teacher", new TeacherModel());
            return "NewTeacher.html";
        }
        return "redirect:list";
    }

    @GetMapping("teacher/list")
    public String displayTeachers(Model model) {
        List<TeacherModel> teachers = teacherService.selectAll();
        model.addAttribute("teachers", teachers);
        return "TeacherList.html";
    }

    @RequestMapping("teacher/edit")
    public String edit(@ModelAttribute("teacher") TeacherModel teacher, Model model) {
        TeacherModel teacherModel = teacherService.selectById(teacher.getId());
        model.addAttribute("teacher", teacherModel);
        return "EditTeacher.html";
    }

    @PostMapping("teacher/edit")
    public String update(@Validated @ModelAttribute("teacher") TeacherModel teacher, BindingResult result, Model model) {
        if (teacherService.selectById(teacher.getId()) != null && !teacherService.selectById(teacher.getId()).getId().equals(teacher.getId())) {
            result.rejectValue("Id", "error.teacher", "This ID is already taken.");
        }

        if (result.hasErrors()) {
            return "EditTeacher.html";
        }

        teacherService.update(teacher);
        return "redirect:list";
    }

    @RequestMapping("teacher/delete")
    public String delete(@RequestParam("Id") String id, Model model) {
        teacherService.delete(id);
        return "redirect:list";
    }

    @GetMapping("/teacher/timetable")
    public String displayTimetable(@RequestParam("Id") String teacherId, Model model) {
        Map<String, Map<String, String>> timetable = timetableService.getTimetableForTeacher(teacherId);
        model.addAttribute("timetable", timetable);
        return "TeacherTimetable.html";
    }

    @GetMapping("/teacher/search")
    public String searchTeachers(@RequestParam("name") String name, Model model) {
        List<TeacherModel> teachers = teacherService.searchByName(name);
        model.addAttribute("teachers", teachers);
        return "TeacherList.html";
    }
}