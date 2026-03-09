package example.day7.practice7;


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
public class EnrollEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer enrollId;
    private String status;

    @ManyToOne
    @JoinColumn(name = "courseId")
    private CourseEntity course;

    @ManyToOne
    @JoinColumn(name = "studentId")
    private StudentEntity student;

}
