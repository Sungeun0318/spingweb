package practice2.department.service;


import java.util.List;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import practice2.department.dto.DepartmentDto;
import practice2.department.entity.DepartmentEntity;
import practice2.department.repository.DepartmentRepository;
import practice2.employee.repository.EmployeeRepository;

@Service
@RequiredArgsConstructor
@Transactional
public class DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;

    public boolean create(DepartmentDto departmentDto) {
        departmentRepository.save(departmentDto.toEntity());
        return true;
    }

    public List<DepartmentDto> findAll() {
        return departmentRepository.findAll().stream()
                .map(DepartmentEntity::toDto)
                .toList();
    }

    public boolean update(Integer did, DepartmentDto departmentDto) {
        DepartmentEntity entity = departmentRepository.findById(did).orElse(null);
        if (entity == null) {
            return false;
        }
        entity.setDname(departmentDto.getDname());
        departmentRepository.save(entity);
        return true;
    }

    public boolean delete(Integer did) {
        boolean exist = departmentRepository.existsById(did);
        if (exist) {
            if (employeeRepository.existsByDid(did)) {
                return false;
            }
            departmentRepository.deleteById(did);
            return true;
        }
        return false;
    }
}
