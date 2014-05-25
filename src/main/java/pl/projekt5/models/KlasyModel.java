/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.projekt5.models;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import pl.projekt5.handlers.ExceptionHandler;

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
        Statement stmt;
        try {
            stmt = conn.createStatement();
            stmt.executeUpdate("insert into klasy(nazwa) values (\"" + nazwa + "\")");
            stmt.close();
        } catch (SQLException e) {
            ExceptionHandler.handle(e, ExceptionHandler.MESSAGE);
        }
    }
    
    public List<Klasa> get() {
        Statement stmt;
        ResultSet rs;
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
        Statement stmt;
        ResultSet rs;
        Klasa result = null;
        try {
            stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery("SELECT klasy_id, nazwa FROM klasy WHERE klasy_id=" + id + " LIMIT 1");
            if(rs.last()) { //jezeli wynik pusty, to metoda zwraca null
                result = new Klasa(rs.getInt(1), rs.getString(2));
            }
        } catch (SQLException e) {
            ExceptionHandler.handle(e, ExceptionHandler.MESSAGE);
        }
        return result;
    }
    
    public void truncate() {
        Statement stmt;
        try {
            stmt = conn.createStatement();
            stmt.executeUpdate("DELETE FROM klasy");
            stmt.close();
        } catch (SQLException e) {
            ExceptionHandler.handle(e, ExceptionHandler.MESSAGE);
        }
    }
    
    public void delete(int id) {
        Statement stmt;
        try {
            stmt = conn.createStatement();
            stmt.executeUpdate("DELETE FROM klasy WHERE klasy_id=" + id + " LIMIT 1");
            stmt.close();
        } catch (SQLException e) {
            ExceptionHandler.handle(e, ExceptionHandler.MESSAGE);
        }
    }
    
    public class Klasa {
        public final int id;
        public String nazwa;
        
        private Klasa(int id, String nazwa) {
            this.id = id;
            this.nazwa = nazwa;
        }
        
        public void update() {
            PreparedStatement stmt;
            try {
                stmt = conn.prepareStatement("UPDATE klasy SET nazwa=? WHERE klasy_id=?");
                //stmt.executeUpdate();
                stmt.setString(1, nazwa);
                stmt.setInt(2, id);
                stmt.executeUpdate();
                stmt.close();
            } catch (SQLException e) {
                ExceptionHandler.handle(e, ExceptionHandler.MESSAGE);
            }
        }
        
        public void delete() {
            Statement stmt;
            try {
                stmt = conn.createStatement();
                stmt.executeUpdate("DELETE FROM klasy WHERE klasy_id=" + id);
                stmt.close();
            } catch (SQLException e) {
                ExceptionHandler.handle(e, ExceptionHandler.MESSAGE);
            }
        }
    }
    
}
