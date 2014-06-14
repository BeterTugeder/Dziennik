/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.projekt5.models;

/**
 *
 * @author Kuba
 */
public class Ocena {
    public final int id;
    /*public Uczen uczen;
    public Przedmiot przedmiot;
    public Kolumna kolumna;*/
    public int ocena;

    
    public Ocena(int id, int ocena) {
        this.id = id;
        this.ocena = ocena;
    }
    
}