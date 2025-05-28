drop table if exists student2;

create table student2(
	hak varchar(10),
	name varchar(10),
	kor number(5),
	eng number(5),
	mat number(5),
	tot number(10) default 0,
	avg number(10,2)
);

Insert into student2(hak, name, kor, eng, mat)
values('1001', 'ȫ�浿', 100,90,90);

select * from student2;
select hak from student2 where hak = '1001' and name='ȫ�浿'