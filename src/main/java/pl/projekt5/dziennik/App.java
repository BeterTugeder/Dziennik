package pl.projekt5.dziennik;

import java.util.ListIterator;
import pl.projekt5.handlers.LogHandler;
import pl.projekt5.models.ModelFactory;

import pl.projekt5.models.KlasyModel;
import pl.projekt5.models.KlasyModel.Klasa;
import pl.projekt5.models.UczniowieModel;
import pl.projekt5.models.UczniowieModel.Uczen;
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
        /*ListIterator<Klasa> it = klasa.get().listIterator();
        Klasa e = null;
        while(it.hasNext()){
            e = it.next();
            System.out.printf("%d\t%s\n", e.id, e.nazwa);
        }
        if(e!=null) {
            //e.delete();   //usuwanie ostatniego elementu
            e.nazwa = "3 A";
            //e.update();     //update ostatniego elementu, zmiana nazwy na "3 A"
        }
        
        e = klasa.get(9);
        System.out.printf("\n***\n%d\t%s\n", e.id, e.nazwa);*/
        
        UczniowieModel uczniowie = (UczniowieModel)m.getModel("UczniowieModel");
        
        /*uczniowie.add("Jan", "Kowalski", klasa.get(9));
        uczniowie.add("Jan", "Nowak", klasa.get(9));*/
        
        ListIterator<Uczen> uit = uczniowie.get().listIterator();
        Uczen ue = null;
        while(uit.hasNext()){
            ue = uit.next();
            System.out.printf("%d\t%s\t%s\t%s\n", ue.id, ue.imie, ue.nazwisko, ue.klasa.nazwa);
        }
        
        //testowy komentarz
        //commit
        
        LogHandler.close();
        
        ModelFactory.closeConnection();
    }
}
