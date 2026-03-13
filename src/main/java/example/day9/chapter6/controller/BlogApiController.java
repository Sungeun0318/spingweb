package example.day9.chapter6.controller;

import example.day9.chapter6.domain.Article;
import example.day9.chapter6.dto.AddArticleRequest;
import example.day9.chapter6.dto.ArticleResponse;
import example.day9.chapter6.dto.UpdateArticleRequest;
import example.day9.chapter6.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/articles")
@RequiredArgsConstructor
public class BlogApiController {
    private final BlogService blogService;

    @PostMapping
    public ResponseEntity<Article> addArticle(@RequestBody AddArticleRequest request) {
        // ResponseEntity<반환타입> : HTTP 응답 객체 수정/커스텀 가능하다. 응답정보 수정, 응답객체 포장
        Article savedArticle = blogService.save(request);
        return ResponseEntity.status(201).body(savedArticle); // 180p. 꼭 알아두면 좋을 응답코드 <암기필요>
            // ResponseEntity.status(응답코드).body(반환값);
    }

    @GetMapping
    public ResponseEntity<List<ArticleResponse>> findAllArticles() {
        List<ArticleResponse> articles = blogService.findAll().stream().map(ArticleResponse::new).toList();
        return ResponseEntity.ok().body(articles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArticleResponse> findArticle(@PathVariable Long id){
        Article article = blogService.findById(id);
        return ResponseEntity.ok().body(new ArticleResponse(article));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable Long id){
        blogService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Article> updateArticle(@PathVariable Long id, @RequestBody UpdateArticleRequest request) {
        Article updateArticle = blogService.update(id, request);
        return ResponseEntity.ok().body(updateArticle);
    }

}
