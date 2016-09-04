package presentationLayer;

import bussinessLogicLayer.RealCustomerLogic;
import dataAccessLayer.RealCustomer;
import exception.DuplicateException;
import exception.EmptyFieldException;
import exception.HibernateExceptions;
import util.OutputGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Dotin school 6 on 8/22/2016.
 */
public class CreateRealCustomerServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF8");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String fatherName = request.getParameter("fatherName");
        String birthDate = request.getParameter("birthDate");
        String nationalId = request.getParameter("nationalCode");
        String outputHTML = "";
        RealCustomer realCustomer = null;

        try {
            RealCustomerLogic.checkValidation(firstName.trim(), lastName.trim(), fatherName.trim(), birthDate.trim(), nationalId.trim());
            realCustomer = RealCustomerLogic.createRealCustomer( firstName, lastName, fatherName ,birthDate , nationalId);
            outputHTML = OutputGenerator.generateSuccessfulInsert(realCustomer);

        } catch (HibernateExceptions ex) {
            outputHTML = OutputGenerator.generateExceptionPage("خطای سیستمی!!!" );

        } catch (EmptyFieldException e) {
            outputHTML = OutputGenerator.generateExceptionPage(e.getMessage());
        } catch (DuplicateException e) {
            outputHTML = OutputGenerator.generateExceptionPage(e.getMessage());
        }
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.println(outputHTML);

}
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request , response);
    }
}
