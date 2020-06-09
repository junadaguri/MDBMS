/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;
import BLL.Users;
import java.util.List;
import javax.persistence.Query;
/**
 *
 * @author Admin
 */
public class UsersRepository extends EntMngClass implements UsersInterface {

    @Override
    public void create(UsersInterface u) throws CrudFormException {
      try {
            em.getTransaction().begin();
            em.persist(u);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new CrudFormException("Msg \n" + e.getMessage());
        }  
    }

    @Override
    public void edit(UsersInterface u) throws CrudFormException {
       try {
            em.getTransaction().begin();
            em.merge(u);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new CrudFormException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public void delete(UsersInterface u) throws CrudFormException {
     try {
            em.getTransaction().begin();
            em.remove(u);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new CrudFormException("Msg \n" + e.getMessage());
        }   
    }

    @Override
    public List<Users> findAll() throws CrudFormException {
        try {
            return em.createNamedQuery("Users.findAll").getResultList();
        } catch (Exception e) {
            throw new CrudFormException("Msg! \n" + e.getMessage());
        }
    }

    @Override
    public Users findByID(Integer ID) throws CrudFormException {
        try {
            Query query = em.createQuery("SELECT u FROM Users u WHERE u.ID = :abc");
            query.setParameter("abc", ID);
            return (Users) query.getSingleResult();
        } catch (Exception e) {
            throw new CrudFormException("Msg! \n" + e.getMessage());
        }
    }

    @Override
    public Users loginByUsernameAndPassword(String n, String p) throws CrudFormException {
       try {
            Query query = em.createQuery("SELECT u FROM Users u WHERE u.username = :us AND u.password=:psw");
            query.setParameter("us", n);
            query.setParameter("psw", p);
            return (Users) query.getSingleResult();
        } catch (Exception e) {
            throw new CrudFormException("Msg! \n" + e.getMessage());
        }
    }
    }
    
   
    
  