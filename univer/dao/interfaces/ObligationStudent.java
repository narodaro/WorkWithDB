package com.veinik.Lesson7.src.main.resources.univer.dao.interfaces;

import com.veinik.Lesson7.src.main.resources.univer.dto.StudentDTO;
import com.veinik.Lesson7.src.main.resources.univer.myExceptions.MyExceptions;

import java.sql.SQLException;
import java.util.List;

public interface ObligationStudent {

    public StudentDTO create(StudentDTO student) throws MyExceptions;

    public StudentDTO read(int key) throws MyExceptions;

    public void delete(int key) throws MyExceptions;

    public void update(StudentDTO student, int key) throws MyExceptions;

    public List<StudentDTO> readall() throws MyExceptions;
}
