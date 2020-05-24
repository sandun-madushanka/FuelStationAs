/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Servlet.employee.salary;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mypojos.Salary;
import mypojos.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Sandun
 */
@WebServlet(name = "employeeSalarydetailsAdd_serv", urlPatterns = {"/employeeSalarydetailsAdd_serv"})
public class employeeSalarydetailsAdd_serv extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {

            String l =  (String) request.getSession().getAttribute("user");
            if (l != null) {
//                System.out.println("user kenek innawaa----------------");

                String nic = request.getParameter("nic");
                String empsalsal = request.getParameter("empsalsal");
                String otcntsal = request.getParameter("otcntsal");
                String pppotsal = request.getParameter("pppotsal");
                String totsal = request.getParameter("totsal");

                Session ses = Connection.NewHibernateUtil.getSessionFactory().openSession();
                Transaction tr = ses.beginTransaction();

                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                Date datec = new Date();
                formatter.format(datec);
                
                Criteria cr = ses.createCriteria(User.class);
                cr.add(Restrictions.eq("nic", nic));
                cr.add(Restrictions.eq("utypstat", 2));
                User us = (User) cr.uniqueResult();
                
                Salary u = new Salary();
                
                u.setUser(us);
                u.setOthrcount(Double.parseDouble(otcntsal));
                u.setPricepOthr(Double.parseDouble(pppotsal));
                u.setTotal(Double.parseDouble(totsal));
                u.setStatus(1);
                u.setDatecreate(datec);
                
                ses.save(u);
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
        }
        
    }


}
