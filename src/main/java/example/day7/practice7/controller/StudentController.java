package example.day7.practice7.controller;

import example.day7.practice7.dto.StudentDto;
import example.day7.practice7.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")

public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping
    public boolean postStudent(@RequestBody StudentDto studentDto) {
        boolean result = studentService.postStudent(studentDto);
        return result;
    }
}
