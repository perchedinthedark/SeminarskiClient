/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

import form.GostiForm;
import form.LoginForma;
import form.MainForm;
import form.RezervacijaForm;
import form.ShowGuest;
import form.ShowReservation;
import form.ShowRoom;
import form.SobaForm;

/**
 *
 * @author Korisnik
 */
public class FormaKontroler {
    
    private static FormaKontroler instance;
    private SobaForm sforma;
    private GostiForm gforma;
    private ShowRoom showrforma;
    private ShowGuest showgforma;
    private LoginForma lforma;
    private RezervacijaForm rforma;
    private ShowReservation showresforma;
    private MainForm mforma;
    
    
    
 
    
    public static FormaKontroler getInstance(){
    if(instance==null){
    instance = new FormaKontroler();}
    return instance;}

    public SobaForm getSforma() {
        return sforma;
    }

    public void setSforma(SobaForm sforma) {
        this.sforma = sforma;
    }

    public GostiForm getGforma() {
        return gforma;
    }

    public void setGforma(GostiForm gforma) {
        this.gforma = gforma;
    }

    public ShowRoom getShowrforma() {
        return showrforma;
    }

    public void setShowrforma(ShowRoom showrforma) {
        this.showrforma = showrforma;
    }

    public ShowGuest getShowgforma() {
        return showgforma;
    }

    public void setShowgforma(ShowGuest showgforma) {
        this.showgforma = showgforma;
    }

    public LoginForma getLforma() {
        return lforma;
    }

    public void setLforma(LoginForma lforma) {
        this.lforma = lforma;
    }

    public RezervacijaForm getRforma() {
        return rforma;
    }

    public void setRforma(RezervacijaForm rforma) {
        this.rforma = rforma;
    }

    public ShowReservation getShowresforma() {
        return showresforma;
    }

    public void setShowresforma(ShowReservation showresforma) {
        this.showresforma = showresforma;
    }

    public MainForm getMforma() {
        return mforma;
    }

    public void setMforma(MainForm mforma) {
        this.mforma = mforma;
    }
    
    
    
}
