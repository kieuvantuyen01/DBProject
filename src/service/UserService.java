/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.JDBCConnection;
import dao.UserDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.UserModel;

/**
 *
 * @author kieuvantuyen01
 */
public class UserService {
    private UserDao userDao;
    
    public UserService() {
        userDao = new UserDao();
    }
    
    public List<UserModel> getAllUsers() {
        return userDao.getAllUsers();
    }
    
    public void addUser(UserModel user) {
        userDao.addUser(user);
    }
    
    public void deleteUser(String Ssn) {
        userDao.deleteUser(Ssn);
    }
    
    public UserModel getUser(String ssn) {
        return userDao.getUser(ssn);
    }
    
    public void updateUser(UserModel user) {
        userDao.updateUser(user);
    }
}
