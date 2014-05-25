package pl.projekt5.dziennik;

import java.util.ListIterator;
import pl.projekt5.handlers.ExceptionHandler;
import pl.projekt5.handlers.LogHandler;
import pl.projekt5.models.Model;
import pl.projekt5.models.ModelFactory;

import pl.projekt5.models.KlasyModel;
import pl.projekt5.models.KlasyModel.Klasa;
/**
* Hello world!
*
*/
public class App
{
    public static void main( String[] args )
    {
        ModelFactory m = ModelFactory.getInstance();
        
        KlasyModel klasa = (KlasyModel)m.getModel("KlasyModel");
        /*klasa.add("2 A");
        klasa.add("3 A");
        klasa.add("4 A");*/
        ListIterator<Klasa> it = klasa.get().listIterator();
        Klasa e = null;
        while(it.hasNext()){
            e = it.next();
            System.out.printf("%d\t%s\n", e.getId(), e.nazwa);
        }
        if(e!=null)
            e.delete();
        
        
        LogHandler.close();
        
        ModelFactory.closeConnection();
    }
}