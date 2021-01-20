/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Time;
import static java.sql.Types.NULL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author me-aydin
 */
public class Jdbc {
    
    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet rs = null;
    //String query = null;
    
    
    public Jdbc(String query){
        //this.query = query;
    }

    public Jdbc() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void connect(Connection con){
       connection = con;
    }
    
    private ArrayList rsToList() throws SQLException {
        ArrayList aList = new ArrayList();

        int cols = rs.getMetaData().getColumnCount();
        while (rs.next()) { 
          String[] s = new String[cols];
          for (int i = 1; i <= cols; i++) {
            s[i-1] = rs.getString(i);
          } 
          aList.add(s);
        } // while    
        return aList;
    } //rsToList
 
    private String makeTable(ArrayList list) {
        StringBuilder b = new StringBuilder();
        String[] row;
        b.append("<table border=\"3\">");
        for (Object s : list) {
          b.append("<tr>");
          row = (String[]) s;
            for (String row1 : row) {
                b.append("<td>");
                b.append(row1);
                b.append("</td>");
            }
          b.append("</tr>\n");
        } // for
        b.append("</table>");
        return b.toString();
    }//makeHtmlTable
    
    private void select(String query, Object... parameters){
        //Statement statement = null;
        
        try {
            statement = connection.prepareStatement(query);
            // now set any parameters
            for (int i = 0; i < parameters.length; i++) {
                // NOTE: check data type.This may or may not work
                statement.setObject(i + 1, parameters[i]);
            }
            rs = statement.executeQuery();
            //statement.close();
        }
        catch(SQLException e) {
            System.out.println("way way"+e);
            //results = e.toString();
        }
    }
  /*  public String retrieve(String user) throws SQLException{
        
        StringBuilder sb = new StringBuilder();
        select("select JOB from users where UNAME='"+user.trim()+"'");
        
        if (rs==null)
            System.out.println("rs is null");
        else
            rsToList();
        
        
        return rsToList();//results;
    }*/
    public String retriveType(String user) throws SQLException {
    String type = "";
    select("select ROLE from users where UNAME=?", user.trim());
     int cols = rs.getMetaData().getColumnCount();
    while (rs.next()) {
        String[] s = new String[cols];
        for (int i = 1; i <= cols; i++) {
            s[i-1] = rs.getString(i);
        }
        type = s[cols-1];
    } // while
    return type;
    }
    
    public String retriveName(String user) throws SQLException {
    String type = "";
    select("select ename from employee where UNAME=?", user.trim());
     int cols = rs.getMetaData().getColumnCount();
    while (rs.next()) {
        String[] s = new String[cols];
        for (int i = 1; i <= cols; i++) {
            s[i-1] = rs.getString(i);
        }
        type = s[cols-1];
    } // while
    return type;
    }
    
    public boolean exists(String user) {
        boolean bool = false;
        try  {
            select("select UNAME from users where UNAME=?", user);
            if(rs.next()) {
                System.out.println("TRUE");         
                bool = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Jdbc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bool;
    }
    
    public boolean login(String user, String password){
        boolean bool = false;
        try{
            select("select uname from users where UNAME=? and PASSWD=?", user, password);
            if(rs.next()){
                System.out.println("Login Successfull");
                bool = true;
                }
            }catch(SQLException ex) {
            Logger.getLogger(Jdbc.class.getName()).log(Level.SEVERE, null, ex);
        }
       return bool; 
    }
        public void insertAdress(String[] str){
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement("INSERT INTO EMPLOYEE VALUES (?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, str[0].trim()); 
            ps.setString(2, str[1].trim());
            ps.setString(3, str[2]);
            ps.executeUpdate();
        
            ps.close();
            System.out.println("1 row added.");
        } catch (SQLException ex) {
            Logger.getLogger(Jdbc.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }
        
    public void insert(String[] str){
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement("INSERT INTO Users VALUES (?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, str[0].trim()); 
            ps.setString(2, str[1].trim());
            ps.setString(3, str[2]);
            ps.executeUpdate();
        
            ps.close();
            System.out.println("1 row added.");
        } catch (SQLException ex) {
            Logger.getLogger(Jdbc.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }
    public void update(String[] str) {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement("Update Users Set passwd=? where uname=?",PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, str[1].trim()); 
            ps.setString(2, str[0].trim());
            ps.executeUpdate();
        
            ps.close();
            System.out.println("1 rows updated.");
        } catch (SQLException ex) {
            Logger.getLogger(Jdbc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void delete(String user){
      
      // FIXME: Not SQL-injection tolerant
      String query = "DELETE FROM Users " +
                   "WHERE uname = '"+user.trim()+"'";
      
        try {
            statement = connection.prepareStatement(query);
            statement.executeUpdate();
        }
        catch(SQLException e) {
            System.out.println("way way"+e);
            //results = e.toString();
        }
    }
    public void closeAll(){
        try {
            rs.close();
            statement.close(); 		
            //connection.close();                                         
        }
        catch(SQLException e) {
            System.out.println(e);
        }
    }
    public static void main(String[] args) throws SQLException {
        String str = "select * from users";
        String insert = "INSERT INTO `Users` (`uname`, `passwd`, 'job') VALUES ('meaydin', 'meaydin','doctor')";
        String update = "UPDATE `Users` SET `passwd`='eaydin' WHERE `uname`='meaydin' ";
        String db = "smartcare-test";
        String dbUsername = "username";
        String dbPassword = "password";
        
        Jdbc jdbc = new Jdbc(str);
        Connection conn = null;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/" + db.trim(), dbUsername.trim(), dbPassword.trim());
        }
        catch(ClassNotFoundException | SQLException e){
            
        }
        jdbc.connect(conn);
        String [] users = {"eaydin","benim","benim"};
        //System.out.println(jdbc.retrieveType(str));
        if (!jdbc.exists(users[0]))
            jdbc.insert(users);            
        else {
                jdbc.update(users);
                System.out.println("user name exists, change to another");
        }
        //jdbc.delete("aydinme");
        System.out.println(jdbc.retriveType(str));
        jdbc.closeAll();
    }            
}
