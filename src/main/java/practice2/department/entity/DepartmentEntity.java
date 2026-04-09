package practice2.department.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import practice2.department.dto.DepartmentDto;


@Entity
@Table(name = "department")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class DepartmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer did;
    private String dname;

    public DepartmentDto toDto() {
        return DepartmentDto
                .builder()
                .did(did)
                .dname(dname)
                .build();
    }
}
