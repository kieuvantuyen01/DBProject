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
import model.GathersModel;

/**
 *
 * @author kieuvantuyen01
 */
public class GathersDao {
    public List<GathersModel> getAllGatherss() {
        
        List<GathersModel> gatherss = new ArrayList<GathersModel>();

        Connection connection = JDBCConnection.getJDBConnection();

        String sql = "SELECT * FROM `gathers`";
            
        try {    
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()) {
                GathersModel gathers = new GathersModel();
                
                gathers.setpID(rs.getString("PID"));
                gathers.settID(rs.getString("TID"));
                gathers.setName(rs.getString("Name"));
                gathers.setDate(rs.getString("Date"));
                gathers.setLocation(rs.getString("Location"));
                
                gatherss.add(gathers);
            }          
        } catch (SQLException ex) {
            Logger.getLogger(GathersDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return gatherss;
    }
    
    
    public void addGathers(GathersModel gathers) {
        Connection connection = JDBCConnection.getJDBConnection();
        
        String sql = "INSERT INTO `gathers`(PID, TID, Name, Date, Location) VALUE (?,?,?,?,?)";
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, gathers.getpID());
            preparedStatement.setString(2, gathers.gettID());
            preparedStatement.setString(3, gathers.getName());
            preparedStatement.setString(4, gathers.getDate());
            preparedStatement.setString(5, gathers.getLocation());
            
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException ex) {
            Logger.getLogger(GathersDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateGathers(GathersModel gathers) {
        Connection connection = JDBCConnection.getJDBConnection();
        
        String sql = "UPDATE `gathers` SET Name = ?,Date = ?,"
                + "Location = ? WHERE PID = ? AND TID = ?";
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setString(1, gathers.getName());
            preparedStatement.setString(2, gathers.getDate());
            preparedStatement.setString(3, gathers.getLocation());
            preparedStatement.setString(4, gathers.getpID());
            preparedStatement.setString(5, gathers.gettID());
            
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException ex) {
            Logger.getLogger(GathersDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deleteGathers(String pid, String tid) {
        Connection connection = JDBCConnection.getJDBConnection();
        
        String sql = "DELETE FROM `gathers` WHERE PID = ? AND TID = ?";
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, pid);
            preparedStatement.setString(2, tid);
            
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException ex) {
            Logger.getLogger(GathersDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public GathersModel getGathers(String pid, String tid) {
        
        List<GathersModel> gatherss = new ArrayList<GathersModel>();

        Connection connection = JDBCConnection.getJDBConnection();

        String sql = "SELECT * FROM `gathers` WHERE PID = ? AND TID = ?";
            
        try {    
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, pid);
            preparedStatement.setString(2, tid);
            
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()) {
                GathersModel gathers = new GathersModel();
                
                gathers.setpID(rs.getString("PID"));
                gathers.settID(rs.getString("TID"));
                gathers.setName(rs.getString("Name"));
                gathers.setDate(rs.getString("Date"));
                gathers.setLocation(rs.getString("Location"));
                
                return gathers;
            }          
        } catch (SQLException ex) {
            Logger.getLogger(GathersDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
