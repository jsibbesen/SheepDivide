package com.sheepdivide.master.dataLayer;

import java.sql.*;

public class connection {

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/teknik_obligatorisk";

    // Database credentials
    static final String USER = "theuser";
    static final String PASS = "virknu";

    public Connection openConnection() {

        Connection conn = null;
        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (Exception e) {
            System.out.println("Connection Error:" + e);
        }
        return conn;
    }
}
