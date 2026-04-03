package practice1.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import practice1.dto.TaskDto;
import practice1.service.TaskService;

import java.util.List;

@RestController
@RequiredArgsConstructor // final 멤버변수 생성자 자동(@Autowired)
@CrossOrigin(origins = "http://localhost:5173") // 서로 다른 port(프로그램식별번호) 간의 통신 허용
// SOP 정책으로 서로 다른 도메인은 통신이 불가능하다. HTTP 보안 정책
// CORS : 교차 출처 리소스 공유, 즉, 서로 다른 도메인(8080 스프링, 5173리액트) 통신 공유 허용
@RequestMapping("/api/task") // 리액트 경로 = task  vs 스프링 경로  = /api/task 중복될 수 있으므로 구분한다.
public class TaskController {
    private final TaskService taskService;

    // 등록
    @PostMapping("")
    // http://localhost:8080/api/task
    public ResponseEntity<?> createTask(@RequestBody TaskDto taskDto) {
        boolean result = taskService.createTask(taskDto);
        return ResponseEntity.ok(result);
    }

    // 전체 조회
    @GetMapping("/list")
    // http://localhost:8080/api/task/list
    public ResponseEntity<?> findAll() {
        List<TaskDto> result = taskService.findAll();
        return ResponseEntity.ok(result);
    }

    // 상세 조회
    @GetMapping("/detail")
    // http://localhost:8080/api/task/detail?id=1
    public ResponseEntity<?> findById(@RequestParam Long id) {
        TaskDto result = taskService.findById(id);
        return ResponseEntity.ok(result);
    }

    // 수정
    @PutMapping("")
    // http://localhost:8080/api/task?id=1
    public ResponseEntity<?> updateTask(@RequestParam Long id, @RequestBody TaskDto taskDto) {
        boolean result = taskService.updateTask(id, taskDto);
        return ResponseEntity.ok(result);
    }

    // 삭제
    @DeleteMapping
    // http://localhost:8080/api/task?id=1
    public ResponseEntity<?> deleteTask(@RequestParam Long id) {
        boolean result = taskService.deleteTask(id);
        return ResponseEntity.ok(result);
    }
}
