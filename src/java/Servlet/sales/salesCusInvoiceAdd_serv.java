/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet.sales;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mypojos.Fuelstock;
import mypojos.FuelstockHasUser;
import mypojos.Invoice;
import mypojos.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Sandun
 */
@WebServlet(name = "salesCusInvoiceAdd_serv", urlPatterns = {"/salesCusInvoiceAdd_serv"})
public class salesCusInvoiceAdd_serv extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            String l = (String) request.getSession().getAttribute("user");
            if (l != null) {
                System.out.println("user kenek innawaa----------------");

                String supnic = request.getParameter("supnic");
                String fueltyp = request.getParameter("fueltyp");
                String suprate = request.getParameter("suprate");
                String qtyltr = request.getParameter("qtyltr");
                String tot = request.getParameter("tot");
                String pymtyp = request.getParameter("pymtyp");

                Session ses = Connection.NewHibernateUtil.getSessionFactory().openSession();

                Criteria cr = ses.createCriteria(User.class);
                cr.add(Restrictions.eq("nic", supnic));
                cr.add(Restrictions.eq("utypstat", 3));

                User u = (User) cr.uniqueResult();

                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                Date datec = new Date();
                formatter.format(datec);

                Transaction tr = ses.beginTransaction();

                if (cr.list().isEmpty()) {
                    response.getWriter().write("3");
                } else {

                    Criteria cr2 = ses.createCriteria(Fuelstock.class);
                    cr2.add(Restrictions.eq("fueltype", Integer.parseInt(fueltyp)));
                    Fuelstock fuelstc = (Fuelstock) cr2.uniqueResult();

                    if (cr2.list().isEmpty()) {
                        response.getWriter().write("5");
                    } else {

                        Invoice inv = new Invoice();

                        inv.setFuelstock(fuelstc);
                        inv.setUser(u);
                        inv.setQtyintake(Double.parseDouble(qtyltr));
                        inv.setDateintaken(datec);
                        inv.setTotal(Double.parseDouble(tot));
                        inv.setPaytype(Integer.parseInt(pymtyp));
                        inv.setStatus(1);

                        ses.save(inv);

                        double crntqty = fuelstc.getCurrentqty();

                        if (crntqty >= Double.parseDouble(qtyltr)) {

                            double updatesqty = crntqty - Double.parseDouble(qtyltr);

                            fuelstc.setCurrentqty(updatesqty);

                            ses.update(fuelstc);

                            tr.commit();
                            ses.flush();

                            response.getWriter().write("1");
                            ses.close();

                        } else {

                            response.getWriter().write("5");
                            
                        }

                    }

                }

////
//                response.getWriter().write("1");
            } else {
                response.getWriter().write("4");

            }

//            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>.");
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().write("2");
        }

    }

}
