CREATE TABLE subject1 (
	강좌이름 VARCHAR2(200) PRIMARY KEY,
	강의실 VARCHAR2(200)
)

CREATE TABLE department (
	학과 VARCHAR2(200) PRIMARY KEY,
	학과사무실 VARCHAR2(200)
)

CREATE TABLE student_information (
	학생번호 VARCHAR2(200) PRIMARY KEY,
	학생이름 VARCHAR2(200),
	주소 VARCHAR2(200),
	학과 VARCHAR2(200)
)

CREATE TABLE record (
	학생번호 NUMBER(38,0),
	강좌이름 VARCHAR2(200),
	성적 NUMBER(38,0)
)


INSERT INTO subject1
VALUES ('자바','공학관100')

SELECT * FROM subject1

UPDATE subject1
SET 강의실 = '공학관112'
WHERE 강좌이름 = '자바'

DELETE FROM subject1
WHERE 강좌이름 = '자바'


-- inner join
SELECT *
FROM SUBJECT1 s , "RECORD" r 
WHERE s.강좌이름 = r.강좌이름 

-- 이렇게 할 수도 있음
SELECT r.학생번호, si.학생이름, s.강좌이름  
FROM "RECORD" r 
INNER JOIN STUDENT_INFORMATION si ON si.학생번호 = r.학생번호 
INNER JOIN SUBJECT1 s ON s.강좌이름 = r.강좌이름 

-- 위와 똑같은 내용을 이렇게 할 수도 있음
SELECT r.학생번호, si.학생이름, s.강좌이름  
FROM "RECORD" r, STUDENT_INFORMATION si, SUBJECT1 s 
WHERE r.학생번호 = si.학생번호 AND r.강좌이름 = s.강좌이름

-- left outer JOIN 
SELECT r.학생번호, r.성적, si.학생이름, si.학과  
FROM "RECORD" r 
LEFT OUTER JOIN STUDENT_INFORMATION si 
on (r.학생번호 = si.학생번호) 

-- right outer JOIN 
SELECT d.학과, si.학생번호, si.학생이름
FROM STUDENT_INFORMATION si 
RIGHT OUTER JOIN DEPARTMENT d 
ON (si.학과 = d.학과)

-- ---------------------------------------------

-- subquery
SELECT * FROM MEMBER
WHERE id IN ('apple', 'ice') 

SELECT * FROM MEMBER
WHERE id IN (SELECT writer FROM BBS) --apple

-- subquery (검색 결과 한개 => =)
SELECT * FROM STUDENT_INFORMATION
WHERE 학생번호 IN ('401', '402')

-- subquery (검색 결과 여러개 => in)
SELECT * FROM STUDENT_INFORMATION
WHERE 학생번호 IN (SELECT 학생번호 FROM RECORD)


-- --------------------------------------------------
CREATE TABLE 회원정보 (
	아이디 VARCHAR2(200) PRIMARY KEY,
	비밀번호 VARCHAR2(200),
	이름 VARCHAR2(200)
)
 
CREATE TABLE 웹툰정보(
	웹툰제목 VARCHAR2(200) PRIMARY KEY,
	요일 VARCHAR2(200),
	장르 VARCHAR2(200)
)

CREATE TABLE 찜한작품 (
	아이디 VARCHAR2(200),
	이름 VARCHAR2(200),
	웹툰제목 VARCHAR2(200)
)

ALTER TABLE HR.찜한작품 ADD CONSTRAINT FK_웹툰정보 FOREIGN KEY (웹툰제목) REFERENCES HR.웹툰정보(웹툰제목)

ALTER TABLE HR.찜한작품 ADD CONSTRAINT FK_회원정보 FOREIGN KEY (아이디) REFERENCES HR.회원정보(아이디)

-- inner join 이용해서 아이디, 이름, 웹툰제목, 장르 출력
SELECT h.아이디, m.이름,  h.웹툰제목, w.장르  
FROM "찜한작품" h 
INNER JOIN "웹툰정보" w ON h.웹툰제목  = w.웹툰제목 
INNER JOIN "회원정보" m  ON h.아이디  = m.아이디

-- inner join 이용해서 아이디, 이름, 웹툰제목, 장르 출력 (위와 동일한 것을 다른식으로 표현)
SELECT h.아이디, m.이름,  h.웹툰제목, w.장르 
FROM "찜한작품" h, "회원정보" m, "웹툰정보" w
WHERE h.아이디 = m.아이디 AND h.웹툰제목 = w.웹툰제목

-- 이중 요일이 월 인것만 출력
SELECT h.아이디, m.이름,  h.웹툰제목, w.장르 
FROM "찜한작품" h, "회원정보" m, "웹툰정보" w
WHERE h.아이디 = m.아이디 AND h.웹툰제목 = w.웹툰제목
AND w.요일 = '월'

-- -------------------------------------------------------------------

INSERT INTO "MEMBER" 
VALUES ('com', 'com', 'com', 'com')

update member set tel = '999'
where id = 'com'

delete from MEMBER22 m 
WHERE id = 'com'

