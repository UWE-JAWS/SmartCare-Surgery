/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pages;
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.lang.NullPointerException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
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
public class Login extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException
     */
      protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        
        HttpSession session = request.getSession(false);
        
        String [] query = new String[2];
        query[0] = (String)request.getParameter("username");
        query[1] = (String)request.getParameter("password");
      
        Jdbc jdbc = (Jdbc)session.getAttribute("dbbean"); 
        
        if (jdbc == null){
            request.getRequestDispatcher("/WEB-INF/conErr.jsp").forward(request, response);
        }
        if(query[0].equals("") ) {
            request.setAttribute("message", "Username cannot be NULL");
        } 
        if(jdbc.login(query[0],query[1])){
            String job = jdbc.retriveType(query[0]);
            String destination = jobs(job);
            // store username for retrieval when needed
            session.setAttribute("loggedInUser", query[0]);
            request.getRequestDispatcher(destination).forward(request, response);
            //String Name = jdbc.retriveName(query[0]);
            //request.setAttribute("message", Name +" Welcome back");
          
        }else{
            request.setAttribute("message", query[0]+ " Username/Password not found");
        }

         
        request.getRequestDispatcher("/WEB-INF/user.jsp").forward(request, response);
    }
      
      public String jobs(String role) throws ServletException{
          String dest = null;
          switch (role) {
          case "A": // Admin
              return "/adminDashboard.jsp";
          case "D": // Doctor
              return "/doctorDashboard.jsp";
          case "N": // Nurse
              return "/nurseDashboard.jsp";
          case "C": // Client
              return "/patientDashboard.jsp";
          default:
              throw new ServletException("Invalid User role type given");
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
          try {
              processRequest(request, response);
          } catch (SQLException ex) {
              Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
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
              Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
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

