/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Model;

import BLL.Ticket;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Spectre
 */
public class TicketTableModel extends AbstractTableModel{
    
    List<Ticket> list;
    String [] cols = {"Nr.", "Ticket Name" , "Cinema", "Movie"};
    
    public TicketTableModel(){}
    
    public TicketTableModel(List<Ticket> list){
        this.list = list;
    }
    
    public void addList(List<Ticket> list){
        this.list = list;
    }
    
    public String getColumnName(int col){
        return cols[col];
    }
    
    public void remove(int row){
        list.remove(row);
    }
    
    public Ticket getTicket(int index){
        return list.get(index);
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return cols.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Ticket t = list.get(rowIndex);
        switch(columnIndex){
            case 0:
                return t.getId();
            case 1:
                return t.getTicketName();
            case 2:
                return t.getCinemaID();
            case 3:
                return t.getMovieID();
            default:
                return null;
        }
    }
    
}
