CREATE TABLE PRODUCT2(	
	"ID" VARCHAR2(200),
	"NAME" VARCHAR2(200),
	"CONTENT" VARCHAR2(200),
	"PRICE" NUMBER(38,0),
	"COMPANY" VARCHAR2(200),
	"IMG" VARCHAR2(200)
)

-- 1. 데이터 불러오기

-- 2.

SELECT * FROM PRODUCT2
ORDER BY price DESC

-- 3.

SELECT NAME, CONTENT, PRICE, COMPANY 
FROM PRODUCT2 
ORDER BY COMPANY 

-- 4.

SELECT DISTINCT COMPANY 
FROM PRODUCT2

-- 5. 

SELECT price * 5 AS price5 
FROM PRODUCT2

-- 6.

SELECT NAME, COMPANY 
FROM PRODUCT2 
WHERE PRICE = 5000

-- 7.

SELECT PRICE, COMPANY 
FROM PRODUCT2 
WHERE PRICE BETWEEN 3000 AND 6000 

-- 8.

SELECT NAME, COMPANY 
FROM PRODUCT2
WHERE COMPANY != 'c100'

-- 9.

SELECT NAME, PRICE 
FROM PRODUCT2 
WHERE COMPANY = 'c100' OR COMPANY  = 'c200'

-- 10. 조건 검색(문자열 포함)

SELECT * 
FROM PRODUCT2 
WHERE NAME LIKE '%4'

-- 11. 조건 검색(문자열 포함)

SELECT * 
FROM PRODUCT2 
WHERE NAME LIKE '%food%'

-- 12. UPDATE 

UPDATE PRODUCT2 
SET CONTENT = '품절'
WHERE PRICE = 5000

SELECT * FROM PRODUCT2 
WHERE PRICE = 5000

-- 13.

UPDATE PRODUCT2 
SET IMG = '0.png', PRICE = 10000
WHERE id = '100' OR id = '102'

SELECT * FROM PRODUCT2

-- 14. DELETE는 컬럼명을 지정하지 않음.
-- > INSERT, DELETE, UPDATE의 결과는 실행된 ROW 수!(정수)
-- > SELECT릐 결과는 테이블이다.!

DELETE FROM PRODUCT2
WHERE COMPANY = 'c100'

SELECT * 
FROM PRODUCT2 
WHERE COMPANY = 'c100'

-- 15. DELETE
--> VARCHAR2, CHAR 차이
--> VARCHAR2(100): VAR(변하다, VARIABLE) + CHAR(문다)
--> 			2글자이면 2글자 들어갈 만큼만 저장공간을 사용
--> 			100글자이면 100글자들어갈 만큼 저장공간을 저장
--> 			(100)이어도 100을 다 안쓸수있음
--> CHAR(100): 저장공간이 고정, 주민번호, 전화번호, 우편번호, 사번 
--> 			(100)이면 뭐가 들어가든 무조건 저장공간이 100

DELETE FROM PRODUCT2 -- row수 
--> DELETE: 저장공간은 남겨두고, 데이터만 지움.
--> 데이터를 복구/취소(ROLLBACK, 롤백) 가능
--> TRUNCATE로 지우면 저장공간도 남겨두지 않고, 복구/취소 불가능

SELECT * FROM PRODUCT2 -- 저장공간은 남겨두고, 데이터만 지움

-- ---------------------------------------------------------

-- 비파괴형 내장함수

-- CONCAT
SELECT CONCAT(empno, ':') AS concat_result FROM emp 

SELECT concat(concat(empno, ':'), ename) AS concat_result FROM emp

SELECT empno || ':' || ename AS concat_result FROM emp

-- LENGHT
SELECT LENGTH(ename) FROM emp -- 공백까지도 길이수에 측정됨

SELECT LENGTH(trim(ename)) FROM EMP -- 공백 제거

-- TRIM
SELECT TRIM(BOTH 'A' from ename) FROM emp  -- 양쪽 끝에 A를 제거

SELECT TRIM(LEADING 'A' from ename) FROM emp -- 앞쪽에 A를 제거

SELECT TRIM(TRAILING 'A' from ename) FROM emp -- 뒤쪽에 A를 제거

-- REPLACE
SELECT REPLACE(ENAME, ' ', '') FROM EMP -- ENAME 의 ' '(공백)을 ''(공백없음)으로 바꾸기

-- TO_DATE
SELECT TO_DATE('2023-03-02', 'YYYY-MM-DD') AS TODATE1,
	   TO_DATE('20230303', 'YYYY-MM-DD') AS TODATE2
	FROM DUAL;

-- UPDATE (UPDATE는 파괴형 함수)
UPDATE EMP
SET COMM = 0
WHERE COMM IS NULL -- NULL은 IS를 씀, NULL이 아닐때는: IS NOT NULL

SELECT *
FROM EMP

SELECT SAL + COMM AS TOTAL -- SAL + COMM 한값을 나타내는데 그이름은 TOTAL이라고 한다
FROM EMP

-- --------------------------------------------------------------
-- 문자함수, 숫자함수 정리 문제

-- 1. ENAME의 글자수 검색
SELECT LENGTH(ENAME) FROM EMP 

-- 2. JOB이 MANAGER인 사람의 ENAME 글자수 검색
SELECT LENGTH (ENAME) FROM EMP WHERE JOB = 'MANAGER'

-- 3. COMM이 null인 사람의 ENAME, JOB 검색
SELECT ENAME, JOB FROM EMP WHERE COMM IS NULL

-- 4. COMM이 null이 아닌 사람의 HIREDATE 검색
SELECT HIREDATE FROM EMP WHERE COMM IS NOT NULL

-- 5. ENAME의 2번째글자부터끝까지 검색
SELECT SUBSTR(ENAME, 2) FROM EMP

-- 6. JOB의 1번째 글자부터 3번째 글자까지 검색
SELECT SUBSTR(JOB, 1, 3) FROM ENP

-- 7. ENAME의 글자 중 K를 P으로 변경하여 검색
SELECT REPLACE (ENAME, 'K', 'P') FROM ENP

-- 8. ENAME과 ENPNO을 이용하여 ‘7369번은 SMITH입니다'로 출력
SELECT EMPNO || '번은 ' || ENAME || '입니다' FROM EMP

-- 9. HIREDATE 이용하여 입사한 월과 요일을 출력
SELECT HIREDATE,
TO_CHAR(SYSDATE, 'mm') AS mm, TO_CHAR(SYSDATE, 'day') AS DAY
FROM EMP

-- 10. JOB이 MANAGER이면 level1, SALESMAN이면 level2, 기타이면 level3라고
-- 		LEVEL_RESULT컬럼에 출력
SELECT JOB,
CASE JOB
	WHEN 'MANAGER' THEN 'LEVEL1'
	WHEN 'SALESMAN' THEN 'LEVEL2'
	ELSE 'LEVEL3'
END AS LEVEL_RESULT
FROM EMP

-- ---------------------------------------------------------------

SELECT * FROM EMP

-- 전체 개수
SELECT COUNT(*)
FROM EMP

-- SAL 개수
SELECT COUNT(SAL)
FROM EMP

-- SAL 중에서 JOB 가 DALESMAN인 것 개수
SELECT COUNT(SAL)
FROM EMP
WHERE JOB = 'SALESMAN'

-- 집계함수
SELECT COUNT(SAL), SUM(SAL), AVG(SAL), MIN(SAL), MAX(SAL)
FROM EMP
WHERE JOB = 'SALESMAN'

-- GROUP
SELECT JOB, COUNT(SAL), SUM(SAL), ROUND(AVG(SAL)), MIN(SAL), MAX(SAL)
FROM EMP
GROUP BY JOB

-- 오름차순
SELECT JOB, COUNT(SAL), SUM(SAL), ROUND(AVG(SAL)), MIN(SAL), MAX(SAL)
FROM EMP
GROUP BY JOB
ORDER BY JOB -- 이미 모든 검색이 다끝난 후, 그결과를 정렬하고자 하는 경우 이기 때문에 항상 맨끝

-- DESC: 내림차순
SELECT JOB, COUNT(SAL), SUM(SAL), ROUND(AVG(SAL)), MIN(SAL), MAX(SAL)
FROM EMP
GROUP BY JOB
ORDER BY JOB DESC -- 이미 모든 검색이 다끝난 후, 그결과를 정렬하고자 하는 경우 이기 때문에 항상 맨끝

-- HAVING 사용 : 그룹을 지어서 검색 후, 필터링을 하고자 하는 경우
SELECT JOB, COUNT(SAL), SUM(SAL), ROUND(AVG(SAL)), MIN(SAL), MAX(SAL)
FROM EMP
GROUP BY JOB
HAVING COUNT(SAL) >= 4
ORDER BY JOB DESC -- 이미 모든 검색이 다끝난 후, 그결과를 정렬하고자 하는 경우 이기 때문에 항상 맨끝

-- -------------------------------------------------------------------
-- 집계/그룹함수 정리 문제

--1. 전체 직원수 출력
SELECT COUNT(*) FROM EMP 

--2. DEPTNO가 20이거나 MGR이 7700이하인 직원수 출력
SELECT COUNT(*) FROM EMP WHERE DEPTNO = 20 OR MGR <= 7700

--3. DEPTNO가 10 또는 20인 직원의 SAL최저 출력
SELECT MIN(SAL) FROM EMP WHERE DEPTNO = 10 OR DEPTNO = 20

--4. 직원의 SAL 최저, 최고, 합계 출력
SELECT MIN(SAL), MAX(SAL), SUM(SAL)
FROM EMP

--5. DEPTNO별 SAL 평균 출력
SELECT DEPTNO, AVG(SAL)
FROM EMP
GROUP BY DEPTNO

--6. DEPTNO별 SAL 합계를 DEPTNO 오름차순으로출력
SELECT DEPTNO, SUM(SAL)
FROM EMP
GROUP BY DEPTNO
ORDER BY DEPTNO

--7. DEPTNO별 SAL 평균이 2000이상인 SAL평균을 DEPTNO역순으로 출력
SELECT DEPTNO, AVG(SAL)
FROM EMP
GROUP BY DEPTNO
HAVING AVG(SAL) >= 2000
ORDER BY DEPTNO DESC 

--8. JOB이 MANAGER인 직원의 전체 수, 월급의 평균 검색
SELECT COUNT(*), AVG(SAL)
FROM EMP
WHERE JOB = 'MANAGER'

--9. ENAME에 S를 포함하는 직원의 전체 수를 검색
SELECT COUNT(*)
FROM EMP
WHERE ENAME LIKE '%S%'

--10. SAL이 3000이상이고, COMM이 null이 아닌 직원의 전체 수 검색, SAL의 역순으로 출력
SELECT COUNT(*)
FROM EMP
WHERE SAL >= 3000 AND COMM IS NOT NULL 
ORDER BY SAL DESC 

-- ----------------------------------------------------------------
-- join: 왜 하는가? 검색을 하고 싶은데 항목들이 여러개의 테이블에 흩어벼 있는 경우
-- 		테이블을 모아서(합해서) 검색

-- 2개의 테이블의 공통된 값들만 조인해서 검색 (inner join)
SELECT *
FROM "MEMBER" m , BBS b 
WHERE M.ID = B.WRITER

SELECT B.NO, B.TITLE, NAME
FROM "MEMBER" m , BBS b 
WHERE M.ID = B.WRITER

-- INNER JOIN: 테이블감 공통된 값만 추출
-- 			   하나의 이상의 동일한 컬럼이 있어야함.
--			   조인 조건이 공통적인 것만 검색 (교집합)

-- 문제1. emp테이블과 dept테이블을 조인하세요.
-- 		empno, ename, job, deptno, loc 컬럼 검색
-- 		조인조건: deptno
SELECT e.EMPNO , e.ENAME , e.JOB , d.DEPTNO , d.LOC -- 뭘 나타날건지
FROM DEPT d , EMP e 
WHERE d.DEPTNO = e.DEPTNO  -- 같은것 명시해주기

-- OUTER JOIN: 한쪽은 다 보이게 하고 다른 한쪽은 일치하는 것만 (left/right)

-- LEFT OUTER JOIN
SELECT *
FROM "MEMBER" m
LEFT OUTER JOIN BBS b 
ON (M.ID = B.WRITER)

-- RIGHT OUTER JOIN
SELECT *
FROM "MEMBER" m
RIGHT OUTER JOIN BBS b 
ON (M.ID = B.WRITER)

-- LEFT/RIGHT OUTER JOIN
-- 1. EMP테이블의 정보는 다보이게 하고 싶음. DEPT는 맞는 것만 오른쪽에 붙여주고 싶음.
SELECT *
FROM EMP e --애가 왼쪽에 있는애 == EMP가 보여짐
LEFT OUTER JOIN DEPT d 
ON (E.DEPTNO = D.DEPTNO)

-- 2. DEPT테이블의 정보는 다 보이게 하고싶음. EMP는 맞는 것만 오른쪽에 붙여주고 싶음
SELECT *
FROM EMP e 
RIGHT OUTER JOIN DEPT d -- 얘가 오른쪽에 있는 애 == DEPT가 보여짐
ON (E.DEPTNO = D.DEPTNO)

-- ------------------------------------------------------------
-- 조인 확인문제

--1. inner join
--	member table과 bbs table의 inner join하시오.
-- 	(조인 조건 bbs의 writer, member의 id)
SELECT *
FROM "MEMBER" m , BBS b 
WHERE M.ID = B.WRITER 
-- MEMBER의-kiwi와, BBS의-null은 출력되지 않음

--2. left outer join
--	member table과 bbs table의 left outer join하시오.
-- 	(조인 조건 bbs의 writer, member의 id)
SELECT *
FROM "MEMBER" m 
LEFT OUTER JOIN BBS b 
ON(M.ID = B.WRITER)
-- 왼쪽의 member는 다(kiwi까지도) 보이지만 그 멤버들과 일치한 bbs만 보임

SELECT m.ID , m.NAME , b.TITLE , b.CONTENT  -- 보고싶은것만 지정해줄때
FROM "MEMBER" m 
LEFT OUTER JOIN BBS b 
ON(M.ID = B.WRITER)

--3. right outer join
-- 	member table과 bbs table의 right outer join하시오.
-- 	(조인 조건 bbs의 writer, member의 id)
SELECT *
FROM "MEMBER" m
RIGHT OUTER JOIN BBS b 
ON(M.ID = B.WRITER)
-- 오른쪽의 bbs는 다 보이지만 bbs와 일치한 member만 보임

SELECT m.ID , m.NAME , b.TITLE , b.CONTENT  -- 보고싶은것만 지정해줄때
FROM "MEMBER" m 
RIGHT OUTER JOIN BBS b 
ON(M.ID = B.WRITER)

-- ------------------------------------------------------------

CREATE TABLE COMPANY (
	ID VARCHAR2(200) PRIMARY KEY,
	NAME VARCHAR2(200),
	ADDR VARCHAR2(200),
	TEL VARCHAR2(200)
)

INSERT INTO COMPANY VALUES ('c100', 'good', 'seoul', '011')

INSERT INTO COMPANY VALUES ('c200', 'joa', 'busan', '012')

INSERT INTO COMPANY VALUES ('c300', 'maria', 'ulsan', '013')

INSERT INTO COMPANY VALUES ('c400', 'my', 'kwangju', '014')

SELECT * FROM company


-- 팀플 미션

-- inner join
SELECT *
FROM PRODUCT p , COMPANY c 
WHERE p.COMPANY = c.ID 

SELECT p.company, p.img, c.name, c.ADDR 
FROM PRODUCT p , COMPANY c 
WHERE p.COMPANY = c.ID 

-- left outer join 
SELECT *
FROM PRODUCT p 
LEFT OUTER JOIN COMPANY c 
on (p.COMPANY = c.ID) 

SELECT p.company, p.img, c.name, c.ADDR 
FROM PRODUCT p 
LEFT OUTER JOIN COMPANY c 
on (p.COMPANY = c.ID) 

-- right outer join
SELECT *
FROM PRODUCT p 
RIGHT OUTER JOIN COMPANY c 
on (p.COMPANY = c.ID) 

SELECT p.company, p.img, c.name, c.ADDR 
FROM PRODUCT p 
RIGHT OUTER JOIN COMPANY c 
on (p.COMPANY = c.ID) 
