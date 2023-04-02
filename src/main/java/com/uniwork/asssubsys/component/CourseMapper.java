package com.uniwork.asssubsys.component;

import com.uniwork.asssubsys.dto.CourseDto;
import com.uniwork.asssubsys.entity.Course;
import org.springframework.stereotype.Component;

@Component
public class CourseMapper {
    public Course mapToCourse(CourseDto courseDto) {
        Course course = new Course();
        course.setId(courseDto.getId());
        course.setCourseTitle(courseDto.getCourseTitle());
        course.setDescription(courseDto.getDescription());
        course.setCourseCredits(courseDto.getCourseCredits());
        // set other fields as needed
        return course;
    }
}
