/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Beans.Forecast;
import Beans.User;
import DB.ForecastDB;
import DB.UserDB;
import Util.MailUtil;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Stephen
 */
@WebServlet(name = "ForecastController", urlPatterns = {"/forecast"})
public class ForecastController extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        User user = new User();
        User admin = new User();
        user = (User) session.getAttribute("theUser");
        admin = (User) session.getAttribute("theAdmin");
        
        final String ADMIN_EMAIL = "sweber19@uncc.edu";
        
        String url = "/home.jsp";
        
        if(action == null){
            action = "join";
            url="/main.jsp";
        }
        if(action.equals("join")){
            url = "/home.jsp";
        }
        
        
        /*      Handle admin redirect and population of data        */
        if(admin != null){
            List<Forecast> forecasts = ForecastDB.getForecasts();
                List<Forecast> submittedForecasts = new ArrayList<Forecast>();
                for(Forecast f : forecasts){
                    if(f.getStatus().equals("Pending")){
                        submittedForecasts.add(f);
                    }
                }
                request.setAttribute("submittedForecasts",submittedForecasts);
        }
        
        if(action.equals("add")){
            String msg = "";
            Forecast forecast = new Forecast();
            int high = Integer.parseInt(request.getParameter("highTemp"));
            int low = Integer.parseInt(request.getParameter("lowTemp"));
            int wnd = Integer.parseInt(request.getParameter("windSpd"));
            String sky = request.getParameter("skyCond");
            double precip = Double.parseDouble(request.getParameter("precip"));
            
            if(user != null){
                forecast.setHighTemp(high);
                forecast.setLowTemp(low);
                forecast.setWindSpeed(wnd);
                forecast.setSkyConditions(sky);
                forecast.setPrecip(precip);
                forecast.setForecasterEmail(user.getEmail());
                forecast.setStatus("Pending");
                
                Date date = new Date();
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);
                StringBuilder sb = new StringBuilder();
                sb.append(date + " ");
                sb.append(user.getEmail());
                String id = sb.toString();
                forecast.setForecastID(id);
                
                StringBuilder sb2 = new StringBuilder();
                sb2.append(month);
                sb2.append("-" + day);
                sb2.append("-" + year);
                String dateTime = sb2.toString();
                forecast.setDateSubmitted(dateTime);
                
                List<Forecast> forecasts;
                forecasts = ForecastDB.getForecasts(user.getEmail());
                boolean submittedToday = false;
                if(forecasts != null){
                    for(Forecast f : forecasts){
                        if(f.getDateSubmitted().equals(dateTime)){
                            msg = "Sorry but you've already submitted a forecast today! Try again tomorrow!";
                            url="/forecast.jsp";
                            submittedToday = true;
                        }
                    }
                    url="/forecast.jsp";
                    request.setAttribute("msg",msg);
                }
                
                if(!submittedToday){
                    ForecastDB.insert(forecast);
                
                    //Send the admin (me) an email stating that a user has just added a new forecast..
                    String to = "stephen.weber3@gmail.com";
                    String from = user.getEmail();
                    String subject = "A user has submitted a new forecast";
                    String body 
                            = "Hi, Stephen,<br/><br/>"+
                                "A user has just submitted a new forecast, please login to approve! <br/><br/>" +
                                "<strong>Forecast details:<strong> <br/><br/>" +
                                "<table style='text-align: center;'>\n" +
                                "<tr>\n" +
                                "<th style='padding-right: 10px;'>High Temperature (F)</th>\n" +
                                "<th style='padding-right: 10px;'>Low Temperature (F)</th>\n" +
                                "<th style='padding-right: 10px;'>Wind Speed (MPH)</th>\n" +
                                "<th style='padding-right: 10px;'>Sky Conditions</th>\n" +
                                "<th style='padding-right: 10px;'>Precipitation (Inches)</th>\n" +
                                "</tr>\n" +
                                "<tr>\n" +
                                "<td>"+ high +"</td>\n" +
                                "<td>"+ low + "</td>\n" +
                                "<td>"+ wnd + "</td>\n" +
                                "<td>"+ sky +"</td>\n" +
                                "<td>"+ precip + "</td>\n" +
                                "</tr>\n" +
                                "</table>" +
                                "<br/><br/>" +
                                "Thank you!" + "<br/><br/>" +
                                "<span style='size:25px'>UNCC WxForecaster</span>";


                    boolean isBodyHTML = true;

                    try{
                        MailUtil.sendMail(to, from, subject, body,isBodyHTML);
                    }catch(MessagingException e){
                        String errorMessage
                                = "Error: Unable to send email. "
                                + "Check Tomcat logs for details. <br/> ";
                        request.setAttribute("errorMessage",errorMessage);
                    }
                    url="/thank-you.jsp";
                
                }
                
            }
            
        }
        
        if(action.equals("view-forecasts")){
            url = "/main.jsp";
            Date date = new Date();
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            int year = cal.get(Calendar.YEAR);
            int month = cal.get(Calendar.MONTH);
            int day = cal.get(Calendar.DAY_OF_MONTH);
            System.out.println(date);
            StringBuilder sb = new StringBuilder();
            sb.append(month);
            sb.append("-" + day);
            sb.append("-" + year);
            String dateTime = sb.toString();
            String status = "Approved";
            System.out.println(dateTime);

            List<Forecast> forecasts = ForecastDB.getTwentyFourForecasts(dateTime,status);
            request.setAttribute("approvedForecasts",forecasts);
            url="/view-forecasts.jsp";
        }
        
        if(action.equals("email")){
            String toAddr = request.getParameter("toAddr");
            String forecastID = request.getParameter("forecastID");
            if(!forecastID.isEmpty()){
                Forecast forecast = ForecastDB.getForecastById(forecastID);
                int highTemp = forecast.getHighTemp();
                int lowTemp = forecast.getLowTemp();
                int windSpd = forecast.getWindSpeed();
                String sky = forecast.getSkyConditions();
                double precip = forecast.getPrecip();

                String fromAddr;
                if(admin != null){
                    fromAddr = admin.getEmail();
                }else{
                    fromAddr = user.getEmail();
                }
                
                String to = toAddr;
                String from = fromAddr;
                String subject = "Check out this Charlotte area forecast!!";
                String body 
                        = "Hi, <br/>"
                        + "Your 24 hour forecast for Charlotte, NC starting tomorrow at 12:00 am EDT <br/><br/>"
                        + "High: " + highTemp + "F<br/>" + "Low: " + lowTemp + "F<br/>"
                        + "Winds: " + windSpd + "MPH<br/>" + "Skies: " + sky + "<br/>"
                        + "Precip (Inches): " + precip;

                boolean isBodyHTML = true;

                try{
                    MailUtil.sendMail(to, from, subject, body,isBodyHTML);
                }catch(MessagingException e){
                    String errorMessage
                            = "Error: Unable to send email. "
                            + "Check Tomcat logs for details. <br/> ";
                    request.setAttribute("errorMessage",errorMessage);
                }
            }
            url="/thank-you-email.jsp";
        }
        
        if(action.equals("admin")){
            List<Forecast> forecasts = ForecastDB.getForecasts();
            List<Forecast> submittedForecasts = new ArrayList<Forecast>();
            for(Forecast f : forecasts){
                if(f.getStatus().equals("Pending")){
                    submittedForecasts.add(f);
                }
            }
            request.setAttribute("submittedForecasts",submittedForecasts);
            url="/admin.jsp";
        }
        
        if(action.equals("approve")){
            url = "/main.jsp";
            String forecastID = request.getParameter("forecastID");
            if(admin != null){
                if(!forecastID.isEmpty()){
                    Forecast forecast = ForecastDB.getForecastById(forecastID);
                    forecast.setStatus("Approved");
                    ForecastDB.update(forecast);
                    
                    String toAddr = forecast.getForecasterEmail();
                    //Send an email to the submitted notifying that the forecast was approved!
                    String to = toAddr;
                    String from = ADMIN_EMAIL;
                    String subject = "Your forecast has been approved!";
                    String body 
                            = "Hi,<br/><br/>"+
                                "The administrators over at UNCC WxForecaster have approved your forecast! <br/><br/>" +
                                "Please go to the folowing link to compare it with everyone else's!<br/><br/>" +
                                "<a href='/'>View Forecasts</a> <br/><br/>" +
                                "Thank you!" + "<br/><br/>" +
                                "<span style='size:25px'>UNCC WxForecaster</span>";


                    boolean isBodyHTML = true;

                    try{
                        MailUtil.sendMail(to, from, subject, body,isBodyHTML);
                    }catch(MessagingException e){
                        String errorMessage
                                = "Error: Unable to send email. "
                                + "Check Tomcat logs for details. <br/> ";
                        request.setAttribute("errorMessage",errorMessage);
                    
                    List<Forecast> forecasts = ForecastDB.getForecasts();
                    List<Forecast> submittedForecasts = new ArrayList<Forecast>();
                    for(Forecast f : forecasts){
                        if(f.getStatus().equals("Pending")){
                            submittedForecasts.add(f);
                        }
                    }
                request.setAttribute("submittedForecasts",submittedForecasts);
                        url="/admin.jsp";
                    }
                }
            }
            
        }
        
       if(action.equals("disapprove")){
            url = "/main.jsp";
            String forecastID = request.getParameter("forecastID");
            if(admin != null){
                if(!forecastID.isEmpty()){
                    Forecast forecast = ForecastDB.getForecastById(forecastID);
                    forecast.setStatus("Rejected");
                    ForecastDB.update(forecast);
                    
                    String toAddr = forecast.getForecasterEmail();
                    //Send an email to the submitted notifying that the forecast was approved!
                    String to = toAddr;
                    String from = ADMIN_EMAIL;
                    String subject = "You're forecast has been rejected";
                    String body 
                            = "Hi,<br/><br/>"+
                                "We regret to inform you that, after review, we've decided to reject your forecast submission." +
                                "This based on the premise that the data you entered was not viable and skewed the other forecasts negatively.<br/><br/>" +
                                "Please try again tomorrow!<br/><br/>" +
                                "Thank you!" + "<br/><br/>" +
                                "<span style='size:25px'>UNCC WxForecaster</span>";


                    boolean isBodyHTML = true;

                    try{
                        MailUtil.sendMail(to, from, subject, body,isBodyHTML);
                    }catch(MessagingException e){
                        String errorMessage
                                = "Error: Unable to send email. "
                                + "Check Tomcat logs for details. <br/> ";
                        request.setAttribute("errorMessage",errorMessage);
                    }
                    
                    
                    List<Forecast> forecasts = ForecastDB.getForecasts();
                    List<Forecast> submittedForecasts = new ArrayList<Forecast>();
                    for(Forecast f : forecasts){
                        if(f.getStatus().equals("Pending")){
                            submittedForecasts.add(f);
                        }
                    }
                    request.setAttribute("submittedForecasts",submittedForecasts);
                    url="/admin.jsp";
                }
            }
            
        } 
        
    getServletContext()
                .getRequestDispatcher(url)
                .forward(request,response);      
       
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        doPost(request,response);
    }

}
