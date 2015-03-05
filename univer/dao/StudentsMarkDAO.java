package com.veinik.Lesson7.src.main.resources.univer.dao;

import com.veinik.Lesson7.src.main.resources.univer.dbConnection.DBConnection;
import com.veinik.Lesson7.src.main.resources.univer.dto.StudentDTO;
import com.veinik.Lesson7.src.main.resources.univer.dto.StudentsMarksDTO;
import com.veinik.Lesson7.src.main.resources.univer.dto.SubjectDTO;
import com.veinik.Lesson7.src.main.resources.univer.interfaces.ObligationStudentsMark;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentsMarkDAO implements ObligationStudentsMark {

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

    private static Connection conn = new DBConnection().getDBConnection();

    private static PreparedStatement psMarkINSERT;
    private static PreparedStatement psMarkDELETE;
    private static PreparedStatement psMarkUPDATE;
    private static PreparedStatement psMarkREAD;
    private static PreparedStatement psMarkREADALL;

    @Override
    public StudentsMarksDTO create(StudentsMarksDTO mark) throws SQLException {
        if (psMarkINSERT == null) {
            psMarkINSERT = conn.prepareStatement(SQL_INSERT);
        }
        psMarkINSERT.setInt(1, mark.getIdStudent());
        psMarkINSERT.setInt(2, mark.getIdSubject());
        psMarkINSERT.setInt(3, mark.getMark());
        psMarkINSERT.executeUpdate();

        return mark;
    }

    @Override
    public Map<StudentDTO,Map<SubjectDTO,StudentsMarksDTO>> read(int key) throws SQLException {

        if (psMarkREAD == null) {
            psMarkREAD = conn.prepareStatement(SQL_READ);
        }
        psMarkREAD.setInt(1, key);
        ResultSet res = psMarkREAD.executeQuery();

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
        if (psMarkDELETE == null) {
            psMarkDELETE = conn.prepareStatement(SQL_DELETE);
        }
        psMarkDELETE.setInt(1, key);
        psMarkDELETE.executeUpdate();
    }

    @Override
    public void update(StudentsMarksDTO mark) throws SQLException {
        if (psMarkUPDATE == null) {
            psMarkUPDATE = conn.prepareStatement(SQL_UPDATE);
        }
        psMarkUPDATE.setInt(1, mark.getMark());
        psMarkUPDATE.setInt(2, mark.getIdSubject());
        psMarkUPDATE.setInt(3, mark.getIdStudent());
        psMarkUPDATE.executeUpdate();
    }

    @Override
    public List<StudentsMarksDTO> readall() throws SQLException {
        List<StudentsMarksDTO> marks = new ArrayList<>();

        if (psMarkREADALL == null) {
            psMarkREADALL = conn.prepareStatement(SQL_READALL);
        }
        ResultSet res = psMarkREADALL.executeQuery();

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

    public void psMarkClose() throws SQLException {
        closePSifNotNULL(psMarkINSERT);
        closePSifNotNULL(psMarkREAD);
        closePSifNotNULL(psMarkDELETE);
        closePSifNotNULL(psMarkUPDATE);
        closePSifNotNULL(psMarkREADALL);
    }

    private void closePSifNotNULL(PreparedStatement ps) throws SQLException {
        if (ps != null) {
            ps.close();
        }
    }
}
