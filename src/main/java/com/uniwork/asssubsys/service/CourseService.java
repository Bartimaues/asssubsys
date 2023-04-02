package com.uniwork.asssubsys.service;

import com.uniwork.asssubsys.dto.CourseDto;

import java.util.List;

public interface CourseService {
    List<CourseDto> getAllCourses();
    void saveCourse(CourseDto courseDto);
    CourseDto getCourseById(Long id);
    void addCourse(String courseTitle, String description, int courseCredits);
}
