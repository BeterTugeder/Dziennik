/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.projekt5.models;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pl.projekt5.handlers.ExceptionHandler;
import pl.projekt5.handlers.LogHandler;

/**
 *
 * @author Kuba
 */
public class KlasyModel implements Model {
    
    Connection conn = null;

    public void initializeModel(Connection c) {
        conn = c;
    }
    
    public void add(String nazwa) {
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            stmt.executeUpdate("insert into klasy(nazwa) values (\"" + nazwa + "\")");
            stmt.close();
        } catch (SQLException e) {
            ExceptionHandler.handle(e, ExceptionHandler.MESSAGE);
        }
    }
    
    public List<Klasa> get() {
        Statement stmt = null;
        ResultSet rs = null;
        List result = new ArrayList<Klasa>();
        try {
            stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery("SELECT klasy_id, nazwa FROM klasy");
            while(rs.next()) {
                result.add( new Klasa(rs.getInt(1), rs.getString(2))) ;
            }
        } catch (SQLException e) {
            ExceptionHandler.handle(e, ExceptionHandler.MESSAGE);
        }
        return result;
    }
    
    public Klasa get(int id) {
        Statement stmt = null;
        ResultSet rs = null;
        Klasa result = null;
        try {
            stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery("SELECT klasy_id, nazwa FROM klasy WHERE klasy_id=" + id + " LIMIT 1");
            if(rs.last()) { //jezeli wynik pusty, to metoda zwraca null
                result = new Klasa(rs.getInt(0), rs.getString(1));
            }
        } catch (SQLException e) {
            ExceptionHandler.handle(e, ExceptionHandler.MESSAGE);
        }
        return result;
    }
    
    public void truncate() {
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            stmt.executeUpdate("DELETE FROM klasy");
            stmt.close();
        } catch (SQLException e) {
            ExceptionHandler.handle(e, ExceptionHandler.MESSAGE);
        }
    }
    
    public void delete(int id) {
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            stmt.executeUpdate("DELETE FROM klasy WHERE klasy_id=" + id + " LIMIT 1");
            stmt.close();
        } catch (SQLException e) {
            ExceptionHandler.handle(e, ExceptionHandler.MESSAGE);
        }
    }
    
    public class Klasa {
        private int id;
        public String nazwa;
        
        private Klasa(int id, String nazwa) {
            this.id = id;
            this.nazwa = nazwa;
        }
        
        public int getId() {//id niemodyfikowalne
            return id;
        }
        
        public void update() {
            nazwa = StringEscapeUtils.escape(nazwa);
            Statement stmt = null;
            try {
                stmt = conn.createStatement();
                stmt.executeUpdate("UPDATE klasy SET nazwa=\"" + nazwa + "\" WHERE klasy_id=" + id + " LIMIT 1");
                stmt.close();
            } catch (SQLException e) {
                ExceptionHandler.handle(e, ExceptionHandler.MESSAGE);
            }
        }
        
        public void delete() {
            Statement stmt = null;
            try {
                stmt = conn.createStatement();
                stmt.executeUpdate("DELETE FROM klasy WHERE klasy_id=" + id + " LIMIT 1");
                LogHandler.getInstance().add("DELETE FROM klasy WHERE klasy_id=" + id + " LIMIT 1");
                stmt.close();
            } catch (SQLException e) {
                ExceptionHandler.handle(e, ExceptionHandler.MESSAGE);
            }
        }
    }
    
}
