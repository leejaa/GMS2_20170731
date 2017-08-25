-- *********************

-- 1. major
-- 2. subject
-- 3. member
-- 4. prof
-- 5. student
-- 6. grade
-- 7. board
DROP SEQUENCE student_seq;

-- String id,pw,ssn,name,regdate;
CREATE SEQUENCE seq
START WITH 2000
INCREMENT BY 1
NOCACHE
NOCYCLE;
-- **********************
-- 1. major
-- 2017.8.2
-- article_seq,seq,id,title,
-- content,hitcount,regdate
-- **********************
-- DDL
CREATE 


CREATE TABLE Member(
	id VARCHAR2(10),
	name VARCHAR2(10),
	password VARCHAR2(10),
	ssn VARCHAR2(15),
	regdate DATE,
	PRIMARY KEY(id)
);

--articleSeq,hitcount;
--id,title,content,
--regdate;
 
 CREATE TABLE Board(
	article_seq NUMBER,
	id VARCHAR2(10),
	title VARCHAR2(50),
	content VARCHAR2(1000),
	hitcount NUMBER,
	regdate DATE,
	PRIMARY KEY(article_seq),
	FOREIGN KEY(id) REFERENCES Member(id) ON DELETE CASCADE
);


CREATE TABLE Student(
	member_id VARCHAR2(10) PRIMARY KEY REFERENCES Member(id),
	stu_no NUMBER
);

CREATE TABLE Prof(
	member_id VARCHAR2(10) PRIMARY KEY REFERENCES Member(id),
	salary NUMBER
);

CREATE TABLE member_subject(
	member_id varchar(20),
	subj_id varchar(20)
);
drop table grade_four;

select * from member;

ALTER TABLE Member
ADD CONSTRAINT member_fk_subject
FOREIGN KEY (subj_id)
REFERENCES member(subj_id);

alter table member drop column subj_id;



