drop database if exists booktest;
create database booktest;
use booktest;

create table book(
	bid int primary key auto_increment,
    bname varchar(255),
    bauthor varchar(255),
    bpublisher varchar(255)
);

insert into book(bname, bauthor, bpublisher) values('해리포터와 마법사의 돌', 'J.K. 롤링', '문학수첩');
insert into book(bname, bauthor, bpublisher) values('연금술사', '파울로 코엘료', '문학동네');
insert into book(bname, bauthor, bpublisher) values('나미야 잡화점의 기적', '히가시노 게이고', '현대문학');
insert into book(bname, bauthor, bpublisher) values('정의란 무엇인가', '마이클 샌델', '와이즈베리');
insert into book(bname, bauthor, bpublisher) values('이기적 유전자', '리처드 도킨스', '을유문화사');
insert into book(bname, bauthor, bpublisher) values('데일 카네기 인간관계론', '데일 카네기', '현대지성');
insert into book(bname, bauthor, bpublisher) values('총 균 쇠', '재레드 다이아몬드', '문학사상');
insert into book(bname, bauthor, bpublisher) values('쇼펜하우어 소품문', '아르투어 쇼펜하우어', '을유문화사');
insert into book(bname, bauthor, bpublisher) values('생각의 탄생', '로버트 루트번스타인', '에코의서재');
insert into book(bname, bauthor, bpublisher) values('자존감 수업', '윤홍균', '심플라이프');

select * from book;



