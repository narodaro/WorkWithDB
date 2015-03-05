package com.veinik.Lesson7.src.main.resources.univer.dao;

import com.veinik.Lesson7.src.main.resources.univer.dbConnection.DBConnection;
import com.veinik.Lesson7.src.main.resources.univer.dto.SubjectDTO;
import com.veinik.Lesson7.src.main.resources.univer.interfaces.ObligationSubject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SubjectsDAO implements ObligationSubject {

    private static final String SQL_INSERT = "INSERT INTO SUBJECTS(SUBJECT_NAME) values(?)";
    private static final String SQL_DELETE = "DELETE FROM SUBJECTS WHERE ID = ?";
    private static final String SQL_UPDATE = "UPDATE SUBJECTS SET SUBJECT_NAME = ? WHERE ID = ?";
    private static final String SQL_READ = "SELECT * FROM SUBJECTS WHERE ID = ?";
    private static final String SQL_READALL = "SELECT * FROM SUBJECTS";

    private static Connection conn = new DBConnection().getDBConnection();

    private static PreparedStatement psSubjectINSERT;
    private static PreparedStatement psSubjectDELETE;
    private static PreparedStatement psSubjectUPDATE;
    private static PreparedStatement psSubjectREAD;
    private static PreparedStatement psSubjectREADALL;

    @Override
    public SubjectDTO create(SubjectDTO Subject) throws SQLException {
        if (psSubjectINSERT == null) {
            psSubjectINSERT = conn.prepareStatement(SQL_INSERT);
        }

        psSubjectINSERT.setString(1, Subject.getSubject_name());
        psSubjectINSERT.executeUpdate();

        return Subject;
    }

    @Override
    public SubjectDTO read(int key) throws SQLException {
        if (psSubjectREAD == null) {
            psSubjectREAD = conn.prepareStatement(SQL_READ);
        }
        psSubjectREAD.setInt(1, key);
        ResultSet res = psSubjectREAD.executeQuery();

        SubjectDTO subject = new SubjectDTO();
        while (res.next()) {
            subject.setId(res.getInt("id"));
            subject.setSubject_name(res.getString("Subject_Name"));
        }
        res.close();

        return subject;
    }

    @Override
    public void delete(int key) throws SQLException{
        if (psSubjectDELETE == null) {
            psSubjectDELETE = conn.prepareStatement(SQL_DELETE);
        }
        psSubjectDELETE.setInt(1, key);
        psSubjectDELETE.executeUpdate();
    }

    @Override
    public void update(SubjectDTO Subject, int key) throws SQLException {
        if (psSubjectUPDATE == null) {
            psSubjectUPDATE = conn.prepareStatement(SQL_UPDATE);
        }
        psSubjectUPDATE.setString(1, Subject.getSubject_name());
        psSubjectUPDATE.setInt(2, key);
        psSubjectUPDATE.executeUpdate();
    }

    @Override
    public List<SubjectDTO> readall() throws SQLException{
        if (psSubjectREADALL == null) {
            psSubjectREADALL = conn.prepareStatement(SQL_READALL);
        }

        List<SubjectDTO> subjects = new ArrayList<SubjectDTO>();
        ResultSet res = psSubjectREADALL.executeQuery();

        while(res.next()){
            SubjectDTO subject = new SubjectDTO();
            subject.setId(res.getInt("id"));
            subject.setSubject_name(res.getString("Subject_name"));
            subjects.add(subject);
        }
        res.close();

        return subjects;
    }

    public void  psSubjectClose() throws SQLException {
        closePSifNotNULL(psSubjectINSERT);
        closePSifNotNULL(psSubjectREAD);
        closePSifNotNULL(psSubjectDELETE);
        closePSifNotNULL(psSubjectUPDATE);
        closePSifNotNULL(psSubjectREADALL);
    }

    private void closePSifNotNULL(PreparedStatement ps) throws SQLException {
        if(ps != null) {
            ps.close();
        }
    }
}
