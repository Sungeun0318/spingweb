package example.day2.practice2;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/board")
public class BoardController {

    // 1.
    // http://localhost:8080/board
    // body : {"bno" : 1, "bcontent" : "내용1", "bwriter" : "작성자"}

    @PostMapping
    public boolean boardWrite(@RequestBody BoardDto boardDto){
        System.out.println("BoardController.boardWrite");
        return true;
    }

    // 2.
    // http://localhost:8080/board
    @GetMapping
    public ArrayList<BoardDto> board(){
        System.out.println("BoardController.board");
        ArrayList<BoardDto> list = new ArrayList<>();
        BoardDto boardDto = new BoardDto(1, "내용1", "작성자1");
        BoardDto boardDto1 = new BoardDto(2, "내용2", "작성자2");
        list.add(boardDto);
        list.add(boardDto1);
        return list;
    }

    // 3.
    // http://localhost:8080/board/detail?bno=1
    @GetMapping("/detail")
    public BoardDto boarddetail(@RequestParam int bno){
        BoardDto boardDto = new BoardDto(1, "내용1", "작성자1");
        return boardDto;

    }
    // 4.
    // http://localhost:8080/board?bno=1
    @DeleteMapping
    public boolean boarddelete(@RequestParam int bno){
        System.out.println("BoardController.boarddelete");
        return false;
    }

    // 5.
    // http://localhost:8080/board
    // body : {"bno" : 1, "bcontent" : "내용1"}

    @PutMapping
    public boolean boardupdate(@RequestBody BoardDto boardDto){
        System.out.println("BoardController.boardupdate");
        return true;
    }
}
