package dataAccessLayer;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.math.BigDecimal;

import static util.SessionFactoryGenerator.getSessionFactory;

/**
 * Created by Dotin school 6 on 8/21/2016.
 */
public class Main {
    public static void main(String[] args) {
        //SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = getSessionFactory().openSession();
        session.beginTransaction();

        RealCustomer realCustomer = new RealCustomer();
        realCustomer.setFirstName("نازنین");
        realCustomer.setBirthDate("73");
        realCustomer.setLastName("شادروز");
        realCustomer.setFatherName("محمود");
        realCustomer.setNationalId("0016958845");

       /* LoanFile loanFile = new LoanFile();
        loanFile.setAmount("700");
        loanFile.setDuration("7");
        loanFile.setLoanType(session.get(LoanType.class , 1));
        loanFile.setRealCustomer(session.get(RealCustomer.class , new Long(1)));
*/

       /* LoanType loanType = new LoanType();
        loanType.setName("maskan");
        loanType.setInterestRate(20);*/

        //loanFile.setLoanType(session.get(LoanType.class , new Integer()));

        /*LoanType loanType = new LoanType();
        loanType.setInterestRate(20);
        loanType.setName("maskan");
        GrantCondition grantCondition = new GrantCondition();
        grantCondition.setName("maskan");
        grantCondition.setMaxAmount(new BigDecimal(50));
        loanType.getGrantConditions().add(grantCondition);
        grantCondition.setLoanType(loanType);*/

        session.save(realCustomer);
        session.getTransaction().commit();
        session.close();
    }
}
