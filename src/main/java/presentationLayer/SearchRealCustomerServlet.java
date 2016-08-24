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
import java.util.List;

/**
 * Created by Dotin school 6 on 8/22/2016.
 */
public class SearchRealCustomerServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF8");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String nationalCode = request.getParameter("nationalCode");
        String customerNumber = request.getParameter("customerNumber");
        String outputHTML = "";
        List<RealCustomer> realCustomers;

        //try {
            if (customerNumber == null) {
                realCustomers = RealCustomerLogic.retrieveRealCustomer(firstName, lastName, nationalCode);
            } else {
                realCustomers = RealCustomerLogic.retrieveRealCustomerByCustomerNumber(customerNumber);
            }
        outputHTML = OutputGenerator.generateRealCustomerSearchResult(realCustomers);

        //}catch (){

        //}
        response.setContentType("text/html ;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.println(outputHTML);

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
