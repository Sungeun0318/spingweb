package example.종합.예제9.controller;

import example.종합.예제9.model.dao.BoardDao;
import example.종합.예제9.model.dto.BoardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // 빈등록 + HTTP + HTTP 응답객체
@RequestMapping("/board")
public class BoardController {

    @Autowired // 의존성 주입 : 등록된 빈(객체) 가져오기
    private BoardDao boardDao;

    @GetMapping // http://localhost:8080/board
    public List<BoardDto> findAll(){                    // 매개변수 정의
        List<BoardDto> result = boardDao.findAll();     // dao 호출하여 결과 받기
        return result;                                  // dao 결과로 응답하기
    }

    @PostMapping
    public boolean write(@RequestBody BoardDto boardDto){
        boolean result = boardDao.write(boardDto);
        System.out.println("BoardController.write");
        return result;
    }

    @PutMapping
    public boolean update(@RequestBody BoardDto boardDto){
        boolean result = boardDao.update(boardDto);
        System.out.println("BoardController.update");
        return result;
    }


    @DeleteMapping
    public boolean delete(@RequestParam Integer bno){
        boolean result = boardDao.delete(bno);
        System.out.println("BoardController.delete");
        return result;
    }



}
