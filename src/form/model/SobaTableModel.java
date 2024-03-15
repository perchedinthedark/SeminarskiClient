/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package form.model;

import domain.Soba;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Korisnik
 */
public class SobaTableModel extends AbstractTableModel{
    
    private List<Soba> sobe = new ArrayList<>();
    
    
    
    String[] kolone = {"ID","Tip","Broj Kreveta","Dostupna","Cena", "Pogled"};

    public SobaTableModel(List<Soba> sobe) {
        this.sobe = sobe;
    }

    @Override
    public int getRowCount() {
        return sobe.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Soba soba = sobe.get(rowIndex);
        switch(columnIndex){
        
            case 0:
                return soba.getId();
            case 1:
                return soba.getTip();
            case 2:
                return soba.getBrojKreveta();
            case 3:
                return soba.isDostupna();
            case 4:
                return soba.getCena();
            case 5:
                return soba.getPogled();
            default:
                throw new AssertionError();
        
        
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public Soba get(int pozicija) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public List<Soba> getSobe() {
        return sobe;
    }

    public void setSobe(List<Soba> sobe) {
        this.sobe = sobe;
    }

    
    
    
}
