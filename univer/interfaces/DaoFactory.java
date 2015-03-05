//package com.veinik.Lesson7.src.main.resources.univer;
//
//import com.veinik.Lesson7.src.main.resources.univer.interfaces.ObligationStudent;
//import com.veinik.Lesson7.src.main.resources.univer.interfaces.ObligationStudentsMark;
//import com.veinik.Lesson7.src.main.resources.univer.interfaces.ObligationSubject;
//
//import java.sql.Connection;
//import java.sql.SQLException;
//
//public interface DaoFactory {
//
//    /** Возвращает подключение к базе данных */
//    public Connection getDBConnection() throws SQLException;
//
//    /** Возвращает объект для управления персистентным состоянием объекта Student */
//    public ObligationStudent getStudenstDao(Connection connection);
//
//    /** Возвращает объект для управления персистентным состоянием объекта Course */
//    public ObligationSubject getSubjectsDao(Connection connection);
//
//    /** Возвращает объект для управления персистентным состоянием объекта Mark */
//    public ObligationStudentsMark getStudentsMarksDao(Connection connection);
//}
