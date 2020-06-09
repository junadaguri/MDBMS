/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Model;

import BLL.Cinema;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Spectre
 */
public class CinemaTableModel extends AbstractTableModel {
    
    List <Cinema> list;
    String [] cols = {"Nr." , "Name", "City"};
    
    public CinemaTableModel(){}
    
    public CinemaTableModel(List<Cinema> list){
        this.list = list;
    }
    
    public void addList(List<Cinema> list){
        this.list = list;
    }
    
    public String getColumnName(int col){
        return cols[col];
    }

    @Override
    public int getRowCount() {
        return list.size();
    }
    
    public void remove(int row){
        list.remove(row);
    }
    
    public Cinema getCinema(int index){
        return list.get(index);
    }

    @Override
    public int getColumnCount() {
        return cols.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cinema c = list.get(rowIndex);
        switch(columnIndex){
            case 0:
                return c.getId();
            case 1:
                return c.getName();
            case 2:
                return c.getCity();
            default:
                return null;
        }
    }
    
}
