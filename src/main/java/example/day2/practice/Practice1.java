package example.day2.practice;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/day02/practice1")
public class Practice1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet 함수 실행");
        // int value = Integer.parseInt(req.getParameter("value"));
        String value = req.getParameter("value");
        int value2 = Integer.parseInt(value);
        resp.getWriter().println(value2 + 2);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost 함수 실행");
        String value = req.getParameter("value");
        int value2 = Integer.parseInt(value);
        resp.getWriter().println(value2 * 2);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPut 함수 실행");
        String value = req.getParameter("value");
        int value2 = Integer.parseInt(value);
        resp.getWriter().println(value2 / 2);

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doDelete 함수 실행");
        String value = req.getParameter("value");
        int value2 = Integer.parseInt(value);
        resp.getWriter().println(value2 % 2);
    }
}
