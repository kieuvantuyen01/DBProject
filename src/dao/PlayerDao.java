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
import model.PlayerModel;

/**
 *
 * @author kieuvantuyen01
 */
public class PlayerDao {
    public List<PlayerModel> getAllPlayers() {
        
        List<PlayerModel> players = new ArrayList<PlayerModel>();

        Connection connection = JDBCConnection.getJDBConnection();

        String sql = "SELECT * FROM player";
            
        try {    
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()) {
                PlayerModel player = new PlayerModel();
                
                player.setSsn(rs.getString("SSN"));
                player.setClubName(rs.getString("ClubName"));
                player.setPosition(rs.getString("Position"));
                player.setShirtNumber(rs.getInt("ShirtNumber"));
                player.setWeight(rs.getInt("Weight"));
                player.setHeight(rs.getInt("Height"));
                player.setCondition(rs.getString("Condition"));
                player.setGoalNumbers(rs.getInt("GoalNumbers"));
                player.setMatchNumbers(rs.getInt("MatchNumbers"));
                player.setPenaltyCards(rs.getInt("PenaltyCards"));
                player.setBidAmount(rs.getInt("BidAmount"));
                
                players.add(player);
            }          
        } catch (SQLException ex) {
            Logger.getLogger(PlayerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return players;
    }
    
    
    public void addPlayer(PlayerModel player) {
        Connection connection = JDBCConnection.getJDBConnection();
        
        String sql = "INSERT INTO player(SSN, ClubName, Position, ShirtNumber, "
                + "Weight, Height, Condition, GoalNumbers, "
                + "MatchNumbers, PenaltyCards, BidAmount) VALUE (?,?,?,?,?,?,?,?,?,?,?)";
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, player.getSsn());
            preparedStatement.setString(2, player.getClubName());
            preparedStatement.setString(3, player.getPosition());
            preparedStatement.setInt(4, player.getShirtNumber());
            preparedStatement.setInt(5, player.getWeight());
            preparedStatement.setInt(6, player.getHeight());
            preparedStatement.setString(7, player.getCondition());
            preparedStatement.setInt(8, player.getGoalNumbers());
            preparedStatement.setInt(9, player.getMatchNumbers());
            preparedStatement.setInt(10, player.getPenaltyCards());
            preparedStatement.setInt(11, player.getBidAmount());
            
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException ex) {
            Logger.getLogger(PlayerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updatePlayer(PlayerModel player) {
        Connection connection = JDBCConnection.getJDBConnection();
        
        String sql = "UPDATE player SET ClubName = ?,Position = ?,"
                + "ShirtNumber = ?,Weight = ?,Height = ?,`Condition` = ?,GoalNumbers = ?,"
                + "MatchNumbers = ?,PenaltyCards = ?,BidAmount = ? WHERE SSN = ?";
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setString(1, player.getClubName());
            preparedStatement.setString(2, player.getPosition());
            preparedStatement.setInt(3, player.getShirtNumber());
            preparedStatement.setInt(4, player.getWeight());
            preparedStatement.setInt(5, player.getHeight());
            preparedStatement.setString(6, player.getCondition());
            preparedStatement.setInt(7, player.getGoalNumbers());
            preparedStatement.setInt(8, player.getMatchNumbers());
            preparedStatement.setInt(9, player.getPenaltyCards());
            preparedStatement.setInt(10, player.getBidAmount());
            preparedStatement.setString(11, player.getSsn());
            
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException ex) {
            Logger.getLogger(PlayerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deletePlayer(String Ssn) {
        Connection connection = JDBCConnection.getJDBConnection();
        
        String sql = "DELETE FROM player WHERE SSN = ?";
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, Ssn);
            
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException ex) {
            Logger.getLogger(PlayerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public PlayerModel getPlayer(String ssn) {
        
        List<PlayerModel> players = new ArrayList<PlayerModel>();

        Connection connection = JDBCConnection.getJDBConnection();

        String sql = "SELECT * FROM player WHERE SSN = ?";
            
        try {    
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, ssn);
            
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()) {
                PlayerModel player = new PlayerModel();
                
                player.setSsn(rs.getString("SSN"));
                player.setClubName(rs.getString("ClubName"));
                player.setPosition(rs.getString("Position"));
                player.setShirtNumber(rs.getInt("ShirtNumber"));
                player.setWeight(rs.getInt("Weight"));
                player.setHeight(rs.getInt("Height"));
                player.setCondition(rs.getString("Condition"));
                player.setGoalNumbers(rs.getInt("GoalNumbers"));
                player.setMatchNumbers(rs.getInt("MatchNumbers"));
                player.setPenaltyCards(rs.getInt("PenaltyCards"));
                player.setBidAmount(rs.getInt("BidAmount"));
                
                return player;
            }          
        } catch (SQLException ex) {
            Logger.getLogger(PlayerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
