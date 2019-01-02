/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import util.DBIO;

/**
 *
 * @author andrei
 */
@WebServlet(name = "Index", urlPatterns = {"/Index"})
public class Index extends HttpServlet {

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
        
        String username = request.getParameter("authenticationpage_username");
        String password = request.getParameter("authenticationpage_password");
        DBIO dbio = new DBIO();
        dbio.connect();
        //dbio.createDB();

        String query = "SELECT NAME, PASSWORD, ROLE FROM EBOOKS.USERS "
            + "WHERE NAME='" + username + "' AND PASSWORD='" + password + "'";

        //confirm that a row with the specified  and password exists in the database
        boolean entryExists;
        ResultSet resultSet;
        String role;
        try {
            resultSet = dbio.runQuery(query);
            entryExists = resultSet.next();
            role = resultSet.getString("ROLE");
        } catch (SQLException ex) {
            resultSet = null;
            System.out.println(ex);
            role = "";
            entryExists = false;
        }
        
        HttpSession session = request.getSession();
        if (entryExists) {
            session.setAttribute("validUser", true);
            session.setAttribute("actualUser", username);
            session.setAttribute("actualUserRole", role);
            request.getRequestDispatcher("./records.jsp").forward(request, response);
        } else {
            session.setAttribute("validUser", false);
            request.getRequestDispatcher("./index.jsp").forward(request, response);                
        }

        dbio.closeAll();
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
