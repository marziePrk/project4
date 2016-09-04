package presentationLayer;

import bussinessLogicLayer.RealCustomerLogic;
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

import static util.OutputGenerator.generateSuccessfulPage;

/**
 * Created by Dotin school 6 on 8/22/2016.
 */
public class SaveRealCustomerChangedServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF8");
        long id = Long.parseLong(request.getParameter("id"));
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String fatherName = request.getParameter("fatherName");
        String birthDate = request.getParameter("birthDate");
        String nationalId = request.getParameter("nationalCode");
        String outHTML = "";

        try {
            RealCustomerLogic.checkValidation(id ,firstName.trim(), lastName.trim(), fatherName.trim(), birthDate.trim(), nationalId.trim());
            RealCustomerLogic.updateRealCustomer(id,firstName , lastName , fatherName , birthDate , nationalId);
            outHTML = generateSuccessfulPage("عملیات بروزرسانی با موفقیت انجام شد.");
        } catch (DuplicateException e) {
            outHTML = OutputGenerator.generateExceptionPage(e.getMessage());
        } catch (EmptyFieldException e) {
            outHTML = OutputGenerator.generateExceptionPage(e.getMessage());
        } catch (HibernateExceptions e) {
            outHTML = OutputGenerator.generateExceptionPage("خطای سیستمی!!!");
        }
        response.setContentType("text/html ;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.println(outHTML);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request , response);
    }
}
