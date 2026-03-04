drop database if exists mydb0304;
create database mydb0304;
use mydb0304;

create table exam(
	eno int primary key auto_increment,
    ename varchar(255)
);

insert into exam(ename) values('유재석');
insert into exam(ename) values('강호동');
insert into exam(ename) values('신동엽');
select * from exam;