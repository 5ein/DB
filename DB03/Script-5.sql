
CREATE TABLE "HR"."PRODUCT" (	
	"ID" VARCHAR2(100), 
	"NAME" VARCHAR2(100), 
	"CONTENT" VARCHAR2(100), 
	"PRICE" NUMBER(38,0),
	"COMPANY" VARCHAR2(200),
	"IMG" VARCHAR2(200)
   )

CREATE TABLE "HR"."MEMBER" (
	"ID" VARCHAR2(100), 
	"PW" VARCHAR2(100), 
	"NAME" VARCHAR2(100), 
	"TEL" VARCHAR2(100) 
   )
   
CREATE TABLE "HR"."BBS" (	
   	"NO" VARCHAR2(100), 
	"TITLE" VARCHAR2(100), 
	"CONTENT" VARCHAR2(100), 
	"WRITER" VARCHAR2(100) 
   )

-- 한줄복사: 컨트롤 + 알트 + 화살표 아래
-- 한줄삭제: 컨트롤 + D
-- 저장할 대상: 엔티티(회원정보, 게시판, 상품), 엔티티간의 관계: 회원이 상품을 주문하다(주문정보)
-- 			엔티티 + 관계 ==> 테이블로 만들자.
   
CREATE TABLE orderlist (
	"NO" VARCHAR2(100),
	member_id varchar2(100),
	product_id varchar2(100),
	total_count varchar2(100)
)   


CREATE TABLE "HR"."depart" (	
	"id" VARCHAR2(100), 
	"name" VARCHAR2(100), 
	"instructor" VARCHAR2(100) 
   )
   
CREATE TABLE "HR"."student" (	
	"id" VARCHAR2(100), 
	"name" VARCHAR2(100), 
	"tel" VARCHAR2(100), 
	"depart_id" VARCHAR2(100) 
   )
      
CREATE TABLE "HR"."subject" (	
	"id" VARCHAR2(100), 
	"title" VARCHAR2(100), 
	"depart_id" VARCHAR2(100) 
   )
   
CREATE TABLE "HR"."BBS2" 
(   "no" VARCHAR2(100), 
	"TITLE" VARCHAR2(100), 
	"CONTENT" VARCHAR2(100), 
	"WRITER" VARCHAR2(100), 
	 CONSTRAINT "BBS_PK22" PRIMARY KEY ("no"),
	 CONSTRAINT "FK_MEMBER22" FOREIGN KEY ("WRITER")
	 REFERENCES "HR"."MEMBER" ("ID")
)

CREATE TABLE "HR"."BBS3" 
(	"no" VARCHAR2(100), 
	"TITLE" VARCHAR2(100), 
	"CONTENT" VARCHAR2(100), 
	"WRITER" VARCHAR2(100)
) 

-- pk제약조건 추가
ALTER TABLE HR.BBS3
ADD CONSTRAINT BBS3_PK PRIMARY KEY ("no")

--FK제약조건 추가
ALTER TABLE HR.BBS3 --ALTER: 테이블에서 테이블명,컬럼명 변경, 제약조건 추가 할때 씀
ADD CONSTRAINT FK_MEMBER33 
FOREIGN KEY (WRITER) REFERENCES HR."MEMBER"(ID);

-- depart2 table생성- id(pk), name, instructor 테이블 생성하면서 제약조건 추가해 주세요.
CREATE TABLE HR."depart2" (
	"id" VARCHAR2(100),
	"name" VARCHAR2(100), 
	"instructor" VARCHAR2(100) ,
	CONSTRAINT depart2_PK PRIMARY KEY ("id")
)

-- student2 table생성- id(pk), name, tel, depart_id(fk) 테이블 생성후, 제약조건(pk, fk)추가해 주세요.
CREATE TABLE HR."student2" (
	id varchar2(100),
	name varchar2(100),
	tel varchar2(100),
	depart_id varchar2(100)
) 

ALTER TABLE HR."student2"
ADD CONSTRAINT student2_PK PRIMARY KEY (id)

ALTER TABLE hr."student2"
ADD CONSTRAINT FK_depart2 FOREIGN KEY (depart_id) REFERENCES hr."depart2"("id");

-- ---------------------------------------------------
-- 테이블 복사
CREATE TABLE member22
AS SELECT *FROM "MEMBER" --MEMBER 테이블을 복사에서 member22를 만들어라.

INSERT INTO MEMBER22 
VALUES ('banana3','banana3','banana3','banana3', sysdate) 
-- sysdate 만들어 보

SELECT * FROM MEMBER22 -- 전체 출력

INSERT INTO MEMBER22 
VALUES ('banana4','banana4','banana4','banana4', sysdate, 'aaa') 
-- 내가 넣은값aaa빼고 나머지 애들은 디폴트값 multi가 들어감, not null도 같이 해봄,

-- sequence 만들고 사용
INSERT INTO BBS3 VALUES (bbs_id_seq.nextval, 'happy', 'happy day','ice')

INSERT INTO BBS3 
VALUES (bbs_id_seq.nextval, 'happy2', 'happy day2','ice')

SELECT * FROM BBS3


CREATE SEQUENCE pd_id_seq 
INCREMENT BY 1
START WITH 1

CREATE TABLE product2 (
	id number(38, 0),
	name varchar2(100)
)

INSERT INTO product2
VALUES (pd_id_seq.nextval, 'shoes')

SELECT * FROM PRODUCT2

-- 1. orderlist3을 만드세요 -- id(number), title, price(number)
-- 2. sequence를 만드세요. --or_seq, start값: 1, increment값: 1
-- 3. row값 3개 이상 넣어보고 확인해보세요.

CREATE TABLE orderlist3 (
	id number(38, 0),
	title varchar2(100),
	price number(38, 0)
)

CREATE SEQUENCE or_seq INCREMENT BY 1 START WITH 1

INSERT INTO orderlist3 VALUES (or_seq.nextval, 'title5', '5')

SELECT * FROM orderlist3

SELECT * FROM orderlist3
ORDER BY id -- 오름차순

SELECT * FROM orderlist3
ORDER BY id DESC -- 내림차순

SELECT * FROM ORDERLIST3
WHERE id >= 3
ORDER BY id DESC 

-- -----------------------------------------------------------------

CREATE TABLE DEPT(	
	DEPTNO NUMBER(2),
	DNAME VARCHAR2(14 BYTE),
	LOC VARCHAR2(13 BYTE)
)

CREATE TABLE EMP(
	EMPNO NUMBER(4),
	ENAME VARCHAR2(10 BYTE),	
	JOB VARCHAR2(9 BYTE),	
	MGR NUMBER(4),	
	HIREDATE DATE,	
	SAL NUMBER(7,2),	
	COMM NUMBER(7,2),	
	DEPTNO NUMBER(2)
)

CREATE TABLE SALGRADE(
	GRADE NUMBER,
	LOSAL NUMBER,
	HISAL NUMBER
)

ALTER TABLE DEPT ADD (
	CONSTRAINT PK_DEPT
	PRIMARY KEY
(DEPTNO));

ALTER TABLE EMP ADD (
	CONSTRAINT PK_EMP
	PRIMARY KEY
(EMPNO));

ALTER TABLE EMP ADD (
	CONSTRAINT FK_DEPTNO
	FOREIGN KEY (DEPTNO)
	REFERENCES DEPT (DEPTNO));

SELECT * FROM EMP -- selection

SELECT DEPTNO  FROM EMP -- projection

SELECT DISTINCT  DEPTNO  FROM EMP -- DISTINCT

SELECT ename, sal * 12 AS yearsal FROM emp -- 컬럼명을 sal * 12 에서 yearsal로 변경해서 출력

SELECT * FROM EMP ORDER BY sal DESC -- 내림차순

SELECT * FROM EMP 
WHERE deptno = 30   -- 30인것
ORDER BY empno DESC

SELECT * FROM EMP 
WHERE NOT deptno = 30 -- 30이 아닌것
ORDER BY empno DESC

SELECT * FROM EMP
WHERE deptno = 30 AND joB = 'SALESMAN' --두가지 조건 다 만족 하는것

SELECT * FROM EMP
WHERE deptno = 30 OR joB = 'SALESMAN' -- 두가지 조건중 하나라도 만족하는것

SELECT * FROM EMP
WHERE sal >= 300 --300보다 큰것

SELECT * FROM EMP
WHERE sal != 300 --300이 아닌것

SELECT * FROM EMP
WHERE job IN ('SALESMAN', 'MANAGER') -- 'SALESMAN', 'MANAGER' 인것
ORDER BY JOB 

SELECT * FROM EMP
WHERE job NOT IN ('SALESMAN', 'MANAGER') -- 'SALESMAN', 'MANAGER'가 아닌것
ORDER BY JOB 

SELECT * FROM EMP
WHERE sal BETWEEN 2000 AND 3000 -- 2000과 3000 사이인것
ORDER BY empno

SELECT * FROM EMP
WHERE sal NOT BETWEEN 2000 AND 3000 -- 2000과 3000 사이가 아닌것
ORDER BY empno

SELECT * FROM EMP
WHERE ENAME LIKE '_L%'  -- '_L%' 이형식인것

SELECT * FROM EMP
WHERE ENAME NOT LIKE '_L%'  -- '_L%' 이형식인것 빼고 가져와

sel * FROM EMP
WHERE comm IS NULL -- comm이 null인것

sel * FROM EMP
WHERE comm IS NOT NULL -- comm이 null이 아닌것 

CREATE TABLE DEPT_TEMP2 
AS						-- DEPT 를 복사하여 fept_temp2를 만들어라
SELECT * FROM DEPT

SELECT * FROM DEPT_TEMP2  -- 복사한 fept_temp2를 보여라

UPDATE DEPT_TEMP2 
SET LOC = 'SEOUL'		-- loc를 SEOUL로 바꿔라

UPDATE DEPT_TEMP2 
SET DNAME = 'DATABASE', loc = 'BUSAN'  -- deptno가 40인것을 DNAME을 DATABASE로 바꾸고
WHERE DEPTNO = 40					   --  loc를 BUSAN로 바꿔라

DELETE FROM DEPT_TEMP2 
WHERE DNAME = 'SALES'

SELECT * FROM DEPT_TEMP2 dt 

-- --------------------------------------
-- 정리 문제

CREATE TABLE PRODUCT3(	
	"ID" VARCHAR2(200),
	"NAME" VARCHAR2(200),
	"CONTENT" VARCHAR2(200),
	"PRICE" NUMBER(38,0),
	"COMPANY" VARCHAR2(200),
	"IMG" VARCHAR2(200)
)

SELECT * FROM PRODUCT3 ORDER BY PRICE DESC -- 2

SELECT NAME, CONTENT, PRICE FROM PRODUCT3 ORDER BY COMPANY -- 3

SELECT DISTINCT COMPANY FROM PRODUCT3 -- 4

SELECT PRICE * 5 AS PRICE5 FROM PRODUCT3 -- 5

SELECT NAME, COMPANY FROM PRODUCT3 WHERE PRICE = 5000 -- 6

SELECT NAME, PRICE, COMPANY FROM PRODUCT3 WHERE PRICE BETWEEN 3000 AND 6000 -- 7

SELECT COMPANY, NAME FROM PRODUCT3 WHERE COMPANY != 'c100' -- 8

SELECT NAME, PRICE FROM PRODUCT3 WHERE COMPANY = 'c100' OR COMPANY = 'c200' -- 9

SELECT * FROM PRODUCT3 WHERE NAME LIKE '%4' -- 10

SELECT * FROM PRODUCT3 WHERE CONTENT  LIKE '%food%' -- 11

UPDATE PRODUCT3 SET CONTENT = '품절' WHERE PRICE = '5000' -- 12

UPDATE PRODUCT3 SET img = '0.png', PRICE = '10000' WHERE ID = 100 OR id = 102 -- 13

DELETE FROM PRODUCT3 WHERE COMPANY = 'c100' -- 14
   
DELETE FROM PRODUCT3 --15

SELECT * FROM PRODUCT3
