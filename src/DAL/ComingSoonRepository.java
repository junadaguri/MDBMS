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
public class ComingSoonRepository extends EntMngClass implements ComingSoonInterface{

    @Override
    public void create(ComingSoon cs) throws CrudFormException {
        try{
           em.getTransaction().begin();
           em.persist(cs);
           em.getTransaction().commit();
        }catch(Exception e){
           throw new CrudFormException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public void edit(ComingSoon cs) throws CrudFormException {
        try{
            em.getTransaction().begin();
            em.merge(cs);
            em.getTransaction().commit();
        }catch(Exception e){
            throw new CrudFormException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public void delete(ComingSoon cs) throws CrudFormException {
        try{
            em.getTransaction().begin();
            em.remove(cs);
            em.getTransaction().commit();
        }catch(Exception e){
            throw new CrudFormException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public List<ComingSoon> findAll() throws CrudFormException {
        try{
            return em.createNamedQuery("ComingSoon.findAll").getResultList();
        }catch(Exception e){
            throw new CrudFormException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public ComingSoon findByID(Integer ID) throws CrudFormException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
