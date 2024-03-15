/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package form.thread;

import communication.Operacija;
import communication.Zahtev;
import form.GostiForm;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import logic.FormaKontroler;
import logic.Kontroler;

/**
 *
 * @author Korisnik
 */
public class GuestThread extends Thread{
    volatile boolean running = true;
    private GostiForm forma;

    public GostiForm getForma() {
        return forma;
    }

    public void setForma(GostiForm forma) {
        this.forma = forma;
    }
    
    public void stopThread() {
    running = false;
}

    @Override
    public void run() {
        
        
        while(running){
        
        try {
            
            Zahtev zahtev = new Zahtev(Operacija.TABLE_GOST, null);
            if (FormaKontroler.getInstance().getGforma().shouldUpdate()) {
                Kontroler.getInstance().createObject(zahtev);
            }
            
            
            try {
                Thread.sleep(10000);
            } catch (InterruptedException ex) {
                Logger.getLogger(GuestThread.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } catch (IOException ex) {
                    Logger.getLogger(GuestThread.class.getName()).log(Level.SEVERE, null, ex);
                }
        
        }
        
        
       
    }
    
    
    
}
