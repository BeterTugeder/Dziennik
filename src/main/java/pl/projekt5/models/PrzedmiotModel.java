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
public class PrzedmiotModel implements Model {
    
    static Connection conn = null;

    public void initializeModel(Connection c) {
        conn = c;
    }
    
    public void add(Przedmiot p) {
        PreparedStatement stmt;
        try {
            stmt = conn.prepareStatement("INSERT INTO przedmioty(nazwa) VALUES (?)");
            //stmt.executeUpdate();
            stmt.setString(1, p.nazwa);
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            ExceptionHandler.handle(e, ExceptionHandler.MESSAGE);
        }
    }
    
    public void add(Przedmiot p, int nauczyciel) {
        PreparedStatement stmt;
        try {
            stmt = conn.prepareStatement("INSERT INTO przedmioty(nazwa, nauczyciele_id) VALUES (?, ?)");
            //stmt.executeUpdate();
            stmt.setString(1, p.nazwa);
            stmt.setInt(2, nauczyciel);
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            ExceptionHandler.handle(e, ExceptionHandler.MESSAGE);
        }
    }
    
    public List<Przedmiot> getAll() {
        Statement stmt;
        ResultSet rs;
        List result = new ArrayList<Przedmiot>();
        try {
            stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery("SELECT przedmioty_id, nazwa FROM przedmioty");
            while(rs.next()) {
                result.add( new Przedmiot(rs.getInt(1), rs.getString(2) )) ;
            }
        } catch (SQLException e) {
            ExceptionHandler.handle(e, ExceptionHandler.MESSAGE);
        }
        return result;
    }
    
    public Przedmiot get(int id) {
        Statement stmt;
        ResultSet rs;
        Przedmiot result = null;
        try {
            stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery("SELECT przedmioty_id, nazwa FROM przedmioty WHERE przedmioty_id=" + id + " LIMIT 1");
            if(rs.next()) { //jezeli wynik pusty, to metoda zwraca null
                result = new Przedmiot(rs.getInt(1), rs.getString(2) );
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
            stmt.executeUpdate("DELETE FROM przedmioty");
            stmt.close();
        } catch (SQLException e) {
            ExceptionHandler.handle(e, ExceptionHandler.MESSAGE);
        }
    }

    public void update(Przedmiot p) {
        PreparedStatement stmt;
        try {
            stmt = conn.prepareStatement("UPDATE przedmioty SET nazwa=? WHERE przedmioty_id=?");
            //stmt.executeUpdate();
            stmt.setString(1, p.nazwa);
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            ExceptionHandler.handle(e, ExceptionHandler.MESSAGE);
        }
    }

    public void update(Przedmiot p, int nauczyciel) {
        PreparedStatement stmt;
        try {
            stmt = conn.prepareStatement("UPDATE przedmioty SET nazwa=?, nauczyciele_id=? WHERE przedmioty_id=?");
            //stmt.executeUpdate();
            stmt.setString(1, p.nazwa);
            stmt.setInt(2, nauczyciel);
            stmt.setInt(3, p.id);
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            ExceptionHandler.handle(e, ExceptionHandler.MESSAGE);
        }
    }

    public void delete(Przedmiot p) {
        Statement stmt;
        try {
            stmt = conn.createStatement();
            stmt.executeUpdate("DELETE FROM przedmioty WHERE przedmioty_id=" + p.id);
            stmt.close();
        } catch (SQLException e) {
            ExceptionHandler.handle(e, ExceptionHandler.MESSAGE);
        }
    }
    
}
