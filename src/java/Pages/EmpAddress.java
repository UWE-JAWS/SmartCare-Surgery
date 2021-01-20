/*
 * Copyright © 2020 Simeon Dobchev, William Garthside,
 * Joshua Saxby, Alexander Stratford & Dylan Waters.
 * All rights reserved.
 */
package Pages;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Jdbc;

/**
 *
 * @author Dylan
 */
public class EmpAddress extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
        protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       
         HttpSession session = request.getSession(false);
        
        Jdbc jdbc = (Jdbc)session.getAttribute("dbbean"); 
        if (jdbc == null)
            request.getRequestDispatcher("/WEB-INF/conErr.jsp").forward(request, response);
        else {
            String [] query = new String[3];
        
            query[0] = (String)request.getParameter("fullname");
            query[1] = (String)request.getParameter("address");
            query[2] = (String)request.getParameter("username");  
            
            if(jdbc.exists(query[2])) {
                jdbc.insertEmpAdress(query);
                request.setAttribute("msg", ""+query[0]+"'s address has been updated");

            }
             else {
                request.setAttribute("msg", ""+query[2]+"Does not exist in Users");
                
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
