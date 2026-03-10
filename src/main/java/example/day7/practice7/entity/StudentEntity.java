package example.day7.practice7.entity;


import example.day7.practice7.dto.StudentDto;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "student")
public class StudentEntity extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sid;
    private String sname;

    @OneToMany(mappedBy = "student")
    @ToString.Exclude
    @Builder.Default
    private List<EnrollEntity>  enrollEntityList = new ArrayList<>();

    public StudentDto toDto() {
        return StudentDto
                .builder()
                .studentid(sid)
                .studentname(sname)
                .build();
    }
}
