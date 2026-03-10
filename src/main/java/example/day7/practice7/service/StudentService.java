package example.day7.practice7.service;

import example.day7.practice7.dto.StudentDto;
import example.day7.practice7.entity.StudentEntity;
import example.day7.practice7.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service

public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    // 등록
    public boolean postStudent(StudentDto studentDto) {
        StudentEntity saveEntity = studentDto.toEntity();
        StudentEntity studentEntity = studentRepository.save(saveEntity);
        if (studentEntity.getStudentId() >= 1) {
            return true;
        }
        return false;
    }


}
