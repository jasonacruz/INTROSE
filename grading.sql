DROP DATABASE IF EXISTS try1;
CREATE DATABASE IF NOT EXISTS try1;
USE try1;

CREATE TABLE Department (
	dept_name varchar(30) NOT NULL,
	PRIMARY KEY (dept_name)
	);

CREATE TABLE EmpPosition(
	pos_name varchar(30) NOT NULL,
	PRIMARY KEY (pos_name)
	);

CREATE TABLE yearQuarter(
	schoolquarter int(1) NOT NULL,
	schoolYear year(4) NOT NULL,
	PRIMARY KEY (schoolquarter),
	UNIQUE KEY(schoolYear, SchoolQuarter)
	);

CREATE TABLE Course(
	course_name varchar(20) NOT NULL,
	course_description varchar(100),
	PRIMARY KEY (course_name)
	);

CREATE TABLE Section (
	sect_name varchar(20) NOT NULL,
	sect_yrlvl int(2) NOT NULL,
	PRIMARY KEY (sect_name, sect_yrlvl),
	UNIQUE KEY (sect_name)
	);

CREATE TABLE Employee (
	emp_id int(20) NOT NULL,
	emp_user varchar(40) NOT NULL,
	emp_lastname varchar(20) NOT NULL,
	emp_midname varchar(20) NOT NULL,
	emp_firstname varchar(40) NOT NULL,
	emp_pos varchar(30),
	emp_pass varchar(20),
	emp_phone varchar(13),
	emp_address varchar(100),
	emp_changedpass boolean NOT NULL,
	FOREIGN KEY (emp_pos) REFERENCES EmpPosition(pos_name),
	PRIMARY KEY (emp_id),
	UNIQUE KEY (emp_user),
	CONSTRAINT emp_fullname UNIQUE KEY (emp_firstname, emp_midname, emp_lastname)
	);

CREATE TABLE Student (
	st_id int(20) NOT NULL,
	st_lastname varchar(20) NOT NULL,
	st_midname varchar(20) NOT NULL,
	st_firstname varchar(40) NOT NULL,
	st_gender varchar(1) NOT NULL,
	st_gradelevel int(2),
	st_age int(2) NOT NULL,
	st_phone varchar(13),
	st_address varchar(100),
	st_enrolled boolean NOT NULL,
	PRIMARY KEY (st_id),
	CONSTRAINT st_fullname UNIQUE KEY (st_firstname, st_midname, st_lastname)
	);

CREATE TABLE ClassAdviser(
	class_name varchar(20) NOT NULL,
	class_schlyear year(4) NOT NULL,
	class_prof int(20) NOT NULL,
	FOREIGN KEY (class_name) REFERENCES Section(sect_name),
	FOREIGN KEY (class_prof) REFERENCES Employee(emp_id),
	PRIMARY KEY (class_name, class_schlyear),
	UNIQUE KEY (class_schlyear, class_name, class_prof),
	UNIQUE KEY (class_schlyear, class_prof),
	UNIQUE KEY(class_name, class_schlyear)
	);
CREATE TABLE ClassStudent ( 
	class_name varchar(20) NOT NULL,
	class_schlyear year(4) NOT NULL,
	class_student int(20) NOT NULL, 
	FOREIGN KEY (class_name) REFERENCES ClassAdviser(class_name),
	FOREIGN KEY (class_schlyear) REFERENCES ClassAdviser(class_schlyear),
	FOREIGN KEY (class_student) REFERENCES Student(st_id),
	UNIQUE KEY (class_schlyear, class_student),
	UNIQUE KEY (class_name, class_schlyear,  class_student)
	);
#make class
 
CREATE TABLE ClassTeacher(
	course_name varchar(20) NOT NULL,
	class_name varchar(20) NOT NULL,
	class_schlyear year(4) NOT NULL,
	class_prof int(20) NOT NULL,
	FOREIGN KEY (class_name) REFERENCES Section(sect_name),
	FOREIGN KEY (course_name) REFERENCES Course(course_name),
	FOREIGN KEY (class_prof) REFERENCES Employee(emp_id),
	UNIQUE KEY(class_schlyear, course_name, class_name),
	UNIQUE KEY(class_schlyear, course_name, class_name, class_prof)
	);


CREATE TABLE GradeComp(
	course_name varchar(20) NOT NULL,
	grade_type varchar(20) NOT NULL,
	grade_number int(2) NOT NULL,
	student_id int(20) NOT NULL,
	student_grade int(3) NOT NULL,
	class_prof int(20) NOT NULL,
	schoolquarter int(1) NOT NULL,
	schoolYear year(4) NOT NULL,
	FOREIGN KEY (schoolYear) REFERENCES classteacher(class_schlyear),
	FOREIGN KEY (course_name) REFERENCES classteacher(course_name),
	FOREIGN KEY (student_id) REFERENCES classStudent(class_student),
	FOREIGN KEY (class_prof) REFERENCES classteacher(class_prof),
	UNIQUE KEY (course_name, grade_type, grade_number, student_id,class_prof, schoolquarter, schoolyear)
	);

CREATE TABLE finalGrade(
	course_name varchar(20) NOT NULL,
	student_id int(20) NOT NULL,
	student_grade int(3) NOT NULL,
	class_prof int(20) NOT NULL,
	grade_final boolean NOT NULL,
	schoolquarter int(1) NOT NULL,
	schoolYear year(4) NOT NULL,
	FOREIGN KEY (schoolYear) REFERENCES classteacher(class_schlyear),
	FOREIGN KEY (course_name) REFERENCES classteacher(course_name),
	FOREIGN KEY (student_id) REFERENCES classStudent(class_student),
	FOREIGN KEY (class_prof) REFERENCES classteacher(class_prof),
	FOREIGN KEY (class_prof) REFERENCES Employee(emp_id)
	);

	
CREATE TABLE DepartmentEmp (
	dept_name varchar(30) NOT NULL,
	dept_empID int(20) NOT NULL,
	dept_hiredate date NOT NULL,
	dept_hiredto date NOT NULL,
	FOREIGN KEY (dept_name) REFERENCES Department (dept_name),
	FOREIGN KEY (dept_empID) REFERENCES Employee(emp_id),
	UNIQUE KEY (dept_name, dept_empID, dept_hiredate, dept_hiredto)
	);

INSERT INTO EmpPosition(pos_name) VALUES ('Principal');
INSERT INTO EmpPosition(pos_name) VALUES ('Coordinator');
INSERT INTO EmpPosition(pos_name) VALUES ('Subject Teacher');
INSERT INTO EmpPosition(pos_name) VALUES ('Administrator');

INSERT INTO EMPLOYEE(emp_id,emp_firstname, emp_midname, emp_lastname, emp_pos, emp_pass, emp_user, emp_changedpass) VALUES(1,'Admin','Admin','Admin','Administrator', 'admin1234', 'admin', TRUE);

INSERT INTO Department(dept_name) VALUES ('High School');
INSERT INTO Department(dept_name) VALUES('Elementary'); 
INSERT INTO Department(dept_name) VALUES('School');
