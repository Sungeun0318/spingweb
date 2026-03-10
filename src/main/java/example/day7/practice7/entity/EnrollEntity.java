package example.day7.practice7.entity;


import example.day7.practice7.dto.EnrollDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "enroll")
public class EnrollEntity extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer eid;
    private String status;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cid")
    private CourseEntity course;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sid")
    private StudentEntity student;

    public EnrollDto toEnrollDto(){
        return EnrollDto
                .builder()
                .enrollid(eid)
                .status(status)
                .courseid(course.getCid())
                .studentid(student.getSid())
                .coursename(course.getCname())
                .studentname(student.getSname())
                .build();
    }

}
