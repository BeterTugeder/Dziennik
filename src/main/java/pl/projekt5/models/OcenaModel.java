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
public class OcenaModel implements Model {
    
    static Connection conn = null;

    public void initializeModel(Connection c) {
        conn = c;
       
    }
    
    public void add(Ocena o, int przedmiot, int uczen, int kolumna) {
        PreparedStatement stmt;
        try {
            stmt = conn.prepareStatement("INSERT INTO oceny(ocena, przedmioty_id, uczniowie_id, kolumny_id) VALUES (?,?,?,?)");
            //stmt.executeUpdate();
            stmt.setInt(1, o.ocena);
            stmt.setInt(2, przedmiot);
            stmt.setInt(3, uczen);
            stmt.setInt(4, kolumna);
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            ExceptionHandler.handle(e, ExceptionHandler.MESSAGE);
        }
    }
    
    public void addd(int o, int przedmiot, int uczen, int kolumna) {
        PreparedStatement stmt;
        try {
            stmt = conn.prepareStatement("INSERT INTO oceny(ocena, przedmioty_id, uczniowie_id, kolumny_id) VALUES (?,?,?,?)");
            //stmt.executeUpdate();
            stmt.setInt(1, o);
            stmt.setInt(2, przedmiot);
            stmt.setInt(3, uczen);
            stmt.setInt(4, kolumna);
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            ExceptionHandler.handle(e, ExceptionHandler.MESSAGE);
        }
    }
    
    public List<Ocena> getAll() {
        Statement stmt;
        ResultSet rs;
        List result = new ArrayList<Ocena>();
        try {
            stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery("SELECT oceny_id, ocena FROM oceny");
            while(rs.next()) {
                result.add( new Ocena(rs.getInt(1), rs.getInt(2))) ;
            }
        } catch (SQLException e) {
            ExceptionHandler.handle(e, ExceptionHandler.MESSAGE);
        }
        return result;
    }
    
    public List<Ocena> getAll(int przedmiot, int kolumna) {
        Statement stmt;
        ResultSet rs;
        List result = new ArrayList<Ocena>();
        try {
            stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery("SELECT oceny_id, ocena FROM oceny WHERE przedmioty_id="
                    + przedmiot + " and kolumny_id=" + kolumna);
            while(rs.next()) {
                result.add( new Ocena(rs.getInt(1), rs.getInt(2))) ;
            }
        } catch (SQLException e) {
            ExceptionHandler.handle(e, ExceptionHandler.MESSAGE);
        }
        return result;
    }
    
    public Ocena get(int id) {
        Statement stmt;
        ResultSet rs;
        Ocena result = null;
        try {
            stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery("SELECT oceny_id, ocena FROM oceny WHERE oceny_id=" + id + " LIMIT 1");
            if(rs.next()) { //jezeli wynik pusty, to metoda zwraca null
                result = new Ocena(rs.getInt(1), rs.getInt(2));
            }
        } catch (SQLException e) {
            ExceptionHandler.handle(e, ExceptionHandler.MESSAGE);
        }
        return result;
    }
    ////////////////
    public Ocena gett(int id_ucznia,int id_przedmiot,int id_kolumny) {
        Statement stmt;
        ResultSet rs;
        Ocena result = null;
        try {
            stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery("SELECT oceny_id, ocena FROM oceny WHERE uczniowie_id=" + id_ucznia + " and przedmioty_id="+id_przedmiot+
                    " and kolumny_id="+id_kolumny );
            if(rs.next()) { //jezeli wynik pusty, to metoda zwraca null
                result = new Ocena(rs.getInt(1), rs.getInt(2));
            }
        } catch (SQLException e) {
            ExceptionHandler.handle(e, ExceptionHandler.MESSAGE);
        }
        return result;
    }
    
    public void update(int ocena,int id_ucznia,int id_przedmiot,int id_kolumny) {
        PreparedStatement stmt;
        try {
            stmt = conn.prepareStatement("UPDATE oceny SET ocena=? WHERE uczniowie_id=? and przedmioty_id=? and kolumny_id=?");
            //stmt.executeUpdate();
            stmt.setInt(1, ocena);
            stmt.setInt(2, id_ucznia);
            stmt.setInt(3, id_przedmiot);
            stmt.setInt(4, id_kolumny);
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            ExceptionHandler.handle(e, ExceptionHandler.MESSAGE);
        }
    }
    
    public void truncate() {
        Statement stmt;
        try {
            stmt = conn.createStatement();
            stmt.executeUpdate("DELETE FROM oceny");
            stmt.close();
        } catch (SQLException e) {
            ExceptionHandler.handle(e, ExceptionHandler.MESSAGE);
        }
    }
        
    public void update(Ocena o) {
        PreparedStatement stmt;
        try {
            stmt = conn.prepareStatement("UPDATE oceny SET ocena=? WHERE oceny_id=?");
            //stmt.executeUpdate();
            stmt.setInt(1, o.ocena);
            stmt.setInt(2, o.id);
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            ExceptionHandler.handle(e, ExceptionHandler.MESSAGE);
        }
    }

    public void delete(Ocena o) {
        Statement stmt;
        try {
            stmt = conn.createStatement();
            stmt.executeUpdate("DELETE FROM oceny WHERE oceny_id=" + o.id);
            stmt.close();
        } catch (SQLException e) {
            ExceptionHandler.handle(e, ExceptionHandler.MESSAGE);
        }
    }
    
}
