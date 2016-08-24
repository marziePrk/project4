package presentationLayer;

import bussinessLogicLayer.RealCustomerLogic;
import exception.HibernateExceptions;
import util.OutputGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import static util.OutputGenerator.generateSuccessfulPage;

/**
 * Created by Dotin school 6 on 8/22/2016.
 */
public class DeleteRealCustomerServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF8");
        long id = Long.parseLong(request.getParameter("id"));
        String outHTML = "";
        try {
            RealCustomerLogic.deleteRealCustomer(id);
            outHTML = generateSuccessfulPage("مشتری مورد نظرباموفقیت حذف شد.");

        }  catch (HibernateExceptions e) {
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
