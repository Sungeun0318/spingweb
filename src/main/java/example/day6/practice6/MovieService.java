package example.day6.practice6;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    // 등록
    public boolean addmovie(MovieDto movieDto) {
        MovieEntity saved = movieRepository.save(movieDto.toEntity());
        if (saved.getMovieid() >= 1) {
            return true;
        }
        return false;
    }

    // 전체 조회
    public List<MovieDto> getmovies() {
        List<MovieEntity> list = movieRepository.findAll();
        List<MovieDto> movieDtos = new ArrayList<>();
        for (MovieEntity movieEntity : list) {
            movieDtos.add(movieEntity.toDto());
        }
        return movieDtos;
    }

    // 개별 조회
    public MovieDto getmovie(int movieid) {
        Optional<MovieEntity> movieEntity = movieRepository.findById(movieid);
        if (movieEntity.isPresent()) {
            MovieEntity movieEntity1 = movieEntity.get();
            return movieEntity1.toDto();
        }
        return null;
    }

    // 수정
    public boolean updatemovie(MovieDto movieDto) {
        int updatePk = movieDto.getMovieid();
        movieRepository.findById(updatePk);
        Optional<MovieEntity> optional = movieRepository.findById(updatePk);
        if (optional.isPresent()) {
            MovieEntity updateEntity = optional.get();
            updateEntity.setTitle(movieDto.getTitle());
            updateEntity.setDirector(movieDto.getDirector());
            updateEntity.setReleasedate(movieDto.getReleasedate());
            updateEntity.setRating(movieDto.getRating());
        } else {
            return false;
        }
        return true;
    }
    // 삭제
    public boolean deletemovie(int movieid) {
        Optional<MovieEntity> movieEntity = movieRepository.findById(movieid);
        if (movieEntity.isPresent()) {
            movieRepository.deleteById(movieid);
            return true;
        }
        return false;
    }
}
