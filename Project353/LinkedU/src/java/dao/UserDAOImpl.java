/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Users;

/**
 *
 * @author john
 */
public class UserDAOImpl implements UserDAO{
//TODO: parameterize SQL bits.
    @Override
    public boolean exists(String userID) { 
        boolean flag = true;
        String query = "SELECT * FROM Project353.LOGININFO where userid = '" + userID + "'";
        try {
                String myDB = "jdbc:derby://localhost:1527/Project353";
                Connection DBConn = DriverManager.getConnection(myDB, "itkstu", "student");
                Statement stmt = DBConn.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                flag = rs.next();
                    rs.close();
                    stmt.close();
            }
            catch (Exception e) {
                System.err.println("ERROR: Problems with SQL select");
                e.printStackTrace();
            }
            return flag;
    }
            
    @Override
    public int createUser(Users aUser, String userID) {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
        aUser.setUserID(userID);
        int rowCount = 0;
        try {
            String myDB = "jdbc:derby://localhost:1527/Project353";
            Connection DBConn = DriverManager.getConnection(myDB, "itkstu", "student");
            
            String insertString;
            Statement stmt = DBConn.createStatement();
            insertString = "INSERT INTO Project353.Users VALUES ('"
                    + aUser.getFirstName()
                    + "','" + aUser.getLastName()
                    + "','" + aUser.getUserID()
                    + "','" + aUser.getEmail()
                    + "','" + aUser.getSecQuestion()
                    + "','" + aUser.getSecAnswer()
                    + "')";
            System.out.println("insert string =" + insertString);
            rowCount = stmt.executeUpdate(insertString);
            
            DBConn.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        // if insert is successful, rowCount will be set to 1 (1 row inserted successfully). Else, insert failed.
        return rowCount;
    }
    
    @Override
    public Users findRow(String userID){
        Users aUser = null;
                String query = "SELECT * FROM Project353.USERS where userid = '" + userID + "'";
        try {
                String myDB = "jdbc:derby://localhost:1527/Project353";
                Connection DBConn = DriverManager.getConnection(myDB, "itkstu", "student");
                Statement stmt = DBConn.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                while(rs.next()){
                    String firstName = rs.getString("FIRSTNAME");
                    String lastName = rs.getString("LASTNAME");
                    String email = rs.getString("EMAIL");
                    String ID = rs.getString("USERID");
                    String secQuestion = rs.getString("SECQUESTION");
                    String secAnswer = rs.getString("SECANSWER");
                    //System.out.println(firstName + lastName + email + ID + secQuestion + secAnswer);
                    aUser = new Users(firstName, lastName, ID, email, secQuestion, secAnswer);
                }
                 rs.close();
                 stmt.close();
            }
            catch (Exception e) {
                System.err.println("ERROR: Problems with SQL select");
                e.printStackTrace();
            }
        
        return aUser;
    }
    
    @Override
    public int updateUser(Users aUser){ //TODO: Parameterize SQL
        int rowCount = 0;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
        try {
            String myDB = "jdbc:derby://localhost:1527/Project353";
            Connection DBConn = DriverManager.getConnection(myDB, "itkstu", "student");
            
            String updateString;
            Statement stmt = DBConn.createStatement();
            updateString = "update Project353.Users set"
                    + " firstname = '" +aUser.getFirstName()
                    + "', lastname = '" + aUser.getLastName()
                    + "', email = '" + aUser.getEmail()
                    + "', secquestion = '" + aUser.getSecQuestion()
                    + "', secanswer = '" + aUser.getSecAnswer()
                    + "' where userid = '" + aUser.getUserID() + "'";
            System.out.println("update string = " + updateString);
            rowCount = stmt.executeUpdate(updateString);
            
            DBConn.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return rowCount;
    }
    
}
