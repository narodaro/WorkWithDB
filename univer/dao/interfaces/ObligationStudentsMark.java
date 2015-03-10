package com.veinik.Lesson7.src.main.resources.univer.dao.interfaces;

import com.veinik.Lesson7.src.main.resources.univer.dto.StudentDTO;
import com.veinik.Lesson7.src.main.resources.univer.dto.StudentsMarksDTO;
import com.veinik.Lesson7.src.main.resources.univer.dto.SubjectDTO;
import com.veinik.Lesson7.src.main.resources.univer.myExceptions.MyExceptions;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface ObligationStudentsMark {

    public StudentsMarksDTO create(StudentsMarksDTO mark) throws MyExceptions;

    public Map<StudentDTO, Map<SubjectDTO, StudentsMarksDTO>> read(int key) throws MyExceptions;

    public void delete(int key) throws MyExceptions;

    public void update(StudentsMarksDTO mark) throws MyExceptions;

    public List<StudentsMarksDTO> readall() throws MyExceptions;

}
