package com;

import Pages.Fees;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class FeesDB {

    private Connection Connection;
    private Statement State;
    private ResultSet ResultSet;

    public ArrayList<Fees> getFees() {
        ArrayList<Fees> result = new ArrayList<Fees>();
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection = DriverManager.getConnection("jdbc:derby://localhost:1527/smartcare-test","username","password");
            State = Connection.createStatement();
            ResultSet = State.executeQuery("SELECT * FROM OPERATIONS");
            while (ResultSet.next()) {
                result.add(new Fees(ResultSet.getInt(1), ResultSet.getInt(2), ResultSet.getString(3), ResultSet.getDouble(4)));
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
