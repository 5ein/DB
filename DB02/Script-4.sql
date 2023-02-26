CREATE TABLE "HR"."NOTICE" 
   (	"BOARDNO" NUMBER(38,0), 
	"TITLE" VARCHAR2(100), 
	"CONTENTS" VARCHAR2(100), 
	"WRITER" VARCHAR2(100), 
	"WRITEDATE" DATE, 
	"RECOMMEND" NUMBER(38,0), 
	"VIEWCOUNT" NUMBER(38,0)
   )
​
-- 추천게시판(recommend)
-- re_no 숫자
-- title, content, 
-- writer 문자
   
CREATE TABLE RECOMMEND (
	RE_NO NUMBER(38,0),
	TITLE VARCHAR2(100),
	CONTENT VARCHAR2(100),
	WRITER VARCHAR2(100)
)
​
DROP TABLE RECOMMEND -- 테이블 통째로 던져버림.
​
​
CREATE TABLE RECOMMEND (
	RE_NO NUMBER(38,0),
	TITLE VARCHAR2(100),
	CONTENT VARCHAR2(100),
	WRITER VARCHAR2(100)
)
​
​
ALTER TABLE HR.RECOMMEND MODIFY TITLE VARCHAR2(333)
​
ALTER TABLE HR.RECOMMEND ADD VIEWCOUNT NUMBER(38,0) NULL;
​
ALTER TABLE RECOMMEND DROP COLUMN VIEWCOUNT;
​
-- 추천게시판(recommend)
-- re_no 숫자
-- title, content, 
-- writer 문자
​
PRODUCT22
​
CREATE TABLE "HR"."BOARD3" 
   (	"BOARDNO" NUMBER(38,0), 
	"TITLE" VARCHAR2(100), 
	"CONTENTS" VARCHAR2(100), 
	"WRITER" VARCHAR2(100), 
	"WRITEDATE" DATE, 
	"RECOMMEND" NUMBER(38,0), 
	"VIEWCOUNT" NUMBER(38,0)
   ) 
   
ALTER TABLE BOARD3 MODIFY WRITER VARCHAR2(200) 
​
ALTER TABLE BOARD3 DROP COLUMN VIEWCOUNT
​
ALTER TABLE BOARD3 ADD TEST2 VARCHAR2(100)
​
DROP TABLE BOARD3        

-- --------------------------------------------------------------
-- D C L : DB 관리/제어 해주는 문법(계정생성, 계정권한부여, 백업, 복구)

CREATE USER apple IDENTIFIED BY a1234 -- id: apple, pw: a1234

GRANT CONNECT, resource, dba TO apple -- GRANT로 권한주기 apple 에게

REVOKE resource, dba FROM apple -- apple 한테서 권한 뺏기

DROP USER apple CASCADE -- apple 계정 삭제

-- 백업, 복구는 다음에 나올 때 하신대!

-- --------------------------------------------------------------
--스키마(틀): 저장한 틀을 만드는 것(항목들 테이블, 테이블 간의 관계)
--엔터티: 그 안에 저장할 대상
--특성: 엔티티 마다 나오는 항목들
--인스턴스: 들어가는 실제값

-- --------------------------------------------------------------
CREATE TABLE "HR"."PRODUCT" 
   ("ID" VARCHAR2(100) PRIMARY KEY, -- 프라이머리키 만들어주기
	"NAME" VARCHAR2(100), 
	"CONTENT" VARCHAR2(100), 
	"PRICE" NUMBER(38,0) 
   )
   
-- --------------------------------------------------------------
   INSERT INTO "MEMBER" VALUES ('100', '100', 'park', '011') -- 값 넣어주기
   
   INSERT INTO "MEMBER" VALUES ('200', '200', 'park', '011') -- 값 넣어주기
   
   INSERT INTO "MEMBER" VALUES ('300', '300', 'park', '011') -- 값 넣어주기
   
   SELECT * FROM "MEMBER" -- 하나 실행하고 잘 들어갔는지 확인
   
   SELECT * FROM "MEMBER" WHERE id = '100' -- id 가 100인 모든 컬럼 검색

   SELECT id FROM "MEMBER" WHERE id = '100' -- id 가 100인 id 컬럼 검색

   SELECT id, name FROM "MEMBER" WHERE id = '100' -- id 가 100인 id, name 컬럼 검색

   SELECT name, id FROM "MEMBER" WHERE id = '100' -- id 가 100인 name, id 순서로 컬럼 검색
   
   SELECT id AS 아이디, name FROM "MEMBER" WHERE id ='100' -- id가 100인 id, name 컬럼을 검색하는데 id를 아이디로 바꿔서 보여줘
   
   SELECT tel FROM "MEMBER" WHERE name = 'park' -- 이름이 park인 tel 컬럼 검색
   
   UPDATE "MEMBER" SET NAME = 'kim' WHERE id = '100' -- 아이디가 100인 사람의 이름을 kim으로 바꿔줘 보여줘
   
   UPDATE "MEMBER" SET NAME = 'yang' WHERE id = '200' -- 아이디가 200인 사람의 이름을 yang으로 바꿔줘 보여줘
   
   UPDATE "MEMBER" SET NAME = 'lee' WHERE id = '300' -- 아이디가 300인 사람의 이름을 lee으로 바꿔줘 보여줘
   
   SELECT * FROM "MEMBER" -- "MEMBER"의 모든 컬럼을 검색
   
   UPDATE "MEMBER" SET PW = '8888', TEL = '9999' WHERE ID = 'ice' -- 아이디가 ice인 사람의 비번을 8888로, 전번을 9999로 바꿔줘
   
   DELETE FROM MEMBER WHERE ID = '100' -- id가 100인 컬럼을 지워
   
   DELETE FROM "MEMBER" WHERE TEL = '011' -- tel이 011인 컬럼을 지워
   
   SELECT * FROM "MEMBER" WHERE ID = '200' AND TEL = '011' -- 조건 두개 다 만족하는 칼럼 보여줘
   
   SELECT * FROM "MEMBER" WHERE ID = '200' OR TEL = '011' -- 조건 둘중 하나라도 만족하는 칼럼 보여줘
   
   SELECT * FROM "MEMBER" ORDER BY id -- id를 기준으로 오름차순으로 정렬
   
   SELECT * FROM MEMBER ORDER BY id DESC -- id를 기준으로 내림차순으로 정렬
   
-- --------------------------------------------------------------
   -- id, name, content, price, company, img
   CREATE TABLE PRODUCT1 (
   	id varchar2(200),
   	name varchar2(200),
   	content varchar2(200),
   	price varchar2(200),
   	company varchar2(200),
   	img varchar2(200)
   )
      
--   csv파일 다운! ex) 공공데이터 포털
--   csv: 한꺼번에 다줌, 
--   XML(오픈API): 내가 요청한것만 줌
   
--   csv 파일 가지고 오기!   
--   TABLE 이름 폴더에서 우클릭 -> 데이터 가져오기 클릭 -> CSV에서 가져오기 클릭 
--   -> 파일 선택 -> 다음 -> 다음 -> 다음 -> 다음 -> 진행!
   
-- 문제 풀기
   SELECT * FROM PRODUCT1 -- 전체
   
	-- 1. price로 내림차순 정렬하여 전체컬럼 검색
   SELECT * FROM PRODUCT1 ORDER BY PRICE DESC 
   
	-- 2. company로 오름차순 정렬하여 제품의 이름, 내용, 가격 검색
   SELECT name, CONTENT, price FROM PRODUCT1 ORDER BY company
   
	-- 3. id가 100인 제품의 이름과 가격 검색
   SELECT name, price FROM PRODUCT1 WHERE id = '100'
   
	-- 4. price가 5000인 제품명과 회사명
   SELECT name, company FROM PRODUCT1 WHERE PRICE = '5000'
   
	-- 5. id가 100이고 가격이 1000인 제품명과 이미지 검색
   SELECT name, img FROM PRODUCT1 WHERE ID = '100' AND PRICE = '1000'
   
	-- 6. 회사명이 c100인 회사명과 제품명
   SELECT company, name FROM PRODUCT1 WHERE COMPANY = 'c100'
   
	-- 7. 회사명이 c100, c200인 제품명과 가격
   SELECT name, price FROM PRODUCT1 WHERE COMPANY = 'c100'
   
	-- 8. price가 5000원인 제품의 content를 품절로 수정
   UPDATE PRODUCT1 SET CONTENT = '품절' WHERE PRICE = '5000'
   
	-- 9. id가 100, 102번 제품의 img를 o.png로, price를 10000으로 수정
   UPDATE PRODUCT1 SET img = 'o.png', PRICE = '1000' WHERE id = 100 OR id = '102'
   
	-- 10. id가 101번 제품의 company를 apple, name은 appleshoes로 수정
   UPDATE PRODUCT1 SET COMPANY = 'apple', name = 'appleshoes' WHERE id = '101'
   
	-- 11. name이 shoes1이거나 id가 107인 제품 삭제
   DELETE FROM PRODUCT1 WHERE NAME = 'shoes1' OR ID = '107'
   
	-- 12. 회사명이 c100인 경우 그 칼럼 삭제
   DELETE FROM PRODUCT1 WHERE COMPANY = 'c100' 
   
	-- 13. 테이블의 모든 정보 삭제
   DELETE FROM PRODUCT1 -- 너 진짜 조건도 없이 이 데이터들 다 지울거야? 라는 확인 창이 뜸
   
    -- 14. 테이블 삭제
   DROP TABLE PRODUCT1 -- 너 진짜 이 테이블 지울거야? 라는 확인 창이 뜸
   
  -- --------------------------------------------------------------
  -- pk, fk 설정 확인 문제(관계성 설정)
   
   CREATE TABLE "HR"."REPLY" 
   (	"ID" VARCHAR2(100) PRIMARY KEY, 
		"ORIID" VARCHAR2(100), 
		"CONTENT" VARCHAR2(100), 
		"WRITER" VARCHAR2(100) 
   )
   
   ALTER TABLE HR.REPLY ADD CONSTRAINT FK_BBS FOREIGN KEY (ID) REFERENCES HR.BBS("NO");
 