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
public class MasterController {
    public TeacherController() {
    }

    @RequestMapping("/")
    public String addTeacher(Model model) {
        return "MasterPage.html";
    }
}
