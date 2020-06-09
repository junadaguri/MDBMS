/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Model;

import BLL.ComingSoon;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Spectre
 */
public class ComingSoonTableModel extends AbstractTableModel{

    List<ComingSoon> list;
    String [] cols = {"Nr." , "Movie Name", "Date", "Cinema"};
    
    public ComingSoonTableModel(){}
    
    public ComingSoonTableModel(List<ComingSoon> list){
        this.list = list;
    }
    
    public void addList(List<ComingSoon> list){
        this.list = list;
    }
    
    public String getColumnName(int col){
        return cols[col];
    }
    
    public void remove(int row){
        list.remove(row);
    }
    
    public ComingSoon getComingSoon(int index){
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
        ComingSoon cs = list.get(rowIndex);
        switch(columnIndex){
            case 0:
                return cs.getId();
            case 1:
                return cs.getCSMovieName();
            case 2:
                return getDateToString(cs.getDate());
            case 3:
                return cs.getCinemaID();
            default:
                return null;
        }
    }
    
    public String getDateToString(Date d){
        DateFormat da = new SimpleDateFormat("dd-MM-yyyy");
        return da.format(d);
    }
    
}
