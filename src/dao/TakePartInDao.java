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
import model.TakePartInModel;

/**
 *
 * @author kieuvantuyen01
 */
public class TakePartInDao {
    public List<TakePartInModel> getAllTakePartIns() {
        
        List<TakePartInModel> takePartIns = new ArrayList<TakePartInModel>();

        Connection connection = JDBCConnection.getJDBConnection();

        String sql = "SELECT * FROM `takesPartIn`";
            
        try {    
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()) {
                TakePartInModel takePartIn = new TakePartInModel();
                
                takePartIn.settID(rs.getString("TID"));
                takePartIn.setmID(rs.getString("MID"));
                takePartIn.setpID(rs.getString("PID"));
                
                takePartIns.add(takePartIn);
            }          
        } catch (SQLException ex) {
            Logger.getLogger(TakePartInDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return takePartIns;
    }
    
    
    public void addTakePartIn(TakePartInModel takePartIn) {
        Connection connection = JDBCConnection.getJDBConnection();
        
        String sql = "INSERT INTO `takesPartIn`(TID, MID, PID) VALUE (?,?,?)";
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, takePartIn.gettID());
            preparedStatement.setString(2, takePartIn.getmID());
            preparedStatement.setString(3, takePartIn.getpID());
            
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException ex) {
            Logger.getLogger(TakePartInDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateTakePartIn(TakePartInModel takePartIn) {
        Connection connection = JDBCConnection.getJDBConnection();
        
        String sql = "UPDATE `takesPartIn` SET TID = ?,MID = ?,PID = ?"
                + "WHERE TID = ? AND MID = ? AND PID = ?";
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setString(1, takePartIn.gettID());
            preparedStatement.setString(2, takePartIn.getmID());
            preparedStatement.setString(3, takePartIn.getpID());
            preparedStatement.setString(4, takePartIn.gettID());
            preparedStatement.setString(5, takePartIn.getmID());
            preparedStatement.setString(6, takePartIn.getpID());
            
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException ex) {
            Logger.getLogger(TakePartInDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deleteTakePartIn(String tid, String mid, String pid) {
        Connection connection = JDBCConnection.getJDBConnection();
        
        String sql = "DELETE FROM `takesPartIn` WHERE TID = ? AND MID = ? AND PID = ?";
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, tid);
            preparedStatement.setString(2, mid);
            preparedStatement.setString(3, pid);
            
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException ex) {
            Logger.getLogger(TakePartInDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public TakePartInModel getTakePartIn(String tid, String mid, String pid) {
        
        List<TakePartInModel> takePartIns = new ArrayList<TakePartInModel>();

        Connection connection = JDBCConnection.getJDBConnection();

        String sql = "SELECT * FROM `takesPartIn` WHERE TID = ? AND MID = ? AND PID = ?";
            
        try {    
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, tid);
            preparedStatement.setString(2, mid);
            preparedStatement.setString(3, pid);
            
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()) {
                TakePartInModel takePartIn = new TakePartInModel();
                
                takePartIn.settID(rs.getString("TID"));
                takePartIn.setmID(rs.getString("MID"));
                takePartIn.setpID(rs.getString("PID"));
                
                return takePartIn;
            }          
        } catch (SQLException ex) {
            Logger.getLogger(TakePartInDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
