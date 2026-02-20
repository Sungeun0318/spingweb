# [1] 데이터베이스 생성
drop database if exists boardservice7;
create database boardservice7;
use boardservice7;

# [2] 테이블 생성
create table board(
	bno int auto_increment,
    constraint primary key(bno),
    bcontent longtext not null,
    bwriter varchar(30) not null,
    bdate datetime default now()
);

# [3] 테이블 샘플 데이터 
insert into board (bcontent, bwriter) values ('안녕하세요', '유재석');
insert into board (bcontent, bwriter) values ('오늘 날씨 좋네요', '강호동');
insert into board (bcontent, bwriter) values ('점심 뭐 먹지?', '신동엽');
insert into board (bcontent, bwriter) values ('자바 공부 중', '하하');
insert into board (bcontent, bwriter) values ('SQL 너무 어려워요', '노홍철');
insert into board (bcontent, bwriter) values ('게시판 테스트입니다', '정형돈');
insert into board (bcontent, bwriter) values ('첫 번째 글', '박명수');
insert into board (bcontent, bwriter) values ('두 번째 글', '정준하');
insert into board (bcontent, bwriter) values ('세 번째 글', '지석진');
insert into board (bcontent, bwriter) values ('네 번째 글', '이광수');
insert into board (bcontent, bwriter) values ('다섯 번째 글', '송지효');
insert into board (bcontent, bwriter) values ('여섯 번째 글', '김종국');
insert into board (bcontent, bwriter) values ('일곱 번째 글', '양세찬');
insert into board (bcontent, bwriter) values ('여덟 번째 글', '전소민');
insert into board (bcontent, bwriter) values ('아홉 번째 글', '조세호');
insert into board (bcontent, bwriter) values ('열 번째 글', '남창희');
insert into board (bcontent, bwriter) values ('열한 번째 글', '홍진경');
insert into board (bcontent, bwriter) values ('열두 번째 글', '이찬원');
insert into board (bcontent, bwriter) values ('열세 번째 글', '임영웅');
insert into board (bcontent, bwriter) values ('열네 번째 글', '영탁');


