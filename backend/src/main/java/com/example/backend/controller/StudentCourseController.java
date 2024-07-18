// package com.example.backend.controller;

// import java.util.List;

// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.validation.annotation.Validated;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.ModelAttribute;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;

// import com.example.backend.service.CourseService;
// import com.example.backend.service.TeacherService;

// import com.example.backend.model.CourseModel;
// import com.example.backend.model.CourseTeacherModel;
// import com.example.backend.model.TeacherModel;
// import com.example.backend.model.StudentCourseModel;
// import com.example.backend.service.StudentService;

// @Controller
// public class StudentCourseController {
//     private final CourseService courseService;
//     private final StudentService studentService;

//     public StudentCourseController(CourseService courseService, StudentService studentService) {
//         this.courseService = courseService;
//         this.studentService = studentService;
//     }
//     @RequestMapping("studentcourse/new")
//     public String addCourse(Model model) {
//         List<TeacherModel> teachers = teacherService.selectAll();

//         model.addAttribute("course", new CourseModel());
//         model.addAttribute("teachers", teachers);

//         return "NewCourse.html";
//     }

//     @PostMapping("studentcourse/new")
//     public String create(@Validated @ModelAttribute CourseModel course, Model model) {
//         courseService.insert(course);
//         return "redirect:list";
//     }

//     @GetMapping("studentcourse/list")
//     public String displayCourses(@ModelAttribute CourseModel course, Model model) {
//         List<CourseModel> courses = courseService.selectByCourseId();
//         List<CourseTeacherModel> courseTeachers = courseService.selectAllWithTeacherName();
//         model.addAttribute("courses", courses);
//         model.addAttribute("courseTeachers", courseTeachers);
//         return "CourseList.html";
//     }

//     @RequestMapping("studentcourse/edit")
//     public String edit(@ModelAttribute CourseModel course, Model model) {
//         CourseModel courseModel = courseService.selectById(course.getId());
//         List<TeacherModel> teachers = teacherService.selectAll();
//         model.addAttribute("course", courseModel);
//         model.addAttribute("teachers", teachers);
//         return "EditCourse.html";
//     }

//     @PostMapping("studentcourse/edit")
//     public String update(@Validated @ModelAttribute CourseModel course, Model model) {
//         courseService.update(course);
//         return "redirect:list";
//     }

//     @RequestMapping("studentcourse/delete")
//     public String delete(@RequestParam("Id") String id, Model model) {
//         courseService.delete(id);
//         return "redirect:list";
//     }
// }