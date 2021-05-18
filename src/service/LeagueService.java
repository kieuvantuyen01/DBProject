/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.JDBCConnection;
import dao.LeagueDao;
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
public class LeagueService {
    private LeagueDao leagueDao;
    
    public LeagueService() {
        leagueDao = new LeagueDao();
    }
    
    public List<LeagueModel> getAllLeagues() {
        return leagueDao.getAllLeagues();
    }
    
    public void addLeague(LeagueModel league) {
        leagueDao.addLeague(league);
    }
    
    public void deleteLeague(String Ssn) {
        leagueDao.deleteLeague(Ssn);
    }
    
    public LeagueModel getLeague(String ssn) {
        return leagueDao.getLeague(ssn);
    }
    
    public void updateLeague(LeagueModel league) {
        leagueDao.updateLeague(league);
    }
}
