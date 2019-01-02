/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import util.DBIO;

/**
 *
 * @author andrei
 */
@WebServlet(name = "AdminUsers", urlPatterns = {"/AdminUsers"})
public class AdminUsers extends HttpServlet {

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

        DBIO dbio = new DBIO();
        dbio.connect();

        String ssn = request.getParameter("admin_users_ssn");
        String username = request.getParameter("admin_users_username");
        String password = request.getParameter("admin_users_password");
        String role = request.getParameter("admin_user_role");
        String[] selectedCheckboxes = request.getParameterValues("admin_users_checkbox");
        String query;
        
        System.out.println("ssn: " + ssn);
        
        if (request.getParameter("admin_users_insert") != null) {
            query = "INSERT INTO EBOOKS.USERS(SSN, NAME, PASSWORD, ROLE) VALUES (?, ?, ?, ?)";
            dbio.runPreparedStatement(query, ssn, username, password, role);
            request.getRequestDispatcher("./adminUsers.jsp").forward(request, response);
        } else if (request.getParameter("admin_users_update") != null) {
            boolean hasUsername = !"".equals(username);
            boolean hasPassword = !"".equals(password);
            for (String str : selectedCheckboxes) {
                ssn = str;
                if (!hasUsername && !hasPassword) {
                    query = "UPDATE EBOOKS.USERS SET role=? WHERE SSN=?";    
                    dbio.runPreparedStatement(query, role, ssn);                    
                } else if (!hasUsername && hasPassword) {
                    query = "UPDATE EBOOKS.USERS SET password=?, role=? WHERE SSN=?";    
                    dbio.runPreparedStatement(query, password, role, ssn);                    
                } else if (hasUsername && !hasPassword) {
                    query = "UPDATE EBOOKS.USERS SET name=?, role=? WHERE SSN=?";
                    dbio.runPreparedStatement(query, username, role, ssn);
                } else if (hasUsername && hasPassword) {
                    query = "UPDATE EBOOKS.USERS SET name=?, password=?, role=? WHERE SSN=?";
                    dbio.runPreparedStatement(query, username, password, role, ssn);
                }
                request.getRequestDispatcher("./adminUsers.jsp").forward(request, response);
            }
        } else if (request.getParameter("admin_users_delete") != null) {
            dbio.setAutoCommit(false);
            query = "DELETE FROM EBOOKS.USERS WHERE SSN=?";
            for (String str : selectedCheckboxes) {
                ssn = str;
                dbio.runPreparedStatement(query, ssn);
            }
            dbio.commit();
            dbio.setAutoCommit(true);
            request.getRequestDispatcher("./adminUsers.jsp").forward(request, response);
        } else if (request.getParameter("admin_users_cancel") != null){       
            request.getRequestDispatcher("./records.jsp").forward(request, response);
        } else {
            System.out.println("Unhandled request in admin users page");
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
