/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.projekt5.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import pl.projekt5.handlers.ExceptionHandler;

/**
 *
 * @author Kuba
 */
public class KolumnaModel implements Model {
    
    static Connection conn = null;

    public void initializeModel(Connection c) {
        conn = c;
    }
    
    public void add(Kolumna k) {
        PreparedStatement stmt;
        try {
            stmt = conn.prepareStatement("INSERT INTO kolumny(nazwa) VALUES (?)");
            //stmt.executeUpdate();
            stmt.setString(1, k.nazwa);
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            ExceptionHandler.handle(e, ExceptionHandler.MESSAGE);
        }
    }
    
    public void add(Kolumna k, int przedmiot, int klasa) {
        PreparedStatement stmt;
        try {
            stmt = conn.prepareStatement("INSERT INTO kolumny(nazwa, przedmioty_id, klasy_id) VALUES (?, ?, ?)");
            //stmt.executeUpdate();
            stmt.setString(1, k.nazwa);
            stmt.setInt(2, przedmiot);
            stmt.setInt(3, klasa);
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            ExceptionHandler.handle(e, ExceptionHandler.MESSAGE);
        }
    }
    
    public List<Kolumna> getAll() {
        Statement stmt;
        ResultSet rs;
        List result = new ArrayList<Kolumna>();
        try {
            stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery("SELECT kolumny_id, nazwa FROM kolumny");
            while(rs.next()) {
                result.add( new Kolumna(rs.getInt(1), rs.getString(2) )) ;
            }
        } catch (SQLException e) {
            ExceptionHandler.handle(e, ExceptionHandler.MESSAGE);
        }
        return result;
    }
    
    public Kolumna get(int id) {
        Statement stmt;
        ResultSet rs;
        Kolumna result = null;
        try {
            stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery("SELECT kolumny_id, nazwa FROM kolumny WHERE kolumny_id=" + id + " LIMIT 1");
            if(rs.next()) { //jezeli wynik pusty, to metoda zwraca null
                result = new Kolumna(rs.getInt(1), rs.getString(2) );
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
            stmt.executeUpdate("DELETE FROM kolumny");
            stmt.close();
        } catch (SQLException e) {
            ExceptionHandler.handle(e, ExceptionHandler.MESSAGE);
        }
    }

    public void update(Kolumna k) {
        PreparedStatement stmt;
        try {
            stmt = conn.prepareStatement("UPDATE kolumny SET nazwa=? WHERE kolumny_id=?");
            //stmt.executeUpdate();
            stmt.setString(1, k.nazwa);
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            ExceptionHandler.handle(e, ExceptionHandler.MESSAGE);
        }
    }

    public void update(Kolumna k, int przedmiot, int klasa) {
        PreparedStatement stmt;
        try {
            stmt = conn.prepareStatement("UPDATE kolumny SET nazwa=?, przedmioty_id=?, klasy_id=? WHERE kolumny_id=?");
            //stmt.executeUpdate();
            stmt.setString(1, k.nazwa);
            stmt.setInt(2, przedmiot);
            stmt.setInt(3, klasa);
            stmt.setInt(4, k.id);
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            ExceptionHandler.handle(e, ExceptionHandler.MESSAGE);
        }
    }

    public void delete(Kolumna p) {
        Statement stmt;
        try {
            stmt = conn.createStatement();
            stmt.executeUpdate("DELETE FROM kolumny WHERE kolumny_id=" + p.id);
            stmt.close();
        } catch (SQLException e) {
            ExceptionHandler.handle(e, ExceptionHandler.MESSAGE);
        }
    }
}
