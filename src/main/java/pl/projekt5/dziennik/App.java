package pl.projekt5.dziennik;

import pl.projekt5.handlers.LogHandler;
import pl.projekt5.models.Model;
import pl.projekt5.models.ModelFactory;

import pl.projekt5.models.InitializeDB;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ModelFactory m = ModelFactory.getInstance();
        InitializeDB init = (InitializeDB)m.getModel("InitializeDB");
        
        init.klasyCreate();
        
        LogHandler.close();
    }
}
