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
import model.TeamModel;

/**
 *
 * @author kieuvantuyen01
 */
public class TeamDao {
    public List<TeamModel> getAllTeams() {
        
        List<TeamModel> teams = new ArrayList<TeamModel>();

        Connection connection = JDBCConnection.getJDBConnection();

        String sql = "SELECT * FROM team";
            
        try {    
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()) {
                TeamModel team = new TeamModel();
                
                team.setId(rs.getString("ID"));
                team.setName(rs.getString("Name"));
                team.setAchievement(rs.getString("Achievement"));
                team.setWin(rs.getInt("Win"));
                team.setDraw(rs.getInt("Draw"));
                team.setLoss(rs.getInt("Loss"));
                team.setCid(rs.getString("CID"));
                
                teams.add(team);
            }          
        } catch (SQLException ex) {
            Logger.getLogger(TeamDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return teams;
    }
    
    
    public void addTeam(TeamModel team) {
        Connection connection = JDBCConnection.getJDBConnection();
        
        String sql = "INSERT INTO team(ID, Name, Achievement, Win, "
                + "Draw, Loss, CID) VALUE (?,?,?,?,?,?,?)";
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, team.getId());
            preparedStatement.setString(2, team.getName());
            preparedStatement.setString(3, team.getAchievement());
            preparedStatement.setInt(4, team.getWin());
            preparedStatement.setInt(5, team.getDraw());
            preparedStatement.setInt(6, team.getLoss());
            preparedStatement.setString(7, team.getCid());
            
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException ex) {
            Logger.getLogger(TeamDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateTeam(TeamModel team) {
        Connection connection = JDBCConnection.getJDBConnection();
        
        String sql = "UPDATE team SET Name = ?,Achievement = ?,"
                + "Win = ?,Draw = ?,Loss = ?,`CID` = ? WHERE ID = ?";
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setString(1, team.getName());
            preparedStatement.setString(2, team.getAchievement());
            preparedStatement.setInt(3, team.getWin());
            preparedStatement.setInt(4, team.getDraw());
            preparedStatement.setInt(5, team.getLoss());
            preparedStatement.setString(6, team.getCid());
            preparedStatement.setString(7, team.getId());
            
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException ex) {
            Logger.getLogger(TeamDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deleteTeam(String Id) {
        Connection connection = JDBCConnection.getJDBConnection();
        
        String sql = "DELETE FROM team WHERE ID = ?";
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, Id);
            
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException ex) {
            Logger.getLogger(TeamDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public TeamModel getTeam(String ssn) {
        
        List<TeamModel> teams = new ArrayList<TeamModel>();

        Connection connection = JDBCConnection.getJDBConnection();

        String sql = "SELECT * FROM team WHERE ID = ?";
            
        try {    
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, ssn);
            
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()) {
                TeamModel team = new TeamModel();
                
                team.setId(rs.getString("ID"));
                team.setName(rs.getString("Name"));
                team.setAchievement(rs.getString("Achievement"));
                team.setWin(rs.getInt("Win"));
                team.setDraw(rs.getInt("Draw"));
                team.setLoss(rs.getInt("Loss"));
                team.setCid(rs.getString("CID"));
                
                return team;
            }          
        } catch (SQLException ex) {
            Logger.getLogger(TeamDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
