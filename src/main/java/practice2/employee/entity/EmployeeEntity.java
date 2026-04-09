package practice2.employee.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import practice2.employee.dto.EmployeeDto;

@Entity
@Table(name = "employee")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer eid;
    private String ename;
    private Integer did;
    private String eposition;
    private String eimg;

    public EmployeeDto toDto() {
        return EmployeeDto
                .builder()
                .eid(eid)
                .ename(ename)
                .did(did)
                .eposition(eposition)
                .eimg(eimg)
                .build();
    }
}
