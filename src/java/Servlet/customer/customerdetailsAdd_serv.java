/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Servlet.customer;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mypojos.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Sandun
 */
@WebServlet(name = "customerdetailsAdd_serv", urlPatterns = {"/customerdetailsAdd_serv"})
public class customerdetailsAdd_serv extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {

            String l =  (String) request.getSession().getAttribute("user");
            if (l != null) {
//                System.out.println("user kenek innawaa----------------");

                String fname = request.getParameter("fnm");
                String lname = request.getParameter("lnam");
                String nic = request.getParameter("nic");
                String adress = request.getParameter("adrs");
                String mob = request.getParameter("mob");
                String tel = request.getParameter("tel");
                int lcstat = Integer.parseInt(request.getParameter("lcstat"));
                String detail = request.getParameter("dis");

                Session ses = Connection.NewHibernateUtil.getSessionFactory().openSession();
                Transaction tr = ses.beginTransaction();

                User u = new User();
                
                u.setFname(fname);
                u.setLname(lname);
                u.setNic(nic);
                u.setAddress(adress);
                u.setMobile(mob);
                u.setTelephone(tel);
                u.setLoyaltycard(lcstat);
                u.setDiscription(detail);
                u.setStatus(1);
                u.setUtypstat(3);
                
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
