package com.veinik.Lesson7.src.main.resources.univer.dao;

import com.veinik.Lesson7.src.main.resources.univer.dto.StudentDTO;
import com.veinik.Lesson7.src.main.resources.univer.dao.interfaces.ObligationStudent;
import com.veinik.Lesson7.src.main.resources.univer.myExceptions.MyExceptions;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO extends DaoObjects implements ObligationStudent {

    private static final String SQL_INSERT = "INSERT INTO STUDENTS(FIRST_NAME,SECOND_NAME) values(?, ?)";
    private static final String SQL_DELETE = "DELETE FROM STUDENTS WHERE ID = ?";
    private static final String SQL_UPDATE = "UPDATE STUDENTS SET FIRST_NAME = ?, SECOND_NAME = ? WHERE ID = ?";
    private static final String SQL_READ = "SELECT * FROM STUDENTS WHERE ID = ?";
    private static final String SQL_READALL = "SELECT * FROM STUDENTS";

    @Override
    public StudentDTO create(StudentDTO student) throws MyExceptions {
        try {
            if (psINSERT == null) {
                psINSERT = conn.prepareStatement(SQL_INSERT);
            }
            psINSERT.setString(1, student.getFirstName());
            psINSERT.setString(2, student.getSecondName());
            psINSERT.executeUpdate();
        } catch (SQLException e) {
            throw new MyExceptions();
        }
        return student;
    }

    @Override
    public StudentDTO read(int key) throws MyExceptions {
        StudentDTO student;
        try {
            if (psREAD == null) {
                psREAD = conn.prepareStatement(SQL_READ);
            }
            psREAD.setInt(1, key);
            ResultSet res = psREAD.executeQuery();

            student = new StudentDTO();
            while (res.next()) {
                student.setId(res.getInt("id"));
                student.setFirstName(res.getString("First_Name"));
                student.setSecondName(res.getString("Second_Name"));
            }
            res.close();
        } catch (SQLException e) {
            throw new MyExceptions();
        }
        return student;
    }

    @Override
    public void delete(int key) throws MyExceptions {
        try {
            if (psDELETE == null) {
                psDELETE = conn.prepareStatement(SQL_DELETE);
            }
            psDELETE.setInt(1, key);
            psDELETE.executeUpdate();
        } catch (SQLException e) {
            throw new MyExceptions();
        }
    }

    @Override
    public void update(StudentDTO student, int key) throws MyExceptions {
        try {
            if (psUPDATE == null) {
                psUPDATE = conn.prepareStatement(SQL_UPDATE);
            }
            psUPDATE.setString(1, student.getFirstName());
            psUPDATE.setString(2, student.getSecondName());
            psUPDATE.setInt(3, key);
            psUPDATE.executeUpdate();
        } catch (SQLException e) {
            throw new MyExceptions();
        }
    }

    @Override
    public List<StudentDTO> readall() throws MyExceptions {
        List<StudentDTO> students = null;
        try {
            if (psREADALL == null) {
                psREADALL = conn.prepareStatement(SQL_READALL);
            }

            students = new ArrayList<>();
            ResultSet res = psREADALL.executeQuery();

            while (res.next()) {
                StudentDTO student = new StudentDTO();
                student.setId(res.getInt("id"));
                student.setFirstName(res.getString("First_Name"));
                student.setSecondName(res.getString("Second_Name"));
                students.add(student);
            }
            res.close();
        } catch (SQLException e) {
            throw new MyExceptions();
        }
        return students;
    }
}