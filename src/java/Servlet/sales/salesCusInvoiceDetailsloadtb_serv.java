/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet.sales;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mypojos.Fuelstock;
import mypojos.Invoice;
import org.hibernate.Criteria;
import org.hibernate.Session;

/**
 *
 * @author Sandun
 */
@WebServlet(name = "salesCusInvoiceDetailsloadtb_serv", urlPatterns = {"/salesCusInvoiceDetailsloadtb_serv"})
public class salesCusInvoiceDetailsloadtb_serv extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            String l = (String) request.getSession().getAttribute("user");
            if (l != null) {
//                System.out.println("user kenek innawaa----------------");

                Session ses = Connection.NewHibernateUtil.getSessionFactory().openSession();
                Criteria cr = ses.createCriteria(Invoice.class);

                if (cr.list().isEmpty()) {
                    response.getWriter().write("1");
                } else {
                    List<Invoice> u_lst = cr.list();
                    String txt = "";

                    for (Invoice user : u_lst) {

                        txt += "<tr>\n";
                        txt += "<td>"+user.getUser().getFname()+"</td>\n";
                        if (user.getFuelstock().getFueltype() == 1) {
                            txt += "<td>Petrol 92</td>\n";
                        } else if (user.getFuelstock().getFueltype() == 2) {
                            txt += "<td>Petrol 95</td>\n";
                        } else if (user.getFuelstock().getFueltype() == 3) {
                            txt += "<td>Diesel 92</td>\n";
                        } else if (user.getFuelstock().getFueltype() == 4) {
                            txt += "<td>Diesel 95</td>\n";
                        }
                        txt += "<td>" + user.getQtyintake() + "</td>\n"
                                + " <td>" + user.getTotal() + "</td>\n"
                                + " <td>" + user.getDateintaken() + "</td>\n"
                                + " </tr> ";

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
