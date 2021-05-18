/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.JDBCConnection;
import dao.GathersDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.GathersModel;

/**
 *
 * @author kieuvantuyen01
 */
public class GathersService {
    private GathersDao gathersDao;
    
    public GathersService() {
        gathersDao = new GathersDao();
    }
    
    public List<GathersModel> getAllGatherss() {
        return gathersDao.getAllGatherss();
    }
    
    public void addGathers(GathersModel gathers) {
        gathersDao.addGathers(gathers);
    }
    
    public void deleteGathers(String pid, String tid) {
        gathersDao.deleteGathers(pid, tid);
    }
    
    public GathersModel getGathers(String pid, String tid) {
        return gathersDao.getGathers(pid, tid);
    }
    
    public void updateGathers(GathersModel gathers) {
        gathersDao.updateGathers(gathers);
    }
}
