package presentationLayer;

import bussinessLogicLayer.LoanFileLogic;
import bussinessLogicLayer.RealCustomerLogic;
import dataAccessLayer.LoanType;
import dataAccessLayer.RealCustomer;
import exception.HibernateExceptions;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dotin school 6 on 8/23/2016.
 */
public class CreateLoanFileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF8");
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");

        if ("searchLoanTypes".equalsIgnoreCase(action)) {
            searchLoanType(request, response);
        }
        if ("retrieveCustomer".equalsIgnoreCase(action)) {
            findCustomer(request, response);
        }
        if ("createLoanFile".equalsIgnoreCase(action)) {
            createLoanFile(request, response);
        }

    }

    private void createLoanFile(HttpServletRequest request, HttpServletResponse response) {
        int customerId = Integer.parseInt(request.getParameter("customerId"));
        String amount = request.getParameter("amount");
        String duration = request.getParameter("duration");
        int loanTypeId = Integer.parseInt(request.getParameter("chosenLoanType"));

        try {
            LoanFileLogic.create(customerId , amount , duration , loanTypeId);
        } catch (HibernateExceptions ex) {
            request.setAttribute("title", "خطا");
            request.setAttribute("header", ex.getMessage());
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/result-page.jsp");
            try {
                requestDispatcher.forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            ex.printStackTrace();
        }

    }

    private void findCustomer(HttpServletRequest request, HttpServletResponse response) {
        String customerNumber = request.getParameter("customerNumber");
        List<RealCustomer> realCustomers = RealCustomerLogic.retrieveRealCustomerByCustomerNumber(customerNumber);
        ArrayList<LoanType> loanTypes = LoanFileLogic.retrieveAll();
        PrintWriter out = null;
        String customerExists;
        try {
            if (realCustomers.size() > 0) {
                customerExists = "true";
                RealCustomer realCustomer = realCustomers.get(0);
                LoanType loanType = loanTypes.get(0);
                request.setAttribute("customerExists" , customerExists );
                request.setAttribute("realCustomer", realCustomer);
                request.setAttribute("loanTypes", loanType);
                RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/create-loan-file.jsp");
                requestDispatcher.forward(request, response);
            } else {
                customerExists = "false";
                request.setAttribute("customerExists" , customerExists );
                request.setAttribute("title", "خطا");
                request.setAttribute("header","شماره مشتری تعریف نشده...");
                RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/result-page.jsp");
                requestDispatcher.forward(request, response);
            }

        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void searchLoanType(HttpServletRequest request, HttpServletResponse response) {
        ArrayList<LoanType> loanTypes = LoanFileLogic.retrieveAll();
        String url;
        PrintWriter out = null;
        String loanTypeExist;
        try {
            if (loanTypes.size() > 0) {
                loanTypeExist = "true";
                request.setAttribute("loanTypeExist" , loanTypeExist );
                RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/create-loan-file.jsp");
                requestDispatcher.forward(request, response);
            } else {
                loanTypeExist = "false";
                request.setAttribute("loanTypeExist" ,loanTypeExist);
                request.setAttribute("title", "خطا");
                request.setAttribute("header","تسهیلاتی یافت نشد!!");
                RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/result-page.jsp");
                requestDispatcher.forward(request, response);
            }

        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
