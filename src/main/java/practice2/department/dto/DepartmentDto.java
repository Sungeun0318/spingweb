package practice2.department.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import practice2.department.entity.DepartmentEntity;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class DepartmentDto {
    private Integer did;
    private String dname;


    public DepartmentEntity toEntity() {
        return DepartmentEntity
                .builder()
                .dname(dname)
                .build();
    }
}
