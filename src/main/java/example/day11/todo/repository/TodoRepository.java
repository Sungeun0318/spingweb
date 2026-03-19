package example.day11.todo.repository;

import example.day11.todo.entity.TodoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository

public interface TodoRepository extends JpaRepository<TodoEntity, Integer> {
    // 1] JpaRepository로부터 상속받으면 .save(), find(), delete() 등등 제공받는다.
    // *findAll() : 전체조회, findById(pk값) : 식별자 1개 조회 등등 그 외 없으면 만들기

    // ============== 그외 만들기 ==============
    // 2] 쿼리 메소드 : SQL 직접 작성하지 않고 추상메소드 이름으로 쿼리 자동 생성 <카멜 표기법>
        // 2-1 : title으로 조회, 엔티티타입명 findBy필드명(타입 매개변수);
     TodoEntity findByTitle(String title); // 추상메소드란? {} 구현부가 없는 메소드

        // 2-2 : title 과 content 일치조회, 엔티티/MAP findBy필드명And필드명(타입 매개변수, 타입 매개변수);
    Map<String, Object> findByTitleAndContent(String title, String content);

        // 2-3 : title이 포함된 조회, findBy필드명Containing()
    List<TodoEntity> findByTitleContaining(String title);

        // 2-4 : 매개변수에 Pageable 인터페이스 사용하면 Page 타입으로 변환 가능하다.
    Page<TodoEntity> findByTitleContaining(String title, Pageable pageable);


    // 3] 네이티브 메소드
        // 3-1 : 연동된 데이터베이스 쿼리 사용 가능하다.
    @Query(value = "select * from todo where title = :title", nativeQuery = true)
    TodoEntity query1(String title);

        // 3-2 :
    @Query(value = "select * from todo where title = :title and content = :content", nativeQuery = true)
    Map<String, Object> query2(String title, String content);

        // 3-3
    @Query(value = "select * from todo where title like %:title%", nativeQuery = true)
    List<TodoEntity> query3(String title);

        // 3-4
    @Query(value = "select * from todo where title like %:keyword% or content like %:keyword", nativeQuery = true)
    Page<TodoEntity> query4(String keyword, Pageable pageable);

    // 4] JPQL


    
}
