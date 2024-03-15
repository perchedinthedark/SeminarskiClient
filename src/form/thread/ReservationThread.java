/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package form.thread;

import communication.Operacija;
import communication.Zahtev;
import form.RezervacijaForm;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import logic.FormaKontroler;
import logic.Kontroler;

/**
 *
 * @author Korisnik
 */
public class ReservationThread extends Thread{
     volatile boolean running = true;
     private RezervacijaForm forma;
     
     
     
     public void stopThread() {
    running = false;
}

    @Override
    public void run() {
        
        while(running){
        
            try {
                
                System.out.println("ovde");
                Zahtev zahtev = new Zahtev(Operacija.TABLE_REZERVACIJA, null);
               if (FormaKontroler.getInstance().getRforma().shouldUpdate()) {
                Kontroler.getInstance().createObject(zahtev);
            }
                
                
                
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ReservationThread.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            } catch (IOException ex) {
                Logger.getLogger(ReservationThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }
    }

    public RezervacijaForm getForma() {
        return forma;
    }

    public void setForma(RezervacijaForm forma) {
        this.forma = forma;
    }
     
     
}
