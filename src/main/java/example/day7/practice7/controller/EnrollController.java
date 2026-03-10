package example.day7.practice7.controller;

import example.day7.practice7.dto.EnrollDto;
import example.day7.practice7.service.EnrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/enroll")

public class EnrollController {
    @Autowired
    private EnrollService enrollService;

    @PostMapping
    public boolean postEnroll(@RequestBody EnrollDto enrollDto) {
        boolean result = enrollService.postEnroll(enrollDto);
        return result;
    }

    @GetMapping
    public List<EnrollDto> findAll() {
        List<EnrollDto> result = enrollService.findAll();
        return result;

    }
}
