package com.veinik.Lesson7.src.main.resources.univer.dao;

import com.veinik.Lesson7.src.main.resources.univer.dbConnection.DBConnection;
import com.veinik.Lesson7.src.main.resources.univer.dto.StudentDTO;
import com.veinik.Lesson7.src.main.resources.univer.interfaces.ObligationStudent;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO implements ObligationStudent {

    private static final String SQL_INSERT = "INSERT INTO STUDENTS(FIRST_NAME,SECOND_NAME) values(?, ?)";
    private static final String SQL_DELETE = "DELETE FROM STUDENTS WHERE ID = ?";
    private static final String SQL_UPDATE = "UPDATE STUDENTS SET FIRST_NAME = ?, SECOND_NAME = ? WHERE ID = ?";
    private static final String SQL_READ = "SELECT * FROM STUDENTS WHERE ID = ?";
    private static final String SQL_READALL = "SELECT * FROM STUDENTS";

    private static Connection conn = new DBConnection().getDBConnection();

    private static PreparedStatement psStudentINSERT;
    private static PreparedStatement psStudentDELETE;
    private static PreparedStatement psStudentUPDATE;
    private static PreparedStatement psStudentREAD;
    private static PreparedStatement psStudentREADALL;

    @Override
    public StudentDTO create(StudentDTO student) throws SQLException {
        if(psStudentINSERT == null) {
            psStudentINSERT = conn.prepareStatement(SQL_INSERT);
        }
            psStudentINSERT.setString(1, student.getFirstName());
            psStudentINSERT.setString(2, student.getSecondName());

            psStudentINSERT.executeUpdate();

        return student;
    }

    @Override
    public StudentDTO read(int key) throws SQLException {
        if (psStudentREAD == null) {
            psStudentREAD = conn.prepareStatement(SQL_READ);
        }
        psStudentREAD.setInt(1, key);
        ResultSet res = psStudentREAD.executeQuery();

        StudentDTO student = new StudentDTO();
        while (res.next()) {
            student.setId(res.getInt("id"));
            student.setFirstName(res.getString("First_Name"));
            student.setSecondName(res.getString("Second_Name"));
        }
        res.close();

        return student;
    }

    @Override
    public void delete(int key) throws SQLException {
        if (psStudentDELETE == null) {
            psStudentDELETE = conn.prepareStatement(SQL_DELETE);
        }
            psStudentDELETE.setInt(1, key);
            psStudentDELETE.executeUpdate();

    }

    @Override
    public void update(StudentDTO student, int key) throws SQLException{
        if (psStudentUPDATE == null) {
            psStudentUPDATE = conn.prepareStatement(SQL_UPDATE);
        }
        psStudentUPDATE.setString(1, student.getFirstName());
        psStudentUPDATE.setString(2, student.getSecondName());
        psStudentUPDATE.setInt(3, key);
        psStudentUPDATE.executeUpdate();

    }

    @Override
    public List<StudentDTO> readall() throws SQLException {
        if (psStudentREADALL == null) {
            psStudentREADALL = conn.prepareStatement(SQL_READALL);
        }

        List<StudentDTO> students = new ArrayList<StudentDTO>();
        ResultSet res = psStudentREADALL.executeQuery();

        while (res.next()) {
            StudentDTO student = new StudentDTO();
            student.setId(res.getInt("id"));
            student.setFirstName(res.getString("First_Name"));
            student.setSecondName(res.getString("Second_Name"));
            students.add(student);
        }
        res.close();

        return students;
    }

    public void  psStudentClose() throws SQLException {
        closePSifNotNULL(psStudentINSERT);
        closePSifNotNULL(psStudentREAD);
        closePSifNotNULL(psStudentDELETE);
        closePSifNotNULL(psStudentUPDATE);
        closePSifNotNULL(psStudentREADALL);
    }

    private void closePSifNotNULL(PreparedStatement ps) throws SQLException {
        if(ps != null) {
            ps.close();
        }
    }
}