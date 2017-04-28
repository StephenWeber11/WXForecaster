/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import Beans.User;
import java.util.List;
import DB.DBUtil;
import Util.PasswordUtil;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Stephen Weber
 */
public class UserDB {
        
    public static void insert(User user) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();        
        try {
            em.persist(user);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }
    
        public static void update(User user) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();       
        try {
            em.merge(user);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public static void delete(User user) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();        
        try {
            em.remove(em.merge(user));
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }       
    }
    
    public static User getUser(String email){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT u FROM User u " +
                "WHERE u.email = :email";
        TypedQuery<User> q = em.createQuery(qString, User.class);
        q.setParameter("email", email);
        try {
            User user = q.getSingleResult();
            return user;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }
    
    public static List<User> getUsers(){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT u FROM User u + "
                + "WHERE EMAIL != null";
        TypedQuery<User> q = em.createQuery(qString,User.class);
        List<User> users;
        try{
            users = q.getResultList();
            if(users == null || users.isEmpty()){
                users = null;
            }
        }finally{
            em.close();
        }
        return users;
    }
    
    public static boolean emailExists(String email) {
        User u = getUser(email);   
        return u != null;
    }
    
    public static boolean passwordIsValid(String email,String userPass){
        User u = getUser(email);
        String password = u.getPassword();
        String salt = u.getSalt();
        System.out.println("Salt " + salt);
        
        String newPass = "";
        String hashedPass = "";
        try {
            newPass = PasswordUtil.hashPassword(userPass + salt);
            hashedPass = PasswordUtil.hashPassword(userPass);
            System.out.println("UserPass " + userPass);
            System.out.println("Hash " + hashedPass);
            System.out.println("Hash + Salt " + newPass);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(password.equals(newPass)){
            return true;
        }
        
        return false;
    }
    
    
}
