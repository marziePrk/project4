package bussinessLogicLayer;

import dataAccessLayer.DAO.LoanTypeDAO;
import dataAccessLayer.LoanType;

import java.util.List;

/**
 * Created by Dotin school 6 on 8/22/2016.
 */
public class LoanTypeLogic {

    public static List<LoanType> retrieveLoanTypes() {
        List<LoanType> loanTypes = LoanTypeDAO.retrieveLoanTypes();
        return loanTypes;
    }
}
