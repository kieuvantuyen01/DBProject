/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.JDBCConnection;
import dao.MatchDao;
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
public class MatchService {
    private MatchDao matchDao;
    
    public MatchService() {
        matchDao = new MatchDao();
    }
    
    public List<MatchModel> getAllMatchs() {
        return matchDao.getAllMatchs();
    }
    
    public void addMatch(MatchModel match) {
        matchDao.addMatch(match);
    }
    
    public void deleteMatch(String mid, String lid) {
        matchDao.deleteMatch(mid, lid);
    }
    
    public MatchModel getMatch(String mid, String lid) {
        return matchDao.getMatch(mid, lid);
    }
    
    public void updateMatch(MatchModel match) {
        matchDao.updateMatch(match);
    }
}
