package pl.projekt5.dziennik;

import java.util.ListIterator;
import java.util.Random;
import pl.projekt5.handlers.LogHandler;
import pl.projekt5.models.Klasa;
import pl.projekt5.models.KlasaModel;
import pl.projekt5.models.Kolumna;
import pl.projekt5.models.KolumnaModel;
import pl.projekt5.models.ModelFactory;
import pl.projekt5.models.Nauczyciel;
import pl.projekt5.models.NauczycielModel;
import pl.projekt5.models.Ocena;
import pl.projekt5.models.OcenaModel;
import pl.projekt5.models.Przedmiot;
import pl.projekt5.models.PrzedmiotModel;
import pl.projekt5.models.Uczen;
import pl.projekt5.models.UczenModel;
import pl.projekt5.views.view;

/**
* Hello world!
*
*/
public class App
{
    public static void main( String[] args )
    {
        /*ModelFactory m = ModelFactory.getInstance();
        
        KlasaModel klasa = (KlasaModel)m.getModel("KlasaModel");
        /*klasa.add("2 A");
        klasa.add("3 A");
        klasa.add("4 A");* /
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
        
        
        
        
        /*ListIterator<Uczen> uit = uczniowie.get().listIterator();
        Uczen ue = null;
        while(uit.hasNext()){
            ue = uit.next();
            System.out.printf("%d\t%s\t%s\t%s\n", ue.id, ue.imie, ue.nazwisko, ue.klasa.nazwa);
        }* /
        */
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new view().setVisible(true);
                
            }
        });
        
        //zapisywanie logow
        LogHandler.close();
        //zamykanie polaczenia z baza danych
        ModelFactory.closeConnection();
    }
}
