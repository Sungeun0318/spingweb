package practice2.employee.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import practice2.department.service.DepartmentService;
import practice2.employee.dto.EmployeeDto;
import practice2.employee.service.EmployeeService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/employee")
@CrossOrigin(origins = "http://localhost:5173")
public class EmployeeController {
    private final EmployeeService employeeService;

    @PostMapping("")
    // http://localhost:8080/api/employee
    // Content-Type : multipart/form-data
    // ename : 김성은
    // did : 1
    // eposition : 주니어
    // uploadFile : File(사진)
    public ResponseEntity<?> create(EmployeeDto employeeDto) {
        return ResponseEntity.ok(employeeService.create(employeeDto));
    }

    @GetMapping("")
    // http://localhost:8080/api/employee
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(employeeService.findAll());
    }

    @PutMapping("")
    // http://localhost:8080/api/employee?eid=1
    // {"ename" : "개발자", "did" : 3, "eposition" : "개발자"}
    public ResponseEntity<?> update(@RequestParam Integer eid, @RequestBody EmployeeDto employeeDto) {
        return ResponseEntity.ok(employeeService.update(eid, employeeDto));
    }

    @DeleteMapping("")
    // http://localhost:8080/api/employee?eid=2
    public ResponseEntity<?> delete(@RequestParam Integer eid) {
        return ResponseEntity.ok(employeeService.delete(eid));
    }








}
