package practice2.employee.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import practice2.employee.dto.EmployeeDto;
import practice2.employee.entity.EmployeeEntity;
import practice2.employee.repository.EmployeeRepository;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    // 업로드 경로
    private String baseDir = System.getProperty("user.dir");
    private String uploadDir = baseDir + "/build/resources/main/static/upload/";

    public boolean create(EmployeeDto employeeDto) {
        MultipartFile uploadFile = employeeDto.getUploadFile();

        String fileName = null;
        if (uploadFile != null && !uploadFile.isEmpty()) {
            File uploadPath = new File(uploadDir);
            if (!uploadPath.exists()) {
                uploadPath.mkdir();
            }
            String uuid = UUID.randomUUID().toString();
            fileName = uuid + uploadFile.getOriginalFilename().replaceAll("_", "-");
            File uploadRealPath = new File(uploadDir + fileName);
            try {
                uploadFile.transferTo(uploadRealPath);
            } catch (IOException e) {
                System.out.println(e);
                return false;
            }
        }
        employeeDto.setEimg(fileName);
        employeeRepository.save(employeeDto.toEntity());
        return true;
    }

    public List<EmployeeDto> findAll() {
        return employeeRepository.findAll().stream()
                .map(EmployeeEntity::toDto)
                .toList();
    }

    public boolean update(Integer eid, EmployeeDto employeeDto) {
        EmployeeEntity entity = employeeRepository.findById(eid).orElse(null);
        if (entity == null) {
            return false;
        }
        entity.setEname(employeeDto.getEname());
        entity.setDid(employeeDto.getDid());
        entity.setEposition(employeeDto.getEposition());
        entity.setEimg(employeeDto.getEimg());
        employeeRepository.save(entity);
        return true;
    }

    public boolean delete(Integer eid) {
        boolean exists = employeeRepository.existsById(eid);
        if (exists) {
            employeeRepository.deleteById(eid);
            return true;
        }
        return false;
    }



}
