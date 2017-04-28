/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import Beans.Forecast;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
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
public class ForecastDB {
        
    public static void insert(Forecast user) {
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
    
        public static void update(Forecast forecast) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();       
        try {
            em.merge(forecast);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public static void delete(Forecast forecast) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();        
        try {
            em.remove(em.merge(forecast));
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }       
    }
    
    public static Forecast getForecast(String email){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT f FROM Forecast f " +
                "WHERE f.email = :email";
        TypedQuery<Forecast> q = em.createQuery(qString, Forecast.class);
        q.setParameter("email", email);
        try {
            Forecast user = q.getSingleResult();
            return user;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }
    
    public static List<Forecast> getForecasts(){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT f FROM Forecast f + "
                + "WHERE EMAIL != null";
        TypedQuery<Forecast> q = em.createQuery(qString,Forecast.class);
        List<Forecast> users;
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
        Forecast f = getForecast(email);   
        return f != null;
    }
    
    
    
}
