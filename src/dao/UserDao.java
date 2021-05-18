/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

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
public class UserDao {
    public List<UserModel> getAllUsers() {
        
        List<UserModel> users = new ArrayList<UserModel>();

        Connection connection = JDBCConnection.getJDBConnection();

        String sql = "SELECT * FROM user";
            
        try {    
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()) {
                UserModel user = new UserModel();
                
                user.setSsn(rs.getString("SSN"));
                user.setFirstName(rs.getString("FirstName"));
                user.setLastName(rs.getString("LastName"));
                user.setDob(rs.getString("DateOfBirth"));
                user.setAddress(rs.getString("Address"));
                user.setRole(rs.getString("Roles"));
                user.setPassWord(rs.getString("Password"));
                
                users.add(user);
            }          
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
    }
    
    
    public void addUser(UserModel user) {
        Connection connection = JDBCConnection.getJDBConnection();
        
        String sql = "INSERT INTO user(SSN, FirstName, LastName, DateOfBirth, Address, Roles, Password) VALUE (?,?,?,?,?,?,?)";
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getSsn());
            preparedStatement.setString(2, user.getFirstName());
            preparedStatement.setString(3, user.getLastName());
            preparedStatement.setString(4, user.getDob());
            preparedStatement.setString(5, user.getAddress());
            preparedStatement.setString(6, user.getRole());
            preparedStatement.setString(7, user.getPassWord());
            
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateUser(UserModel user) {
        Connection connection = JDBCConnection.getJDBConnection();
        
        String sql = "UPDATE user SET FirstName = ?,LastName = ?,"
                + "DateOfBirth = ?,Address = ?,Roles = ?,Password = ?WHERE SSN = ?";
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getDob());
            preparedStatement.setString(4, user.getAddress());
            preparedStatement.setString(5, user.getRole());
            preparedStatement.setString(6, user.getPassWord());
            preparedStatement.setString(7, user.getSsn());

            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deleteUser(String Ssn) {
        Connection connection = JDBCConnection.getJDBConnection();
        
        String sql = "DELETE FROM user WHERE SSN = ?";
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, Ssn);
            
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public UserModel getUser(String ssn) {
        
        List<UserModel> users = new ArrayList<UserModel>();

        Connection connection = JDBCConnection.getJDBConnection();

        String sql = "SELECT * FROM user WHERE SSN = ?";
            
        try {    
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, ssn);
            
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()) {
                UserModel user = new UserModel();
                
                user.setSsn(rs.getString("SSN"));
                user.setFirstName(rs.getString("FirstName"));
                user.setLastName(rs.getString("LastName"));
                user.setDob(rs.getString("DateOfBirth"));
                user.setAddress(rs.getString("Address"));
                user.setRole(rs.getString("Roles"));
                user.setPassWord(rs.getString("Password"));
                
                return user;
            }          
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
