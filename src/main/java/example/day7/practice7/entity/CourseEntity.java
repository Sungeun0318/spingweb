package example.day7.practice7.entity;

import example.day7.practice7.dto.CourseDto;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "course")
public class CourseEntity extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cid;
    private String cname;

    @OneToMany(mappedBy = "course")
    @ToString.Exclude
    @Builder.Default
    private List<EnrollEntity> enrollEntityList =  new ArrayList<>();

    public CourseDto toDto() {
        return CourseDto
                .builder()
                .courseid(cid)
                .coursename(cname)
                .createdAt(getCreatedAt().toString())
                .updatedAt(getUpdatedAt().toString())
                .build();
    }
}
