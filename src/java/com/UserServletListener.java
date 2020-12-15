/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
//import java.util.Enumeration;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.ServletContext;

/**
 * Web application lifecycle listener.
 *
 * @author me-aydin
 */
@WebListener()
public class UserServletListener implements ServletContextListener {

    private Connection conn = null;
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext sc = sce.getServletContext();
        String db = sc.getInitParameter("dbname");
        
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/smartcare-test","username","password");
            
        }
        catch(ClassNotFoundException | SQLException e){
            sc.setAttribute("error", e);
        }
        sc.setAttribute("connection", conn);
        // now try to create the tables if they don't exist
        try {
            String commands = (
                "create table if not exists users(\n" +
                "	uname varchar(20) primary key,\n" +
                "	passwd varchar(20),\n" +
                "	role varchar(10)\n" +
                ");" +
                "create table if not exists clients(\n" +
                "	cID int not null primary key\n" +
                "            generated always as identity (start with 1, increment by 1), \n" +
                "	cName varchar(50),\n" +
                "	cAddress varchar(100),\n" +
                "	cType varchar(10),\n" +
                "	uName varchar(20) references users(uname)\n" +
                ");" +
                "create table if not exists employee(\n" +
                "	eID int not null primary key\n" +
                "            generated always as identity (start with 1, increment by 1), \n" +
                "	eName varchar(50),\n" +
                "	eAddress varchar(100),\n" +
                "	uName varchar(20) references users(uname)\n" +
                ");" +
                "create table if not exists operations(\n" +
                "    oID int not null primary key\n" +
                "            generated always as identity (start with 1, increment by 1), \n" +
                "    eID int references employee(eID),\n" +
                "    cID int references clients(cID),\n" +
                "    oDate date,\n" +
                "    oTime time,\n" +
                "    nSlot int,\n" +
                "    charge float\n" +
                ");"
            );
            System.out.println(commands);
            for (String command : commands.split(";")) {
                System.out.println(command);
                Statement s = conn.createStatement();
                s.execute(command);
                if (!conn.getAutoCommit()) {
                    conn.commit();
                }
            }
        }
        catch(SQLException e) { // OH DEAR, the tables could not be created
            sc.setAttribute("error", e);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        try { conn.close(); } catch(SQLException e) {}
    }
}
