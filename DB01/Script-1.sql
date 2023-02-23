-- 테이블명 + 항목명 + 항목에 들어가는 데이터타입

use hr

CREATE TABLE member2 ( 
	id varchar(100),
	pw varchar(100),
	name varchar(100),
	tel varchar(100)
)

create table bbs2(
	id varchar(100),
	pw varchar(100),
	content varchar(100),
	writer varchar(100)
)

create table product2 (
	no varchar(100),
	name varchar(100),
	content varchar(100),
	price varchar(100)
)

CREATE TABLE `member3` (
  `id` varchar(100) DEFAULT NULL,
  `pw` varchar(100) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `tel` varchar(100) DEFAULT NULL
)

insert into member values ('park', '1234', 'park', '011')

insert into member values ('apple', '1111', 'apple', '011')

insert into member values ('ice', '2222', 'ice', '012')

insert into member values ('melon', '3333', 'melon', '013')


SELECT * FROM `member`  -- 모든 컬럼

select id from `member`

select id, pw from `member`



