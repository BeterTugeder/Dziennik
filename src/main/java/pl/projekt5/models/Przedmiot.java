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
public class Przedmiot {
    public final int id;
    public String nazwa;
    
    public Przedmiot(int id, String nazwa) {
        this.id = id;
        this.nazwa = nazwa;
    }
}
