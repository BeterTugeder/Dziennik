/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.projekt5.models;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import pl.projekt5.handlers.ExceptionHandler;
import static pl.projekt5.models.UczenModel.conn;

/**
 *
 * @author Kuba
 */
public class NauczycielModel implements Model {
    
    static Connection conn = null;

    public void initializeModel(Connection c) {
        conn = c;
    }
    
    public void add(Nauczyciel n, String haslo) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA1");
        }catch(NoSuchAlgorithmException e) {
            ExceptionHandler.handle(e, ExceptionHandler.MESSAGE);
        } 
        try {
            haslo = new String( md.digest(haslo.getBytes("UTF-8")) );
        }catch(UnsupportedEncodingException e) {
            ExceptionHandler.handle(e, ExceptionHandler.MESSAGE);
        } 
        
        PreparedStatement stmt;
        try {
            stmt = conn.prepareStatement("INSERT INTO nauczyciele(imie, nazwisko, klasy_id, haslo) VALUES (?, ?, ?, ?)");
            //stmt.executeUpdate();
            stmt.setString(1, n.imie);
            stmt.setString(2, n.nazwisko);
            stmt.setInt(3, n.klasa.id);
            stmt.setString(4, haslo);
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            ExceptionHandler.handle(e, ExceptionHandler.MESSAGE);
        }
    }
    
    public List<Nauczyciel> getAll() {
        Statement stmt;
        ResultSet rs;
        List result = new ArrayList<Nauczyciel>();
        try {
            stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery("SELECT nauczyciele_id, imie, nazwisko, klasy.klasy_id, nazwa FROM nauczyciele, klasy WHERE klasy.klasy_id=nauczyciele.klasy_id");
            while(rs.next()) {
                result.add( new Nauczyciel(rs.getInt(1), rs.getString(2), rs.getString(3), new Klasa( rs.getInt(4), rs.getString(5) ) )) ;
            }
        } catch (SQLException e) {
            ExceptionHandler.handle(e, ExceptionHandler.MESSAGE);
        }
        return result;
    }
    
    public Nauczyciel get(int id) {
        Statement stmt;
        ResultSet rs;
        Nauczyciel result = null;
        try {
            stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery("SELECT nauczyciele_id, imie, nazwisko, klasy_id, nazwa FROM nauczyciele, klasy WHERE klasy.klasy_id=nauczyciele.klasy_id AND uczniowie_id=" + id + " LIMIT 1");
            if(rs.next()) { //jezeli wynik pusty, to metoda zwraca null
                result = new Nauczyciel(rs.getInt(1), rs.getString(2), rs.getString(3), new Klasa( rs.getInt(4), rs.getString(5) ) );
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
            stmt.executeUpdate("DELETE FROM nauczyciele");
            stmt.close();
        } catch (SQLException e) {
            ExceptionHandler.handle(e, ExceptionHandler.MESSAGE);
        }
    }

    public void update(Nauczyciel n) {
        PreparedStatement stmt;
        try {
            stmt = conn.prepareStatement("UPDATE nauczyciele SET imie=?, nazwisko=?, klasy_id=? WHERE nauczyciele_id=?");
            //stmt.executeUpdate();
            stmt.setString(1, n.imie);
            stmt.setString(2, n.nazwisko);
            stmt.setInt(3, n.klasa.id);
            stmt.setInt(4, n.id);
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            ExceptionHandler.handle(e, ExceptionHandler.MESSAGE);
        }
    }

    public void delete(Nauczyciel n) {
        Statement stmt;
        try {
            stmt = conn.createStatement();
            stmt.executeUpdate("DELETE FROM nauczyciele WHERE nauczyciele_id=" + n.id);
            stmt.close();
        } catch (SQLException e) {
            ExceptionHandler.handle(e, ExceptionHandler.MESSAGE);
        }
    }
    
}
