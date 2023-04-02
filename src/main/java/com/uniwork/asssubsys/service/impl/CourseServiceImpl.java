package com.uniwork.asssubsys.service.impl;

import com.uniwork.asssubsys.dto.CourseDto;
import com.uniwork.asssubsys.entity.Course;
import com.uniwork.asssubsys.repository.CourseRepository;
import com.uniwork.asssubsys.service.CourseService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<CourseDto> getAllCourses() {
        List<Course> courses = courseRepository.findAll();
        return courses.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public void saveCourse(CourseDto courseDto) {
        Course course = convertToEntity(courseDto);
        courseRepository.save(course);
    }

    @Override
    public CourseDto getCourseById(Long id) {
        Optional<Course> course = courseRepository.findById(id);
        return course.map(this::convertToDto).orElse(null);
    }

    @Override
    public void addCourse(String courseTitle, String description, int courseCredits) {
        Course course = new Course();
        course.setCourseTitle(courseTitle);
        course.setDescription(description);
        course.setCourseCredits(courseCredits);
        courseRepository.save(course);
    }

    private CourseDto convertToDto(Course course) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(course, CourseDto.class);
    }

    private Course convertToEntity(CourseDto courseDto) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(courseDto, Course.class);
    }

}
