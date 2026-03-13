package example.day9.chapter6.repository;

import example.day9.chapter6.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Article, Long> {
}
