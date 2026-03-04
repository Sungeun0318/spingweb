package example.day5.practice5;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class BookDto {
    private Integer bid;
    private String bname;
    private String bauthor;
    private String bpublisher;
}
