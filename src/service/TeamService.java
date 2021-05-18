/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.JDBCConnection;
import dao.TeamDao;
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
public class TeamService {
    private TeamDao teamDao;
    
    public TeamService() {
        teamDao = new TeamDao();
    }
    
    public List<TeamModel> getAllTeams() {
        return teamDao.getAllTeams();
    }
    
    public void addTeam(TeamModel team) {
        teamDao.addTeam(team);
    }
    
    public void deleteTeam(String Ssn) {
        teamDao.deleteTeam(Ssn);
    }
    
    public TeamModel getTeam(String ssn) {
        return teamDao.getTeam(ssn);
    }
    
    public void updateTeam(TeamModel team) {
        teamDao.updateTeam(team);
    }
}
