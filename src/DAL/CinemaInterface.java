/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Cinema;
import java.util.List;

/**
 *
 * @author Spectre
 */
public interface CinemaInterface {
    void create(Cinema c) throws CrudFormException;
    void edit(Cinema c) throws CrudFormException;
    void delete(Cinema c) throws CrudFormException;
    List <Cinema> findAll() throws CrudFormException;
    Cinema findByID(Integer ID) throws CrudFormException;
}
