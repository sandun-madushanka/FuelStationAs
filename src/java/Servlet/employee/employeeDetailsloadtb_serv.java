/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet.employee;

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
import org.json.simple.JSONObject;

/**
 *
 * @author Sandun
 */
@WebServlet(name = "employeeDetailsloadtb_serv", urlPatterns = {"/employeeDetailsloadtb_serv"})
public class employeeDetailsloadtb_serv extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            String l = (String) request.getSession().getAttribute("user");
            if (l != null) {
//                System.out.println("user kenek innawaa----------------");

                Session ses = Connection.NewHibernateUtil.getSessionFactory().openSession();
                Criteria cr = ses.createCriteria(User.class);
                cr.add(Restrictions.eq("utypstat", 2));
                cr.add(Restrictions.eq("status", 1));
                
                if (cr.list().isEmpty()) {
                    response.getWriter().write("1");
                } else {
                    List<User> u_lst = cr.list();
                    String txt = "";

                    for (User user : u_lst) {

                        txt += "<tr>\n"
                                + "                                                        <td>"+user.getFname()+"</td>\n"
                                + "                                                        <td>"+user.getSalary()+"</td>\n"
                                + "                                                        <td>"+user.getNic()+"</td>\n"
                                + "                                                        <td><button type=\"button\" onclick=\"employeeDelete("+user.getIduser()+")\" class=\"btn btn-danger btn-fill\">Delete</button></td>\n"
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
