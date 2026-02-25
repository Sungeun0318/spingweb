package example.day2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Controller // HTTP 기능 + 빈 등록
public class RestController2 {

    // 1. 100 반환하는 메소드
    @GetMapping("/day02/task")
    @ResponseBody // Response(응답) Body(객체지향) : 응답 자료 자동 타입변환
    // java(객체지향) <--> HTTP(문자), JAVA는 INT를 반환하겠다고 하지만 HTTP는 INT 모른다.
    // 즉] JAVA 타입을 자동으로 HTTP contents Type 변환해준다. int -> application/json
    public int method1(){
        System.out.println("RestController2.method1");
        return 100;
    }

    // 2. 문자열 반환 하는 메소드
    @GetMapping("/day02/task2")
    @ResponseBody // java String - > text/plain
    public String method2(){
        System.out.println("RestController2.method2");
        return "유재석";
    }

    // 3. Map 타입 반환 하는 메소드
    @GetMapping("/day02/task3")
    @ResponseBody
    public Map<String, Object> method3(){
        Map<String, Object> map = new HashMap<>();
        map.put("유재석", 100);
        map.put("강호동", 90);
        return map;
    }



}
