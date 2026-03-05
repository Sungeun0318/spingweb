package example.day6.practice6;


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
@Table(name = "movie")
public class MovieEntity extends BaseTime{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer movieid;

    @Column
    private String title;
    @Column
    private String director;
    @Column
    private String releaseDate;
    @Column
    private String rating;

    public MovieDto toDto() {
        return MovieDto
                .builder()
                .movieid(movieid)
                .title(title)
                .director(director)
                .releaseDate(releaseDate)
                .rating(rating)
                .createDate(getCreateDate().toString())
                .updateDate(getUpdateDate().toString())
                .build();
    }
}
