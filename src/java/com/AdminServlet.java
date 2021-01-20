/*
 * Copyright © 2020 Simeon Dobchev, William Garthside,
 * Joshua Saxby, Alexander Stratford & Dylan Waters.
 * All rights reserved.
 */
package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
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
public class AdminServlet extends HttpServlet {

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
        String qry = "select * from USERS";
       
        HttpSession session = request.getSession();
        
        response.setContentType("text/html;charset=UTF-8");
        
        Jdbc dbBean = new Jdbc();
        //conn = DriverManager.getConnection("jdbc:derby://localhost:1527/"+db.trim(),"dylan","123456");
        dbBean.connect((Connection)request.getServletContext().getAttribute("connection"));
        session.setAttribute("dbbean", dbBean);
        
        if((Connection)request.getServletContext().getAttribute("connection")==null)
            request.getRequestDispatcher("/WEB-INF/conErr.jsp").forward(request, response);

        // logged in user guard
        if (session.getAttribute("loggedInUser") == null) {
            throw new ServletException("Not logged in");
        }
        
        switch (request.getParameter("tbl")) {
            case "Timetable":
                request.getRequestDispatcher("adminDashboard.jsp").forward(request, response);
                break;
            case "Records":
                request.setAttribute("msg", "new");
                request.getRequestDispatcher("/WEB-INF/EmployeeAddress.jsp").forward(request, response);
                break;
            case "Documents":
                request.setAttribute("msg", "");
                request.getRequestDispatcher("/WEB-INF/AdminFees.jsp").forward(request, response);
                break;
            case "NewEmp":
                request.setAttribute("msg", "new");
                request.getRequestDispatcher("/WEB-INF/employee.jsp").forward(request, response);  
                break;
            default:
                break;
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
