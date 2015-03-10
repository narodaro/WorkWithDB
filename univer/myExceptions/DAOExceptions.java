package com.veinik.Lesson7.src.main.resources.univer.myExceptions;


public class DAOExceptions extends Exception {
    public DAOExceptions() {
    }

    public DAOExceptions(String message) {
        super(message);
    }

    public DAOExceptions(String message, Throwable cause) {
        super(message, cause);
    }

    public DAOExceptions(Throwable cause) {
        super(cause);
    }

    public DAOExceptions(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
