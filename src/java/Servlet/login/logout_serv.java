/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet.login;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Sandun
 */
@WebServlet(name = "logout_serv", urlPatterns = {"/logout_serv"})
public class logout_serv extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        try {

//            UserLogin ul = (UserLogin) request.getSession().getAttribute("user");


            if (session.getAttribute("user") != null) {
                session.invalidate();
            } else {

            }
            response.sendRedirect("index.jsp");
        } catch (Exception e) {
            e.printStackTrace();

        }

    }

}
