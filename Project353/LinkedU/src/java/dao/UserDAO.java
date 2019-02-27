/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Users;

/**
 *
 * @author john
 */
public interface UserDAO {
    public boolean exists(String UserID);
    public int createUser(Users aUser, String userID);
    public Users findRow(String userID);
    public int updateUser(Users aUser);
}
