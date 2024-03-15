/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package form.model;

import domain.Gost;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Korisnik
 */
public class GostTableModel extends AbstractTableModel{
    
    private List<Gost> gosti = new ArrayList<>();
            
    String[] kolone = {"ID","Ime","Prezime","Kontakt","Popust"};

    public GostTableModel(List<Gost> gosti) {
        this.gosti=gosti;
    }
    

    @Override
    public int getRowCount() {
        return gosti.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Gost gost = gosti.get(rowIndex);
        switch(columnIndex){
        
            case 0:
                return gost.getId();
            case 1:
                return gost.getIme();
            case 2:
                return gost.getPrezime();
            case 3:
                return gost.getKontakt();
            case 4:
                return gost.getPopust();
            default:
                throw new AssertionError();
        
        
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public List<Gost> getGosti() {
        return gosti;
    }


    
    
}
