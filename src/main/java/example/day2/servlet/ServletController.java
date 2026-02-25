package example.day2.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

// 서블릿이란? 자바 회사에서 HTTP웹 동적처리 하기위한 라이브러리(미리만든)/클래스
// 사용법
// 1. 현재 클래스의 "HttpServlet" 클래스로부터 상속 받는다. 상속이란> 다른 클래스로부터 멤버변수/함수 물려받는다.
// 2. 현재 클래스 위에 @WebServlet("/URL") 주소 설정한다. 중복없이 영문으로 정의한다.
// 3. (스프링환경에만 해당) AppStart 클래스 위에 @ServletComponentScan 주입하여 스프링이 서블릿 찾을 수 있도록 한다.
@WebServlet("/day02/servlet") // -> localhost:8080/day02/servlet 요청시 통신 가능한 클래스 정의

public class ServletController extends HttpServlet {

    // 순수 자바의 메소드/함수
    boolean method(int param){return true;}
    // 1. 서블릿 클래스로부터 HTTP 요청시 init함수 최초 1번 실행된다.
    @Override
    public void init() throws ServletException {
        System.out.println("init 함수 실행");
        super.init();
    }
    // 2. 서블릿 클래스로부터 HTTP 요청마다 service함수 실행된다.
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("service 함수 실행");
        super.service(req, resp);
    }










}
