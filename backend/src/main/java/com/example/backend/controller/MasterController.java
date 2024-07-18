package com.example.backend.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MasterController {
    public MasterController() {
    }

    @RequestMapping("/")
    public String addTeacher(Model model) {
        return "MasterPage.html";
    }
}
