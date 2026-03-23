package example.day14;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/seesion")
public class SessionController {

    // [1] 세션객체 내 값 저장 = 로그인
    @PostMapping("")
    public ResponseEntity<?> test1(@RequestParam String data, HttpServletRequest request) {
        // 1) HttpServletRequest request : HTTP 요청 정보를 담고 있는 객체
        System.out.println(request.getRemoteAddr()); // 요청한 클라이언트(사용자) IP 주소 얻기(로그/위치추척/조회수 등)
        System.out.println(request.getHeader("User-Agent")); // 요청한 클라이언트 브라우저 정보
        System.out.println(request.getSession()); // 요청한 클라이언트의 세션객체 정보 * 각 브라우저 마다 할당 *

        // 2)
        HttpSession session = request.getSession();
        System.out.println(session.getId()); // 세션의 식별번호 반환, 브라우저/드바이스 마다 할당
        System.out.println(session.getCreationTime()); // 세션의 최초생성 시간
        System.out.println(session.getLastAccessedTime()); // 세션의 마지막 접근 시간
        System.out.println(session.getMaxInactiveInterval()); // 세션의 최대 유지시간(초)

        // 3) 세션 객체 내 값 저장 == 로그인
        session.setAttribute("data", data); // 세션객체내 값(key:value) 저장
        System.out.println(session.getAttribute("data")); // 세션객체내 값(key) 호출

        return ResponseEntity.ok(true); // 임의 값 반환
    }

    // [2] 세션객체 내 값 호출 = 로그인의 회원정보(마이페이지)

    // [3] 세션객체 내 값 제거 = 로그아웃

}


/*
    톰캣 세션
        1. 정의 : 톰캣(서버프로그램)내 데이터를 저장하고 관리할 수 있게 메모리/객체 제공
        2. 목적 : 1) 상태/값 관리 2) 인증/권한 3)효율적인 메모리
        3. 사용처 : 1) *로그인*상태(서버측 = 세션 vs 클라이언트측 = JWT) 2) 장바구니 3) 실시간처리 등등
        4. 특징 : 브라우저(크롬/엣지/사파리/TV 등) 마다 *별도의 세션 객체* 할당 된다.

    HttpServletRequest
        - 서블릿(Servlet) : WAS(톰캣) 서버내 웹 기술이 가능하게 JAVA의 HTTP통신 클래스 객체
        - 주요 메소드
            1) .getRemoteAddr() : 요청한 클라이언트의 IP 반환
            2) .getHeader()     : 요청한 클라이언트의 브라우저 정보 반환
            3) .getSession()    : 요청한 클라이언트의 세션 객체 반환 *브라우저 마다*

*/


