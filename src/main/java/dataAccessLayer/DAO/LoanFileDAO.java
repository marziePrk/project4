package dataAccessLayer.DAO;

import dataAccessLayer.LoanFile;
import exception.HibernateExceptions;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 * Created by Dotin school 6 on 8/20/2016.
 */
public class LoanFileDAO {
    public static void createLoanFile(LoanFile loanFile) throws HibernateExceptions {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(loanFile);
            transaction.commit();
            session.close();
            Logger.getLogger(LoanFile.class).info("loan file retrieved.");
        } catch (HibernateException ex) {
            Logger.getLogger(LoanFile.class).info("loan file dose not retrieved.");
            transaction.rollback();
            session.close();
            ex.printStackTrace();
            throw new HibernateExceptions("create Loan File exception.......");
        }

    }
}
