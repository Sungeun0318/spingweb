package example.day7.practice7.controller;

import example.day7.practice7.dto.CourseDto;
import example.day7.practice7.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/course")

public class CourseController {
    @Autowired
    private CourseService courseService;

    @PostMapping
    public boolean postCourse(@RequestBody CourseDto courseDto) {

        return courseService.postCourse(courseDto);
    }
}
