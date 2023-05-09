# fisa-01
우리fisa 5월 8일 미니 프로젝트

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
