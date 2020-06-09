/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Model;

import BLL.Movie;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Spectre
 */
public class MovieTableModel extends AbstractTableModel {
    
    List<Movie> list;
    String [] cols = {"Nr.", "Movie Name" , "Date", "Cinema"};
    
    public MovieTableModel(){}
    
    public MovieTableModel(List<Movie> list){
        this.list = list;
    }
    
    public void addList(List<Movie> list){
        this.list = list;
    }
    
    public String getColumnName(int col){
        return cols[col];
    }
    
    public void remove(int row){
        list.remove(row);
    }
    
    public Movie getMovie(int index){
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
        Movie m = list.get(rowIndex);
        switch(columnIndex){
            case 0:
                return m.getId();
            case 1:
                return m.getMovieName();
            case 2:
                return getDateToString(m.getDate());
            case 3:
                return m.getCinemaID();
            default:
                return null;
        }
    }
    
    public String getDateToString(Date d){
        DateFormat da = new SimpleDateFormat("dd-MM-yyyy");
        return da.format(d);
    }
}
