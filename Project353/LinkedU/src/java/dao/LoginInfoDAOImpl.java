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
import model.LoginInfo;

/**
 *
 * @author john
 */
public class LoginInfoDAOImpl implements LoginInfoDAO{
//TODO: parameterize SQL bits.

    @Override
    public LoginInfo findRow(String userID) {
        LoginInfo info = null;
       String query = "SELECT * FROM Project353.LOGININFO where userid = '" + userID + "'";
       //System.out.println(query);
        try {
                String myDB = "jdbc:derby://localhost:1527/Project353";
                Connection DBConn = DriverManager.getConnection(myDB, "itkstu", "student");
                Statement stmt = DBConn.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                while(rs.next()){
                    String uid = rs.getString("USERID");
                    String pw = rs.getString("PASSWORD");
                   // System.out.println(uid + ", " + pw);
                info = new LoginInfo(uid, pw);
                }
                    rs.close();
                    stmt.close();
            }
            catch (Exception e) {
                System.err.println("ERROR: Problems with SQL select");
                e.printStackTrace();
            }
        return info;
    }

    @Override
    public int createLoginInfo(LoginInfo info) {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
        LoginInfo login = new LoginInfo(info.getUserId(), info.getPassword());
        int rowCount = 0;
        try {
            String myDB = "jdbc:derby://localhost:1527/Project353";
            Connection DBConn = DriverManager.getConnection(myDB, "itkstu", "student");
            
            String insertString;
            Statement stmt = DBConn.createStatement();
            insertString = "INSERT INTO Project353.LogInInfo VALUES ('"
                    + info.getUserId()
                    + "','" + info.getPassword()
                    + "')";

            rowCount = stmt.executeUpdate(insertString);
            System.out.println("insert string =" + insertString);
            DBConn.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        // if insert is successful, rowCount will be set to 1 (1 row inserted successfully). Else, insert failed.
        return rowCount;
    }
    
    @Override
    public int updatePassword(String userID, String newPassword){
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
            updateString = "UPDATE Project353.LogInInfo SET PASSWORD = '" + newPassword +
                    "' where userid = '" + userID + "'";

            rowCount = stmt.executeUpdate(updateString);
            System.out.println("update string = " + updateString);
            DBConn.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return rowCount;
    }
}
