/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package form.model;

import domain.Rezervacija;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Korisnik
 */
public class RezervacijaTableModel extends AbstractTableModel{
     
   private List<Rezervacija> rezervacije = new ArrayList<>();

    public RezervacijaTableModel(List<Rezervacija> rezervacije) {
        this.rezervacije = rezervacije;
    }

    public List<Rezervacija> getRezervacije() {
        return rezervacije;
    }

    public void setRezervacije(List<Rezervacija> rezervacije) {
        this.rezervacije = rezervacije;
    }
    
    String[] kolone = {"ID", "Soba", "Gost", "Zaposleni", "Datum Prijave", "Datum Odjave", "Ukupna cena"};

    @Override
    public int getRowCount() {
        return rezervacije.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Rezervacija rezervacija = rezervacije.get(rowIndex);
        switch(columnIndex){
        
            case 0: 
                return rezervacija.getId();
            case 1:
                return rezervacija.getSoba().getId();
            case 2:
                return rezervacija.getGost().getIme()+ " " + rezervacija.getGost().getPrezime();
            case 3:
                return rezervacija.getZaposleni().getIme() + " " + rezervacija.getZaposleni().getPrezime();
            case 4:
                return rezervacija.getDatumPrijave();
            case 5:
                return rezervacija.getDatumOdjave();
            case 6:
                return rezervacija.getUkupnaCena();
            default:
                throw new AssertionError();
        
        
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
    
    
    
   
}
