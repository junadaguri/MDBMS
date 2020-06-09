/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Model;

import BLL.Cinema;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author Spectre
 */
public class CinemaComboBoxModel extends AbstractListModel<Cinema> implements ComboBoxModel<Cinema>{
    
    private List<Cinema> data;
    private Cinema selectedItem;
    
    public CinemaComboBoxModel(){}
    
    public CinemaComboBoxModel(List<Cinema> data){
        this.data = data;
    }
    
    public void add(List<Cinema> data){
        this.data = data;
    }
    
    @Override
    public int getSize() {
         return data.size();
    }

    @Override
    public Cinema getElementAt(int index) {
        return data.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selectedItem = (Cinema)anItem;
    }

    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }
    
}
