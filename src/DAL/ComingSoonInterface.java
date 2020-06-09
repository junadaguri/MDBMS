/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.ComingSoon;
import java.util.List;

/**
 *
 * @author Spectre
 */
public interface ComingSoonInterface {
    void create(ComingSoon cs) throws CrudFormException;
    void edit(ComingSoon cs) throws CrudFormException;
    void delete(ComingSoon cs) throws CrudFormException;
    List <ComingSoon> findAll() throws CrudFormException;
    ComingSoon findByID(Integer ID) throws CrudFormException;
}
