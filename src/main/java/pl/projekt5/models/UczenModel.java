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
public class UczenModel implements Model {
    
    static Connection conn = null;

    public void initializeModel(Connection c) {
        conn = c;
    }
    
    public void add(Uczen u) {
        PreparedStatement stmt;
        try {
            stmt = conn.prepareStatement("INSERT INTO uczniowie(imie, nazwisko) VALUES (?, ?)");
            //stmt.executeUpdate();
            stmt.setString(1, u.imie);
            stmt.setString(2, u.nazwisko);
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            ExceptionHandler.handle(e, ExceptionHandler.MESSAGE);
        }
    }
    
    public void add(Uczen u, int klasa) {
        PreparedStatement stmt;
        try {
            stmt = conn.prepareStatement("INSERT INTO uczniowie(imie, nazwisko, klasy_id) VALUES (?, ?, ?)");
            //stmt.executeUpdate();
            stmt.setString(1, u.imie);
            stmt.setString(2, u.nazwisko);
            stmt.setInt(3, klasa);
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            ExceptionHandler.handle(e, ExceptionHandler.MESSAGE);
        }
    }
    
    public List<Uczen> getAll() {
        Statement stmt;
        ResultSet rs;
        List result = new ArrayList<Uczen>();
        try {
            stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery("SELECT uczniowie_id, imie, nazwisko FROM uczniowie");
            while(rs.next()) {
                result.add( new Uczen(rs.getInt(1), rs.getString(2), rs.getString(3) )) ;
            }
        } catch (SQLException e) {
            ExceptionHandler.handle(e, ExceptionHandler.MESSAGE);
        }
        return result;
    }
    
    public List<Uczen> getAll(int klasa) {
        Statement stmt;
        ResultSet rs;
        List result = new ArrayList<Uczen>();
        try {
            stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery("SELECT uczniowie_id, imie, nazwisko FROM uczniowie WHERE klasy_id=" + klasa);
            while(rs.next()) {
                result.add( new Uczen(rs.getInt(1), rs.getString(2), rs.getString(3) )) ;
            }
        } catch (SQLException e) {
            ExceptionHandler.handle(e, ExceptionHandler.MESSAGE);
        }
        return result;
    }
    
    public Uczen get(int id) {
        Statement stmt;
        ResultSet rs;
        Uczen result = null;
        try {
            stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery("SELECT uczniowie_id, imie, nazwisko FROM uczniowie WHERE uczniowie_id=" + id + " LIMIT 1");
            if(rs.next()) { //jezeli wynik pusty, to metoda zwraca null
                result = new Uczen(rs.getInt(1), rs.getString(2), rs.getString(3) );
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
            stmt.executeUpdate("DELETE FROM uczniowie");
            stmt.close();
        } catch (SQLException e) {
            ExceptionHandler.handle(e, ExceptionHandler.MESSAGE);
        }
    }

    public void update(Uczen u) {
        PreparedStatement stmt;
        try {
            stmt = conn.prepareStatement("UPDATE uczniowie SET imie=?, nazwisko=? WHERE uczniowie_id=?");
            //stmt.executeUpdate();
            stmt.setString(1, u.imie);
            stmt.setString(2, u.nazwisko);
            stmt.setInt(3, u.id);
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            ExceptionHandler.handle(e, ExceptionHandler.MESSAGE);
        }
    }

    public void update(Uczen u, int klasa) {
        PreparedStatement stmt;
        try {
            stmt = conn.prepareStatement("UPDATE uczniowie SET imie=?, nazwisko=?, klasy_id=? WHERE uczniowie_id=?");
            //stmt.executeUpdate();
            stmt.setString(1, u.imie);
            stmt.setString(2, u.nazwisko);
            stmt.setInt(3, klasa);
            stmt.setInt(4, u.id);
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            ExceptionHandler.handle(e, ExceptionHandler.MESSAGE);
        }
    }

    public void delete(Uczen u) {
        Statement stmt;
        try {
            stmt = conn.createStatement();
            stmt.executeUpdate("DELETE FROM uczniowie WHERE uczniowie_id=" + u.id);
            stmt.close();
        } catch (SQLException e) {
            ExceptionHandler.handle(e, ExceptionHandler.MESSAGE);
        }
    }
    
}
