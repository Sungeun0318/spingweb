package practice2.department.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import practice2.department.dto.DepartmentDto;
import practice2.department.service.DepartmentService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/department")
@CrossOrigin(origins = "http://localhost:5173")
public class DepartmentController {
    private final DepartmentService departmentService;

    @PostMapping("")
    // http://localhost:8080/api/department
    // {"dname" : "개발자"}
    public ResponseEntity<?> create(@RequestBody DepartmentDto departmentDto) {
        return ResponseEntity.ok(departmentService.create(departmentDto));
    }

    @GetMapping("")
    // http://localhost:8080/api/department
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(departmentService.findAll());
    }

    @PutMapping("")
    // http://localhost:8080/api/department?did=1
    // {"dname" : "김성은"}
    public ResponseEntity<?> update(@RequestParam Integer did, @RequestBody DepartmentDto departmentDto) {
        return ResponseEntity.ok(departmentService.update(did, departmentDto));
    }

    @DeleteMapping("")
    // http://localhost:8080/api/department?did=1
    public ResponseEntity<?> delete(@RequestParam Integer did) {
        return ResponseEntity.ok(departmentService.delete(did));
    }
}
