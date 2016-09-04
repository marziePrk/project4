package presentationLayer;

import bussinessLogicLayer.GrantConditionLogic;
import dataAccessLayer.GrantCondition;
import exception.DuplicateException;
import exception.OutOfRangeException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Created by Dotin school 6 on 8/28/2016.
 */
public class CreateGrantConditionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String loanTypeName = request.getParameter("loanTypeName");
        String interestRate = request.getParameter("interestRate");
        int grantConditionNumber = Integer.parseInt(request.getParameter("rowNumber"));

        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        ArrayList<GrantCondition> grantConditionList = new ArrayList<GrantCondition>();
        try {
            for (int count = 1; count <= grantConditionNumber; count++) {
                GrantCondition grantCondition = new GrantCondition();
                grantCondition.setName(request.getParameter("grantName" + count));
                grantCondition.setMinDuration(Long.parseLong(request.getParameter("minDuration" + count)));
                grantCondition.setMaxDuration(Long.parseLong(request.getParameter("maxDuration" + count)));
                grantCondition.setMinAmount(new BigDecimal((request.getParameter("minAmount" + count))));
                grantCondition.setMaxAmount(new BigDecimal((request.getParameter("maxAmount" + count))));
                GrantConditionLogic.validate(grantCondition);
                grantConditionList.add(grantCondition);
            }
            GrantConditionLogic.create(grantConditionList, loanTypeName, interestRate);
            request.setAttribute("title", "تایید ثبت تسهیلات");
            request.setAttribute("header", "تسهیلات " + loanTypeName + " با موفقیت ثبت شد.");
            getServletConfig().getServletContext().getRequestDispatcher("/result-page.jsp").forward(request, response);

        } catch (OutOfRangeException e) {
            request.setAttribute("title", "خطا");
            request.setAttribute("header", e.getMessage());
            getServletContext().getRequestDispatcher("/result-page.jsp").forward(request, response);
        } catch (DuplicateException e) {
            request.setAttribute("title", "خطا");
            request.setAttribute("header", e.getMessage());
            getServletContext().getRequestDispatcher("/result-page.jsp").forward(request, response);
        }

    }
}
