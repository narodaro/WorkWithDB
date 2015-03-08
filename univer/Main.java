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
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {

    private static Connection conn = new DBConnection().getDBConnection();

    public static void main(String[] args) throws SQLException {

        StudentDAO student = new StudentDAO();
        StudentDTO st;
        SubjectsDAO subject = new SubjectsDAO();
        SubjectDTO sub;
        StudentsMarkDAO mark = new StudentsMarkDAO();
        StudentsMarksDTO m;

//        student.create(new StudentDTO("Надежда", "Тимошенко"));
//        st = student.read(4);
//        printStudent(st);
//        student.update(new StudentDTO("Вася","Пупкин"),38);
//        student.delete(38);
//        List<StudentDTO> students = student.readall();
//        for (StudentDTO s: students)
//        printStudent(s);

//
//        subject.create(new SubjectDTO("Paleantologie"));
//        subject.create(new SubjectDTO("Archeologie"));
//        subject.create(new SubjectDTO("Zoologie"));
//        sub = subject.read(2);
//        printSubject(sub);
//        subject.delete(10);
//        subject.update(new SubjectDTO("Filologie"), 9);
//        List<SubjectDTO> subjects = subject.readall();
//        for (SubjectDTO subj: subjects)
//        printSubject(subj);

//        mark.create(new StudentsMarksDTO(1, 7, 5));
//        mark.create(new StudentsMarksDTO(2, 6, 5));
//        mark.create(new StudentsMarksDTO(3, 3, 4));
//        mark.create(new StudentsMarksDTO(4, 9, 3));
//        System.out.println(mark.read(1)); // Получить все предметы одного студента вместе с их оценками
//        Map<StudentDTO,Map<SubjectDTO,StudentsMarksDTO>> allmarks = mark.read(1);
//        System.out.println(allmarks);
//        mark.delete(20);
//        mark.update(new StudentsMarksDTO(1, 7, 5));
//        List<StudentsMarksDTO> allMarks = mark.readall();
//        for (StudentsMarksDTO marks: allMarks)
//        printMark(marks);


        student.psClose();
        subject.psClose();
        mark.psClose();

        conn.close();
    }

    private static void printMark(StudentsMarksDTO m) {
        System.out.println("id: " + m.getId() + ", Mark: " + m.getMark());
    }

    private static void printStudent(StudentDTO st) {
        System.out.println("id = " + st.getId() + ", " + "First Name = " + st.getFirstName() + ", " + "Second Name = " + st.getSecondName());
    }

    private static void printSubject(SubjectDTO sub) {
        System.out.println("id = " + sub.getId() + ", " + "Subject name = " + sub.getSubject_name());
    }
}


