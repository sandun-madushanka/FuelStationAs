/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet.customer;

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
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Sandun
 */
@WebServlet(name = "customerDetailsloadtb_serv", urlPatterns = {"/customerDetailsloadtb_serv"})
public class customerDetailsloadtb_serv extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            String l = (String) request.getSession().getAttribute("user");
            if (l != null) {
//                System.out.println("user kenek innawaa----------------");

                Session ses = Connection.NewHibernateUtil.getSessionFactory().openSession();
                Criteria cr = ses.createCriteria(User.class);
                cr.add(Restrictions.eq("utypstat", 3));
                cr.add(Restrictions.eq("status", 1));

                if (cr.list().isEmpty()) {
                    response.getWriter().write("1");
                } else {
                    List<User> u_lst = cr.list();
                    String txt = "";

                    for (User user : u_lst) {

                        txt += "<tr>\n"
                                + "                                                        <td>" + user.getFname() + "</td>\n"
                                + "                                                        <td>" + user.getMobile() + "</td>\n";
                        if (user.getLoyaltycard() == 1) {
                            txt += "<td><span class=\"text-success\">Have</span></td>\n";
                        } else {
                            txt += "<td><span class=\"text-danger\">Not Have</span></td>\n";

                        }
                        txt += "                                                        <td>" + user.getNic() + "</td>\n"
                                + "                                                        <td><button type=\"button\" onclick=\"customerDelete(" + user.getIduser() + ")\" class=\"btn btn-danger btn-fill\">Delete</button></td>\n"
                                + "                                                    </tr> ";

                    }

                    response.getWriter().write(txt);

                    ses.close();
//
                }

            } else {
                response.getWriter().write("4");
            }

//            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>.");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
