package com.veinik.Lesson7.src.main.resources.univer;


import com.veinik.Lesson7.src.main.resources.univer.dao.StudentDAO;
import com.veinik.Lesson7.src.main.resources.univer.dao.StudentsMarkDAO;
import com.veinik.Lesson7.src.main.resources.univer.dao.SubjectsDAO;
import com.veinik.Lesson7.src.main.resources.univer.dbConnection.DBConnection;
import com.veinik.Lesson7.src.main.resources.univer.dto.StudentDTO;
import com.veinik.Lesson7.src.main.resources.univer.dto.StudentsMarksDTO;
import com.veinik.Lesson7.src.main.resources.univer.dto.SubjectDTO;
import com.veinik.Lesson7.src.main.resources.univer.myExceptions.DAOExceptions;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

public class Main {

    private static Connection conn = new DBConnection().getDBConnection();

    public static void main(String[] args) throws DAOExceptions {

        StudentDAO student = new StudentDAO();
        StudentDTO st;
        SubjectsDAO subject = new SubjectsDAO();
        SubjectDTO sub;
        StudentsMarkDAO mark = new StudentsMarkDAO();

//        Work with Students
        student.create(new StudentDTO("Надежда", "Тимошенко"));
        st = student.read(42);
        printStudent(st);
        student.update(new StudentDTO("Вася","Пупкин"),41);
        student.delete(43);
        List<StudentDTO> students = student.readall();
        for (StudentDTO s: students)
        printStudent(s);

//        Work with Subjects
        subject.create(new SubjectDTO("Filologie"));
        sub = subject.read(2);
        printSubject(sub);
        subject.delete(13);
        subject.update(new SubjectDTO("Psihology"), 9);
        List<SubjectDTO> subjects = subject.readall();
        for (SubjectDTO subj: subjects)
        printSubject(subj);

        // Work with Marks
        mark.create(new StudentsMarksDTO(2, 2, 5));
        Map<StudentDTO,Map<SubjectDTO,StudentsMarksDTO>> allmarks = mark.read(3);
        printMarksOneStudent(allmarks);
        mark.delete(25);
        mark.update(new StudentsMarksDTO(2, 2, 4));
        List<StudentsMarksDTO> allMarks = mark.readall();
        for (StudentsMarksDTO marks: allMarks)
        printMark(marks);

        student.psClose();
        subject.psClose();
        mark.psClose();

        try {
            conn.close();
        } catch (SQLException e) {
            throw new DAOExceptions("Dao error", e);
        }
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


