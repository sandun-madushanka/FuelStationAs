/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet.sales;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mypojos.Dailysales;
import mypojos.Fuelstock;
import mypojos.Invoice;
import mypojos.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Sandun
 */
@WebServlet(name = "sailysalesAdd_serv", urlPatterns = {"/sailysalesAdd_serv"})
public class sailysalesAdd_serv extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            String l = (String) request.getSession().getAttribute("user");
            if (l != null) {
                
                String fueltypdlysale = request.getParameter("fueltypdlysale");
                String expndsale = request.getParameter("expndsale");
                String revdsale = request.getParameter("revdsale");
                String totdsale = request.getParameter("totdsale");

                Session ses = Connection.NewHibernateUtil.getSessionFactory().openSession();

                Dailysales u = new Dailysales();

                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                Date datec = new Date();
                formatter.format(datec);

                Transaction tr = ses.beginTransaction();

                u.setFueltyp(Integer.parseInt(fueltypdlysale));
                u.setExpence(Double.parseDouble(expndsale));
                u.setRevenue(Double.parseDouble(revdsale));
                u.setTotal(Double.parseDouble(totdsale));
                u.setDatesl(datec);
                
                ses.save(u);

                tr.commit();
                ses.flush();
                
////
                response.getWriter().write("1");
                
                ses.close();
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
