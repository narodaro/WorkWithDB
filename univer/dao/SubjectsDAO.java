package com.veinik.Lesson7.src.main.resources.univer.dao;

import com.veinik.Lesson7.src.main.resources.univer.DaoObjects;
import com.veinik.Lesson7.src.main.resources.univer.dto.SubjectDTO;
import com.veinik.Lesson7.src.main.resources.univer.interfaces.ObligationSubject;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SubjectsDAO extends DaoObjects implements ObligationSubject {

    private static final String SQL_INSERT = "INSERT INTO SUBJECTS(SUBJECT_NAME) values(?)";
    private static final String SQL_DELETE = "DELETE FROM SUBJECTS WHERE ID = ?";
    private static final String SQL_UPDATE = "UPDATE SUBJECTS SET SUBJECT_NAME = ? WHERE ID = ?";
    private static final String SQL_READ = "SELECT * FROM SUBJECTS WHERE ID = ?";
    private static final String SQL_READALL = "SELECT * FROM SUBJECTS";


    @Override
    public SubjectDTO create(SubjectDTO Subject) throws SQLException {
        if (psINSERT == null) {
            psINSERT = conn.prepareStatement(SQL_INSERT);
        }
        psINSERT.setString(1, Subject.getSubject_name());
        psINSERT.executeUpdate();
        return Subject;
    }

    @Override
    public SubjectDTO read(int key) throws SQLException {
        if (psREAD == null) {
            psREAD = conn.prepareStatement(SQL_READ);
        }
        psREAD.setInt(1, key);
        ResultSet res = psREAD.executeQuery();

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
        if (psDELETE == null) {
            psDELETE = conn.prepareStatement(SQL_DELETE);
        }
        psDELETE.setInt(1, key);
        psDELETE.executeUpdate();
    }

    @Override
    public void update(SubjectDTO Subject, int key) throws SQLException {
        if (psUPDATE == null) {
            psUPDATE = conn.prepareStatement(SQL_UPDATE);
        }
        psUPDATE.setString(1, Subject.getSubject_name());
        psUPDATE.setInt(2, key);
        psUPDATE.executeUpdate();
    }

    @Override
    public List<SubjectDTO> readall() throws SQLException{
        if (psREADALL == null) {
            psREADALL = conn.prepareStatement(SQL_READALL);
        }

        List<SubjectDTO> subjects = new ArrayList<SubjectDTO>();
        ResultSet res = psREADALL.executeQuery();

        while(res.next()){
            SubjectDTO subject = new SubjectDTO();
            subject.setId(res.getInt("id"));
            subject.setSubject_name(res.getString("Subject_name"));
            subjects.add(subject);
        }
        res.close();
        return subjects;
    }
}
