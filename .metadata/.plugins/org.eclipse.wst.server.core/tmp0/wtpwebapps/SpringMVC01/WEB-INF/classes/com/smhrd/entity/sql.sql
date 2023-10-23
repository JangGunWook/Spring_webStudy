-- 게시글 작성할 수 있는
-- 글번호, 제목, 작성자, 내용, 작성일, 조회수 
create table BOARD
				(
					idx int not null auto_increment,
					title varchar(100) not null,
					writer varchar(50) not null,
					content varchar(1000) not null,
					indate datetime default now(),
					count int default 0,

					primary key(idx)
				);
				
--- 실행 : 블록 지정 후, alt + X
insert into BOARD (title, writer, content) values('spring 게시판 만들기 01', '안현진', '스프링을 활용한 게시판 만들기');
insert into BOARD (title, writer, content) values('spring 게시판 만들기 02', '손지영', '진도빨리나가라');
insert into BOARD (title, writer, content) values('spring 게시판 만들기 03', '안권수', '신기술좀 많이 알려줘');
insert into BOARD (title, writer, content) values('spring 게시판 만들기 04', '양현종', '제발 좀 많이 배워라');


select * from BOARD where idx=1;