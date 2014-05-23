/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.projekt5.handlers;

/**
 *
 * @author Kuba
 */
public class ExceptionHandler {
    public static final int FATAL_ERR=0;
    public static final int WARNING=1;
    public static final int MESSAGE=3;
    
    public static void handle(Exception ex) {
        handle( ex, MESSAGE );
    }
    public static void handle(Exception ex, int level) {
        switch(level) {
            case FATAL_ERR:
                System.err.format("[Blad krytyczny]: (%s) %s\n", ex.getClass(), ex.getMessage());
                ex.printStackTrace();
                System.err.println("Konczenie programu...");
                System.exit(1);
            break;
            case WARNING:
                System.err.format("[Blad]: %s\n", ex.getMessage());
                ex.printStackTrace();
            break;
            case MESSAGE:
            default:
                System.err.format("[Wiadomosc]: %s\n", ex.getMessage());
            break;
            
        }
    }
}
