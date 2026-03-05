package example.day5.practice5;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "book")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자바 : bName  --> db : b_name 으로 표기됨
    private Integer bid;

    @Column(name = "bname", length = 255, nullable = true) // name 생략시 자바 멤버변수명으로 자동 설정
    private String bname;

    @Column(name = "bauthor", length = 255, nullable = true) // nullable 생략시 자동 true 설정, length 생략시 255 자동설정
    private String bauthor;

    @Column(name = "bpublisher", length = 255, nullable = true)
    private String bpublisher;
}
