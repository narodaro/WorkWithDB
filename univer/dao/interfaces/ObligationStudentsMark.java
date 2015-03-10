package com.veinik.Lesson7.src.main.resources.univer.dao.interfaces;

import com.veinik.Lesson7.src.main.resources.univer.dto.StudentDTO;
import com.veinik.Lesson7.src.main.resources.univer.dto.StudentsMarksDTO;
import com.veinik.Lesson7.src.main.resources.univer.dto.SubjectDTO;
import com.veinik.Lesson7.src.main.resources.univer.myExceptions.DAOExceptions;

import java.util.List;
import java.util.Map;

public interface ObligationStudentsMark {

    public StudentsMarksDTO create(StudentsMarksDTO mark) throws DAOExceptions;

    public Map<StudentDTO, Map<SubjectDTO, StudentsMarksDTO>> read(int key) throws DAOExceptions;

    public void delete(int key) throws DAOExceptions;

    public void update(StudentsMarksDTO mark) throws DAOExceptions;

    public List<StudentsMarksDTO> readall() throws DAOExceptions;

}
