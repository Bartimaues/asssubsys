package com.uniwork.asssubsys.service;

import com.uniwork.asssubsys.dto.CourseDto;
import com.uniwork.asssubsys.entity.Course;
import com.uniwork.asssubsys.repository.CourseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<CourseDto> getAllCourses() {
        List<Course> courses = courseRepository.findAll();
        return courses.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    public void saveCourse(CourseDto courseDto) {
        Course course = convertToEntity(courseDto);
        courseRepository.save(course);
    }

    public CourseDto getCourseById(Long id) {
        Optional<Course> course = courseRepository.findById(id);
        return course.map(this::convertToDto).orElse(null);
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
