# fisa-01
우리fisa 5월 8일 미니 프로젝트

1. 데이터 테이블 관리
2. 회원가입시 돈을입력받아서 500원 미만일 경우 실버, 500원 이상일 경우 골드, 다이아몬드
3. 이름은 3글자이하

=목표 기능=
1. 회원가입
2. 로그인 "누구누구님이 로그인 하셨습니다. 잔액은 얼마입니다, 그리고 등급은 무엇입니다."

Controller 기능:
1.showAllCustomer
 - 모든 회원번호, 이름, 잔액, 등급번호 출력
2.login:
 - 아이디를 입력받아서 이름과, 잔액, 등급 출력
3.signin
 - 이름과 돈을 입력받아 회원 추가
 - 회원번호, 이름과 돈을 입력받아 회원 추가

EndView 기능:
1. lineCounter
 - 행 번호 출력

MyUtil 기능:
1. strMapping
 - char배열 받아서 문자열 반환
 - 문자열 받아서 char배열 반환
2. strInteger
 - 래퍼클래스 받아서 널인경우 문자열 "null"반환



```
create database project_w;

use project_w;

create table customer(
	cno int not null,
	cname varchar(3),
	cmoney int,
	cpw varchar(3),
	mno int,
	constraint pk_cno primary key (cno)
)

desc customer;

drop table membership;

create table membership(
	mno int not null,
	mname varchar(10),
	constraint pk_mno primary key (mno)
)

desc membership;

alter table customer 
add constraint fk_cus_mem foreign key (mno) references membership (mno)
on delete no action on update no action;

select * from information_schema.table_constraints where TABLE_NAME='customer';

insert into membership values(10, "silver");
insert into membership values(20, "gold");
insert into membership values(30, "diamond");

insert into customer values(101, "NOA", 100, "123", 10);
insert into customer values(102, "MOA", 300, "456", 20);
insert into customer values(103, "KAL", 600, "789", null);

select * from customer;
select * from membership;

update 
```
