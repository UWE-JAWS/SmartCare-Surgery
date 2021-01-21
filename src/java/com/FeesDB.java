package com;

//import Fees;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class FeesDB {
    /*
     * @author Simeon Dobchev
     * @author Joshua Saxby
     */
    private Connection Connection;
    private Statement State;
    private ResultSet ResultSet;

    public ArrayList<Fees> getFees() {
        ArrayList<Fees> result = new ArrayList<Fees>();
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection = DriverManager.getConnection("jdbc:derby://localhost:1527/smartcare-test","username","password");
            State = Connection.createStatement();
            ResultSet = State.executeQuery("SELECT id, client_id, charge, start_date FROM Operations ORDER BY start_date DESC");
            while (ResultSet.next()) {
                result.add(
                    new Fees(
                        ResultSet.getInt(1),
                        ResultSet.getInt(2),
                        ResultSet.getBigDecimal(3),
                        ResultSet.getString(4))
                );
            }
            ResultSet.close();
            State.close();
            Connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Error: " + e);
        }
        return result;
    }
}
