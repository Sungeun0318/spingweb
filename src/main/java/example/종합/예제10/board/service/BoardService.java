package example.종합.예제10.board.service;

import example.종합.예제10.board.dto.BoardDto;
import example.종합.예제10.board.entity.BoardEntity;
import example.종합.예제10.board.repository.BoardRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;


    // 게시물 등록
    public boolean 등록(BoardDto boardDto) {
        BoardEntity saveEntity = boardDto.toEntity();
        BoardEntity boardEntity = boardRepository.save(saveEntity);
        if (boardEntity.getBno() >= 1) {
            return true;
        }
        return false;
    }

    // 게시물 전체 조회
    public List<BoardDto> 전체조회(){
        List<BoardEntity> boardEntities = boardRepository.findAll();
        // 2] 조회된 모든 엔티티 --> dto 변환
        List<BoardDto> boardDtos = new ArrayList<>();
        boardEntities.forEach(boardEntity -> { // 리스트변수명.forEach( 반복변수 -> { 실행문; } );
            BoardDto boardDto = boardEntity.toDto(); // 3] 엔티티 하나씩 dto로 변환
            boardDtos.add(boardDto); // 4] 새로운 리스트에 담기
        });
        // 5] 새로운 리스트 반환
        return boardDtos;
    }

    // 게시물 개별 조회
    public BoardDto 개별조회(int bno){
        // 1] 조회할 번호(pk/id)의 엔티티 찾기
        Optional<BoardEntity> boardEntity = boardRepository.findById(bno);
        // 2] 만약에 엔티티가 존재하면
        if (boardEntity.isPresent()) {
            BoardEntity boardEntity1 = boardEntity.get();
            // 3] 엔티티 --> dto 반환
            BoardDto boardDto = boardEntity1.toDto();
            // 4] 반환, 조회 성공
            return boardDto;
        }
        // 4] 반환
        return null;
    }

    // 게시물 개별 수정
    @Transactional
    public boolean 개별수정(BoardDto boardDto){
        Optional<BoardEntity> boardEntity = boardRepository.findById(boardDto.getBno());
        if (boardEntity.isPresent()) {
            BoardEntity boardEntity1 = boardEntity.get();
            boardEntity1.setBtitle(boardDto.getBtitle());
            boardEntity1.setBcontent(boardDto.getBcontent());
            boardEntity1.setBwriter(boardDto.getBwriter());
            boardRepository.save(boardEntity1);
            return true;
        }
        return false;
    }

    // 게시물 개별 삭제
    public boolean 개별삭제(int bno){
        Optional<BoardEntity> boardEntity = boardRepository.findById(bno);
        if (boardEntity.isPresent()) {
            boardRepository.deleteById(bno);
            return true;
        }
        return false;
    }

}
