package com.sheepdivide.master.dataLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class updateSheep {
    private Connection conn;

    public updateSheep(Connection conn){
        this.conn = conn;
    }

    //dropdownliste til at vælge nogle af de forskellige værdier.
    // data kommer fra controller?
    public void updateAllValues(int sheepId, String sheepType, int sheepWeight, int sheepWool, int sheepHorns, int sheepLegs){

        // loop i registerSheep eller i controller?

        PreparedStatement stmt = null;
        try {

            //EVT lav metode som vi genbruger!
            int typeSheep = 0;
            if (sheepType.equals("Ewe"))
                typeSheep = 1;
            else if (sheepType.equals("Ewe Lamb"))
                typeSheep = 2;
            else if (sheepType.equals("Male Lamb"))
                typeSheep = 3;
            else if (sheepType.equals("Ram"))
                typeSheep = 4;

            // Prepare statement
            stmt = conn.prepareStatement("UPDATE sheep SET typeOfSheep = ?, weightInKilograms = ?, " +
                                                      "wool = ?, horns = ?, legs = ? WHERE sheepId(?)");

            // sets int values in SQL, Preparedstatement prevents sql injection
            stmt.setInt(1, typeSheep);
            stmt.setInt(2, sheepWeight);
            stmt.setInt(3, sheepWool);
            stmt.setInt(4, sheepHorns);
            stmt.setInt(5, sheepLegs);
            stmt.setInt(6, sheepId);
            // executes update, checks if insert was successful
            stmt.executeUpdate();
            if (stmt.getUpdateCount() > 0){
                System.out.println("Sheep updated");
            }
            else
                System.out.println("Sheep not updated");
            stmt.close();
        }
        catch (Exception e) {
            System.out.println("Update Error: " + e);
        }
    }
    public void updateSheepType(int sheepId, String sheepType){

    }
    public void updatesheepWeight(int sheepId, int sheepWeight){

    }
    public void updateSheepWool(int sheepId, int sheepWool){

    }
    public void updateSheepHorns(int sheepId, int sheepHorns){

    }
    public void updateSheepLegs(int sheepId, int sheepLegs){

    }
}
