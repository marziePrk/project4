package bussinessLogicLayer;

import dataAccessLayer.DAO.LoanTypeDAO;
import dataAccessLayer.LoanType;
import exception.EmptyFieldException;
import exception.HibernateExceptions;

/**
 * Created by Dotin school 6 on 8/22/2016.
 */
public class LoanTypeLogic {


    public static LoanType validate(String loanTypeName, String interestRate) throws EmptyFieldException {
        if (loanTypeName.equals("") || interestRate.equals("") ){
            throw new EmptyFieldException("");
        }else {
            LoanType loanType = new LoanType(loanTypeName , interestRate);
            return  loanType;
        }
    }
}
