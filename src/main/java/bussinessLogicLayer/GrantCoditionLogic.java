package bussinessLogicLayer;

import dataAccessLayer.DAO.GrantConditionDAO;
import dataAccessLayer.GrantCondition;
import dataAccessLayer.LoanType;

import java.util.ArrayList;

/**
 * Created by Dotin school 6 on 8/22/2016.
 */
public class GrantCoditionLogic {
    public static void create(ArrayList<GrantCondition> grantConditionList, String loanTypeName, String interestRate) {
        LoanType loanType = new LoanType(loanTypeName , interestRate , grantConditionList);
        GrantConditionDAO.create(loanType , grantConditionList);
    }
}
