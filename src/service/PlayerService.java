/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.JDBCConnection;
import dao.PlayerDao;
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
public class PlayerService {
    private PlayerDao playerDao;
    
    public PlayerService() {
        playerDao = new PlayerDao();
    }
    
    public List<PlayerModel> getAllPlayers() {
        return playerDao.getAllPlayers();
    }
    
    public void addPlayer(PlayerModel player) {
        playerDao.addPlayer(player);
    }
    
    public void deletePlayer(String Ssn) {
        playerDao.deletePlayer(Ssn);
    }
    
    public PlayerModel getPlayer(String ssn) {
        return playerDao.getPlayer(ssn);
    }
    
    public void updatePlayer(PlayerModel player) {
        playerDao.updatePlayer(player);
    }
}
