/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Beans.User;
import DB.UserDB;
import Util.PasswordUtil;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "UserController", urlPatterns = {"/user"})
public class UserController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        String url = "/home.jsp";
        User user = new User();
        User admin = new User();
        
        if(action == null){
            action = "join";
        }
        if(action.equals("join")){
            url = "/home.jsp";
        }
        
        
        //Handle Login
        if(action.equals("login")){
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            user = UserDB.getUser(email);
            String salt = user.getSalt();
            
            String msg = "";
            if(!UserDB.emailExists(email)){
                msg = "Sorry but this user does not exist. <br/>" + 
                        "Please try another email address.";
                url = "/login.jsp";
            }else{
                if(UserDB.passwordIsValid(email,password)){
                    if(user.getRole().equals("user")){
                        session.setAttribute("theUser",user);
                        url = "/main.jsp";
                    }
                    if(user.getRole().equals("admin")){
                        session.setAttribute("theAdmin",user);
                        url = "/main.jsp";
                    }
                }else{
                    msg="The password you entered is invalid, please try again!";
                    url="/login.jsp";
                    
                }
            }
            session.setAttribute("msg",msg);
        }
        
        //Handle account creation
        if(action.equals("create")){
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");
            String type = request.getParameter("type");
            String password = request.getParameter("password");
            String msg = "";
            
            user = new User();
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setEmail(email);
            user.setRole("user");
            
            String message;
            try {
                PasswordUtil.checkPasswordStrength(password);
                message = "";
            } catch (Exception e) {
                message = e.getMessage();
            }
            request.setAttribute("message", message);  
            
            //Hash and salt password from Chapter 17 example
            String salt = "";
            String saltedAndHashedPassword;
            try {
                salt = PasswordUtil.getSalt();
                saltedAndHashedPassword = PasswordUtil.hashPassword(password+salt);                    

            } catch (NoSuchAlgorithmException ex) {
                saltedAndHashedPassword = ex.getMessage();
            }
            
            user.setSalt(salt);
            user.setPassword(saltedAndHashedPassword);
            
            if(UserDB.emailExists(email)){
                msg = "Sorry, the email you entered already exists. <br/>" +
                        "Please enter another email address.";
                url = "/signup.jsp";
                session.setAttribute("msg", msg);
            }else{
                session.setAttribute("theUser", user);
                url = "/main.jsp";
                UserDB.insert(user);
            }
        }
        
        if(action.equals("logout")){
            url = "/home.jsp";
            if(user != null){
                session.invalidate();
                request.logout();
                url = "/home.jsp";
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
