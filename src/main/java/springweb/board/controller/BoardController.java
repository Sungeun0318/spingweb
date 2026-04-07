package springweb.board.controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springweb.board.dto.BoardDto;
import springweb.board.service.BoardService;
import springweb.member.service.JWTService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/board")
@CrossOrigin(value = "http://localhost:5173", exposedHeaders = "Authorization", allowCredentials = "true")
public class BoardController {
    private final BoardService boardService;
    private final JWTService jWTService;


    // [1-1] 회원제 글등록 + 세션정보
    @PostMapping("/write")
    public ResponseEntity<?> write(@RequestBody BoardDto boardDto, HttpSession session){
        // 1) 세션내 로그인정보 확인
        Object object = session.getAttribute("loginMid");
        if(object == null){
            return ResponseEntity.ok(false);
        }
        // 2) 로그인 중이면
        String loginMid = (String)object;
        // 3) 서비스에게 입력받은 값과 세션에 저장된 값 전달한다.
        boolean result = boardService.write(boardDto, loginMid);
        return ResponseEntity.ok(result);

    }

    // [1-2] 회원제 글등록 + 토큰 정보
    @PostMapping("/write2")
    public ResponseEntity<?> write2(@RequestBody BoardDto boardDto, @RequestHeader("Authorization") String token){
        // 1) 매개변수로 jwt토큰 받는다.
        // 2) 만약에 토큰이 없거나 Bearer 시작하지 않으면, 문자열.startsWith("시작문자") : 문자열내 시작문자가 존재하면 true
        if(token == null || !token.startsWith("Bearer ")){
            return ResponseEntity.ok(false); // 비
        }
        // * 토큰만 추가
        token = token.replace("Bearer ", "");
        // 3) 토큰에서 클레임(값) 꺼내기
        String loginMid = jWTService.getClaim(token);
        if(loginMid == null){
            return ResponseEntity.ok(false);
        }
        // 4) 서비스에게 입력받은 값과 세션에 저장된 값 전달하기
        boolean result = boardService.write(boardDto, loginMid);
        return ResponseEntity.ok(result);

    }

    // [1-3] 회원제 글등록 + 토큰 정보 + 첨부파일(content-Type : multipart/form-data 변경)
    @PostMapping("/write3")
    public ResponseEntity<?> write3(BoardDto boardDto, @RequestHeader("Authorization") String token){
        // 1] @RequestBody 사용하지 않는다. 왜? 첨부파일 매핑하기 위해
        // 2] dto에 MultipartFile 인터페이스 포함한다. private List<MultipartFile> uploadFile; // 업로드 용도
        if(token == null || !token.startsWith("Bearer ")){
            return ResponseEntity.ok(false); // 비
        }
        token = token.replace("Bearer ", "");
        // 3) 토큰에서 클레임(값) 꺼내기
        String loginMid = jWTService.getClaim(token);
        if(loginMid == null){
            return ResponseEntity.ok(false);
        }
        // 4) 서비스에게 입력받은 값과 세션에 저장된 값 전달하기
        boolean result = boardService.write(boardDto, loginMid);
        return ResponseEntity.ok(result);

    }

    // [1-4] 회원제 글등록 + 토큰 정보 + 첨부파일 + 쿠키
    @PostMapping("/write4")
    public ResponseEntity<?> write4(BoardDto boardDto, @CookieValue(value = "token", required = false) String token){
        if(token == null ){
            return ResponseEntity.ok(false); // 비
        }
        // 3) 토큰에서 클레임(값) 꺼내기
        String loginMid = jWTService.getClaim(token);
        if(loginMid == null){
            return ResponseEntity.ok(false);
        }
        // 4) 서비스에게 입력받은 값과 세션에 저장된 값 전달하기
        boolean result = boardService.write(boardDto, loginMid);
        return ResponseEntity.ok(result);

    }

    // [2] 전체 조회
    @GetMapping("/list")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(boardService.findAll());
    }

    // [3] 개별 조회
    @GetMapping("/view")
    public ResponseEntity<?> findById(@RequestParam long bno){
        return ResponseEntity.ok(boardService.findById(bno));
    }


}
