package com.veinik.Lesson7.src.main.resources.univer.dao.interfaces;

import com.veinik.Lesson7.src.main.resources.univer.dto.SubjectDTO;
import com.veinik.Lesson7.src.main.resources.univer.myExceptions.DAOExceptions;

import java.util.List;

public interface ObligationSubject {

    public SubjectDTO create(SubjectDTO Subject) throws DAOExceptions;

    public SubjectDTO read(int key) throws DAOExceptions;

    public void delete(int key) throws DAOExceptions;

    public void update(SubjectDTO Subject, int key) throws DAOExceptions;

    public List<SubjectDTO> readall() throws DAOExceptions;
}
