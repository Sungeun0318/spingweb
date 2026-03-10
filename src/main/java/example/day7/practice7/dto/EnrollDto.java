package example.day7.practice7.dto;

import example.day7.practice7.entity.EnrollEntity;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class EnrollDto {
    private Integer enrollid;
    private String status;
    private Integer courseid;
    private Integer studentid;

    private String coursename;
    private String studentname;

    public EnrollEntity toEntity() {
        return EnrollEntity.builder()
                .status(status)
                .build();
    }
}
