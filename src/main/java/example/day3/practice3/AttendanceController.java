package example.day3.practice3;

import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/attendance")

public class AttendanceController {
    @PostMapping
    public boolean method(@RequestBody AttendanceDto attendanceDto) {
        System.out.println("AttendanceController.method");
        return true;
    }

    @GetMapping
    public List<AttendanceDto> list() {
        System.out.println("AttendanceController.list");
        List<AttendanceDto> list = new ArrayList<>();
        list.add(new AttendanceDto(1, "홍길동", "2026-02-26", "출석"));
        list.add(AttendanceDto.builder().status("출석").studentName("홍길동").date("2026-02-26").ano(1).build());
        return list;
    }

    @GetMapping("/detail")
    public AttendanceDto detail(@RequestParam Integer ano) {
        System.out.println("AttendanceController.detail");
        return AttendanceDto.builder().ano(1).studentName("홍길동").date("2026-02-26").status("출석").build();
    }

    @DeleteMapping
    public boolean delete(@RequestParam Integer ano){
        System.out.println("AttendanceController.delete");
        return true;
    }

    @PutMapping
    public boolean update(@RequestBody AttendanceDto attendanceDto) {
        System.out.println("AttendanceController.update");
        return true;
    }

}


