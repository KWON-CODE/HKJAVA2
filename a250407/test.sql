-- DDL : CAD 정의 언어 create table alter table drop table
-- DML : inseupde = insert into, select, update, delete 관리 언어
-- DCL :  제어 언어 

drop table member;
create table member (
    code char(4) not null,
    name varchar(30) not null,
    id varchar(30),
    pwd varchar(15),
    age varchar(3)
);

-- insert into 테이블명(필드,필드들) values('값',값들)

insert into member (code, name, id, pwd, age)
values('1001', '강아지', 'jeea', '1111', 20);

insert into member (code, name, id, pwd, age)
values('1002', '개', 'raea', '2222', 20);

insert into member (code, name, id, pwd, age)
values('1003', '고양이', 'cat', '3333', 14);

insert into member (code, name, age)
values('1004', '홍길동', 25);

commit; -- 완료
rollback; -- 복귀

-- select 필드명들 from 테이블명 where 조건
-- order by 필드 asc(desc)
-- group by 필드

select code, name, id, pwd, age from member;
select * from member;
select * from member where code = '1001';
select age from member;
select distinct age from member;  -- 중복제거
select * from member where name='홍길동';
select * from member where name like '홍%'; -- %는 모든 문자열 패턴
select * from member where name like '홍__'; -- __는 한글자 문자열 패턴
select * from member where name like '%백%' and code=1003;
select * from member order by name asc; --오름차순 정렬
select * from member order by name desc; -- 내림차순 정렬

-- 그룹함수 : count(), sum(), avg(), max(), min() 드래그하고 실행하기
select count(*) from member;
select sum(age) from member;
select max(age) from member;
select min(age) from member;
select avg(age) from member;

select * from member where age in(25, 30); -- 25,30 포함된
select * from member where age not in(25,30); -- 25,30이 아닌
select * from member where age between 20 and 30; -- 20~30 사이
select * from member where pwd is null; --pwd가 null인
select * from member where pwd is not null;

-- group by 필드명 having 조건
select * from member;
select age from member group by age; -- age별 나이출력
select age from member group by age order by age; 
select age, sum(age) from member group by age; 
select age from member group by age having age >=20;

-- update 필드명 set 수정할내용 where 조건
update member set pwd='1234' where name='개';
update member set code='1005' where name like '홍%';
select * from member;

-- delete from 테이블명 where 조건
delete from  member where pwd='1111'
delete from member;


-- alter table 테이블명 modify 필드명 자료형(10); -- 오라클 (modify) / mysql(change)
-- alter table 테이블명 add 필드명 자료형(10); --필드추가
-- alter table 테이블명 drop 필드명; -- 필드삭제
alter table member modify code varchar(10); -- code varchar(10)로 변경
alter table member add juso varchar(50); -- juso varchar(50) 추가
alter table member add juso2 varchar(50); -- juso2 varchar(50) 추가
alter table member modify name varchar(30) null;
alter table member drop column JUSO2; -- 오라클 (drop column) / mysql (drop)

--drop table 테이블명 // 테이블자체를 제거
drop table member;



desc member; --member 테이블 구조보기
rollback; -- 이전값으로 복귀
commit; -- 완료