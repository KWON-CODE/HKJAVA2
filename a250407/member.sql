-- DDL : CAD ���� ��� create table alter table drop table
-- DML : inseupde = insert into, select, update, delete ���� ���
-- DCL :  ���� ��� 

drop table member;
create table member (
    code char(4) not null,
    name varchar(30) not null,
    id varchar(30),
    pwd varchar(15),
    age varchar(3)
);

 select * from customer;
 create table customer (
  code number(4) primary key,
  name varchar(30) not null,
  email  varchar(30),
  tel  varchar(30));

-- insert into ���̺��(�ʵ�,�ʵ��) values('��',����)

insert into member (code, name, id, pwd, age)
values('1001', '������', 'jeea', '1111', 20);

insert into member (code, name, id, pwd, age)
values('1002', '��', 'raea', '2222', 20);

insert into member (code, name, id, pwd, age)
values('1003', '�����', 'cat', '3333', 14);

insert into member (code, name, age)
values('1004', 'ȫ�浿', 25);

commit; -- �Ϸ�
rollback; -- ����

-- select �ʵ��� from ���̺�� where ����
-- order by �ʵ� asc(desc)
-- group by �ʵ�

select code, name, id, pwd, age from member;
select * from member;
select * from member where code = '1001';
select age from member;
select distinct age from member;  -- �ߺ�����
select * from member where name='ȫ�浿';
select * from member where name like 'ȫ%'; -- %�� ��� ���ڿ� ����
select * from member where name like 'ȫ__'; -- __�� �ѱ��� ���ڿ� ����
select * from member where name like '%��%' and code=1003;
select * from member order by name asc; --�������� ����
select * from member order by name desc; -- �������� ����

-- �׷��Լ� : count(), sum(), avg(), max(), min() �巡���ϰ� �����ϱ�
select count(*) from member;
select sum(age) from member;
select max(age) from member;
select min(age) from member;
select avg(age) from member;

select * from member where age in(25, 30); -- 25,30 ���Ե�
select * from member where age not in(25,30); -- 25,30�� �ƴ�
select * from member where age between 20 and 30; -- 20~30 ����
select * from member where pwd is null; --pwd�� null��
select * from member where pwd is not null;

-- group by �ʵ�� having ����
select * from member;
select age from member group by age; -- age�� �������
select age from member group by age order by age; 
select age, sum(age) from member group by age; 
select age from member group by age having age >=20;

-- update �ʵ�� set �����ҳ��� where ����
update member set pwd='1234' where name='��';
update member set code='1005' where name like 'ȫ%';
select * from member;

-- delete from ���̺�� where ����
delete from  member where pwd='1111'
delete from member;


-- alter table ���̺�� modify �ʵ�� �ڷ���(10); -- ����Ŭ (modify) / mysql(change)
-- alter table ���̺�� add �ʵ�� �ڷ���(10); --�ʵ��߰�
-- alter table ���̺�� drop �ʵ��; -- �ʵ����
alter table member modify code varchar(10); -- code varchar(10)�� ����
alter table member add juso varchar(50); -- juso varchar(50) �߰�
alter table member add juso2 varchar(50); -- juso2 varchar(50) �߰�
alter table member modify name varchar(30) null;
alter table member drop column JUSO2; -- ����Ŭ (drop column) / mysql (drop)

--drop table ���̺�� // ���̺���ü�� ����
drop table member;



desc member; --member ���̺� ��������
rollback; -- ���������� ����
commit; -- �Ϸ�