package springweb.member.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import springweb.member.dto.MemberDto;
import springweb.member.entity.MemberEntity;
import springweb.member.repository.MemberRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {
    private final MemberRepository memberRepository;

    // [*] 비크립트(암호화) 객체 생성
    BCryptPasswordEncoder passwordEncoder =  new BCryptPasswordEncoder();

    // [1] 회원가입
    public boolean signup(MemberDto memberDto){
        MemberEntity saveEntity = memberDto.toEntity(); // 1] 저장할 dto -> entity 변환
        // ***** 최종 저장 하기 전에 입력받은 비밀번호를 암호화 *****
        String pwd = passwordEncoder.encode(saveEntity.getMpwd()); // - 입력받은 패스워드 암호화
        saveEntity.setMpwd(pwd); // - 암호화된 패스워드 대입
        MemberEntity savedEntity = memberRepository.save(saveEntity); // 2] jpa의 save 메소드
        if(savedEntity.getMno() > 0){ // 확인
            return true;
        }
            return false;
    }

    // [2] 로그인
    public boolean login(MemberDto loginDto){
        // 1] JPA으로 아이디로 엔티티 찾기, SQL로 아이디/비밀번호 일치 여부로 로그인 판단 불가능
        Optional<MemberEntity> optionalMember= memberRepository.findByMid(loginDto.getMid());
        // 2] 만약에 조회된 엔티티가 존재하면
        if(optionalMember.isPresent()){
            // 엔티티 꺼내기
            MemberEntity memberEntity = optionalMember.get();
            // 비크립트 암호화로 평문과 암호화문 비교
            // passwordEncoder.matches(평문, 암호화);
            boolean result = passwordEncoder.matches(loginDto.getMpwd(), memberEntity.getMpwd());
            if(result){
                return true;
            }else {
                return false;
            }
        }
        return false;
    }

    // [3] 로그아웃 생략

    // [4] 마이페이지
    public MemberDto myInfo(String loginMid){
        // 1) 로그인된 mid를 받아서 리포지토리에서 찾는다.
        Optional<MemberEntity> entityoptional= memberRepository.findByMid(loginMid);
        // 2) 만약에 엔티티가 존재하면
        if(entityoptional.isPresent()){
            return entityoptional.get().toDto();
        }
        return null;
    }


}


/*
    암호화
        1.정의 : 자료를 보호하기 위해 사람이 이해하기 어려운 데이터로 변환
        2.목적 : 자료보호, 신뢰성, 무결성 유지
        3.사용처 : 비밀번호, 금융, HTTPS 등등
        4.용어 :
            - 평문 : 원래의 자료
            - 암호문 : 암호화된 자료
            - 암호화 : 평문자료를 암호문으로 변화하는 과정
            - 복호화 : 암호문 자료를 평문으로 변환하는 과정
            - 단방향 암호화 : 평문을 암호문으로 변환하고 다시 평문으로 변환 불가능 <복호화 없음>
            - 양방향 암호화 : 평문을 암호문으로 변환하고 다시 평문으로 변환 가능 <암호화/복호화>
            - 해시 함수 : 자료를 고정된 길이로 변환하는 함수
                * 서로 다른 자료들을 *동일한 길이* 로 변화하는 함수
                * 임의의 계산식으로 변환하는 과정이므로 다시 되돌리기
                - 자바 : .hashCode(), Object클래스의 메소드로 객체주소 값을 해시코드로 반환(일정한길이의 값)로 반환
                - '사과' ------> A1B2C3
                - '사과' ------> A1B2C3    * 같은 자료는 같은 해시값이 나올 수 있다.
                - '바나나' -----> X1C2V3    * 단 서로 다른 자료도 일정한 길이로 변환한다.
                - '파인애플' ---> T1Y2U3
            - 솔트 : 암호화할 때 사용되는 랜덤값 (동일한 계산식(알고리즘/해시)의 서로 다른 결과값
                - '사과' --> 솔트추가 --> A1B2C5
        5. 종류
            1) 비밀번호      : Bcrypt(비크립트), 해시함수, 단방향/복호화없음
            2) 전자서명/파일  : SHA-256, 해시함수, 단방향/복호화없음, SHA-비트수
                - bit : 0 또는 1, 101 = 3bit
            3) 웹통신        : HTTPS(TLS//SSL), HTTP(암호화안된 상태) VS HTTPS(암호화된 상태)
        6. 비크립트
            정의 : 해시 함수를 이용하여 주로 비밀번호 암호화할 때 사용된다.
            특징
                - 솔트(salt) : 같은 비밀번호라도 랜덤(salt)값으로 서로 다른 암호화된 결과를 만든다.
                - 반복연산적용 : 계산식을 여러번하여 검증 속도 늦춤
                - 원본 복구 불가능 : 단방향 암호화문으로 비밀번호 찾기 대신에 임시비밀번호 부여/수정
            형태
                $2a$10$RFnj76wRYoqrblIi8saXR.KAuQeL7PKpf0JENYKNbAt3IhXOwj65e
                - $2a : 비크린트 버전
                - $10 : 반복연산수, 제곱근
                - $RFnj76wRYoqrblIi8saXR. : salt(22글자)
                - KAuQeL7PKpf0JENYKNbAt3IhXOwj65e : 해시값
                * 평문과 암호문 비교할 때는 암호문의 연산수와 salt와 해시값으로 평문을 암호화해서 비교한다.

            1) 설치 :
                1. SPRING 시큐리티 포함 : implementation 'org.springframework.security:spring-security'
                2. SPRING 시큐리티내 비크립트만 : implementation 'org.springframework.security:spring-security-crypto:6.4.4'

            2) 사용법
                BCryptPasswordEncoder passwordEncoder =  new BCryptPasswordEncoder();
                - String 암호화된값 = 암호객체.encode(암호화할자료)
                - boolean 비교결과 = 암호객체.matches(평문, 암호문)










*/
