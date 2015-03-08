package com.veinik.Lesson7.src.main.resources.univer.dao;


import com.veinik.Lesson7.src.main.resources.univer.dbConnection.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DaoObjects {
    public PreparedStatement psINSERT;
    public PreparedStatement psDELETE;
    public PreparedStatement psUPDATE;
    public PreparedStatement psREAD;
    public PreparedStatement psREADALL;

    public Connection conn = new DBConnection().getDBConnection();

    public void closePSifNotNULL(PreparedStatement ps) throws SQLException {
        if (ps != null) {
            ps.close();
        }
    }

    public void psClose() throws SQLException {
        closePSifNotNULL(psINSERT);
        closePSifNotNULL(psREAD);
        closePSifNotNULL(psDELETE);
        closePSifNotNULL(psUPDATE);
        closePSifNotNULL(psREADALL);
    }
}
