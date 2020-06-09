/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;
import BLL.Users;
import java.util.List;
/**
 *
 * @author Admin
 */
public interface UsersInterface {
    void create(UsersInterface u) throws CrudFormException;
    void edit(UsersInterface u) throws CrudFormException;
    void delete(UsersInterface u) throws CrudFormException;
    List<Users> findAll() throws CrudFormException;
    Users findByID(Integer ID) throws CrudFormException;
    Users loginByUsernameAndPassword(String n, String p) throws CrudFormException;
    
}
