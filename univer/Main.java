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
import java.util.*;

public class Main {

    private static Connection conn = new DBConnection().getDBConnection();

    public static void main(String[] args) throws SQLException {

        StudentDAO student = new StudentDAO();
        StudentDTO st;
        SubjectsDAO subject = new SubjectsDAO();
        SubjectDTO sub;
        StudentsMarkDAO mark = new StudentsMarkDAO();
        StudentsMarksDTO m;

        // Work with Students
        student.create(new StudentDTO("Надежда", "Тимошенко"));
        st = student.read(4);
        printStudent(st);
        student.update(new StudentDTO("Вася","Пупкин"),38);
        student.delete(38);
        List<StudentDTO> students = student.readall();
        for (StudentDTO s: students)
        printStudent(s);

        // Work with Subjects
        subject.create(new SubjectDTO("Zoologie"));
        sub = subject.read(2);
        printSubject(sub);
        subject.delete(10);
        subject.update(new SubjectDTO("Filologie"), 9);
        List<SubjectDTO> subjects = subject.readall();
        for (SubjectDTO subj: subjects)
        printSubject(subj);

        // Work with Marks
        mark.create(new StudentsMarksDTO(1, 7, 5));
        Map<StudentDTO,Map<SubjectDTO,StudentsMarksDTO>> allmarks = mark.read(1);
        printMarksOneStudent(allmarks);
        mark.delete(20);
        mark.update(new StudentsMarksDTO(1, 7, 5));
        List<StudentsMarksDTO> allMarks = mark.readall();
        for (StudentsMarksDTO marks: allMarks)
        printMark(marks);

        student.psClose();
        subject.psClose();
        mark.psClose();

        conn.close();
    }

    private static void printMarksOneStudent(Map<StudentDTO, Map<SubjectDTO, StudentsMarksDTO>> allmarks) {
        for (Map.Entry<StudentDTO,Map<SubjectDTO,StudentsMarksDTO>> allst : allmarks.entrySet()) {
            StudentDTO students = allst.getKey();
            System.out.println(students.getFirstName() + " " + students.getSecondName());

            Map<SubjectDTO,StudentsMarksDTO> subsMarks = allst.getValue();
            for (Map.Entry<SubjectDTO,StudentsMarksDTO> all : subsMarks.entrySet()) {
                SubjectDTO subj = all.getKey();
                StudentsMarksDTO marks = all.getValue();
                System.out.println(subj.getSubject_name() + " " + marks.getMark());
            }
        }
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


