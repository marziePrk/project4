package bussinessLogicLayer;

import dataAccessLayer.DAO.GrantConditionDAO;
import dataAccessLayer.DAO.LoanFileDAO;
import dataAccessLayer.DAO.LoanTypeDAO;
import dataAccessLayer.DAO.RealCustomerDAO;
import dataAccessLayer.GrantCondition;
import dataAccessLayer.LoanFile;
import dataAccessLayer.LoanType;
import dataAccessLayer.RealCustomer;
import exception.HibernateExceptions;
import exception.OutOfRangeException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

/**
 * Created by Dotin school 6 on 8/22/2016.
 */
public class LoanFileLogic {
    public static ArrayList<LoanType> retrieveAll() {
        ArrayList<LoanType> loanTypes = LoanTypeDAO.retrieveLoanTypes();
        return loanTypes;
    }

    public static RealCustomer create(long customerId, String amount, String duration, int loanTypeId) throws HibernateExceptions {
        LoanType loanType = LoanTypeDAO.retrieveLoanTypesById(loanTypeId);
        RealCustomer realCustomer = RealCustomerDAO.retrieveRealCustomerById(customerId);
        LoanFile loanFile = new LoanFile(realCustomer, duration, amount, loanType);
        LoanFileDAO.createLoanFile(loanFile);
        return realCustomer;
    }

    public static int validate(String amount, String duration , int loanTyoeId) throws OutOfRangeException {
        List<GrantCondition> grantConditions = GrantConditionDAO.retrieveByLoanId(loanTyoeId);
        for (GrantCondition grantCondition : grantConditions) {
            if ((Long.parseLong(duration) <= grantCondition.getMaxDuration()) && (Long.parseLong(duration) >= grantCondition.getMinDuration())) {
                if ((new BigDecimal(amount).compareTo(grantCondition.getMaxAmount())) < 0 && (new BigDecimal(amount).compareTo(grantCondition.getMinAmount()) > 0)) {
                    return grantCondition.getLOAN_TYPE_ID();
                }
            }
        }
        throw new OutOfRangeException("در وارد کردن مدت و مبلغ قرار داد دقت فرمایید...");
    }
}
