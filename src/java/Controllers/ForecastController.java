/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Beans.Forecast;
import java.io.IOException;
import java.io.PrintWriter;
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
        String url = "/home.jsp";
        
        if(action == null){
            action = "join";
        }
        if(action.equals("join")){
            url = "/home.jsp";
        }
        
        if(action.equals("email")){
            String highTemp = request.getParameter("highTemp");
            String lowTemp = request.getParameter("lowTemp");
            String windSpd = request.getParameter("windSpd");
            //TODO: Add rest of parameters!
            
            //Forecast forecast = ForecastDB.getForecast(email); 
            //Sending email need to add more code above..
            //String to = email;
            //String from = email;
            String subject = "Check out this Charlotte area forecast!!";
            String boday = "Hi, ";
        }
        
    getServletContext()
                .getRequestDispatcher(url)
                .forward(request,response);      
       
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

}
