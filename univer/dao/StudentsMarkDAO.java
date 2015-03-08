package com.veinik.Lesson7.src.main.resources.univer.dao;

import com.veinik.Lesson7.src.main.resources.univer.DaoObjects;
import com.veinik.Lesson7.src.main.resources.univer.dto.StudentDTO;
import com.veinik.Lesson7.src.main.resources.univer.dto.StudentsMarksDTO;
import com.veinik.Lesson7.src.main.resources.univer.dto.SubjectDTO;
import com.veinik.Lesson7.src.main.resources.univer.interfaces.ObligationStudentsMark;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentsMarkDAO extends DaoObjects implements ObligationStudentsMark {

    private static final String SQL_INSERT = "INSERT INTO STUDENTS_MARKS(ID_STUDENT, ID_SUBJECT, MARK) values(?, ?, ?)";
    private static final String SQL_DELETE = "DELETE FROM STUDENTS_MARKS WHERE ID = ?";
    private static final String SQL_UPDATE = "UPDATE STUDENTS_MARKS SET MARK = ? WHERE ID_SUBJECT = ? AND ID_STUDENT = ?";
    private static final String SQL_READALL = "SELECT * FROM STUDENTS_MARKS";
    private static final String SQL_READ = "SELECT students.second_name, students.first_name, subjects.subject_name, students_marks.mark " +
                                            "FROM students \n" +
                                            "LEFT JOIN students_marks\n" +
                                            "ON students.id = students_marks.id_student\n" +
                                            "LEFT JOIN Subjects\n" +
                                            "ON students_marks.id_subject = subjects.id\n" +
                                            "where students.id = ?";


    @Override
    public StudentsMarksDTO create(StudentsMarksDTO mark) throws SQLException {
        if (psINSERT == null) {
            psINSERT = conn.prepareStatement(SQL_INSERT);
        }
        psINSERT.setInt(1, mark.getIdStudent());
        psINSERT.setInt(2, mark.getIdSubject());
        psINSERT.setInt(3, mark.getMark());
        psINSERT.executeUpdate();
        return mark;
    }

    @Override
    public Map<StudentDTO,Map<SubjectDTO,StudentsMarksDTO>> read(int key) throws SQLException {
        if (psREAD == null) {
            psREAD = conn.prepareStatement(SQL_READ);
        }
        psREAD.setInt(1, key);
        ResultSet res = psREAD.executeQuery();

        Map<StudentDTO,Map<SubjectDTO,StudentsMarksDTO>> allTheMarksOfOneStudent = new HashMap<>();
        Map<SubjectDTO,StudentsMarksDTO> subsMarks = new HashMap<>();
        StudentDTO student = new StudentDTO();

        while (res.next()) {
            StudentsMarksDTO mark = new StudentsMarksDTO();
            mark.setMark(res.getInt("Mark"));

            SubjectDTO subject = new SubjectDTO();
            subject.setSubject_name(res.getString("Subject_Name"));
            subsMarks.put(subject, mark);

            student.setFirstName(res.getString("First_Name"));
            student.setSecondName(res.getString("Second_Name"));
        }
        allTheMarksOfOneStudent.put(student,subsMarks);
        res.close();
        return allTheMarksOfOneStudent;
    }

    @Override
    public void delete(int key) throws SQLException {
        if (psDELETE == null) {
            psDELETE = conn.prepareStatement(SQL_DELETE);
        }
        psDELETE.setInt(1, key);
        psDELETE.executeUpdate();
    }

    @Override
    public void update(StudentsMarksDTO mark) throws SQLException {
        if (psUPDATE == null) {
            psUPDATE = conn.prepareStatement(SQL_UPDATE);
        }
        psUPDATE.setInt(1, mark.getMark());
        psUPDATE.setInt(2, mark.getIdSubject());
        psUPDATE.setInt(3, mark.getIdStudent());
        psUPDATE.executeUpdate();
    }

    @Override
    public List<StudentsMarksDTO> readall() throws SQLException {
        List<StudentsMarksDTO> marks = new ArrayList<>();
        if (psREADALL == null) {
            psREADALL = conn.prepareStatement(SQL_READALL);
        }
        ResultSet res = psREADALL.executeQuery();

        while (res.next()) {
            StudentsMarksDTO mark = new StudentsMarksDTO();
            mark.setId(res.getInt("id"));
            mark.setIdStudent(res.getInt("id_Student"));
            mark.setIdSubject(res.getInt("id_Subject"));
            mark.setMark(res.getByte("mark"));
            marks.add(mark);
        }
        res.close();
        return marks;
    }
}
