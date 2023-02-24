--[실습문제]
--1.	DBeaver를 사용하여 hobby테이블을 생성하시오(hobbyid, content, location)
--
--2.	hobby테이블에서 DDL을 생성하여 hobby2 테이블을 생성하시오.
--
--3.	hobby테이블에 SQL문을 사용하여 1)100, 'run', 'seoul' 2)200, 'book', 'busan'을 입력
--insert into HOBBY values (100, 'run', 'seoul')
--insert into HOBBY values (200, 'book', 'busan')
--
--String sql = “insert into HOBBY values (200, 'book', 'busan')”;
--
--4.	hobby테이블에 SQL문을 사용하여 
--1)전체 내용을 검색, 
--2)content만 검색, 
--3) location, content검색

CREATE TABLE "HR"."HOBBY2" 
   (	"HOBBYID" NUMBER(38,0), 
	"CONTENT" VARCHAR2(100), 
	"LOCATION" VARCHAR2(100)
   )
   
   insert into HOBBY values (100, 'run', 'seoul')
   
   insert into HOBBY values (200, 'book', 'busan')
   
   
   SELECT * FROM HOBBY
   
   select content from HOBBY
   
   select location, content from HOBBY