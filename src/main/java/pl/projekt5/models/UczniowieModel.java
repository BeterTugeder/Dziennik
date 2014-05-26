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
import pl.projekt5.models.KlasyModel.Klasa;

/**
 *
 * @author Kuba
 */
public class UczniowieModel implements Model {
    
    static Connection conn = null;

    public void initializeModel(Connection c) {
        conn = c;
    }
    
    public void add(String imie, String nazwisko, Klasa kl) {
        PreparedStatement stmt;
        try {
            stmt = conn.prepareStatement("INSERT INTO uczniowie(imie, nazwisko, klasy_id) VALUES (?, ?, ?)");
            //stmt.executeUpdate();
            stmt.setString(1, imie);
            stmt.setString(2, nazwisko);
            stmt.setInt(3, kl.id);
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            ExceptionHandler.handle(e, ExceptionHandler.MESSAGE);
        }
    }
    
    public List<Uczen> get() {
        Statement stmt;
        ResultSet rs;
        List result = new ArrayList<Uczen>();
        try {
            stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery("SELECT uczniowie_id, imie, nazwisko, klasy.klasy_id, nazwa FROM uczniowie, klasy WHERE klasy.klasy_id=uczniowie.klasy_id");
            while(rs.next()) {
                result.add( new Uczen(rs.getInt(1), rs.getString(2), rs.getString(3), new Klasa( rs.getInt(4), rs.getString(5) ) )) ;
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
            rs = stmt.executeQuery("SELECT uczniowie_id, imie, nazwisko, klasy_id, nazwa FROM uczniowie, klasy WHERE klasy.klasy_id=uczniowie.klasy_id AND uczniowie_id=" + id + " LIMIT 1");
            if(rs.next()) { //jezeli wynik pusty, to metoda zwraca null
                result = new Uczen(rs.getInt(1), rs.getString(2), rs.getString(3), new Klasa( rs.getInt(4), rs.getString(5) ) );
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
    
    public void delete(int id) {
        Statement stmt;
        try {
            stmt = conn.createStatement();
            stmt.executeUpdate("DELETE FROM uczniowie WHERE uczniowie_id=" + id);
            stmt.close();
        } catch (SQLException e) {
            ExceptionHandler.handle(e, ExceptionHandler.MESSAGE);
        }
    }
    
    public static class Uczen {
        public final int id;
        public String imie;
        public String nazwisko;
        public Klasa klasa;
        
        public Uczen(int id, String imie, String nazwisko, Klasa kl) {
            this.id = id;
            this.imie = imie;
            this.nazwisko = nazwisko;
            this.klasa = kl;
        }
        
        public void update() {
            PreparedStatement stmt;
            try {
                stmt = conn.prepareStatement("UPDATE uczniowie SET imie=?, nazwisko=?, klasy_id=? WHERE uczniowie_id=?");
                //stmt.executeUpdate();
                stmt.setString(1, imie);
                stmt.setString(2, nazwisko);
                stmt.setInt(3, klasa.id);
                stmt.setInt(4, id);
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
                stmt.executeUpdate("DELETE FROM uczniowie WHERE uczniowie_id=" + id);
                stmt.close();
            } catch (SQLException e) {
                ExceptionHandler.handle(e, ExceptionHandler.MESSAGE);
            }
        }
    }
    
}
