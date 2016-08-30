package presentationLayer;

import bussinessLogicLayer.GrantCoditionLogic;
import dataAccessLayer.GrantCondition;

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
public class CreateGrantCondition extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF8");
        String loanTypeName = request.getParameter("loanTypeName");
        String interestRate = request.getParameter("interestRate");
        int grantConditionNumber = Integer.parseInt(request.getParameter("rowNumber"));
        System.out.println(grantConditionNumber);
        System.out.println(loanTypeName + interestRate);

        ArrayList<GrantCondition> grantConditionList = new ArrayList<GrantCondition>();
        for (int count = 1 ; count <=grantConditionNumber ; count++){
            GrantCondition grantCondition = new GrantCondition();
            grantCondition.setName(request.getParameter("grantName" +count));
            grantCondition.setMinDuration(Long.parseLong(request.getParameter("minDuration" +count)));
            grantCondition.setMaxDuration(Long.parseLong(request.getParameter("maxDuration" +count)));
            grantCondition.setMinAmount(new BigDecimal((request.getParameter("minAmount" +count))));
            grantCondition.setMaxAmount(new BigDecimal((request.getParameter("maxAmount" +count))));
            System.out.println(grantCondition);
            grantConditionList.add(grantCondition);
        }
        GrantCoditionLogic.create(grantConditionList ,loanTypeName , interestRate );
    }

}
