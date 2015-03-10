package com.veinik.Lesson7.src.main.resources.univer.dao.interfaces;

import com.veinik.Lesson7.src.main.resources.univer.dto.SubjectDTO;
import com.veinik.Lesson7.src.main.resources.univer.myExceptions.MyExceptions;

import java.sql.SQLException;
import java.util.List;

public interface ObligationSubject {

    public SubjectDTO create(SubjectDTO Subject) throws MyExceptions;

    public SubjectDTO read(int key) throws MyExceptions;

    public void delete(int key) throws MyExceptions;

    public void update(SubjectDTO Subject, int key) throws MyExceptions;

    public List<SubjectDTO> readall() throws MyExceptions;
}
