package practice1.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import practice1.Repository.TaskRepository;
import practice1.dto.TaskDto;
import practice1.entity.TaskEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class TaskService {
    private final TaskRepository taskRepository;

    // 등록
    public boolean createTask(TaskDto taskDto) {
        TaskEntity saveEntity = taskDto.toEntity();
        TaskEntity taskEntity = taskRepository.save(saveEntity);
        if (taskEntity.getId() >= 1) {
            return true;
        }
        return false;
    }

    // 전체 조회
    public List<TaskDto> findAll() {
        List<TaskEntity> entityList = taskRepository.findAll();
        List<TaskDto> dtoList = new ArrayList<>();
        entityList.forEach(entity -> {
            TaskDto dto = entity.toDto();
            dtoList.add(dto);
        });
        return dtoList;
    }

    // 상세 조회
    public TaskDto findById(Long id) {
        Optional<TaskEntity> optional = taskRepository.findById(id);
        if (optional.isPresent()) {
            TaskEntity entity = optional.get();
            TaskDto dto = entity.toDto();
            return dto;
        }
        return null;
    }

    // 수정
    @Transactional
    public boolean updateTask(Long id, TaskDto taskDto) {
        Optional<TaskEntity> optional = taskRepository.findById(id);
        if (optional.isPresent()) {
            TaskEntity entity = optional.get();
            entity.setTitle(taskDto.getTitle());
            entity.setContent(taskDto.getContent());
            entity.setStatus(taskDto.getStatus());
            taskRepository.save(entity);
            return true;
        }
        return false;
    }

    // 삭제
    public boolean deleteTask(Long id) {
        boolean exist = taskRepository.existsById(id);
        if (exist) {
            taskRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
