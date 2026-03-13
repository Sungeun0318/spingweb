package example.day9.chapter6.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Getter
public class UpdateArticleRequest {
    private String title;
    private String content;
}
