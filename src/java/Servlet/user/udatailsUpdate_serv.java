/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet.user;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mypojos.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author Sandun
 */
@WebServlet(name = "udatailsUpdate_serv", urlPatterns = {"/udatailsUpdate_serv"})
public class udatailsUpdate_serv extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

//        try {
//
//            UserLogin l = (UserLogin) request.getSession().getAttribute("user");
//            if (l != null) {
////                System.out.println("user kenek innawaa----------------");
//
//                String fname = request.getParameter("fnm");
//                String lname = request.getParameter("lnam");
//                String nic = request.getParameter("nic");
//                String adress = request.getParameter("adrs");
//                String mob = request.getParameter("mob");
//                String tel = request.getParameter("tel");
//
//                Session ses = Connection.NewHibernateUtil.getSessionFactory().openSession();
//                Transaction tr = ses.beginTransaction();
//
//                Criteria cr = ses.createCriteria(User.class);
//                UserLogin ul = (UserLogin) ses.load(UserLogin.class, l.getIduserLogin());
//                cr.add(Restrictions.eq("userLogin", ul));
//                User usr = (User) cr.uniqueResult();
//
//                usr.setFname(fname);
//                usr.setLname(lname);
//                usr.setNic(nic);
//                usr.setAddress(adress);
//                usr.setMobile(mob);
//                usr.setTelephone(mob);
//
//                ses.update(usr);
////            System.out.println("Update unaa>>>>>>>>>>>>>>>>>>>>>..");
//                tr.commit();
//                ses.flush();
//                ses.close();
////
//                response.getWriter().write("1");
//            } else {
//                response.getWriter().write("4");
//            }
//
////            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>.");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

    }

}
