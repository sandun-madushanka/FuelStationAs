/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet.sales;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mypojos.FuelstockHasUser;
import mypojos.Invoice;
import mypojos.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.json.simple.JSONObject;

/**
 *
 * @author Sandun
 */
@WebServlet(name = "CalculateProfitSale_serv", urlPatterns = {"/CalculateProfitSale_serv"})
public class CalculateProfitSale_serv extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            String l = (String) request.getSession().getAttribute("user");
            if (l != null) {
//                System.out.println("user kenek innawaa----------------");

                String sfromdate = request.getParameter("frmdt");
                String stodate = request.getParameter("todt");

                double invtot = 0;
                double suprectot = 0;

                Session ses = Connection.NewHibernateUtil.getSessionFactory().openSession();
                Criteria cr = ses.createCriteria(Invoice.class);

                Criteria cr2 = ses.createCriteria(FuelstockHasUser.class);

                if (!sfromdate.equals("") && !stodate.equals("")) {
                    DateFormat formatter = new SimpleDateFormat("yyy-MM-dd");
                    Date datef = formatter.parse(sfromdate);
                    Date datet = formatter.parse(stodate);
                    cr.add(Restrictions.between("dateintaken", datef, datet));

                    cr2.add(Restrictions.between("dateintake", datef, datet));

                    if (cr.list().isEmpty()) {
                        response.getWriter().write("1");
                    } else {
                        List<Invoice> inv_list = cr.list();
                        List<FuelstockHasUser> fshu_list = cr2.list();

                        for (FuelstockHasUser fuelstockHasUser : fshu_list) {
                            suprectot += fuelstockHasUser.getTotal();
                        }

                        for (Invoice invoice : inv_list) {

                            invtot += invoice.getTotal();

                        }

                        if (invtot > suprectot) {

                            double profittot = invtot - suprectot;

                            JSONObject u_object = new JSONObject();

                            u_object.put("profTot", profittot);

                            response.getWriter().write(u_object.toJSONString());

                            ses.close();

                        } else {
                            response.getWriter().write("1");
                        }

//
                    }

                } else {

                    response.getWriter().write("2");

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
