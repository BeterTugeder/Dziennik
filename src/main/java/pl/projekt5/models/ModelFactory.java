package pl.projekt5.models;

import pl.projekt5.dziennik.ExceptionHandler;

/**
 *
 * @author Kuba
 */
public class ModelFactory {
    public static Model getModel(String name) {
        Model obj = null;
        try {
            //Throws
            //ClassNotFoundException
            //InstantiationException
            //IllegalAccessException
            obj = (Model)Class.forName(name).newInstance();
        }catch(Exception e) { 
            //lapiemy wszystkie wyjatki jako fatal error
            ExceptionHandler.handle(e, ExceptionHandler.FATAL_ERR);
        }
        return obj;
    }
}
