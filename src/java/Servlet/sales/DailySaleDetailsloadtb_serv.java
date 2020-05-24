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
import mypojos.Dailysales;
import mypojos.Fuelstock;
import mypojos.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Sandun
 */
@WebServlet(name = "DailySaleDetailsloadtb_serv", urlPatterns = {"/DailySaleDetailsloadtb_serv"})
public class DailySaleDetailsloadtb_serv extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {

            String l = (String) request.getSession().getAttribute("user");
            if (l != null) {
//                System.out.println("user kenek innawaa----------------");

                Session ses = Connection.NewHibernateUtil.getSessionFactory().openSession();
                Criteria cr = ses.createCriteria(Dailysales.class);
                
                if (cr.list().isEmpty()) {
                    response.getWriter().write("1");
                } else {
                    List<Dailysales> u_lst = cr.list();
                    String txt = "";

                    for (Dailysales user : u_lst) {

                        txt += "<tr>\n";

                        if (user.getFueltyp() == 1) {
                            txt += "<td>Petrol 92</td>\n";
                        }else if (user.getFueltyp() == 2) {
                            txt += "<td>Petrol 95</td>\n";
                        }else if (user.getFueltyp() == 3) {
                            txt += "<td>Diesel 92</td>\n";
                        }else if (user.getFueltyp() == 4) {
                            txt += "<td>Diesel 95</td>\n";
                        }
                        txt += "<td>" + user.getExpence() + "</td>\n"
                                + " <td>" + user.getRevenue()+ "</td>\n"
                                + " <td><input id=\"dailysaleretrivegm"+user.getIddailysales()+"\" type=\"text\" class=\"form-control border-input\"  placeholder=\"total\" value=\""+user.getTotal()+"\"></td>\n"
                                + " <td>" + user.getDatesl()+ "</td>\n"
                                + " <td><button type=\"button\" onclick=\"DailySaleUpdate("+user.getIddailysales()+")\" class=\"btn btn-info btn-fill\">Update</button></td>\n"
                                + " <td><button type=\"button\" onclick=\"dailySaleDelete("+user.getIddailysales()+")\" class=\"btn btn-danger btn-fill\">Delete</button></td>\n"
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
