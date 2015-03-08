package com.veinik.Lesson7.src.main.resources.univer.dao.interfaces;

import com.veinik.Lesson7.src.main.resources.univer.dto.StudentDTO;
import com.veinik.Lesson7.src.main.resources.univer.dto.StudentsMarksDTO;
import com.veinik.Lesson7.src.main.resources.univer.dto.SubjectDTO;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface ObligationStudentsMark {
    public StudentsMarksDTO create(StudentsMarksDTO mark) throws SQLException;
    public Map<StudentDTO,Map<SubjectDTO,StudentsMarksDTO>> read(int key) throws SQLException;
    public void delete(int key) throws SQLException;
    public void update(StudentsMarksDTO mark) throws SQLException;

    public List<StudentsMarksDTO> readall() throws SQLException;

}
