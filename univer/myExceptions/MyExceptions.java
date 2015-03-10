package com.veinik.Lesson7.src.main.resources.univer.myExceptions;

import java.io.PrintStream;
import java.sql.SQLException;

public class MyExceptions extends SQLException {
    @Override
    public void printStackTrace(PrintStream s) {
        System.err.println("Exception occurred: " + s.toString());
    }
}
