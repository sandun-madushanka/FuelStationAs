/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Servlet.employee.salary;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mypojos.Salary;
import mypojos.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Sandun
 */
@WebServlet(name = "employeeSalaryDetailsloadtb_serv", urlPatterns = {"/employeeSalaryDetailsloadtb_serv"})
public class employeeSalaryDetailsloadtb_serv extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {

            String l = (String) request.getSession().getAttribute("user");
            if (l != null) {
//                System.out.println("user kenek innawaa----------------");

                Session ses = Connection.NewHibernateUtil.getSessionFactory().openSession();
                Criteria cr = ses.createCriteria(Salary.class);
                
                if (cr.list().isEmpty()) {
                    response.getWriter().write("1");
                } else {
                    List<Salary> u_lst = cr.list();
                    String txt = "";

                    for (Salary user : u_lst) {

                        txt += "<tr>\n"
                                + "                                                        <td>"+user.getUser().getFname()+"</td>\n"
                                + "                                                        <td>"+user.getUser().getSalary()+"</td>\n"
                                + "                                                        <td>"+user.getOthrcount()+"</td>\n"
                                + "                                                        <td>"+user.getPricepOthr()+"</td>\n"
                                + "                                                        <td>"+user.getTotal()+"</td>\n"
                                + "                                                        <td>"+user.getDatecreate()+"</td>\n"
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
