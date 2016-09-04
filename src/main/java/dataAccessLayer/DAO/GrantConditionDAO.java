package dataAccessLayer.DAO;

import dataAccessLayer.GrantCondition;
import dataAccessLayer.LoanType;
import dataAccessLayer.RealCustomer;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;



/**
 * Created by Dotin school 6 on 8/20/2016.
 */
public class GrantConditionDAO {
    public static void create(LoanType loanType, ArrayList<GrantCondition> grantConditionList) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(loanType);
            for (GrantCondition grantCondition: grantConditionList){
                grantCondition.setLOAN_TYPE_ID(loanType.getId());
                Logger.getLogger(GrantCondition.class).info("Grant Conditions created.");

            }
            transaction.commit();
            session.close();
        } catch (HibernateException e) {
            Logger.getLogger(GrantCondition.class).info("Grant Conditions dose not created.");
            transaction.rollback();
            session.close();
            e.printStackTrace();

        }

    }

    public static GrantCondition retrieveByName(String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        GrantCondition grantCondition = new GrantCondition();
        try {
            String hql = "from GrantCondition grantCondition where name = :name";
            Query query = session.createQuery(hql);
            query.setParameter("name" , name);
            grantCondition = (GrantCondition) query.uniqueResult();
            transaction.commit();
            Logger.getLogger(GrantCondition.class).info("Grant Conditions created retrieved.");

        } finally {
            session.close();
        }
        return grantCondition;

    }

    public static List<GrantCondition> retrieveByLoanId(int loanTypeId) {
        List<GrantCondition> grantConditions = new ArrayList<GrantCondition>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            String hql = "from GrantCondition grantCondition where LOAN_TYPE_ID = :loanTypeId";
            Query query = session.createQuery(hql);
            query.setParameter("loanTypeId" , loanTypeId);
            grantConditions = query.list();
            transaction.commit();
            Logger.getLogger(GrantCondition.class).info("Grant Conditions created retrieved.");

        } finally {
            session.close();
        }
        return grantConditions;

    }
}
