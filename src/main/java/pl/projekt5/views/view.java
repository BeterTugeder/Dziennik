/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.projekt5.views;
import java.util.ListIterator;
import pl.projekt5.models.Klasa;
import pl.projekt5.models.KlasaModel;
import pl.projekt5.models.ModelFactory;
import pl.projekt5.models.NauczycielModel;
import pl.projekt5.models.Przedmiot;
import pl.projekt5.models.PrzedmiotModel;

/**
 *
 * @author Jacek
 */
public class view extends javax.swing.JFrame {

    /**
     * Creates new form view
     */
    public view() {
        initComponents();
        wypelnij_combobox();
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
        opcje_dodaj_przedmiot = new javax.swing.JMenuItem();
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

            },
            new String [] {
                "Nr", "Imię i nazwisko", "Spr.", "Kart.", "Odp.", "Obecność", "Sem. I", "Spr.", "Kart.", "Odp.", "Obecność", "Koniec roku"
            }
        ));
        scroll_panel.setViewportView(tabela);
        if (tabela.getColumnModel().getColumnCount() > 0) {
            tabela.getColumnModel().getColumn(0).setHeaderValue("Nr");
            tabela.getColumnModel().getColumn(1).setHeaderValue("Imię i nazwisko");
            tabela.getColumnModel().getColumn(2).setHeaderValue("Spr.");
            tabela.getColumnModel().getColumn(3).setHeaderValue("Kart.");
            tabela.getColumnModel().getColumn(4).setHeaderValue("Odp.");
            tabela.getColumnModel().getColumn(5).setHeaderValue("Obecność");
            tabela.getColumnModel().getColumn(6).setHeaderValue("Sem. I");
            tabela.getColumnModel().getColumn(7).setHeaderValue("Spr.");
            tabela.getColumnModel().getColumn(8).setHeaderValue("Kart.");
            tabela.getColumnModel().getColumn(9).setHeaderValue("Odp.");
            tabela.getColumnModel().getColumn(10).setHeaderValue("Obecność");
            tabela.getColumnModel().getColumn(11).setHeaderValue("Koniec roku");
        }

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
        opcje_dodaj.add(opcje_dodaj_ucznia);

        opcje_dodaj_przedmiot.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, 0));
        opcje_dodaj_przedmiot.setText("Przedmiot");
        opcje_dodaj.add(opcje_dodaj_przedmiot);

        opcje.add(opcje_dodaj);

        opcje_zmien.setText("zmień");

        opcje_zmien_nauczyciela.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, 0));
        opcje_zmien_nauczyciela.setText("nauczyciela");
        opcje_zmien.add(opcje_zmien_nauczyciela);

        opcje_zmien_wychowawce.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        opcje_zmien_wychowawce.setText("wychowawcę");
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
        usun.add(usun_ucznia);

        usun_klase.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F7, 0));
        usun_klase.setText("klasę");
        usun.add(usun_klase);

        menu.add(usun);

        setJMenuBar(menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panel3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(scroll_panel)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scroll_panel, javax.swing.GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE))
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
        wychowawca_text.setText(nauczyciele.get(id, true).nazwisko+" "+nauczyciele.get(id, true).imie);
    }//GEN-LAST:event_wybor_klasyActionPerformed

    private void klasa_textActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_klasa_textActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_klasa_textActionPerformed

    private void wybor_przedmiotuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wybor_przedmiotuActionPerformed
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
      
        nauczyciel_text.setText(nauczyciele.get(idd).nazwisko+" "+nauczyciele.get(idd).imie);  
    }//GEN-LAST:event_wybor_przedmiotuActionPerformed

    private void usun_nauczycielaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usun_nauczycielaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usun_nauczycielaActionPerformed

    private void opcje_dodaj_klaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcje_dodaj_klaseActionPerformed
       
    }//GEN-LAST:event_opcje_dodaj_klaseActionPerformed

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
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
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
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new view().setVisible(true);
                
            }
        });
    }

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
    public javax.swing.JMenuItem opcje_dodaj_przedmiot;
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
    public javax.swing.JTable tabela;
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
