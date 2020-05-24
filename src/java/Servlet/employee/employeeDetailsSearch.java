/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet.employee;

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
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author Sandun
 */
@WebServlet(name = "employeeDetailsSearch", urlPatterns = {"/employeeDetailsSearch"})
public class employeeDetailsSearch extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            String l = (String) request.getSession().getAttribute("user");
            if (l != null) {
//                System.out.println("user kenek innawaa----------------");

                String nic = request.getParameter("nicemp");

                Session ses = Connection.NewHibernateUtil.getSessionFactory().openSession();
                Criteria cr = ses.createCriteria(User.class);
                cr.add(Restrictions.eq("nic", nic));

                if (cr.list().isEmpty()) {
                    response.getWriter().write("1");
                } else {
                    User u = (User) cr.uniqueResult();
                    System.out.println(u.getFname());
                    JSONObject u_object = new JSONObject();

                    u_object.put("fname", u.getFname());
                    u_object.put("lname", u.getLname());
                    u_object.put("adress", u.getAddress());
                    u_object.put("mobile", u.getMobile());
                    u_object.put("telephone", u.getTelephone());
                    u_object.put("salary", u.getSalary());
                    u_object.put("discription", u.getDiscription());

                    response.getWriter().write(u_object.toJSONString());

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
