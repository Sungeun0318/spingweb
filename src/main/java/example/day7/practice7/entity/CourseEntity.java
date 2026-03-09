package example.day7.practice7.entity;

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
public class CourseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer courseId;
    private String courseName;

    @OneToMany(mappedBy = "courseEntity")
    @ToString.Exclude
    @Builder.Default
    private List<EnrollEntity> enrollEntityList =  new ArrayList<>();
}
