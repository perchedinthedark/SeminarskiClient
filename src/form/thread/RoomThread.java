/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package form.thread;

import communication.Operacija;
import communication.Zahtev;
import form.SobaForm;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import logic.FormaKontroler;
import logic.Kontroler;

/**
 *
 * @author Korisnik
 */
public class RoomThread extends Thread{
    
    volatile boolean running = true;
   
    
    private SobaForm forma;
    
    public void stopThread() {
    running = false;
}
    
    

    @Override
    public void run() {
        
        while(running){
        
            try {
                
                Zahtev zahtev = new Zahtev(Operacija.TABLE_SOBA, null);
                 if (FormaKontroler.getInstance().getSforma().shouldUpdate()) {
                Kontroler.getInstance().createObject(zahtev);
            }
                
                
                
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(RoomThread.class.getName()).log(Level.SEVERE, null, ex);
                      Thread.currentThread().interrupt();
                }
                
            } catch (IOException ex) {
                Logger.getLogger(RoomThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }
        
        
    }

    public SobaForm getForma() {
        return forma;
    }

    public void setForma(SobaForm forma) {
        this.forma = forma;
    }
    
    
    
}
