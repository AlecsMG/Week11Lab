/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.AccountService;

/**
 *
 * @author 831690
 */
public class ForgotPasswordServlet extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setAttribute("message", "Please enter your email address to retrieve your password.");
        
        getServletContext().getRequestDispatcher("/WEB-INF/forgot.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setAttribute("message", "If the address you entered is valid, you will receive an email very soon. Please check your email for your password.");

        String email = request.getParameter("email");
        String path = getServletContext().getRealPath("/WEB-INF");
        AccountService as = new AccountService();
        
        as.forgotPassword(path, email);
        
        getServletContext().getRequestDispatcher("/WEB-INF/forgot.jsp").forward(request, response);
        
        
        
    }


}
