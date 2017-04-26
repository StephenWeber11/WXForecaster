/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Stephen
 */
public class Forecast implements Serializable{
    
    private int forecastID;
    private int highTemp;
    private int lowTemp;
    private int windSpeed;
    private String skyConditions;
    private double precip;
    private Date dateSubmitted;
    private String email;
    
    public Forecast(){
        
    }
    
    public void setForecastID(int forecastID){
        this.forecastID = forecastID;
    }
    
    public int getForecastID(){
        return forecastID;
    }
    
    public void setHighTemp(int highTemp){
        this.highTemp = highTemp;
    }
    
    public int getHighTemp(){
        return highTemp;
    }
    
    public void setLowTemp(int lowTemp){
        this.lowTemp = lowTemp;
    }
    
    public int getLowTemp(){
        return lowTemp;
    }
    
    public void setWindSpeed(int windSpeed){
        this.windSpeed = windSpeed;
    }
    
    public int getWindSpeed(){
        return windSpeed;
    }
    
    public void setSkyConditions(String skyConditions){
        this.skyConditions = skyConditions;
    }
    
    public String getSkyConditions(){
        return skyConditions;
    }
    
    public void setPrecip(double precip){
        this.precip = precip;
    }
    
    public double getPrecip(){
        return precip;
    }
    
    public void setDateSubmitted(Date dateSubmitted){
        this.dateSubmitted = dateSubmitted;
    }
    
    public Date getDateSubmitted(){
        return dateSubmitted;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public String getEmail(){
        return email;
    }
    
}
