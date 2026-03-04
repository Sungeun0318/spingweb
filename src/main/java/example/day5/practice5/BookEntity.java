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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bid;

    @Column(name = "bname", length = 255, nullable = true)
    private String bname;

    @Column(name = "bauthor", length = 255, nullable = true)
    private String bauthor;

    @Column(name = "bpublisher", length = 255, nullable = true)
    private String bpublisher;
}
