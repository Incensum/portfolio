/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.LoginInfoDAO;
import dao.LoginInfoDAOImpl;
import dao.UserDAO;
import dao.UserDAOImpl;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.HashMap;

/**
 *
 * @author john
 */
@Named(value = "loginInfo")
@SessionScoped
public class LoginInfo implements Serializable {
private static HashMap<String, String> map;
private String userId, password;

    /**
     * Creates a new instance of User
     */
    public LoginInfo() {
    }
    public LoginInfo(String userID, String password){
        this.userId = userID;
        this.password = password;
    }
    public static boolean authenticate(String uCred, String pCred){
        boolean auth = false;
        String dbUname, dbPw;
                UserDAO check = new UserDAOImpl();
                boolean exists = check.exists(uCred);
                if(!exists){
                    return auth;
                }
                else{
                LoginInfoDAO dbInfo = new LoginInfoDAOImpl();
                LoginInfo info = dbInfo.findRow(uCred);
                dbUname = info.userId;
                dbPw = info.password;
                LoginInfo.map = new HashMap<>();
                map.put(dbUname, dbPw);
	if (uCred == null || uCred.isEmpty()) {
			return auth;
	  }
        if(map.get(uCred) == null){
            return auth;
        }
        else{
            if(!map.get(uCred).equals(pCred)){
                return auth;
            }
            else{
                auth = true;
            }
        }
                }
        return auth;
    }
        
    /**
     * @return the userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
}
