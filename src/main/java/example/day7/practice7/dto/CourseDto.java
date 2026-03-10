package example.day7.practice7.dto;

import example.day7.practice7.entity.CourseEntity;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CourseDto {
    private Integer courseid;
    private String coursename;

    public CourseEntity toEntity() {
        return CourseEntity.builder()
                .courseName(coursename)
                .build();
    }
}
