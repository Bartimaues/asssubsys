package com.uniwork.asssubsys.controller;

import com.uniwork.asssubsys.component.CourseMapper;
import com.uniwork.asssubsys.dto.CourseDto;
import com.uniwork.asssubsys.entity.Course;
import com.uniwork.asssubsys.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class CourseDashboardController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private CourseMapper courseMapper;

    @GetMapping("/courses")
    public String getCourses(Model model) {
        List<CourseDto> courseDtos = courseService.getAllCourses();
        System.out.println("Number of courses retrieved: " + courseDtos.size());
        List<Course> courses = courseDtos.stream()
                .map(courseMapper::mapToCourse)
                .collect(Collectors.toList());
        System.out.println("Number of courses mapped: " + courses.size());
        model.addAttribute("courses", courses);
        model.addAttribute("course", new CourseDto());
        return "courses";
    }

    @PostMapping("/courses")
    public String addCourse(@ModelAttribute("course") CourseDto courseDto) {
        courseService.addCourse(courseDto.getCourseTitle(), courseDto.getDescription(), courseDto.getCourseCredits());
        return "redirect:/courses";
    }

    @PostMapping("/addCourse")
    public String addCourseForm(@ModelAttribute("course") CourseDto courseDto) {
        courseService.addCourse(courseDto.getCourseTitle(), courseDto.getDescription(), courseDto.getCourseCredits());
        return "redirect:/courses";
    }
}
