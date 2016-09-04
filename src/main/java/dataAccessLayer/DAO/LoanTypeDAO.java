package dataAccessLayer.DAO;

import dataAccessLayer.LoanType;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.util.ArrayList;

/**
 * Created by Dotin school 6 on 8/20/2016.
 */
public class LoanTypeDAO {
    public static ArrayList<LoanType> retrieveLoanTypes() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        ArrayList<LoanType> loanTypes;
        try {
            String hql = "from LoanType loanType";
            Query query = session.createQuery(hql);
            loanTypes = (ArrayList<LoanType>) query.list();
            transaction.commit();
            Logger.getLogger(LoanTypeDAO.class).info("loan type retrieved.");

        }finally {
            session.close();
        }
        return loanTypes;
    }

    public static LoanType retrieveLoanTypesById(int loanTypeId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        LoanType loanTypes;
        try {
            String hql = "from LoanType loanType where id = :id";
            Query query = session.createQuery(hql);
            query.setParameter("id" , loanTypeId);
            loanTypes = (LoanType) query.uniqueResult();
            transaction.commit();
            Logger.getLogger(LoanTypeDAO.class).info("loan type retrieved.");
        }finally {
            session.close();
        }
        return loanTypes;
    }



    /*public static List<LoanType> retrieveLoanTypes() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        String hql = "from RealCustomer ";
        Query query = session.createQuery(hql);
        List<LoanType> loanTypes = query.list();
        transaction.commit();
        session.close();
        return loanTypes;
    }*/
}