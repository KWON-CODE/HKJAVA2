drop table tblboard;
create table tblboard (
    num number(4) primary key,
    name varchar(10),
    pass varchar(10),
    email varchar(20),
    title varchar(30),
    contents varchar(100),
    writedate varchar(20),
    readcount number(4)
);

create sequence num_seq
    increment by 1
    start with 1
    nocycle;

insert into tblboard(num, name, pass, email) 
   values(num_seq.nextval, 'È«±æµ¿','111','hong@itcom.kr');


alter table tblboard rename column num to numseq;

select * from tblboard;

alter table tblboard add(num number(4));

 SELECT * FROM COLS WHERE TABLE_NAME = 'tblboard';
 
delete from tblboard;

desc tblboard;

select max(num) from tblboard;

insert into tblboard(numseq, name , pass, email,title, num)
    values(num_seq.nextval, 'È«±æµ¿', 'hong', 'hong@naver.com','¿¬½À', 1);

delete from tblboard;
commit;
    
create table tblmember(
    id varchar(10) not null primary key,
    pass varchar(10) not null,
    name varchar(20) not null,
    juminnum1 char(6) not null,
    juminnum2 char(7) not null,
    zip char(7),
    address1 varchar(30),
    address2 varchar(40),
    phone varchar(20),
    email varchar(30)
    );
    
    
    ALTER TABLE tblboard ADD (
  ref      NUMBER(4) DEFAULT 0,
  re_step  NUMBER(4) DEFAULT 0,
  re_level NUMBER(4) DEFAULT 0
);



insert into tblmember(id,pass,name,juminnum1,juminnum2,phone,email) values 
('hong', 'hong','È«±æµ¿','200101','1698765','01011111111','hong@naver.com');

select * from tblmember;
