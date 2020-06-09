/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Ticket;
import java.util.List;

/**
 *
 * @author Spectre
 */
public interface TicketInterface {
    void create(Ticket t) throws CrudFormException;
    void edit(Ticket t) throws CrudFormException;
    void delete(Ticket t) throws CrudFormException;
    List <Ticket> findAll() throws CrudFormException;
    Ticket findByID(Integer ID) throws CrudFormException;
}
