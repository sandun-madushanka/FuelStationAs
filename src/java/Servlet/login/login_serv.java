/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Sandun
 */
@WebServlet(name = "login_serv", urlPatterns = {"/login_serv"})
public class login_serv extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            String user = request.getParameter("user");
            String pass = request.getParameter("pass");

            Session ses = Connection.NewHibernateUtil.getSessionFactory().openSession();
//            Criteria cr = ses.createCriteria(UserLogin.class);
//            cr.add(Restrictions.eq("email", user));
//            cr.add(Restrictions.eq("password", pass));
////            System.out.println(user+" "+pass);
//            UserLogin l = (UserLogin) cr.uniqueResult();
            if (user.equals("admin") && pass.equals("123")) {
                //Invalid Details
                request.getSession().setAttribute("user", "1");

                response.getWriter().write("2");

            } else if (user.equals("manager") && pass.equals("456")) {

                request.getSession().setAttribute("user", "2");

                response.getWriter().write("2");

            } else {
                response.getWriter().write("1");

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
