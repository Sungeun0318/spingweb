package example.day6.practice6;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class MovieDto {
    private Integer movieid;
    private String title;
    private String director;
    private String releaseDate;
    private String rating;

    private String createDate;
    private String updateDate;

    public MovieEntity toEntity() {
        return MovieEntity
                .builder()
                .movieid(movieid)
                .title(title)
                .director(director)
                .releaseDate(releaseDate)
                .rating(rating)
                .build();
    }


}
