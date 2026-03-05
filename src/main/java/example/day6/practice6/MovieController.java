package example.day6.practice6;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {
    @Autowired
    private MovieService movieService;

    // 등록
    @PostMapping
    public boolean addmovie(@RequestBody MovieDto movieDto) {
        boolean result = movieService.addmovie(movieDto);
        return result;
    }

    // 전체 조회
    @GetMapping
    public List<MovieDto> getmovie() {
        List<MovieDto> result = movieService.getmovies();
        return  result;
    }
    // 개별 조회
    @GetMapping
    public MovieDto getmovie(@RequestParam int movieid) {
        MovieDto result = movieService.getmovie(movieid);
        return result;
    }

    // 수정
    @PutMapping
    public boolean updatemovie(@RequestBody MovieDto movieDto) {
        boolean result = movieService.updateMovie(movieDto);
        return result;
    }

    // 삭제
    @DeleteMapping
    public boolean deletemovie(@RequestParam MovieDto movieDto) {
        boolean result = movieService.deletemovie(movieDto);
        return result;
    }

}
