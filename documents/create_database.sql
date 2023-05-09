




insert into auth values('2020CSB1060','iitropar','student');
insert into auth values('2020CSB1061','iitropar','student');
insert into auth values('2020CSB1062','iitropar','student');
insert into auth values('2020EEB1263','iitropar','student');
insert into auth values('2020EEB1264','iitropar','student');
insert into auth values('2020EEB1265','iitropar','student');
insert into auth values('2020MEB1463','iitropar','student');
insert into auth values('2020MEB1464','iitropar','student');
insert into auth values('2020MEB1465','iitropar','student');
insert into auth values('2008CSI1060','iitropar','faculty');
insert into auth values('2016CSI1112','iitropar','faculty');
insert into auth values('2020EEI1062','iitropar','faculty');
insert into auth values('2017EEI1263','iitropar','faculty');
insert into auth values('2020ADM1113','iitropar','admin');
insert into auth values('2016ADM1112','iitropar','admin');


insert into course_cat values('PROGRAMMING PARADIGMS AND PRAGMATICS','CS202',3,1,2,4,'CSE','PC');
insert into course_cat values('COMPUTER ARCHITECTURE','CS204',3,1,2,4,'CSE','PC');
insert into course_cat values('DATABASES','CS301',3,1,2,4,'CSE','PC');
insert into course_cat values('ANALYSIS AND DESIGN OF ALGORITHMS','CS302',3,1,0,3,'CSE','PC');
insert into course_cat values('OPERATING SYSTEMS','CS303',3,1,2,4,'CSE','PC');
insert into course_cat values('Digital images','CS517',3,1,2,3,'CSE','PE');
insert into course_cat values('Computer vision','CS535',3,1,2,3,'CSE','PE');
insert into course_cat values('Machine learning','CS546',3,1,2,3,'CSE','PE');
insert into course_cat values('Fantasy','HS491',3,1,2,3,'CSE','E');
insert into course_cat values('professional ethics','HS507',3,1,2,3,'CSE','E');
insert into course_cat values('Capstone ','CP301-1',0,0,0,3,'','PC');
insert into course_cat values('Capstone ','CP301-2',0,0,0,3,'','PC');
insert into course_cat values('Capstone ','CP301-3',0,0,0,3,'','PC');

insert into course_offer values(2001,'CS202',2022,2,'2008CSI1060',2,'CSE','PC');
insert into course_offer values(2002,'CS204',2022,2,'2008CSI1060',5,'CSE','PC');
insert into course_offer values(2003,'CS301',2023,1,'2008CSI1060',7,'CSE','PC');
insert into course_offer values(2004,'CS302',2023,2,'2008CSI1060',5,'CSE','PC');
insert into course_offer values(2005,'CS303',2023,2,'2016CSI1112',8,'CSE','PC');
insert into course_offer values(2006,'CS517',2022,1,'2016CSI1112',4,'CSE','PE');
insert into course_offer values(2007,'CS535',2022,1,'2016CSI1112',4,'CSE','PE');
insert into course_offer values(2008,'CS546',2020,1,'2016CSI1112',0,'CSE','PE');
insert into course_offer values(2009,'HS507',2023,2,'2016CSI1112',0,'CSE','E');
insert into course_offer values(2014,'CP301-1',2022,2,'2016CSI1112',5,'','PC');
insert into course_offer values(2015,'CP301-2',2023,1,'2008CSI1060',5,'','PC');
insert into course_offer values(2016,'CP301-3',2023,2,'2016CSI1112',5,'','PC');
insert into course_offer values(2017,'CS546',2023,2,'2016CSI1112',0,'CSE','PE');
insert into course_offer values(2005,'CS535',2023,2,'2008CSI1060',0,'CSE','PE');

 


insert into pre_req values('CS202','{"CS201"}');
insert into pre_req values('CS204','{"GE103","GE104"}');
insert into pre_req values('CS301','{}');
insert into pre_req values('CS203','{}');
insert into pre_req values('CS302','{}');
insert into pre_req values('CS303','{"CS201"}');
insert into pre_req values('CS517','{}');
insert into pre_req values('CS535','{}');
insert into pre_req values('CS546','{}');

insert into student values('Aakash','2020CSB1060',120,'CSE');
insert into student values('Abhay','2020CSB1061',120,'CSE');
insert into student values('Abhijeet','2020CSB1062',120,'CSE');


 insert into student_transcript values(2001,'2020CSB1060','CS202',2020,2,'NA',0,'running','PC');
insert into student_transcript values(2002,'2020CSB1060','CS204',2020,2,'NA',0,'running','PC');
insert into student_transcript values(2003,'2020CSB1060','CS301',2023,1,'NA',0,'running','PC');
insert into student_transcript values(2004,'2020CSB1060','CS302',2023,2,'NA',0,'running','PC');
insert into student_transcript values(2005,'2020CSB1060','CS303',2023,2,'NA',0,'running','PC');
insert into student_transcript values(2006,'2020CSB1060','CS517',2022,1,'NA',0,'running','PE');
insert into student_transcript values(2007,'2020CSB1060','CS535',2022,1,'NA',0,'running','PE');
insert into student_transcript values(2007,'2020CSB1062','CS535',2022,1,'NA',0,'running','PE');
insert into student_transcript values(2002,'2020CSB1062','CS204',2022,2,'NA',0,'running','PC');
insert into student_transcript values(2003,'2020CSB1062','CS301',2023,1,'NA',0,'running','PC');
insert into student_transcript values(2001,'2020CSB1061','CS202',2020,2,'NA',0,'running','PC');
insert into student_transcript values(2002,'2020CSB1061','CS204',2020,2,'NA',0,'running','PC');
insert into student_transcript values(2003,'2020CSB1061','CS301',2023,1,'NA',0,'running','PC');
insert into student_transcript values(2004,'2020CSB1061','CS302',2023,2,'NA',0,'running','PC');
insert into student_transcript values(2005,'2020CSB1061','CS303',2023,2,'NA',0,'running','PC');
insert into student_transcript values(2006,'2020CSB1061','CS517',2022,1,'NA',0,'running','PE');
insert into student_transcript values(2007,'2020CSB1061','CS535',2022,1,'NA',0,'running','PE');
insert into student_transcript values(2017,'2020CSB1063','CS546',2023,2,'NA',0,'running','PE');


insert into semester values(2020,1,'f');
insert into semester values(2020,2,'f');
insert into semester values(2021,1,'f');
insert into semester values(2021,2,'f');
insert into semester values(2022,1,'f');
insert into semester values(2022,2,'f');
insert into semester values(2023,1,'f');
insert into semester values(2023,2,'t');


create table course_cat(name varchar(50) not null,course_id varchar(30) not null,l int not null,t int not null,p int not null ,c int not null ,dept varchar(10),type varchar(10),primary key(course_id));
create table dept(name varchar(15),hod varchar(40) not NULL,primary key(name));
create table instructor(name varchar(40) not null,instr_id varchar(15) primary key,dept varchar(15),foreign key(dept) references dept(name));
 create table course_offer(offr_id serial primary key,course_id varchar(20) not null, year integer not null,semester integer not null,instr_id varchar(30) not null, cgpa_req double precision,dept varchar(10),type varchar(10),foreign key(course_id) references course_cat(course_id), foreign key(instr_id) references instructor(instr_id));
 CREATE TABLE student_transcript(offr_id int not null,stu_id varchar(20),course_id varchar(15) not null,year int not null,sem integer not null,grade int,credits double precision,status varchar(15),type varchar(5),PRIMARY KEY (offr_id,stu_id));
 create table auth(user_name varchar(50) primary key,pswd varchar(50) not null,role varchar(20) not null);
 create table student(name varchar(30),entry_no varchar(15) primary key,grad_cred int,dept varchar(10));
 create table semester(year int not null,sem int not null,status boolean,primary key(year,sem));
 create table pre_req (course_id varchar(10) primary key,pre_req text[]);

insert into dept values('CSE','S. Iyengar');
insert into dept values('EE','S.Murala');


 insert into instructor values('Puneet Goyal','2020CSI1060','CSE');
 insert into instructor values('Balwinder Sodhi','2008CSI1060','CSE');
 insert into instructor values('Neeraj Goel','2016CSI1112','CSE');
 insert into instructor values('Anil SHukla','2012CSI1134','CSE');
 insert into instructor values('Sujata Pal','2018CSI1260','CSE');
 insert into instructor values('Shirshendu Das','2019CSI1012','CSE');";
