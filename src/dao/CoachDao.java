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
import model.CoachModel;

/**
 *
 * @author kieuvantuyen01
 */
public class CoachDao {
    public List<CoachModel> getAllCoachs() {
        
        List<CoachModel> coachs = new ArrayList<CoachModel>();

        Connection connection = JDBCConnection.getJDBConnection();

        String sql = "SELECT * FROM coach";
            
        try {    
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()) {
                CoachModel coach = new CoachModel();
                
                coach.setSsn(rs.getString("SSN"));
                coach.setNationality(rs.getString("Nationality"));
                coach.setPosition(rs.getString("Position"));
                coach.setMatchNumbers(rs.getInt("MatchNumbers"));
                coach.setBidAmount(rs.getInt("BidAmount"));
                
                coachs.add(coach);
            }          
        } catch (SQLException ex) {
            Logger.getLogger(CoachDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return coachs;
    }
    
    
    public void addCoach(CoachModel coach) {
        Connection connection = JDBCConnection.getJDBConnection();
        
        String sql = "INSERT INTO coach(SSN, Nationality, Position, MatchNumbers, "
                + "BidAmount) VALUE (?,?,?,?,?)";
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, coach.getSsn());
            preparedStatement.setString(2, coach.getNationality());
            preparedStatement.setString(3, coach.getPosition());
            preparedStatement.setInt(4, coach.getMatchNumbers());
            preparedStatement.setInt(5, coach.getBidAmount());
            
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException ex) {
            Logger.getLogger(CoachDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateCoach(CoachModel coach) {
        Connection connection = JDBCConnection.getJDBConnection();
        
        String sql = "UPDATE coach SET Nationality = ?,Position = ?,"
                + "MatchNumbers = ?,BidAmount = ? WHERE SSN = ?";
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setString(1, coach.getNationality());
            preparedStatement.setString(2, coach.getPosition());
            preparedStatement.setInt(3, coach.getMatchNumbers());
            preparedStatement.setInt(4, coach.getBidAmount());
            preparedStatement.setString(5, coach.getSsn());
            
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException ex) {
            Logger.getLogger(CoachDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deleteCoach(String Ssn) {
        Connection connection = JDBCConnection.getJDBConnection();
        
        String sql = "DELETE FROM coach WHERE SSN = ?";
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, Ssn);
            
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException ex) {
            Logger.getLogger(CoachDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public CoachModel getCoach(String ssn) {
        
        List<CoachModel> coachs = new ArrayList<CoachModel>();

        Connection connection = JDBCConnection.getJDBConnection();

        String sql = "SELECT * FROM coach WHERE SSN = ?";
            
        try {    
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, ssn);
            
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()) {
                CoachModel coach = new CoachModel();
                
                coach.setSsn(rs.getString("SSN"));
                coach.setNationality(rs.getString("Nationality"));
                coach.setPosition(rs.getString("Position"));
                coach.setMatchNumbers(rs.getInt("MatchNumbers"));
                coach.setBidAmount(rs.getInt("BidAmount"));
                
                return coach;
            }          
        } catch (SQLException ex) {
            Logger.getLogger(CoachDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
