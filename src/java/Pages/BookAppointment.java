/*
 * Copyright © 2020 Simeon Dobchev, William Garthside,
 * Joshua Saxby, Alexander Stratford & Dylan Waters.
 * All rights reserved.
 */
package Pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Jdbc;

/**
 *
 * @author joshua
 */
@WebServlet(name = "BookAppointment", urlPatterns = {"/PatientDashboard/BookAppointment"})
public class BookAppointment extends HttpServlet {

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
            throws ServletException, IOException, SQLException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        
        HttpSession session = request.getSession(false);
        
        String [] query = new String[4];
        query[0] = (String)request.getParameter("username");
        query[1] = (String)request.getParameter("docName");
        query[2] = (String)request.getParameter("appDate");
        query[3] = (String)request.getParameter("appt");
      
        Jdbc jdbc = (Jdbc)session.getAttribute("dbbean"); 
        
        if (jdbc == null){
            request.getRequestDispatcher("/WEB-INF/conErr.jsp").forward(request, response);
        }

        // logged in user guard
       /* if (session.getAttribute("loggedInUser") == null) {
            throw new ServletException("Not logged in");
        }*/
        
        if(query[0].equals("") ) {
            request.setAttribute("message", "Username cannot be NULL");
        } 
        if(jdbc.exists(query[0])){
            String empID = jdbc.retriveEmployeeID(query[1]);
            String cliID = jdbc.retriveClientID(query[0]);
            query[1] = cliID;
            query[0] = empID; 
            jdbc.bookApp(query);
            request.setAttribute("message", query[0] +" Your appointment for " + query[3]+ "is now booked.");
          
        }else{
            request.setAttribute("message", query[0]+ " Username not found");
        }

         
        request.getRequestDispatcher("/WEB-INF/bookAppointment.jsp").forward(request, response);
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
        try {
            processRequest(request, response);
        } catch (SQLException | ParseException ex) {
            Logger.getLogger(BookAppointment.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(BookAppointment.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(BookAppointment.class.getName()).log(Level.SEVERE, null, ex);
        }
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
