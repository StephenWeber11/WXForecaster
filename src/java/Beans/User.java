/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Stephen
 */

public class User implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String email;
    
    private String firstName;
    private String lastName;
    private String password;
    private String role;
    private String hash;
    private String salt;
    
    public User(){
        
    }
    
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    
    public String getFirstName(){
        return firstName;
    }
    
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    
    public String getLastName(){
        return lastName;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public String getEmail(){
        return email;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    public String getPassword(){
        return password;
    }
    
    public void setRole(String role){
        this.role = role;
    }
    
    public String getRole(){
        return role;
    }
    
    public void setSalt(String salt){
        this.salt = salt;
    }
    
    public String getSalt(){
        return salt;
    }
    
    public void setHash(String hash){
        this.hash = hash;
    }
    
    public String getHash(){
        return hash;
    }
    
    
}
