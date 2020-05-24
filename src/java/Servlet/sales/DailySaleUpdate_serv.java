/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Servlet.sales;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mypojos.Dailysales;
import mypojos.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Sandun
 */
@WebServlet(name = "DailySaleUpdate_serv", urlPatterns = {"/DailySaleUpdate_serv"})
public class DailySaleUpdate_serv extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        try {

            String l = (String) request.getSession().getAttribute("user");
            if (l != null) {
//                System.out.println("user kenek innawaa----------------");

                String saleid = request.getParameter("idu");
                String tot = request.getParameter("tot");

                Session ses = Connection.NewHibernateUtil.getSessionFactory().openSession();
                Transaction tr = ses.beginTransaction();
                Criteria cr = ses.createCriteria(Dailysales.class);
                cr.add(Restrictions.eq("iddailysales", Integer.parseInt(saleid)));

                Dailysales u = (Dailysales) cr.uniqueResult();

                u.setTotal(Double.parseDouble(tot));

                ses.update(u);
//            System.out.println("Update unaa>>>>>>>>>>>>>>>>>>>>>..");
                tr.commit();
                ses.flush();
                ses.close();
//

                response.getWriter().write("1");
                
                

            } else {
                response.getWriter().write("4");
            }

//            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>.");
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().write("2");
        }
        
    }


}
