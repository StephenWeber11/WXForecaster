/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

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
        
        
        
    getServletContext()
                .getRequestDispatcher(url)
                .forward(request,response);      
       
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

}
