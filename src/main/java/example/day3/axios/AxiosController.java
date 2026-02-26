package example.day3.axios;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/day03/task")

public class AxiosController {

    @GetMapping
    public void method() {
        System.out.println("AxiosController.method");
    }

    @DeleteMapping
    public int method1(@RequestParam String name) {
        System.out.println("AxiosController.method1");
        return 10;
    }

    @PostMapping
    public boolean method2(@RequestParam int age) {
        System.out.println("AxiosController.method2");
        return true;
    }

    @PutMapping
    public boolean method3(@RequestBody Map<String, Object> map) {
        System.out.println("AxiosController.method3");
        System.out.println("map = " + map);
        return false;
    }

    @GetMapping("/axios")
    public boolean method4(@RequestParam String name) {
        System.out.println("AxiosController.method4");
        return true;
    }

}
