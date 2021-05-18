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
import model.LeagueModel;

/**
 *
 * @author kieuvantuyen01
 */
public class LeagueDao {
    public List<LeagueModel> getAllLeagues() {
        
        List<LeagueModel> leagues = new ArrayList<LeagueModel>();

        Connection connection = JDBCConnection.getJDBConnection();

        String sql = "SELECT * FROM league";
            
        try {    
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()) {
                LeagueModel league = new LeagueModel();
                
                league.setId(rs.getString("ID"));
                league.setName(rs.getString("Name"));
                league.setDays(rs.getInt("Days"));
                
                leagues.add(league);
            }          
        } catch (SQLException ex) {
            Logger.getLogger(LeagueDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return leagues;
    }
    
    
    public void addLeague(LeagueModel league) {
        Connection connection = JDBCConnection.getJDBConnection();
        
        String sql = "INSERT INTO league(ID, Name, Days) VALUE (?,?,?)";
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, league.getId());
            preparedStatement.setString(2, league.getName());
            preparedStatement.setInt(3, league.getDays());
            
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException ex) {
            Logger.getLogger(LeagueDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateLeague(LeagueModel league) {
        Connection connection = JDBCConnection.getJDBConnection();
        
        String sql = "UPDATE league SET Name = ?,Days = ? WHERE ID = ?";
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setString(1, league.getName());
            preparedStatement.setInt(2, league.getDays());
            preparedStatement.setString(3, league.getId());
            
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException ex) {
            Logger.getLogger(LeagueDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deleteLeague(String Id) {
        Connection connection = JDBCConnection.getJDBConnection();
        
        String sql = "DELETE FROM league WHERE ID = ?";
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, Id);
            
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException ex) {
            Logger.getLogger(LeagueDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public LeagueModel getLeague(String ssn) {
        
        List<LeagueModel> leagues = new ArrayList<LeagueModel>();

        Connection connection = JDBCConnection.getJDBConnection();

        String sql = "SELECT * FROM league WHERE ID = ?";
            
        try {    
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, ssn);
            
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()) {
                LeagueModel league = new LeagueModel();
                
                league.setId(rs.getString("ID"));
                league.setName(rs.getString("Name"));
                league.setDays(rs.getInt("Days"));
                
                return league;
            }          
        } catch (SQLException ex) {
            Logger.getLogger(LeagueDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
