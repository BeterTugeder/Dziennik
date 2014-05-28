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
public class Uczen {
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
}
