package dataAccessLayer.DAO;

import dataAccessLayer.GrantCondition;
import dataAccessLayer.LoanType;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.ArrayList;


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
                session.save(grantCondition);
            }
            transaction.commit();
            session.close();
        } catch (HibernateException e) {
            transaction.rollback();
            session.close();
            e.printStackTrace();
        }

    }
}
