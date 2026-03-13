package example.day9.chapter6.dto;

import example.day9.chapter6.domain.Article;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
public class AddArticleRequest {
    private String title;
    private String content;

    public Article toEntity() {
        return Article
                .builder()
                .title(title)
                .content(content)
                .build();
    }
}
