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
public class CinemaRepository extends EntMngClass implements CinemaInterface{

    @Override
    public void create(Cinema c) throws CrudFormException {
        try{
           em.getTransaction().begin();
           em.persist(c);
           em.getTransaction().commit();
       }catch(Exception e){
           throw new CrudFormException("Msg \n" + e.getMessage());
       }
    }

    @Override
    public void edit(Cinema c) throws CrudFormException {
        try{
            em.getTransaction().begin();
            em.merge(c);
            em.getTransaction().commit();
        }catch(Exception e){
            throw new CrudFormException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public void delete(Cinema c) throws CrudFormException {
        try{
            em.getTransaction().begin();
            em.remove(c);
            em.getTransaction().commit();
        }catch(Exception e){
            throw new CrudFormException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public List<Cinema> findAll() throws CrudFormException {
        try{
            return em.createNamedQuery("Cinema.findAll").getResultList();
        }catch(Exception e){
            throw new CrudFormException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public Cinema findByID(Integer ID) throws CrudFormException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }   
}
