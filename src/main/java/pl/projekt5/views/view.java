/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.projekt5.views;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ListIterator;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import pl.projekt5.models.Klasa;
import pl.projekt5.models.KlasaModel;
import pl.projekt5.models.ModelFactory;
import pl.projekt5.models.Nauczyciel;
import pl.projekt5.models.NauczycielModel;
import pl.projekt5.models.Ocena;
import pl.projekt5.models.OcenaModel;
import pl.projekt5.models.Przedmiot;
import pl.projekt5.models.PrzedmiotModel;
import pl.projekt5.models.Uczen;
import pl.projekt5.models.UczenModel;
 /*
 * @author Jacek
 */
public class view extends javax.swing.JFrame implements TableModelListener {

    /**
     * Creates new form view
     */
    private int ind;
    private int idPrzedmiotu;
    private boolean zaznacz =  false;
    public view() {
        
        initComponents();
        
        tabela.getModel().addTableModelListener(this);

        SimpleDateFormat simpleDateHere = new SimpleDateFormat("yyyy");
        rok_szkolny_text.setText(simpleDateHere.format(new Date()));
        wypelnij_combobox();
   }

    public void tableChanged(TableModelEvent e) {
        if(zaznacz == true){
           
            int row = e.getFirstRow();
            int column = e.getColumn();
                     
            Object data = tabela.getModel().getValueAt(row, column);
           
            //System.out.println(data);
            
            try{
                
                
                
                ModelFactory m = ModelFactory.getInstance();
                OcenaModel km = (OcenaModel)m.getModel("OcenaModel");
                
                    if(km.gett((Integer)tabela.getModel().getValueAt(row, 0), idPrzedmiotu, column-1)==null)
                    {
                        if(column<5 ){
                            km.addd(0, idPrzedmiotu, (Integer)tabela.getModel().getValueAt(row, 0), column-1);
                            km.update(Integer.parseInt(String.valueOf(data)), (Integer)tabela.getModel().getValueAt(row, 0), idPrzedmiotu, column-1);
                        }else
                            if(column>5){
                                
                            km.addd(0, idPrzedmiotu, (Integer)tabela.getModel().getValueAt(row, 0), column-5);
                            km.update(Integer.parseInt(String.valueOf(data)), (Integer)tabela.getModel().getValueAt(row, 0), idPrzedmiotu, column-5);
                        }
                        //System.out.println("dziala");
                    }else if(Integer.parseInt(String.valueOf(data))>=1 && Integer.parseInt(String.valueOf(data))<=5 ){


                            if(column<5 ){
                                km.update(Integer.parseInt(String.valueOf(data)), (Integer)tabela.getModel().getValueAt(row, 0), idPrzedmiotu, column-1);
                            }else
                            if(column>5){
                                km.update(Integer.parseInt(String.valueOf(data)), (Integer)tabela.getModel().getValueAt(row, 0), idPrzedmiotu, column-5);
                            } 

                    }else{
                        showMessageDialog(null, "Podaj ocene w skali od 1 do 5");
                    }
            
            }catch(Exception ex){
                showMessageDialog(null, "Podaj liczbe");
            }
            zaznacz=false;
           
           
        }
       
    }
 

    
    private int osobyKlasa(int idKlasy){
        restartTabeli();
        ModelFactory m = ModelFactory.getInstance();
        UczenModel uczen1 = (UczenModel)m.getModel("UczenModel");
        ListIterator<Uczen> it = uczen1.getAll(idKlasy).listIterator();
        int i = 0;
        while(it.hasNext()){
             
            Uczen uczen2 = it.next();
            
            tabela.getModel().setValueAt(uczen2.id, i , 0);
            tabela.getModel().setValueAt(uczen2.imie+" "+uczen2.nazwisko, i , 1);
            i++;
            
            if (i==20) break;
        }
        return i;
    }
    private int ocenaOsoby(int idUcznia, int idPrzedmiotu, int idKolumny){
        
        ModelFactory m = ModelFactory.getInstance();
        OcenaModel km = (OcenaModel)m.getModel("OcenaModel");
       // ListIterator<Kolumna> it = km.getAll().listIterator();
        
        Ocena tmp = km.gett(idUcznia, idPrzedmiotu, idKolumny);
        
        int k = 0;
        if(tmp != null)
            k = tmp.ocena;
        
        
       return k;
    }
    private void restartTabeli(){
        
        for(int i = 0 ; i<tabela.getRowCount() ; i++){
            for( int j = 0 ; j < tabela.getColumnCount(); j++){
                tabela.getModel().setValueAt(null, i , j);
            }
            
        }
        
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        panel1 = new javax.swing.JPanel();
        dziennik_elektroniczny = new javax.swing.JLabel();
        panel2 = new javax.swing.JPanel();
        jasiu = new javax.swing.JLabel();
        tablica = new javax.swing.JLabel();
        witaj_szkolo = new javax.swing.JLabel();
        wybor_klasy = new javax.swing.JComboBox();
        wybor_przedmiotu = new javax.swing.JComboBox();
        panel3 = new javax.swing.JPanel();
        klasa = new javax.swing.JLabel();
        klasa_text = new javax.swing.JTextField();
        nauczyciel = new javax.swing.JLabel();
        nauczyciel_text = new javax.swing.JTextField();
        wychowawca = new javax.swing.JLabel();
        wychowawca_text = new javax.swing.JTextField();
        rok_szkolny = new javax.swing.JLabel();
        rok_szkolny_text = new javax.swing.JTextField();
        scroll_panel = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        menu = new javax.swing.JMenuBar();
        opcje = new javax.swing.JMenu();
        opcje_dodaj = new javax.swing.JMenu();
        opcje_dodaj_klase = new javax.swing.JMenuItem();
        opcje_dodaj_ucznia = new javax.swing.JMenuItem();
        opcje_dodaj_nauczyciela = new javax.swing.JMenuItem();
        opcje_zmien = new javax.swing.JMenu();
        opcje_zmien_nauczyciela = new javax.swing.JMenuItem();
        opcje_zmien_wychowawce = new javax.swing.JMenuItem();
        usun = new javax.swing.JMenu();
        usun_nauczyciela = new javax.swing.JMenuItem();
        usun_ucznia = new javax.swing.JMenuItem();
        usun_klase = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel1.setLayout(new java.awt.GridBagLayout());

        dziennik_elektroniczny.setFont(new java.awt.Font("Italic", 3, 24)); // NOI18N
        dziennik_elektroniczny.setForeground(new java.awt.Color(0, 153, 51));
        dziennik_elektroniczny.setText("Dziennik Elektroniczny");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(7, 354, 0, 0);
        panel1.add(dziennik_elektroniczny, gridBagConstraints);

        panel2.setLayout(new java.awt.GridBagLayout());

        jasiu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pl/projekt5/views/Grafiki/jasiu.jpg"))); // NOI18N
        jasiu.setText("jLabel3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.ipadx = -37;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 107, 13, 0);
        panel2.add(jasiu, gridBagConstraints);

        tablica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pl/projekt5/views/Grafiki/tablica.jpg"))); // NOI18N
        tablica.setText("jLabel4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.ipadx = -39;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 77, 13, 0);
        panel2.add(tablica, gridBagConstraints);

        witaj_szkolo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pl/projekt5/views/Grafiki/witaj_szkolo.jpg"))); // NOI18N
        witaj_szkolo.setText("jLabel5");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.ipadx = -41;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 74, 13, 74);
        panel2.add(witaj_szkolo, gridBagConstraints);

        wybor_klasy.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "wybór klasy" }));
        wybor_klasy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wybor_klasyActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 59;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 83, 0, 0);
        panel2.add(wybor_klasy, gridBagConstraints);

        wybor_przedmiotu.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "wybór przedmiotu" }));
        wybor_przedmiotu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wybor_przedmiotuActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 30;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(23, 83, 0, 0);
        panel2.add(wybor_przedmiotu, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 74;
        gridBagConstraints.ipady = 13;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 0, 0);
        panel1.add(panel2, gridBagConstraints);

        panel3.setLayout(new java.awt.GridBagLayout());

        klasa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        klasa.setText("Klasa:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 34, 0, 0);
        panel3.add(klasa, gridBagConstraints);

        klasa_text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                klasa_textActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 78;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 10, 11, 0);
        panel3.add(klasa_text, gridBagConstraints);

        nauczyciel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nauczyciel.setText("Nauczyciel:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 10, 0, 0);
        panel3.add(nauczyciel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 109;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 10, 11, 0);
        panel3.add(nauczyciel_text, gridBagConstraints);

        wychowawca.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        wychowawca.setText("Wychowawca: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 18, 0, 0);
        panel3.add(wychowawca, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 90;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 10, 11, 0);
        panel3.add(wychowawca_text, gridBagConstraints);

        rok_szkolny.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rok_szkolny.setText("Rok szkolny:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 21, 0, 0);
        panel3.add(rok_szkolny, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 18, 11, 75);
        panel3.add(rok_szkolny_text, gridBagConstraints);

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Nr", "Imie Nazwisko", "Spr.", "Kart.", "Odp.", "Semestr I", "Spr.", "Kart.", "Odp.", "Koniec roku"
            }
        ));
        tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaMouseClicked(evt);
            }
        });
        scroll_panel.setViewportView(tabela);

        opcje.setText("Opcje");

        opcje_dodaj.setText("dodaj");

        opcje_dodaj_klase.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        opcje_dodaj_klase.setText("Klasę");
        opcje_dodaj_klase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcje_dodaj_klaseActionPerformed(evt);
            }
        });
        opcje_dodaj.add(opcje_dodaj_klase);

        opcje_dodaj_ucznia.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        opcje_dodaj_ucznia.setText("Ucznia");
        opcje_dodaj_ucznia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcje_dodaj_uczniaActionPerformed(evt);
            }
        });
        opcje_dodaj.add(opcje_dodaj_ucznia);

        opcje_dodaj_nauczyciela.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F8, 0));
        opcje_dodaj_nauczyciela.setText("Nauczyciela");
        opcje_dodaj_nauczyciela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcje_dodaj_nauczycielaActionPerformed(evt);
            }
        });
        opcje_dodaj.add(opcje_dodaj_nauczyciela);

        opcje.add(opcje_dodaj);

        opcje_zmien.setText("zmień");

        opcje_zmien_nauczyciela.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, 0));
        opcje_zmien_nauczyciela.setText("nauczyciela");
        opcje_zmien_nauczyciela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcje_zmien_nauczycielaActionPerformed(evt);
            }
        });
        opcje_zmien.add(opcje_zmien_nauczyciela);

        opcje_zmien_wychowawce.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        opcje_zmien_wychowawce.setText("wychowawcę");
        opcje_zmien_wychowawce.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcje_zmien_wychowawceActionPerformed(evt);
            }
        });
        opcje_zmien.add(opcje_zmien_wychowawce);

        opcje.add(opcje_zmien);

        menu.add(opcje);

        usun.setText("Usuń");

        usun_nauczyciela.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        usun_nauczyciela.setText("nauczyciela");
        usun_nauczyciela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usun_nauczycielaActionPerformed(evt);
            }
        });
        usun.add(usun_nauczyciela);

        usun_ucznia.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F6, 0));
        usun_ucznia.setText("ucznia");
        usun_ucznia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usun_uczniaActionPerformed(evt);
            }
        });
        usun.add(usun_ucznia);

        usun_klase.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F7, 0));
        usun_klase.setText("klasę");
        usun_klase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usun_klaseActionPerformed(evt);
            }
        });
        usun.add(usun_klase);

        menu.add(usun);

        setJMenuBar(menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panel3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scroll_panel)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scroll_panel, javax.swing.GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    
    private void wybor_klasyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wybor_klasyActionPerformed
        klasa_text.setText(wybor_klasy.getSelectedItem().toString());
        ModelFactory m = ModelFactory.getInstance();
        KlasaModel klasa1 = (KlasaModel)m.getModel("KlasaModel");
        ListIterator<Klasa> it = klasa1.getAll().listIterator();
        int id=0;
        while(it.hasNext()){
           if(it.next().nazwa.equals(wybor_klasy.getSelectedItem().toString())){
               it.previous();
               id = it.next().id;
           }      
        }
        NauczycielModel nauczyciele = (NauczycielModel)m.getModel("NauczycielModel");
        ind =  osobyKlasa(id);
        
        
         
        wychowawca_text.setText(nauczyciele.get(id, true).nazwisko+" "+nauczyciele.get(id, true).imie);
    }//GEN-LAST:event_wybor_klasyActionPerformed

    private void klasa_textActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_klasa_textActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_klasa_textActionPerformed

    private void wybor_przedmiotuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wybor_przedmiotuActionPerformed
        try{
            
        
            ModelFactory m = ModelFactory.getInstance();
            PrzedmiotModel przedmiot1 = (PrzedmiotModel)m.getModel("PrzedmiotModel");
            ListIterator<Przedmiot> it = przedmiot1.getAll().listIterator();
            int idd=0;
            while(it.hasNext()){
               if(it.next().nazwa.equals(wybor_przedmiotu.getSelectedItem().toString())){
                   it.previous();
                   idd = it.next().id;
               }      
            }
            NauczycielModel nauczyciele = (NauczycielModel)m.getModel("NauczycielModel");
            idd = przedmiot1.get(idd, true);
            idPrzedmiotu = idd;
            //ocenyOsob(ind, idd);
            if(nauczyciele.get(idd).imie.equals(null)){
                showMessageDialog(null, "Nie ma nauczyciela!");  
            }else{
            for(int i =0 ;i< ind;i++){

                tabela.getModel().setValueAt(ocenaOsoby( (Integer)tabela.getModel().getValueAt(i, 0), idd, 1), i , 2);
                tabela.getModel().setValueAt(ocenaOsoby( (Integer)tabela.getModel().getValueAt(i, 0), idd, 2), i , 3);
                tabela.getModel().setValueAt(ocenaOsoby( (Integer)tabela.getModel().getValueAt(i, 0), idd, 3), i , 4);
                tabela.getModel().setValueAt(ocenaOsoby( (Integer)tabela.getModel().getValueAt(i, 0), idd, 1), i , 6);
                tabela.getModel().setValueAt(ocenaOsoby( (Integer)tabela.getModel().getValueAt(i, 0), idd, 2), i , 8);
                tabela.getModel().setValueAt(ocenaOsoby( (Integer)tabela.getModel().getValueAt(i, 0), idd, 3), i , 7);
                //tabela.getModel().setValueAt(ocenaOsoby( (Integer)tabela.getModel().getValueAt(i, 0), idd, 27), i , 5);
                tabela.getModel().setValueAt(((Integer)tabela.getModel().getValueAt(i, 2)+(Integer)tabela.getModel().getValueAt(i, 3)+(Integer)tabela.getModel().getValueAt(i, 4))/3, i, 5);
                tabela.getModel().setValueAt(((Integer)tabela.getModel().getValueAt(i, 7)+(Integer)tabela.getModel().getValueAt(i, 8)+(Integer)tabela.getModel().getValueAt(i, 6))/3, i, 9);
            }
            nauczyciel_text.setText(nauczyciele.get(idd).nazwisko+" "+nauczyciele.get(idd).imie);  
            }
        }
        catch(Exception e){
            restartTabeli();
        }
    }//GEN-LAST:event_wybor_przedmiotuActionPerformed

    private void usun_nauczycielaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usun_nauczycielaActionPerformed
        Opcje okno = new Opcje();
        okno.tytul.setText("Usun nauczyciela");
        okno.ukryj_wszystko();
        okno.combo1.setVisible(true);
        okno.opcja.setText("3");
        
        ModelFactory m = ModelFactory.getInstance();
        NauczycielModel nauczyciel1 = (NauczycielModel)m.getModel("NauczycielModel");
        ListIterator<Nauczyciel> it = nauczyciel1.getAll().listIterator();
        while(it.hasNext()){
            Nauczyciel nauczyciel2 = it.next();
            okno.combo1.addItem(nauczyciel2.nazwisko+" "+nauczyciel2.imie);
        }
        
        
        okno.setVisible(true);
        dispose();
    }//GEN-LAST:event_usun_nauczycielaActionPerformed

    private void opcje_dodaj_klaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcje_dodaj_klaseActionPerformed
        Opcje okno = new Opcje();
        okno.tytul.setText("Dodaj klase");
        okno.jLabel2.setText("Nazwa");
        okno.ukryj_wszystko();
        okno.jLabel2.setVisible(true);
        okno.jTextField1.setVisible(true);
        okno.opcja.setText("1");

        okno.setVisible(true);
        dispose();

    }//GEN-LAST:event_opcje_dodaj_klaseActionPerformed

    private void opcje_dodaj_nauczycielaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcje_dodaj_nauczycielaActionPerformed
        Opcje okno = new Opcje();
        okno.tytul.setText("Dodaj nauczyciela");
        okno.jLabel2.setText("Imie");
        okno.jLabel3.setText("Nazwisko");
        okno.combo1.setVisible(false);
        okno.label_combo2.setVisible(false);
        okno.combo2.setVisible(false);
        okno.label_combo1.setVisible(false);
        okno.opcja.setText("0");
        
        okno.setVisible(true);
        dispose();
    }//GEN-LAST:event_opcje_dodaj_nauczycielaActionPerformed

    private void opcje_dodaj_uczniaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcje_dodaj_uczniaActionPerformed
        Opcje okno = new Opcje();
        okno.tytul.setText("Dodaj ucznia");
        okno.jLabel2.setText("Imie");
        okno.jLabel3.setText("Nazwisko");
        okno.ukryj_wszystko();
        okno.jLabel2.setVisible(true);
        okno.jLabel3.setVisible(true);
        okno.jTextField1.setVisible(true);
        okno.jTextField2.setVisible(true);
        okno.jComboBox3.setVisible(true);
        
        okno.opcja.setText("2");
        okno.setVisible(true);
        dispose();
    }//GEN-LAST:event_opcje_dodaj_uczniaActionPerformed

    private void usun_klaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usun_klaseActionPerformed
        Opcje okno = new Opcje();
        okno.tytul.setText("Usun klase");
        okno.ukryj_wszystko();
        okno.jComboBox3.setVisible(true);
        okno.opcja.setText("4");
        
        ModelFactory m = ModelFactory.getInstance();
        KlasaModel klasa1 = (KlasaModel)m.getModel("KlasaModel");
        ListIterator<Klasa> it = klasa1.getAll().listIterator();
        while(it.hasNext()){
            okno.combo1.addItem(it.next().nazwa);
        }

        okno.setVisible(true);
        dispose();
        
    }//GEN-LAST:event_usun_klaseActionPerformed

    private void usun_uczniaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usun_uczniaActionPerformed
        Opcje okno = new Opcje();
        okno.tytul.setText("Usun ucznia");
        okno.ukryj_wszystko();
        okno.combo1.setVisible(true);
        okno.jComboBox3.setVisible(true);
        okno.opcja.setText("5");
        
        okno.setVisible(true);  
        dispose();
    }//GEN-LAST:event_usun_uczniaActionPerformed

    private void opcje_zmien_wychowawceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcje_zmien_wychowawceActionPerformed
        Opcje okno = new Opcje();
        okno.tytul.setText("Zmien wychowawce");
        okno.ukryj_wszystko();
        okno.combo1.setVisible(true);
        okno.jComboBox3.setVisible(true);
        okno.label_combo1.setVisible(true);
        okno.label_combo1.setText("Imie i nazwisko");
        
        ModelFactory m = ModelFactory.getInstance();
        NauczycielModel nauczyciel1 = (NauczycielModel)m.getModel("NauczycielModel");
        ListIterator<Nauczyciel> it2 = nauczyciel1.getAll().listIterator();
        while(it2.hasNext()){
            Nauczyciel nauczyciel2 = it2.next();
            okno.combo1.addItem(nauczyciel2.nazwisko+" "+nauczyciel2.imie);
        }
        okno.opcja.setText("7");
        okno.setVisible(true);
        dispose();
    }//GEN-LAST:event_opcje_zmien_wychowawceActionPerformed

    private void opcje_zmien_nauczycielaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcje_zmien_nauczycielaActionPerformed
        Opcje okno = new Opcje();
        okno.tytul.setText("Zmien nauczyciela");
        okno.ukryj_wszystko();
        okno.combo1.setVisible(true);
        okno.combo2.setVisible(true);
        okno.label_combo1.setVisible(true);
        okno.label_combo2.setVisible(true);
        okno.label_combo1.setText("Przedmiot");
        okno.label_combo2.setText("Imie i nazwisko");
        
        ModelFactory m = ModelFactory.getInstance();
        PrzedmiotModel przedmioty = (PrzedmiotModel)m.getModel("PrzedmiotModel");
        ListIterator<Przedmiot> it = przedmioty.getAll().listIterator();
        while(it.hasNext()){
            okno.combo1.addItem(it.next().nazwa);
        }       
        
        NauczycielModel nauczyciel1 = (NauczycielModel)m.getModel("NauczycielModel");
        ListIterator<Nauczyciel> it2 = nauczyciel1.getAll().listIterator();
        while(it2.hasNext()){
            Nauczyciel nauczyciel2 = it2.next();
            okno.combo2.addItem(nauczyciel2.nazwisko+" "+nauczyciel2.imie);
        }
        okno.opcja.setText("6");
        okno.setVisible(true);
        dispose();
    }//GEN-LAST:event_opcje_zmien_nauczycielaActionPerformed

    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked
        zaznacz=true;
        
    }//GEN-LAST:event_tabelaMouseClicked

    private void wypelnij_combobox(){
        ModelFactory m = ModelFactory.getInstance();
        KlasaModel klasa1 = (KlasaModel)m.getModel("KlasaModel");
        ListIterator<Klasa> it = klasa1.getAll().listIterator();
        while(it.hasNext()){
            wybor_klasy.addItem(it.next().nazwa);
        }
        
        PrzedmiotModel przedmiot = (PrzedmiotModel)m.getModel("PrzedmiotModel");
        ListIterator<Przedmiot> it3 = przedmiot.getAll().listIterator();
        while(it3.hasNext()){
            wybor_przedmiotu.addItem(it3.next().nazwa);
        }  
    }
    /**
     * @param args the command line arguments
     */
    /*
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         * /
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
        //</editor-fold>

        /* Create and display the form * /
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new view().setVisible(true);
                
            }
        });
    }
    */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel dziennik_elektroniczny;
    public javax.swing.JLabel jasiu;
    public javax.swing.JLabel klasa;
    public javax.swing.JTextField klasa_text;
    public javax.swing.JMenuBar menu;
    public javax.swing.JLabel nauczyciel;
    public javax.swing.JTextField nauczyciel_text;
    public javax.swing.JMenu opcje;
    public javax.swing.JMenu opcje_dodaj;
    public javax.swing.JMenuItem opcje_dodaj_klase;
    private javax.swing.JMenuItem opcje_dodaj_nauczyciela;
    public javax.swing.JMenuItem opcje_dodaj_ucznia;
    public javax.swing.JMenu opcje_zmien;
    public javax.swing.JMenuItem opcje_zmien_nauczyciela;
    public javax.swing.JMenuItem opcje_zmien_wychowawce;
    public javax.swing.JPanel panel1;
    public javax.swing.JPanel panel2;
    public javax.swing.JPanel panel3;
    public javax.swing.JLabel rok_szkolny;
    public javax.swing.JTextField rok_szkolny_text;
    public javax.swing.JScrollPane scroll_panel;
    private javax.swing.JTable tabela;
    public javax.swing.JLabel tablica;
    public javax.swing.JMenu usun;
    public javax.swing.JMenuItem usun_klase;
    public javax.swing.JMenuItem usun_nauczyciela;
    public javax.swing.JMenuItem usun_ucznia;
    public javax.swing.JLabel witaj_szkolo;
    public javax.swing.JComboBox wybor_klasy;
    public javax.swing.JComboBox wybor_przedmiotu;
    public javax.swing.JLabel wychowawca;
    public javax.swing.JTextField wychowawca_text;
    // End of variables declaration//GEN-END:variables

}
