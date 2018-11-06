package com.sheepdivide.master.dataLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class registerSheep {

    private Connection conn;

    public registerSheep(Connection conn){
        this.conn = conn;
    }

    //dropdownliste til at vælge nogle af de forskellige værdier.
    // data kommer fra controller?
    public void newSheep(String sheepType, int sheepWeight, int sheepWool, int sheepHorns, int sheepLegs){

        // loop i registerSheep eller i controller?

        PreparedStatement stmt = null;
        try {
            /*
            Når de forskellige data bliver hentet ind i databasen, skal typeOfSheep være et ID eller en string?.
            Det er nok lettest direkte at skrive fårets ID ind tilhørende til sheep type.
            Skal sheepType sammenlignes med de forskellige typer får i databasen som string, eller skriver dens
            tilhørende typeId direkte ind i tabellen med får?
             */

            // int i stedet for string der bliver hentet i parameter, da tabellen forventer en int.
            // Det er en string i dropdownlisten. hvordan skal vi håndtere dette generelt?
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
            stmt = conn.prepareStatement("INSERT INTO sheep(typeOfSheep, weightInKilograms, wool, horns, legs) VALUES (?, ?, ?, ?, ?)");

            // sets int values in SQL, Preparedstatement prevents sql injection
            stmt.setInt(1, typeSheep);
            stmt.setInt(2, sheepWeight);
            stmt.setInt(3, sheepWool);
            stmt.setInt(4, sheepHorns);
            stmt.setInt(5, sheepLegs);

            // executes update, checks if insert was successful
            stmt.executeUpdate();
            if (stmt.getUpdateCount() > 0){
                System.out.println("Sheep inserted");
            }
            else
                System.out.println("Sheep not inserted");
            stmt.close();
        }
        catch (Exception e) {
            System.out.println("Insert Error: " + e);
        }
    }
}
