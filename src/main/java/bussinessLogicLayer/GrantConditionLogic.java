package bussinessLogicLayer;

import dataAccessLayer.DAO.GrantConditionDAO;
import dataAccessLayer.GrantCondition;
import dataAccessLayer.LoanType;
import exception.DuplicateException;
import exception.OutOfRangeException;

import java.util.ArrayList;

/**
 * Created by Dotin school 6 on 8/22/2016.
 */
public class GrantConditionLogic {
    public static void create(ArrayList<GrantCondition> grantConditionList, String loanTypeName, String interestRate) {
        LoanType loanType = new LoanType(loanTypeName, interestRate, grantConditionList);
        GrantConditionDAO.create(loanType, grantConditionList);
    }

    public static boolean validate(GrantCondition grantCondition) throws OutOfRangeException, DuplicateException {
        if (grantCondition.getMinDuration() >= grantCondition.getMaxDuration()) {
            throw new OutOfRangeException("حداقل زمان باید کمتر از حداکثر باشد.");
        }
        if (grantCondition.getMinAmount().compareTo(grantCondition.getMaxAmount()) > 0) {
            throw new OutOfRangeException("حداقل مبلغ باید کمتر از حداکثر باشد.");
        }
        GrantCondition retrieveGrantCondition = GrantConditionDAO.retrieveByName(grantCondition.getName());
        if (retrieveGrantCondition != null) {
            throw new DuplicateException("نام شرط اعطا ذکر شده تکراری است.");
        }
        return true;
    }
}
