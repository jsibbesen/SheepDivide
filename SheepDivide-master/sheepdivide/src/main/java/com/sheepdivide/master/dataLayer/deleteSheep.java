package com.sheepdivide.master.dataLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class deleteSheep {
    private Connection conn;

    public deleteSheep(Connection conn){
        this.conn = conn;
    }

    //dropdownliste til at vælge nogle af de forskellige værdier.
    // data kommer fra controller?
    public void deleteASheep(int sheepId) {

        // loop i registerSheep eller i controller?

        PreparedStatement stmt = null;
        try {

            // Prepare statement
            stmt = conn.prepareStatement("DELETE FROM sheep WHERE sheepId = ? LIMIT 1");

            // sets int values in SQL, Preparedstatement prevents sql injection
            stmt.setInt(1, sheepId);

            // executes update, checks if insert was successful
            stmt.executeUpdate();
            if (stmt.getUpdateCount() > 0) {
                System.out.println("Sheep deleted");
            } else
                System.out.println("Sheep not deleted");
            stmt.close();
        } catch (Exception e) {
            System.out.println("Delete Error: " + e);
        }
    }
}
