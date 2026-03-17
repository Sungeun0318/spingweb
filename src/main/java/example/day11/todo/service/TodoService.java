package example.day11.todo.service;

import example.day11.todo.dto.TodoDto;
import example.day11.todo.entity.TodoEntity;
import example.day11.todo.repository.TodoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor // final 멤버변수 생성자 제공
@Transactional // 트랜잭션
public class TodoService {
    private final TodoRepository todoRepository;

    // 1. 전체 조회
    public List<TodoDto> findAll(){
        // 1]  모든 엔티티 조회한다.
        List<TodoEntity> entityList = todoRepository.findAll();
        // 2] 모든 엔티티 --> 모든 dto 변환한다.
            // 방법4]l
        List<TodoDto> list4 = entityList
                .stream()
                .map(TodoEntity :: toDto) // 중간연산, 람다식 대신에 메소드 레퍼런스API(미리 정의된 메소드)
                // 클래스명 :: 메소드명
                .collect(Collectors.toList()); // 최종출력, List 타입
        return list4;
    }

    // 2. 개별 조회
    public TodoDto findById(int id){
        // 방법 2]
        TodoDto todoDto = todoRepository.findById(id)
                // 스트림(데이터들) 사용하지 않고 Optional에서 map 메소드 지원
                .map(TodoEntity :: toDto) // 중간 연산
                .orElse(null); // 만약에 조회 결과 없으면 null 반환
        return todoDto;

    }

    // 3. title 개별조회
    public TodoDto query1(String title){
        // * findById 밖에 없으므로 리포지토리에서 findByIdTitle 만들자.
        // 2-1] 쿼리 메소드 호출
        TodoEntity entity = todoRepository.findByTitle(title);
        // 3-1] 네이티브 쿼리 호출
        TodoEntity entity1 = todoRepository.query1(title);
        return entity1.toDto();
    }

    // 4. title과 content 개별 조회
    public Map<String, Object> query2(String title, String content){
        // 2-2] 쿼리 메소드 호출
        Map<String, Object> result = todoRepository.findByTitleAndContent(title, content);
        System.out.println("result = " + result.toString());
        // 3-2] 네이티브 메소드 호출
        return todoRepository.query2(title, content);
    }

    // 5. title이 포함된 개별 조회
    public List<TodoDto> query3(String title){
        // 2-3]
        // List<TodoEntity> entityList = todoRepository.findByTitleContaining(title);
        // 3-3]
        List<TodoEntity> entityList1 = todoRepository.query3(title);
        return entityList1
                .stream() // 스트림 시작
                .map(TodoEntity::toDto) // 중간연산, 메소드레퍼런스API, 엔티티 --> dto 변환
                .collect(Collectors.toList()); // 최종출력은 List 타입
    }



}
//      ==== 4가지 방법 1번 방법을 알고 있어야 아래 방법들 활용가능 꼭 알아둘 것 ====
//            // 방법1]
//        List<TodoDto> list1 = new ArrayList<>();
//        for(int i = 0; i < entityList.size(); i++){
//            TodoEntity entity = entityList.get(i);
//            list1.add(entity.toDto());
//        }
//            // 방법2]
//        List<TodoDto> list2 = new ArrayList<>();
//        entityList.forEach(todoEntity -> list2.add(todoEntity.toDto()));
//
//            // 방법3]
//        List<TodoDto> list3 = entityList
//                .stream() // 스트림(데이터들 흐름) 시작
//                .map(entity -> entity.toDto()) // 중간연산, 람다식(함수 정의)
//                .collect(Collectors.toList()); // 최종출력

//            // 방법4]
//        List<TodoDto> list4 = entityList
//                .stream()
//                .map(TodoEntity :: toDto) // 중간연산, 람다식 대신에 메소드 레퍼런스API(미리 정의된 메소드)
//                // 클래스명 :: 메소드명
//                .collect(Collectors.toList());


// 방법 1]
//Optional<TodoEntity> optional = todoRepository.findById(id);
//        if(optional.isPresent()){
//TodoDto todoDto = optional.get().toDto();
//        }
//
// 방법 2]
//TodoDto todoDto = todoRepository.findById(id)
//        // 스트림(데이터들) 사용하지 않고 Optional에서 map 메소드 지원
//        .map(TodoEntity :: toDto) // 중간 연산
//        .orElse(null); // 만약에 조회 실패하면 null 반환
//        return todoDto.toEntity();
