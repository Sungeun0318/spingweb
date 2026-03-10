package example.day7.practice7.service;

import example.day7.practice7.dto.CourseDto;
import example.day7.practice7.entity.CourseEntity;
import example.day7.practice7.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    // 등록
    public boolean postCourse(CourseDto courseDto) {
        CourseEntity saveCourseEntity = courseDto.toEntity();
        CourseEntity courseEntity = courseRepository.save(saveCourseEntity);
        if (courseEntity.getCid() >= 1) {
            return true;
        }
        return false;
    }
}
