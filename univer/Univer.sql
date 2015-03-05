CREATE database `UNIVER` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
use univer;

CREATE TABLE STUDENTS (
 `id` INT(10) NOT NULL AUTO_INCREMENT,
 `First_name` VARCHAR(64) NOT NULL,
 `Second_name` VARCHAR(64) NOT NULL,
 PRIMARY KEY (ID)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

insert into students(First_name, Second_name) values
 ('�����', '���������'),
 ('��������', '�������'),
 ('������', '��������'),
 ('�������', '�������'),
 ('����', '������'),
 ('�������', '���������');
CREATE TABLE Subjects (
  `id` INT NOT NULL auto_increment,
  `Subjectname` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

insert into Subjects(Subjectname) values
 ('Mathematics'),
 ('Physics'),
 ('DBMS'),
 ('History'),
 ('Philosophy'),
 ('Logic'),
 ('Psychology'),
 ('Programming');
    
CREATE TABLE Students_marks (
 `id` INT NOT NULL auto_increment,
 `id_student` int(10),
 `id_subject` int(10),
 `Mark` tinyint(1) unsigned,
 PRIMARY KEY (`id`),
 FOREIGN KEY (id_student) REFERENCES Students(id)
 ON DELETE cascade ON UPDATE cascade,
    FOREIGN KEY (id_subject) REFERENCES Subjects(id)
    ON DELETE cascade ON UPDATE cascade
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

insert into Students_marks (id_student, id_subject, Mark) values
 (1, 1, 3),
 (2, 2, 4),
 (3, 2, 5),
 (4, 3, 3),
 (5, 5, 4),
 (6, 6, 3),
 (1, 4, 4),
 (1, 6, 4),
 (2, 7, 3),
 (4, 8, 5);
 
 
#�������� ��������
UPDATE STUDENTS SET FIRST_NAME = '�����', SECOND_NAME = '�������������' WHERE ID = 7;
#�������� �������
UPDATE SUBJECTS SET SUBJECTNAME = 'Anatomy' WHERE ID = 3;
#�������� ������
UPDATE STUDENTS_MARKS SET MARK = 4 WHERE ID = 7;
#�������� ��������
INSERT INTO STUDENTS(FIRST_NAME,SECOND_NAME) values('�������', '���������');
#�������� �������
INSERT INTO SUBJECTS(SUBJECT_NAME) values('DBMS');
#�������� ������
INSERT INTO STUDENTS_MARKS(ID_STUDENT, ID_SUBJECT, MARK) values(2, 4, 4)
#������� ��������
DELETE FROM STUDENTS WHERE ID = 5;
#������� �������
DELETE FROM SUBJECTS WHERE ID = 3'
#������� ������
"DELETE FROM STUDENTS_MARKS WHERE ID = 20"
 
��������� ���� ���������
select * from students;

#�������� ��� �������� ������ �������� ������ � �� ��������
SELECT students.second_name, students.first_name, subjects.subject_name, students_marks.mark FROM students 
LEFT JOIN students_marks
ON students.id = students_marks.id_student
LEFT JOIN Subjects
ON students_marks.id_subject = subjects.id
where students.Second_name = "���������"
	
#�������� ��� ��������
select * from Subjects;

"��� ������ ���� ������������� � ��������.
"������ � ����� Java ������������ � sql ��� �������� � ���������� ������ ��������� �������.
