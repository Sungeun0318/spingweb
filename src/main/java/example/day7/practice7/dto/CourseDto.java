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
    private String createdAt;
    private String updatedAt;

    public CourseEntity toEntity() {
        return CourseEntity.builder()
                .cname(coursename)
                .build();
    }
}
