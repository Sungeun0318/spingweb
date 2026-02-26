package example.day2.practice2;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/day02/practice2/post")
public class PostController {

    /*
        메소드란? 상호작용(주고받는 쌍방향 행동)
            매개변수? 매개(중개)변수(정해져 있지 않는 값) : 메소드가 호출될 때 들어오는 값(인수)
            반환값? 메소드가 종료될 때 호출했던 곳으로 반환해주는 값(리턴)
        HTTP란? 상호작용(request/response)
            request? 클라이언트가 서버로부터 요청
            response? 서버가 처리한 결과를 클라이언트에 반환/응답
    */

    @PostMapping
    public boolean method(){
        System.out.println("PostController.method");
        return true;
    }

    @GetMapping()
    public List<Map<String,Object>> list(){
        System.out.println("PostController.method1");
        List<Map<String,Object>> list1 = new ArrayList<>();
        Map<String,Object> map = new HashMap<>();
        map.put("pno", "1");
        map.put("ptitle", "제목1");
        Map<String,Object> map1 = new HashMap<>();
        map1.put("pno", "2");
        map1.put("ptitle", "제목2");
        list1.add(map);
        list1.add(map1);
        return list1;

    }

    @GetMapping("/view")
    public Map<String,String> map(){
        System.out.println("PostController.method2");
        Map<String,String> map = new HashMap<>();
        map.put("pno", "3");
        map.put("ptitle", "제목3");
        return map;
    }

    @PutMapping()
    public boolean method3(){
        System.out.println("PostController.method3");
        return true;
    }

    @DeleteMapping()
    public int method4(){
        System.out.println("PostController.method4");
        return 1;
    }



}
