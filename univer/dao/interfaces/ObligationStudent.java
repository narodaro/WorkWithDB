package com.veinik.Lesson7.src.main.resources.univer.dao.interfaces;

import com.veinik.Lesson7.src.main.resources.univer.dto.StudentDTO;

import java.sql.SQLException;
import java.util.List;

public interface ObligationStudent {
    public StudentDTO create(StudentDTO student) throws SQLException;
    public StudentDTO read(int key) throws SQLException;
    public void delete(int key) throws SQLException;
    public void update(StudentDTO student, int key) throws SQLException;

    public List<StudentDTO> readall() throws SQLException;
}
