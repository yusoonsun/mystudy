-- DDL(Data Definition Language)

<<<<<<< HEAD
drop table boards;

=======
>>>>>>> 532c703ff5ba30a7402a5eb323c74b833439de7d
create table boards(
  board_no int primary key auto_increment,
  title varchar(255) not null,
  content text not null,
  writer varchar(30) not null,
  created_date datetime null default now()
);

insert into boards(board_no,title,content,writer) 
<<<<<<< HEAD
  values(1, '제목1','내용1','홍길동');
insert into boards(board_no,title,content,writer) 
  values(2, '제목2','내용2','임꺽정');
insert into boards(board_no,title,content,writer) 
  values(3, '제목3','내용3','유관순');
insert into boards(board_no,title,content,writer) 
  values(4, '제목4','내용4','안중근');
insert into boards(board_no,title,content,writer) 
  values(5, '제목5','내용5','윤봉길');
=======
  values(1,'제목1','내용1','홍길동');
insert into boards(board_no,title,content,writer)
 values(2,'제목2','내용2','임꺽정');
insert into boards(board_no,title,content,writer)
 values(3,'제목3','내용3','유관순');
insert into boards(board_no,title,content,writer)
 values(4,'제목4','내용4','안중근');
insert into boards(board_no,title,content,writer)
 values(5,'제목5','내용5','윤봉길');
>>>>>>> 532c703ff5ba30a7402a5eb323c74b833439de7d

select * 
from boards;

select * 
<<<<<<< HEAD
from boards 
where board_no = 3;
=======
from boards where board_no = 3;
>>>>>>> 532c703ff5ba30a7402a5eb323c74b833439de7d

update boards set 
  title='okok', 
  content='nono', 
  writer='hoho' 
where board_no = 3;

delete from boards where board_no=3;

<<<<<<< HEAD

drop table assignments;
=======
drop table assignment;
>>>>>>> 532c703ff5ba30a7402a5eb323c74b833439de7d

create table assignments(
  assignment_no int primary key auto_increment,
  title varchar(255) not null,
  content text not null,
  deadline date not null
);

insert into assignments(assignment_no,title,content,deadline) 
<<<<<<< HEAD
  values(1,'과제1','내용1','2024-1-1');
insert into assignments(assignment_no,title,content,deadline) 
  values(2,'과제2','내용2','2024-2-2');
insert into assignments(assignment_no,title,content,deadline) 
  values(3,'과제3','내용3','2024-3-3');
insert into assignments(assignment_no,title,content,deadline) 
  values(4,'과제4','내용4','2024-4-4');
insert into assignments(assignment_no,title,content,deadline) 
  values(5,'과제5','내용5','2024-5-5');

drop table members;
=======
  values(1,'과제1','내용1','2024-01-01');
insert into assignments(assignment_no,title,content,deadline)
 values(2,'과제2','내용2','2024-02-02');
insert into assignments(assignment_no,title,content,deadline)
 values(3,'과제3','내용3','2024-03-03');
insert into assignments(assignment_no,title,content,deadline)
 values(4,'과제4','내용4','2024-05-05');
insert into assignments(assignment_no,title,content,deadline)
 values(5,'과제5','내용5','2024-07-07');
>>>>>>> 532c703ff5ba30a7402a5eb323c74b833439de7d

create table members(
  member_no int primary key auto_increment,
  email varchar(255) not null,
  name varchar(255) not null,
  password varchar(100) not null,
  created_date datetime null default now()
);

<<<<<<< HEAD
insert into members(email,name,password,created_date)
  values('user1@test.com','user1',sha2('1111',256),'2024-1-1');
insert into members(email,name,password,created_date)
  values('user2@test.com','user2',sha2('1111',256),'2024-2-2');
insert into members(email,name,password,created_date)
  values('user3@test.com','user3',sha2('1111',256),'2024-3-3');
insert into members(email,name,password,created_date)
  values('user4@test.com','user4',sha2('1111',256),'2024-4-4');
insert into members(email,name,password,created_date)
  values('user5@test.com','user5',sha2('1111',256),'2024-5-5');
=======
insert into members(email,name,password,created_date) 
  values('user1@test.com','user1',sha2('1111',256),'2024-01-01');
insert into members(email,name,password,created_date)
  values('user2@test.com','user2',sha2('1111',256),'2024-02-01');
insert into members(email,name,password,created_date)
  values('user3@test.com','user3',sha2('1111',256),'2024-03-01');
insert into members(email,name,password,created_date)
  values('user4@test.com','user4',sha2('1111',256),'2024-04-01');
insert into members(email,name,password,created_date)
  values('user5@test.com','user5',sha2('1111',256),'2024-05-01');
>>>>>>> 532c703ff5ba30a7402a5eb323c74b833439de7d

alter table boards
  add column category int not null;

<<<<<<< HEAD
update boards set category=1;
=======
update boards set category=1;

>>>>>>> 532c703ff5ba30a7402a5eb323c74b833439de7d
