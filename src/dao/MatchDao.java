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
import model.MatchModel;

/**
 *
 * @author kieuvantuyen01
 */
public class MatchDao {
    public List<MatchModel> getAllMatchs() {
        
        List<MatchModel> matchs = new ArrayList<MatchModel>();

        Connection connection = JDBCConnection.getJDBConnection();

        String sql = "SELECT * FROM `match`";
            
        try {    
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()) {
                MatchModel match = new MatchModel();
                
                match.setmId(rs.getString("MID"));
                match.setlId(rs.getString("LID"));
                match.setName(rs.getString("Name"));
                match.setStadium(rs.getString("Stadium"));
                match.setDate(rs.getString("Date"));
                
                matchs.add(match);
            }          
        } catch (SQLException ex) {
            Logger.getLogger(MatchDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return matchs;
    }
    
    
    public void addMatch(MatchModel match) {
        Connection connection = JDBCConnection.getJDBConnection();
        
        String sql = "INSERT INTO `match`(MID, LID, Name, Stadium, Date) VALUE (?,?,?,?,?)";
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, match.getmId());
            preparedStatement.setString(2, match.getlId());
            preparedStatement.setString(3, match.getName());
            preparedStatement.setString(4, match.getStadium());
            preparedStatement.setString(5, match.getDate());
            
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException ex) {
            Logger.getLogger(MatchDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateMatch(MatchModel match) {
        Connection connection = JDBCConnection.getJDBConnection();
        
        String sql = "UPDATE `match` SET Name = ?,Stadium = ?,"
                + "Date = ? WHERE MID = ? AND LID = ?";
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setString(1, match.getName());
            preparedStatement.setString(2, match.getStadium());
            preparedStatement.setString(3, match.getDate());
            preparedStatement.setString(4, match.getmId());
            preparedStatement.setString(5, match.getlId());
            
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException ex) {
            Logger.getLogger(MatchDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deleteMatch(String mid, String lid) {
        Connection connection = JDBCConnection.getJDBConnection();
        
        String sql = "DELETE FROM `match` WHERE MID = ? AND LID = ?";
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, mid);
            preparedStatement.setString(2, lid);
            
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException ex) {
            Logger.getLogger(MatchDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public MatchModel getMatch(String mid, String lid) {
        
        List<MatchModel> matchs = new ArrayList<MatchModel>();

        Connection connection = JDBCConnection.getJDBConnection();

        String sql = "SELECT * FROM `match` WHERE MID = ? AND LID = ?";
            
        try {    
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, mid);
            preparedStatement.setString(2, lid);
            
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()) {
                MatchModel match = new MatchModel();
                
                match.setmId(rs.getString("MID"));
                match.setlId(rs.getString("LID"));
                match.setName(rs.getString("Name"));
                match.setStadium(rs.getString("Stadium"));
                match.setDate(rs.getString("Date"));
                
                return match;
            }          
        } catch (SQLException ex) {
            Logger.getLogger(MatchDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
