/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package form;

import communication.Operacija;
import communication.Zahtev;
import domain.Gost;
import domain.Rezervacija;
import domain.Soba;
import domain.Zaposleni;
import form.model.RezervacijaTableModel;
import form.thread.ReservationThread;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import logic.FormaKontroler;
import logic.Kontroler;

/**
 *
 * @author Korisnik
 */
public class RezervacijaForm extends javax.swing.JDialog {

    Zaposleni user;
    ReservationThread nit = new ReservationThread();
    private String lastFilterCriteria = null;
    private int lastResultCount = -1;
    private Timer messageTimer;
    private final int MESSAGE_DELAY = 3000;
    private volatile boolean isFilteringActive = false;
    /**
     * Creates new form RezervacijaForm
     */
    public RezervacijaForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
    }

    RezervacijaForm(MainForm aThis, boolean b, Zaposleni user) {
        super(aThis, b);
        initComponents();
        this.user = user;
        FormaKontroler.getInstance().setRforma(this);
        fillRooms();
        fillGuests();
        txtZaposleni.setText(user.getIme() + " " + user.getPrezime());
        txtZaposleni.setEditable(false);
        spiner1.setModel(new SpinnerDateModel(new Date(), null, null, Calendar.DAY_OF_MONTH));
        spiner1.setEditor(new JSpinner.DateEditor(spiner1, "dd/MM/yyyy"));
        spiner2.setModel(new SpinnerDateModel(new Date(), null, null, Calendar.DAY_OF_MONTH));
        spiner2.setEditor(new JSpinner.DateEditor(spiner2, "dd/MM/yyyy"));
        nit.setForma(this);
        nit.start();
        addDocumentListeners();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        comboSoba = new javax.swing.JComboBox<>();
        comboGost = new javax.swing.JComboBox<>();
        txtZaposleni = new javax.swing.JTextField();
        spiner1 = new javax.swing.JSpinner();
        spiner2 = new javax.swing.JSpinner();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRes = new javax.swing.JTable();
        btnClose = new javax.swing.JButton();
        btnPrikazi = new javax.swing.JButton();
        btnPrikazi1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtFilter = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Zaposleni:");

        jLabel2.setText("Gost:");

        jLabel3.setText("Soba:");

        jLabel4.setText("Datum Prijave:");

        jLabel5.setText("Datum Odjave:");

        comboSoba.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboSobaActionPerformed(evt);
            }
        });

        comboGost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboGostActionPerformed(evt);
            }
        });

        jButton1.setText("Kreiraj rezervaciju");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tblRes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblRes);

        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        btnPrikazi.setText("Prikaži rezervaciju");
        btnPrikazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrikaziActionPerformed(evt);
            }
        });

        btnPrikazi1.setText("Obriši rezervaciju");
        btnPrikazi1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrikazi1ActionPerformed(evt);
            }
        });

        jLabel6.setText("Filtriraj rezervacije po datumu odjave:");

        jLabel7.setText(" (u formatu yyyy/mm/dd)");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                        .addComponent(btnClose)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(spiner2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(spiner1)
                            .addComponent(comboSoba, 0, 243, Short.MAX_VALUE)
                            .addComponent(comboGost, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtZaposleni))
                        .addGap(35, 35, 35))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(btnPrikazi)
                        .addGap(55, 55, 55)
                        .addComponent(btnPrikazi1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtFilter)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnPrikazi, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                    .addComponent(btnPrikazi1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(comboSoba, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(comboGost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtZaposleni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(spiner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(spiner2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClose))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboSobaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboSobaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboSobaActionPerformed

    private void comboGostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboGostActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboGostActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            // TODO add your handling code here:
            Rezervacija rezervacija = new Rezervacija();
            if(comboSoba.getSelectedIndex()==-1){
            
                 JOptionPane.showMessageDialog(null, "Sistem ne može da kreira rezervaciju. Selektujte sobu iz comboboxa");
                 return;
            }
            rezervacija.setSoba((Soba) comboSoba.getSelectedItem());
             if(comboGost.getSelectedIndex()==-1){
            
                 JOptionPane.showMessageDialog(null, "Sistem ne može da kreira rezervaciju. Selektujte sobu iz comboboxa");
                 return;
            }
            rezervacija.setGost((Gost) comboGost.getSelectedItem());
            rezervacija.setZaposleni(user);
            rezervacija.setDatumPrijave((Date) spiner1.getValue());
            rezervacija.setDatumOdjave((Date) spiner2.getValue());
            Zahtev zahtev = new Zahtev(Operacija.C_REZEERVACIJA, rezervacija);
            Kontroler.getInstance().createObject(zahtev);
        } catch (IOException ex) {
            Logger.getLogger(RezervacijaForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        // TODO add your handling code here:
        nit.stopThread();
        this.dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnPrikaziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrikaziActionPerformed
        // TODO add your handling code here:
        int pozicija = tblRes.getSelectedRow();
        if(pozicija==-1){
        JOptionPane.showMessageDialog(null,"Sistem ne može da učita rezervaciju. Izaberite polje forme" );
        return;
        }
        RezervacijaTableModel tm = (RezervacijaTableModel) tblRes.getModel();
        Rezervacija rezervacija = tm.getRezervacije().get(pozicija);
        FormaKontroler.getInstance().getRforma().startShowReservation(rezervacija);
        JOptionPane.showMessageDialog(null, "Sistem je učitao rezervaciju");
    }//GEN-LAST:event_btnPrikaziActionPerformed

    private void btnPrikazi1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrikazi1ActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            int pozicija = tblRes.getSelectedRow();
            if(pozicija==-1){
        JOptionPane.showMessageDialog(null,"Sistem ne može da obriše rezervaciju. Izaberite polje forme" );
        return;
        }
            RezervacijaTableModel tm = (RezervacijaTableModel) tblRes.getModel();
            Rezervacija rezervacija = tm.getRezervacije().get(pozicija);
            Zahtev zahtev = new Zahtev(Operacija.D_REZERVACIJA, rezervacija);
            Kontroler.getInstance().createObject(zahtev);
        } catch (IOException ex) {
            Logger.getLogger(RezervacijaForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnPrikazi1ActionPerformed

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
            java.util.logging.Logger.getLogger(RezervacijaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RezervacijaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RezervacijaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RezervacijaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                RezervacijaForm dialog = new RezervacijaForm(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnPrikazi;
    private javax.swing.JButton btnPrikazi1;
    private javax.swing.JComboBox<Gost> comboGost;
    private javax.swing.JComboBox<Soba> comboSoba;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner spiner1;
    private javax.swing.JSpinner spiner2;
    private javax.swing.JTable tblRes;
    private javax.swing.JTextField txtFilter;
    private javax.swing.JTextField txtZaposleni;
    // End of variables declaration//GEN-END:variables

    private void fillRooms() {
        try {
            Zahtev zahtev = new Zahtev(Operacija.BOX_SOBA, null);
            Kontroler.getInstance().createObject(zahtev);
        } catch (IOException ex) {
            Logger.getLogger(RezervacijaForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setComboSoba(List<Soba> sobe) {
    DefaultComboBoxModel<Soba> model = new DefaultComboBoxModel<>();
    for (Soba soba : sobe) {
        model.addElement(soba);
    }
    comboSoba.setModel(model);
    comboSoba.setSelectedIndex(-1);
    }

    private void fillGuests() {
        
        try {
            Zahtev zahtev = new Zahtev(Operacija.BOX_GOST, null);
            Kontroler.getInstance().createObject(zahtev);
        } catch (IOException ex) {
            Logger.getLogger(RezervacijaForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setComboGost(List<Gost> gosti) {
        DefaultComboBoxModel<Gost> model = new DefaultComboBoxModel<>();
    for (Gost gost : gosti) {
        model.addElement(gost);
    }
    comboGost.setModel(model);
    comboGost.setSelectedIndex(-1);
    }

    public void populateTable(List<Rezervacija> rezervacije) {
        RezervacijaTableModel tm = new RezervacijaTableModel(rezervacije);
        tblRes.setModel(tm);
    }

    public void startShowReservation(Rezervacija nova) {
        ShowReservation show = new ShowReservation(this, false, nova);
        show.pack();
        show.setLocationRelativeTo(null);
        show.setVisible(true);
    }

     private void addDocumentListeners() {
     txtFilter.getDocument().addDocumentListener(new DocumentListener() {
    @Override
    public void changedUpdate(DocumentEvent e) {
        runSearch();
    }
    @Override
    public void removeUpdate(DocumentEvent e) {
        runSearch();
    }
    @Override
    public void insertUpdate(DocumentEvent e) {
        runSearch();
    }
     private void runSearch() {
        SwingUtilities.invokeLater(() -> {
            try {
                String searchText = txtFilter.getText().trim();
                Zahtev zahtev = new Zahtev(Operacija.R_REZERVACIJA, searchText);
                Kontroler.getInstance().createObject(zahtev);
            } catch (IOException ex) {
                Logger.getLogger(RezervacijaForm.class.getName()).log(Level.SEVERE, null, ex);
            }
         
        });
    }
     });}

     public void updateWithFilter(List<Rezervacija> rezervacije) {
    
    isFilteringActive = true;

    RezervacijaTableModel tm = new RezervacijaTableModel(rezervacije);
    tblRes.setModel(tm);
    String currentFilterCriteria = txtFilter.getText().trim();
    int currentResultCount = rezervacije.size();

    if (messageTimer != null && messageTimer.isRunning()) {
        messageTimer.stop();
    }

    messageTimer = new Timer(MESSAGE_DELAY, e -> {
        if (!currentFilterCriteria.equals(lastFilterCriteria) || currentResultCount != lastResultCount) {
            if (rezervacije.isEmpty()) {
                JOptionPane.showMessageDialog(tblRes, "Sistem ne može da nađe sobe po zadatoj vrednosti.");
            } else {
                JOptionPane.showMessageDialog(tblRes, "Sistem je našao sobe po zadatoj vrednosti.");
            }

           
            lastFilterCriteria = currentFilterCriteria;
            lastResultCount = currentResultCount;
        }
       
        isFilteringActive = currentFilterCriteria.isEmpty();
    });
    messageTimer.setRepeats(false);
    messageTimer.start();
}

    public void showDialogue(Rezervacija rezervacija) {
        if(rezervacija==null){
        
            JOptionPane.showMessageDialog(null, "Sistem ne može da kreira rezervaciju. Greške u validaciji datuma");
            return;
        }
        
        JOptionPane.showMessageDialog(null, "Sistem je kreirao rezervaciju!");
    }

    public void showDialogueDeleted() {
        JOptionPane.showMessageDialog(null, "Sistem je obrisao rezervaciju!");
    }
    public boolean shouldUpdate() {
    return !isFilteringActive;
}
}
