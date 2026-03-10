package example.day7.practice7.dto;

import example.day7.practice7.entity.StudentEntity;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class StudentDto {
    private Integer studentid;
    private String studentname;

    public StudentEntity toEntity() {
        return StudentEntity.builder()
                .sname(studentname)
                .build();
    }
}
