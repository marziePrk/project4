package presentationLayer;

import bussinessLogicLayer.RealCustomerLogic;
import dataAccessLayer.RealCustomer;
import util.OutputGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static util.OutputGenerator.generateRealCustomerUpdatePage;

/**
 * Created by Dotin school 6 on 8/22/2016.
 */
public class UpdateRealCustomerServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF8");
        String customerNumber = request.getParameter("customerNumber");
        String outHTML = "";

        List<RealCustomer> realCustomers = RealCustomerLogic.retrieveRealCustomerByCustomerNumber(customerNumber);
        RealCustomer realCustomer = realCustomers.get(0);
        outHTML = generateRealCustomerUpdatePage(realCustomer);

        response.setContentType("text/html ;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.println(outHTML);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
