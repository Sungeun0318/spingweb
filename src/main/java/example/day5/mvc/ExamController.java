package example.day5.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExamController {
    @Autowired
    private ExamService examService;

}
