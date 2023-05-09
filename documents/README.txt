In this project, I have designed the aims portal using java and PostgreSQL and done jUnit testing on the unit and generated a jacoco report.

My portal has three users student, faculty, and admin.


Functionality of student.
A student can do the following things:
1)Can see his courses and grades.
2)Can register for a course only when he meets the eligibility criteria for the  course(pre requisites and CGPA) and does not exceed the limit. 
3) A student can deregister for courses that is not completed yet.

Functionality of faculty
1)A teacher can see the courses he has taken in past or taking right now and the 
grades of students in it.
2) Can offer a course or revoke the offered course.
3)Can see the grades of all courses or grade of a particular student.
4) Can upload grades in his offered courses.


Functionality of Admin
1)Admin sets the current year and semester.
2) Can update course catalogue (add or delete courses to catalogue).
3)Can see the grade of all coursses or for a particular student.
4)Can generates the transcript for a student .

The Database tables i have used are:
1. auth-This is used for authorization check.
2. course_cat-This  stores course catalogue.
3. course_offer- This shows list of offered courses.
4. dept-This table displays department names and their hod's.
5. instructor- This table contains instructor details.
6.pre_req-This table displays the pre reqisites of a course.
7. semester- This table displays the current and previous semesters data.
8. student-This contains student details.
9.student_transcript-This the master table containg the courses and grades of all the students.



How to run!!!!
1.Establish java and dbc environment on your PC.
2.populate database using create_database.sql file.
2.Run firstly main.java which will be the starting point of our portal.
3.Write unit cases for junit testing.
4.Genearte the jacoco report by follwoing steps:
1. ./gradlew tasks
2. ./gradlew clean build
3. ./gradlew JacocoTestReport

I have created test cases for each class ,the test coverage using intellij is 94% and using Jacoco is 84%.I have attached Jacoco report for your reference.

















