package pl.projekt5.dziennik;

import java.util.ListIterator;
import pl.projekt5.handlers.LogHandler;
import pl.projekt5.models.ModelFactory;

import pl.projekt5.models.KlasaModel;
import pl.projekt5.models.Klasa;
import pl.projekt5.models.NauczycielModel;
import pl.projekt5.models.Nauczyciel;
import pl.projekt5.models.Przedmiot;
import pl.projekt5.models.PrzedmiotModel;
import pl.projekt5.models.Uczen;
import pl.projekt5.models.UczenModel;

/**
* Hello world!
*
*/
public class App
{
    public static void main( String[] args )
    {
        ModelFactory m = ModelFactory.getInstance();
        
        KlasaModel klasa = (KlasaModel)m.getModel("KlasaModel");
        /*klasa.add("2 A");
        klasa.add("3 A");
        klasa.add("4 A");*/
        ListIterator<Klasa> it = klasa.getAll().listIterator();
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
        System.out.printf("\n***\n%d\t%s\n", e.id, e.nazwa);
        
      
      PrzedmiotModel przedmioty = (PrzedmiotModel)m.getModel("PrzedmiotModel");
        Przedmiot aa = przedmioty.get(2);
        aa.nazwa = "informatyka";
        przedmioty.update(aa, 2);
        
        
        /*
       PrzedmiotModel przedmioty = (PrzedmiotModel)m.getModel("PrzedmiotModel");
        Przedmiot aa = new Przedmiot(91, "matematyka");
        Przedmiot bb = new Przedmiot(92, "fizyka");
        Przedmiot cc = new Przedmiot(93, "informatyka");
        przedmioty.add(aa, 1);
        przedmioty.add(cc, 2);
        przedmioty.add(bb, 3);
        UczenModel uczniowie = (UczenModel)m.getModel("UczenModel");
        Uczen aaa = new Uczen(1, "Agnieszka", "Madra");
        Uczen bbb = new Uczen(2, "Adam", "Kowalewski");
        uczniowie.add(aaa, 9);
        uczniowie.add(bbb, 9);*/
        
        /*uczniowie.add("Jan", "Kowalski", klasa.get(9));
        uczniowie.add("Jan", "Nowak", klasa.get(9));*/
        
        
        
        /*ListIterator<Uczen> uit = uczniowie.get().listIterator();
        Uczen ue = null;
        while(uit.hasNext()){
            ue = uit.next();
            System.out.printf("%d\t%s\t%s\t%s\n", ue.id, ue.imie, ue.nazwisko, ue.klasa.nazwa);
        }*/
        
        //testowy komentarz
        //commit
        
        LogHandler.close();
        
        ModelFactory.closeConnection();
    }
}
