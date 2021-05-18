/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.JDBCConnection;
import dao.CoachDao;
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
public class CoachService {
    private CoachDao playerDao;
    
    public CoachService() {
        playerDao = new CoachDao();
    }
    
    public List<CoachModel> getAllCoachs() {
        return playerDao.getAllCoachs();
    }
    
    public void addCoach(CoachModel player) {
        playerDao.addCoach(player);
    }
    
    public void deleteCoach(String Ssn) {
        playerDao.deleteCoach(Ssn);
    }
    
    public CoachModel getCoach(String ssn) {
        return playerDao.getCoach(ssn);
    }
    
    public void updateCoach(CoachModel player) {
        playerDao.updateCoach(player);
    }
}
