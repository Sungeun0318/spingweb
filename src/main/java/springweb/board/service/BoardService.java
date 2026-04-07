package springweb.board.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import springweb.FileService;
import springweb.board.dto.BoardDto;
import springweb.board.entity.BoardEntity;
import springweb.board.repository.BoardRepository;
import springweb.member.entity.MemberEntity;
import springweb.member.repository.MemberRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;
    private final FileService fileService; // + 파일 서비스


    // [1] 글쓰기
    public boolean write(BoardDto boardDto, String loginMid){
        BoardEntity saveEntity = boardDto.toEntity(); // 1] dto --> entity 변환한다.
        // 저장하기 전에 FK 대입하기, FK의 엔티티를 찾아서 대입
        // 현재 로그인중인 mid로 엔티티 찾기
        Optional<MemberEntity> entityOptional = memberRepository.findByMid(loginMid);
        if(!entityOptional.isPresent()){ // !부정문, isPresent() 아니면
            return false; // 존재하지않은 회원으로 실패
        }
        // 저장할 게시물 엔티티에 set엔티티(회원엔티티)
        saveEntity.setMemberEntity(entityOptional.get());

        // === 최종 DB에 엔티티를 SAVE하기 전에 첨부파일이 존재하면 업로드 ===
        String fileName = fileService.upload(boardDto.getUploadFile()); // dto내 multipartFile 대입한다.
        // 만약에 업로드 했다면
        if(fileName != null){
            saveEntity.setBfile(fileName);
        }


        BoardEntity savedEntity = boardRepository.save(saveEntity); // 2] entity 저장한다.
        if (savedEntity.getBno() > 0){
            return true;
        }else {
            return false;
        }


    }

    // [2] 전체 조회
    public List<BoardDto> findAll(){
        return boardRepository.findAll(Sort.by(Sort.Direction.DESC, "bno")) // .findAll(페이징, 정렬) 전체조회
                .stream() // .stream()란? 여러 개 자료를 갖는 자료(리스트/베열)들의 순차적 처리 지원 함수
                // .map(boardEntity -> boardEntity.toDto()) // map(반복변수 -> { return 실행문})
                .map(BoardEntity :: toDto) // 메소드 레퍼런스란? 화살표 함수 간결하게 사용하는 문법, 클래스명 :: 함수명
                .toList(); // 리스트타입으로 반환
    }

    // [3] 개별 조회
    public BoardDto findById(long bno){
        return boardRepository.findById(bno) // .findById(pk번호) 개별엔티티조회
                .orElse(null) // 만일 엔티티가 없으면
                .toDto(); // 엔티티가 존재하면 dto로 변환
    }



}
