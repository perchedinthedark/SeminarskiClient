/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

import communication.Odgovor;
import communication.Receiver;
import communication.Sender;
import communication.Zahtev;
import domain.Gost;
import domain.Rezervacija;
import domain.Soba;
import domain.Zaposleni;
import java.io.IOException;
import java.net.Socket;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Korisnik
 */
public class Kontroler extends Thread{
    
    
    
    Socket soket;
    Sender sender;
    Receiver receiver;
    private static Kontroler instance;
    
    private Kontroler() throws IOException{
    soket = new Socket("127.0.0.1", 9000);
    sender = new Sender(soket);
    receiver = new Receiver(soket);}
    
    public static Kontroler getInstance() throws IOException{
    
        if(instance==null){
        instance = new Kontroler();}
        
        return instance;
    }

    @Override
    public void run() {
        
        while(true){
        
            try {
                Odgovor odgovor = (Odgovor) receiver.primiOdgovor();
                
                switch(odgovor.getOperacija()){
                
                    case TABLE_SOBA:{
                    
                        List<Soba> sobe = (List<Soba>) odgovor.getRezultat();
                        System.out.println(sobe);
                        FormaKontroler.getInstance().getSforma().populateTable(sobe);
                    
                    break;
                    }
                    
                    case TABLE_GOST:{
                    
                        List<Gost> gosti = (List<Gost>) odgovor.getRezultat();
                        FormaKontroler.getInstance().getGforma().populateTable(gosti);
                        break;
                    
                    
                    }
                    
                    case R_SOBA:{
                    
                         List<Soba> sobe = (List<Soba>) odgovor.getRezultat();
                         FormaKontroler.getInstance().getSforma().updateWithFilter(sobe);
                    break;
                    }
                    
                    
                    case R_GOST:{
                    List<Gost> gosti = (List<Gost>) odgovor.getRezultat();
                    FormaKontroler.getInstance().getGforma().updateWithFilter(gosti);
                        
                    break;
                    }
                    
                    case LOGIN:{
                    
                        Zaposleni novi = (Zaposleni) odgovor.getRezultat();
                        FormaKontroler.getInstance().getLforma().login(novi);
                        break;
                    }
                    
                    case BOX_SOBA:{
                    
                        List<Soba> sobe = (List<Soba>) odgovor.getRezultat();
                        FormaKontroler.getInstance().getRforma().setComboSoba(sobe);
                        if(FormaKontroler.getInstance().getShowresforma()!=null){
                        FormaKontroler.getInstance().getShowresforma().setComboSoba(sobe);}
                        break;
                    
                    }
                    
                    case BOX_GOST:{
                    
                     List<Gost> gosti = (List<Gost>) odgovor.getRezultat();
                        System.out.println(gosti);
                        FormaKontroler.getInstance().getRforma().setComboGost(gosti);
                        if(FormaKontroler.getInstance().getShowresforma()!=null){
                        FormaKontroler.getInstance().getShowresforma().setComboGost(gosti);}
                        break;
                    
                    }
                    
                    case TABLE_REZERVACIJA:{
                    
                      List<Rezervacija> rezervacije = (List<Rezervacija>) odgovor.getRezultat();
                        System.out.println(rezervacije);
                        FormaKontroler.getInstance().getRforma().populateTable(rezervacije);
                        break;
                    
                    }
                    
                    case R_REZERVACIJA:{
                    
                    List<Rezervacija> rezervacije = (List<Rezervacija>) odgovor.getRezultat();
                    FormaKontroler.getInstance().getRforma().updateWithFilter(rezervacije);
                       
                    break;
                        
                    
                    
                    }
                    
                    case LOGOUT:{
                    
                        FormaKontroler.getInstance().getMforma().odjava();
                        break;
                    
                    
                    }
                    
                    case C_SOBA:{
                    
                        Soba soba = (Soba) odgovor.getRezultat();
                        FormaKontroler.getInstance().getSforma().showDialogue(soba);
                        break;
                    
                    }
                    
                    case U_SOBA:{
                    
                        Soba soba = (Soba) odgovor.getRezultat();
                        FormaKontroler.getInstance().getShowrforma().showDialogue(soba);
                        break;
                    
                    }
                    
                    case C_GOST:{
                        Gost gost = (Gost) odgovor.getRezultat();
                        FormaKontroler.getInstance().getGforma().showDialogue(gost);
                        break;
                    
                    
                    }
                    
                    case U_GOST:{
                    
                        Gost gost = (Gost) odgovor.getRezultat();
                        FormaKontroler.getInstance().getShowgforma().showDialogue(gost);
                        break;
                    }
                    
                    case C_REZEERVACIJA:{
                    
                        Rezervacija rezervacija = (Rezervacija) odgovor.getRezultat();
                        FormaKontroler.getInstance().getRforma().showDialogue(rezervacija);
                        break;
                    
                    }
                    
                    case U_REZERVACIJA:{
                    
                        Rezervacija rezervacija = (Rezervacija) odgovor.getRezultat();
                        FormaKontroler.getInstance().getShowresforma().showDialogue(rezervacija);
                        break;
                    
                    }
                    
                    case D_REZERVACIJA:{
                    
                        FormaKontroler.getInstance().getRforma().showDialogueDeleted();
                    break;
                    }
                    
                    
                
                
                }
            } catch (Exception ex) {
                Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        
        
        
        }
    }
    
    
    

   

    public void createObject(Zahtev zahtev) {
        try {
            sender.posalji(zahtev);
        } catch (Exception ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

        public void odjava() {
        
        if(soket!=null && !soket.isClosed()){
        
            try {
                soket.close();
            } catch (IOException ex) {
                Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        
        }
    }

   

}
