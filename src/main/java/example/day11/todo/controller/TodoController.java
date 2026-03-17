package example.day11.todo.controller;

import example.day11.todo.dto.TodoDto;
import example.day11.todo.repository.TodoRepository;
import example.day11.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/todo")
public class TodoController {
    private final TodoService todoService;

    // 1. 전체조회
    @GetMapping
    public ResponseEntity<?> findAll(){
        List<TodoDto> result = todoService.findAll();
        return ResponseEntity.status(200).body(result);
    }

    // 2. 개별조회
    @GetMapping("/detail")
    public ResponseEntity<?> findById(@RequestParam int id){
        TodoDto result = todoService.findById(id);
        return ResponseEntity.status(200).body(result);
    }

    // 3. title 개별조회
    @GetMapping("/query1") //http://localhost:8080/api/todo/query1?title=자바 공부
    public ResponseEntity<?> query1(@RequestParam String title){
        TodoDto result = todoService.query1(title);
        return ResponseEntity.ok(result);
    }

}

// ResponseEntity : 응답객체, 사용목적 : 반환값 외 추가적인 자료 포함 <응답코드>
// <> : 제네릭, <?> 제네릭에 ? 타입 사용시 Object 와 동일하게 모든 타입을 대입 가능하다.
// ResponseEntity< Integer > : Integer 타입만 반환
// ResponseEntity<?> : 모든 타입 반환
