package example.day7.practice7.service;

import example.day7.practice7.dto.EnrollDto;
import example.day7.practice7.entity.CourseEntity;
import example.day7.practice7.entity.EnrollEntity;
import example.day7.practice7.entity.StudentEntity;
import example.day7.practice7.repository.CourseRepository;
import example.day7.practice7.repository.EnrollRepository;
import example.day7.practice7.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class EnrollService {
    @Autowired
    private EnrollRepository enrollRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private StudentRepository studentRepository;


    public boolean postEnroll(EnrollDto enrollDto) {
        Optional<CourseEntity> courseEntity = courseRepository.findById(enrollDto.getCourseid());
        Optional<StudentEntity> studentEntity = studentRepository.findById(enrollDto.getStudentid());
        if (courseEntity.isPresent() && studentEntity.isPresent()) {
            EnrollEntity saveEntity = enrollDto.toEntity();
            saveEntity.setCourse(courseEntity.get());
            saveEntity.setStudent(studentEntity.get());
            EnrollEntity enrollEntity = enrollRepository.save(saveEntity);

            if (enrollEntity.getEid() >= 1) {
                return true;
            }
        }
        return false;
    }

    public List<EnrollDto> findAll() {
        List<EnrollEntity> enrollEntities = enrollRepository.findAll();
        List<EnrollDto> enrollDtos = new ArrayList<>();
        enrollEntities.forEach(enrollEntity -> {
            EnrollDto enrollDto = enrollEntity.toEnrollDto();
            enrollDtos.add(enrollDto);
        });
        return enrollDtos;
    }






}
