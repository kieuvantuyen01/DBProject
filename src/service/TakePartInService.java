/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.JDBCConnection;
import dao.TakePartInDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.TakePartInModel;

/**
 *
 * @author kieuvantuyen01
 */
public class TakePartInService {
    private TakePartInDao takePartInDao;
    
    public TakePartInService() {
        takePartInDao = new TakePartInDao();
    }
    
    public List<TakePartInModel> getAllTakePartIns() {
        return takePartInDao.getAllTakePartIns();
    }
    
    public void addTakePartIn(TakePartInModel takePartIn) {
        takePartInDao.addTakePartIn(takePartIn);
    }
    
    public void deleteTakePartIn(String tid, String mid, String pid) {
        takePartInDao.deleteTakePartIn(tid, mid, pid);
    }
    
    public TakePartInModel getTakePartIn(String tid, String mid, String pid) {
        return takePartInDao.getTakePartIn(tid, mid, pid);
    }
    
    public void updateTakePartIn(TakePartInModel takePartIn) {
        takePartInDao.updateTakePartIn(takePartIn);
    }
}
