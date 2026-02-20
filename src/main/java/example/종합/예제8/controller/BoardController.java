package example.종합.예제8.controller;
import example.종합.예제8.model.dao.BoardDao;
import example.종합.예제8.model.dto.BoardDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
@RestController // 해당 컨트롤러는 HTTP 기능 갖게 된다. <싱글톤 유사 포함>

public class BoardController {
//    public  BoardController() {}
//    private static final BoardController instance = new BoardController();
//    public static BoardController getInstance() {return instance;}

    private BoardDao bd = BoardDao.getInstance();

    // [1] 게시물 등록 controller
    @PostMapping
    public boolean write( String bcontent,  String bwrite) {
        boolean result = bd.write(bcontent, bwrite);
        return result;
    }

    // [2] 게시물 삭제 controller
    @DeleteMapping
    public boolean delete( int bno) {
        boolean result = bd.delete(bno);
        return result;
    }

    // [3] 게시물 수정 controller
    @PutMapping
    public boolean update( int bno,  String bcontent) {
        boolean result = bd.update(bno, bcontent);
        return result;
    }

    // [2] 게시물 조회 controller
    @GetMapping
    public ArrayList<BoardDto> findAll() {
        ArrayList<BoardDto> result = bd.findAll();
        return result;
    }
}


