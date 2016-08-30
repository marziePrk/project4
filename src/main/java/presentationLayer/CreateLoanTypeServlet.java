package presentationLayer;

import bussinessLogicLayer.LoanTypeLogic;
import dataAccessLayer.LoanType;
import exception.EmptyFieldException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Dotin school 6 on 8/23/2016.
 */
public class CreateLoanTypeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String loanTypeName= request.getParameter("loanTypeName");
        String interestRate= request.getParameter("interestRate");
        System.out.println(loanTypeName + interestRate);
        try{
            LoanType loanType = LoanTypeLogic.validate(loanTypeName.trim() , interestRate.trim());
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/create-grant-condition.jsp");
            request.setAttribute("loanType" , loanType);
            requestDispatcher.forward(request , response);
        } catch (EmptyFieldException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request , response);
    }
}