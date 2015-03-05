package com.veinik.Lesson7.src.main.resources.univer;


import com.veinik.Lesson7.src.main.resources.univer.dao.StudentDAO;
import com.veinik.Lesson7.src.main.resources.univer.dao.StudentsMarkDAO;
import com.veinik.Lesson7.src.main.resources.univer.dao.SubjectsDAO;
import com.veinik.Lesson7.src.main.resources.univer.dbConnection.DBConnection;
import com.veinik.Lesson7.src.main.resources.univer.dto.StudentDTO;
import com.veinik.Lesson7.src.main.resources.univer.dto.StudentsMarksDTO;
import com.veinik.Lesson7.src.main.resources.univer.dto.SubjectDTO;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {

    private static Connection conn = new DBConnection().getDBConnection();

    public static void main(String[] args) throws SQLException {

        StudentDAO student = new StudentDAO();

//        student.create(new StudentDTO("Надежда", "Тимошенко"));
//        student.create(new StudentDTO("Дитрий", "Хоротьян"));
//        student.create(new StudentDTO("Дмитрий", "Нагиев"));
//        System.out.println(student.read(1));
//        student.update(new StudentDTO("Вася","Пупкин"),38);
//        student.delete(38);
//        System.out.println(student.readall());

        SubjectsDAO subject = new SubjectsDAO();
//        subject.create(new SubjectDTO("Paleantologie"));
//        subject.create(new SubjectDTO("Archeologie"));
//        subject.create(new SubjectDTO("Zoologie"));
//        System.out.println(subject.read(7));
//        subject.delete(10);
//        subject.update(new SubjectDTO("Filologie"), 9);
//        System.out.println(subject.readall());

        StudentsMarkDAO mark = new StudentsMarkDAO();
//        mark.create(new StudentsMarksDTO(1, 7, 5));
//        mark.create(new StudentsMarksDTO(2, 6, 5));
//        mark.create(new StudentsMarksDTO(3, 3, 4));
//        mark.create(new StudentsMarksDTO(4, 9, 3));
        System.out.println(mark.read(1)); // Получить все предметы одного студента вместе с их оценками
//        mark.read(1); // Получить все предметы одного студента вместе с их оценками
//        mark.delete(20);
//        mark.update(new StudentsMarksDTO(1, 7, 5));
//        System.out.println(mark.readall());

        student.psStudentClose();
        subject.psSubjectClose();
        mark.psMarkClose();

        conn.close();
    }
}


