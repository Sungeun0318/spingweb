package practice2.employee.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;
import practice2.employee.entity.EmployeeEntity;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class EmployeeDto {
    private Integer eid;
    private String ename;
    private Integer did;
    private String eposition;
    private String eimg;
    private MultipartFile uploadFile;

    public EmployeeEntity toEntity() {
        return EmployeeEntity
                .builder()
                .ename(ename)
                .did(did)
                .eposition(eposition)
                .eimg(eimg)
                .build();
    }
}
