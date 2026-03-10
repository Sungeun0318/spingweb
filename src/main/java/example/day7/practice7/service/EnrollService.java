package example.day7.practice7.service;

import example.day7.practice7.dto.EnrollDto;
import example.day7.practice7.entity.EnrollEntity;
import example.day7.practice7.repository.EnrollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class EnrollService {
    @Autowired
    private EnrollRepository enrollRepository;


    public boolean postEnroll(EnrollDto enrollDto) {
        EnrollEntity saveEntity = enrollDto.toEntity();
        EnrollEntity enrollEntity = enrollRepository.save(saveEntity);
        if (enrollEntity.getEnrollId() >= 1) {
            return true;
        }
        return false;
    }

    public List<EnrollDto> findAll() {
        List<EnrollEntity> enrollEntities = enrollRepository.findAll();
        List<EnrollDto> enrollDtos = new ArrayList<>();
        enrollEntities.forEach(enrollEntity -> {
            EnrollDto enrollDto = enrollEntity.toDto();
            enrollDtos.add(enrollDto);
        });
        return enrollDtos;
    }






}
