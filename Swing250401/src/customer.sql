select * from customer;
drop table customer;

create table customer (
  code number(4) primary key,
  name varchar(30) not null,
  email  varchar(30),
  tel  varchar(30));
  
insert into customer(code,name,email,tel)
	values(1,'홍길동','홍길동@지메일', '111-111')