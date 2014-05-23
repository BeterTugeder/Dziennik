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
public class ModelException extends Exception {
    public ModelException() {
        super();
    }
    
    public ModelException(String msg) {
        super(msg);
    }
}