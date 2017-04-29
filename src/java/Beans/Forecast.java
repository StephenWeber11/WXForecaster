/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Stephen
 */
@Entity
public class Forecast implements Serializable{
    
    private String forecasterEmail;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String forecastID;
    private int highTemp;
    private int lowTemp;
    private int windSpeed;
    private String skyConditions;
    private double precip;
    private String dateSubmitted;
    private String status;
    
    public Forecast(){
        
    }
    
    public void setForecastID(String forecastID){
        this.forecastID = forecastID;
    }
    
    public String getForecastID(){
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
    
    public void setDateSubmitted(String dateSubmitted){
        this.dateSubmitted = dateSubmitted;
    }
    
    public String getDateSubmitted(){
        return dateSubmitted;
    }
    
    public void setForecasterEmail(String forecasterEmail){
        this.forecasterEmail = forecasterEmail;
    }
    
    public String getForecasterEmail(){
        return forecasterEmail;
    }
    
    public void setStatus(String status){
        this.status = status;
    }
    
    public String getStatus(){
        return status;
    }
    
}
