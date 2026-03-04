package example.day5.mvc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // getter + setter + toString
@NoArgsConstructor
@AllArgsConstructor
public class ExamDto {
    private Integer eno; // int 대신에 Integer 사용
    private String ename;
}
// DTO 이동 객체
