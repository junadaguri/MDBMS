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
public class TicketRepository extends EntMngClass implements TicketInterface{

    @Override
    public void create(Ticket t) throws CrudFormException {
        try{
            em.getTransaction().begin();
            em.persist(t);
            em.getTransaction().commit();
        }catch(Exception e){
            throw new CrudFormException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public void edit(Ticket t) throws CrudFormException {
        try{
            em.getTransaction().begin();
            em.merge(t);
            em.getTransaction().commit();
        }catch(Exception e){
            throw new CrudFormException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public void delete(Ticket t) throws CrudFormException {
        try{
            em.getTransaction().begin();
            em.remove(t);
            em.getTransaction().commit();
        }catch(Exception e){
            throw new CrudFormException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public List<Ticket> findAll() throws CrudFormException {
        try{
            return em.createNamedQuery("Ticket.findAll").getResultList();
        }catch(Exception e){
            throw new CrudFormException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public Ticket findByID(Integer ID) throws CrudFormException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
