package com.veinik.Lesson7.src.main.resources.univer;


import com.veinik.Lesson7.src.main.resources.univer.dbConnection.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DaoObjects {
    protected static PreparedStatement psINSERT;
    protected static PreparedStatement psDELETE;
    protected static PreparedStatement psUPDATE;
    protected static PreparedStatement psREAD;
    protected static PreparedStatement psREADALL;

    protected static Connection conn = new DBConnection().getDBConnection();


    protected void closePSifNotNULL(PreparedStatement ps) throws SQLException {
        if (ps != null) {
            ps.close();
        }
    }

    protected void psClose() throws SQLException {
        closePSifNotNULL(psINSERT);
        closePSifNotNULL(psREAD);
        closePSifNotNULL(psDELETE);
        closePSifNotNULL(psUPDATE);
        closePSifNotNULL(psREADALL);
    }
}
