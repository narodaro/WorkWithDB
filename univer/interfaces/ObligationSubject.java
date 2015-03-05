package com.veinik.Lesson7.src.main.resources.univer.interfaces;

import com.veinik.Lesson7.src.main.resources.univer.dto.SubjectDTO;

import java.sql.SQLException;
import java.util.List;

public interface ObligationSubject {
    public SubjectDTO create(SubjectDTO Subject) throws SQLException;
    public SubjectDTO read(int key) throws SQLException;
    public void delete(int key) throws SQLException;
    public void update(SubjectDTO Subject, int key) throws SQLException;

    public List<SubjectDTO> readall() throws SQLException;
}
