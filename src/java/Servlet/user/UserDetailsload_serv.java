/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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

/**
 *
 * @author Sandun
 */
@WebServlet(name = "UserDetailsload_serv", urlPatterns = {"/UserDetailsload_serv"})
public class UserDetailsload_serv extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

//        try {
////            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>.");
//
//            String l = request.getSession().getAttribute("user").toString();
//            if (l != null || !l.equals("")) {
//
//                Session ses = Connection.NewHibernateUtil.getSessionFactory().openSession();
//                Transaction tr = ses.beginTransaction();
//
//                Criteria cr = ses.createCriteria(User.class);
//                UserLogin ul = (UserLogin) ses.load(UserLogin.class, l.getIduserLogin());
//                cr.add(Restrictions.eq("userLogin", ul));
//                User usr = (User) cr.uniqueResult();
//
//                String txt = "<div class=\"row\">\n" +
//"                                                <div class=\"col-md-6\">\n" +
//"                                                    <div class=\"form-group\">\n" +
//"                                                        <label>First Name</label>\n" +
//"                                                        <input type=\"text\" id=\"ufnm\" class=\"form-control border-input\" placeholder=\"Company\" value=\""+usr.getFname()+"\">\n" +
//"                                                    </div>\n" +
//"                                                </div>\n" +
//"                                                <div class=\"col-md-6\">\n" +
//"                                                    <div class=\"form-group\">\n" +
//"                                                        <label>Last Name</label>\n" +
//"                                                        <input type=\"text\" id=\"ulnm\" class=\"form-control border-input\" placeholder=\"Last Name\" value=\""+usr.getLname()+"\">\n" +
//"                                                    </div>\n" +
//"                                                </div>\n" +
//"                                            </div>\n" +
//"\n" +
//"                                            <div class=\"row\">\n" +
//"                                                <div class=\"col-md-4\">\n" +
//"                                                    <div class=\"form-group\">\n" +
//"                                                        <label>NIC</label>\n" +
//"                                                        <input type=\"text\" id=\"unic\" class=\"form-control border-input\" placeholder=\"nic\" value=\""+usr.getNic()+"\">\n" +
//"                                                    </div>\n" +
//"                                                </div>\n" +
//"                                                <div class=\"col-md-8\">\n" +
//"                                                    <div class=\"form-group\">\n" +
//"                                                        <label>Address</label>\n" +
//"                                                        <input type=\"text\" id=\"uadrs\" class=\"form-control border-input\" placeholder=\"Home Address\" value=\""+usr.getAddress()+"\">\n" +
//"                                                    </div>\n" +
//"                                                </div>\n" +
//"                                            </div>\n" +
//"\n" +
//"                                            <div class=\"row\">\n" +
//"                                                <div class=\"col-md-4\">\n" +
//"                                                    <div class=\"form-group\">\n" +
//"                                                        <label>Mobile</label>\n" +
//"                                                        <input type=\"number\" id=\"umob\" class=\"form-control border-input\" placeholder=\"mobile\" value=\""+usr.getMobile()+"\">\n" +
//"                                                    </div>\n" +
//"                                                </div>\n" +
//"                                                <div class=\"col-md-4\">\n" +
//"                                                    <div class=\"form-group\">\n" +
//"                                                        <label>Telephone</label>\n" +
//"                                                        <input type=\"number\" id=\"utel\" class=\"form-control border-input\" placeholder=\"telephone\"value=\""+usr.getTelephone()+"\">\n" +
//"                                                    </div>\n" +
//"                                                </div>\n" +
//"\n" +
//"                                            </div>\n" +
//"\n" +
//"\n" +
//"                                            <div class=\"text-center\">\n" +
//"                                                <button type=\"button\" onclick=\"userdetailsUpdate()\" class=\"btn btn-info btn-fill btn-wd\">Update Profile</button>\n" +
//"                                            </div>\n" +
//"                                            <div class=\"clearfix\"></div>";
//
//                response.getWriter().write(txt);
//
//                ses.close();
//
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

    }

}
