CREATE TABLE `hr`.`NOTICE` (
  `BOARDNO` int DEFAULT NULL COMMENT '게시판번호',
  `TITLE` varchar(100) DEFAULT NULL COMMENT '게시판제목',
  `CONTENTS` varchar(100) DEFAULT NULL COMMENT '게시판내용',
  `WRITER` varchar(100) DEFAULT NULL COMMENT '게시판글쓴이',
  `WRITEDATE` date DEFAULT NULL COMMENT '작성일',
  `RECOMMEND` int DEFAULT NULL COMMENT '추천수',
  `VIEWCOUNT` int DEFAULT NULL COMMENT '조회수'
)

-- sql문이랑 붙여쓰면 안됨
-- 추천게시판(recommend)
-- re_no 숫자
-- title, content, writer 문자

create table HR.RECOMMEND (
	`RE_NO` int,
	`TITLE` varchar(100),
	`CONTENT` varchar(100),
	`WRITER` varchar(100)
)

DROP table RECOMMEND -- 테이블 통채로 던져버림.

create table RECOMMEND (
	`RE_NO` int,
	`TITLE` varchar(100),
	`CONTENT` varchar(100),
	`WRITER` varchar(100)
)

DROP table RECOMMEND -- 테이블 통채로 던져버림.

create table RECOMMEND (
	`RE_NO` int(38.0),
	`TITLE` varchar(100),
	`CONTENT` varchar(100),
	`WRITER` varchar(100)
)

ALTER TABLE hr.recommend MODIFY COLUMN TITLE varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;

ALTER TABLE hr.recommend MODIFY COLUMN CONTENT varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;

ALTER TABLE hr.recommend ADD VIEWCOUNT INTEGER NULL;

ALTER TABLE hr.recommend MODIFY COLUMN WRITER varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;

CREATE TABLE `board3` (
  `BOARDNO` int DEFAULT NULL COMMENT '게시판번호',
  `TITLE` varchar(100) DEFAULT NULL COMMENT '게시판제목',
  `CONTENTS` varchar(100) DEFAULT NULL COMMENT '게시판내용',
  `WRITER` varchar(100) DEFAULT NULL COMMENT '게시판글쓴이',
  `WRITEDATE` date DEFAULT NULL COMMENT '작성일',
  `RECOMMEND` int DEFAULT NULL COMMENT '추천수',
  `VIEWCOUNT` int DEFAULT NULL COMMENT '조회수'
)

ALTER TABLE hr.board3 ADD TEST varchar(100) NULL;

ALTER TABLE hr.board3 DROP COLUMN TEST;

CREATE TABLE HR.PRODUCT3
(ID VARCHAR(100) primary key,
NAME VARCHAR(100),
CONTENT VARCHAR(100),
PRICE INT
)

-- ------------------------------------------------------------

INSERT INTO MEMBER VALUES ('100','100','park','011')

INSERT INTO MEMBER VALUES ('200','200','park','011')

INSERT INTO MEMBER VALUES ('300','300','park','011')

select * from member 

select * from member where ID = '100' -- ID가 100인 모든 컬럼

select ID from member where ID = '100' -- ID가 100인 ID 컬럼

select ID, NAME from member where ID = '100' -- ID가 100인 ID, NAME 컬럼

select NAME, ID from member where ID = '100' -- ID가 100인 NAME, ID 컬럼

select ID as 아이디, NAME from member where ID = '100' -- ID를 아이디로 보이게하고 아이디, NAME 컬럼 보이게

SELECT tel FROM MEMBER WHERE name = 'park'

select * FROM member -- member 전부다 프린트

update member set NAME = 'KIM' where ID = '100' -- ID 가 100인 사람 NAME 을 KIM으로 바꾸기

update `member` set NAME = 'YANG' where ID = '200'

update `member` set NAME = 'LEE' where ID = '300'

select * from member

update `member` set PW = '8888', TEL = '9999' where ID = 'ICE' -- where 뒤에 조건을 안써주면 전부다 바뀜

delete from `member` where ID = '100' -- 멤버중 아이디가 100인 사람 삭제 

DELETE from member where TEL = '011' -- TEL이 011 인 사람들 삭제

select * from member where ID = '200' and TEL = '011' -- 조건 둘다 맞는거 보여줘(가져와) 

select * from member where ID = '200' or TEL = '011' -- 조건 하나가 맞아도 보여줘(가져와) 

select * from member order by ID -- 오름차순으로 정렬

select * from member order by ID desc  -- 내림차순으로 정렬

-- -----------------------
-- ID, NAME, CONTENT, PRICE, COMPANY, IMG

create table PRODUCT (
	ID VARCHAR(200),
	NAME VARCHAR(200),
	CONTENT VARCHAR(200),
	PRICE VARCHAR(200),
	COMPANY VARCHAR(200),
	IMG VARCHAR(200)
)

select * from product -- 전체컬럼 보이기

SELECT * from product order by PRICE desc -- 1. price로 내림차순 정렬하여 전체컬럼 검색

SELECT NAME, CONTENT, PRICE from product order by COMPANY -- 2. company로 오름차순 정렬하여 제품의 이름, 내용, 가격 검색

select NAME, PRICE from product where ID = '100' -- 3. ID가 100인 제품의 이름과 가격 검색

select NAME, COMPANY from product where PRICE = '5000' -- 4. price가 5000인 제품명과 회사명

select NAME, IMG from product where ID = '100' and PRICE = '1000' -- 5. id가 100이고 가격이 1000인 제품명과 이미지 검색

select COMPANY, NAME from product where COMPANY = 'C100' -- 6. 회사명이 c100인 회사명과 제품명

select NAME, PRICE from product where COMPANY = 'C100' or COMPANY = 'C200' -- 7. 회사명이 c100, c200인 제품명과 가격

update product set CONTENT = '품절' where PRICE = '5000' -- 8. price가 5000원인 제품의 content를 품절로 수정

select * from product where PRICE = '5000' -- 8-1. 8번 확인

update product set IMG = 'O.PNG', PRICE = '10000' where ID = '100' OR ID = '102' -- 9. id가 100, 102번 제품의 img를 o.png로, price를 10000으로 수정

select * from product where ID = '100' OR ID = '102' -- 9-1. 9번 확인

update product set COMPANY = 'APPLE', NAME = 'APPLESHOES' where ID = '101' -- 10. id가 101번 제품의 company를 apple, name은 appleshoes로 수정

select * from product where ID = '101' -- 10-1. 10번 확인

delete from product where NAME = 'SHOES1' or ID = '107' -- 11. name이 shoes1이거나 id가 107인 제품 삭제

select * from product where NAME = 'SHOES1' or ID = '107' -- 11-1. 11번 확인

delete from product where COMPANY = 'C100' -- 12. 회사명이 c100인 경우 모든 정보 삭제

select * from product -- 12-1. 12번 확인

delete from product -- 13. 테이블의 모든 정보 삭제 (너 조건도 없이 이데이터들 다 진짜 지울거야? 창 띄움)

drop table product -- 14. 테이블 삭제

select * from product -- 14-1. 14번 확인 (그 테이블 없어 라고 오류뜨면 정답!)

-- ----------------------------------------------------------------------