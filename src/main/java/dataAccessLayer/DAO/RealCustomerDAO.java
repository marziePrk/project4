package dataAccessLayer.DAO;

import dataAccessLayer.RealCustomer;
import exception.HibernateExceptions;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.SessionFactoryGenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by Dotin school 6 on 8/20/2016.
 */
public class RealCustomerDAO {

    //create real customer----------------------------------------------------------------------------------------------
    public static void createRealCustomer(RealCustomer realCustomer) throws HibernateExceptions {
        Session session = SessionFactoryGenerator.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(realCustomer);
            transaction.commit();
            session.close();
        } catch (HibernateException ex) {
            transaction.rollback();
            session.close();
            ex.printStackTrace();
            throw new HibernateExceptions("create real customer exception.......");
        }

    }

    //deleteRealCustomer------------------------------------------------------------------------------------------------
    public static void deleteRealCustomer(long id) throws HibernateExceptions {
        Session session = SessionFactoryGenerator.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            RealCustomer realCustomer = session.get(RealCustomer.class, id);
            session.remove(realCustomer);
            transaction.commit();
            session.close();
        } catch (HibernateException ex) {
            transaction.rollback();
            session.close();
            throw new HibernateExceptions("");
        }

    }

    //updateRealCustomer------------------------------------------------------------------------------------------------
    public static void updateRealCustomer(String firstName, String lastName, String fatherName, String birthDate, String nationalId) throws HibernateExceptions {
        Session session = SessionFactoryGenerator.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            RealCustomer realCustomer = new RealCustomer(firstName, lastName, fatherName, birthDate, nationalId);
            session.update(realCustomer);
            transaction.commit();
            session.close();
        } catch (HibernateException ex) {
            transaction.rollback();
            session.close();
            throw new HibernateExceptions("");
        }

    }

    //retrieveRealCustomerByCustomerNumber------------------------------------------------------------------------------
    public static List<RealCustomer> retrieveRealCustomerByCustomerNumber(String customerNumber) {
        Session session = SessionFactoryGenerator.getSessionFactory().openSession();
        //Long number1 = Long.valueOf(customerNumber);
        List<RealCustomer> realCustomers;
        Query query;
        if (customerNumber.equals("")) {
            String hql = "from RealCustomer ";
            query = session.createQuery(hql);
        } else {
            String hql = "from RealCustomer realCustomer where realCustomer.customerNumber = :customerNumber";
            query = session.createQuery(hql);
            query.setParameter("customerNumber", customerNumber);
        }
        realCustomers = query.list();

        return realCustomers;
    }

    //retrieveRealCustomerByNationalId----------------------------------------------------------------------------------
    public static ArrayList<RealCustomer> retrieveRealCustomerByNationalId(String nationalId) {
        Session session = SessionFactoryGenerator.getSessionFactory().openSession();
        List<RealCustomer> realCustomers;
        try {
            String hql = "from RealCustomer realCustomer where realCustomer.nationalId = nationalId";
            Query query = session.createQuery(hql);
            realCustomers = query.list();
        } finally {
            session.close();
        }
        return (ArrayList<RealCustomer>) realCustomers;
    }

    //retrieveRealCustomer----------------------------------------------------------------------------------------------
    public static ArrayList<RealCustomer> retrieveRealCustomer(String firstName, String lastName, String fatherName, String birthDate, String nationalCode) {
        List<RealCustomer> realCustomers;
        Session session = SessionFactoryGenerator.getSessionFactory().openSession();
        Query query;
        StringBuilder hqlCommand = new StringBuilder("");
        Map<String, String> parameters = new HashMap<String, String>();
        if (!firstName.equals("")) {
            hqlCommand.append("firstName =:firstName");
            parameters.put("firstName", firstName);
        }
        if (!lastName.equals("")) {
            hqlCommand.append(" lastName =:lastName");
            parameters.put("lastName", lastName);
        }
        if (!fatherName.equals("")) {
            hqlCommand.append(" fatherName =:fatherName");
            parameters.put(" fatherName", fatherName);
        }
        if (!birthDate.equals("")) {
            hqlCommand.append(" birthDate =:birthDate");
            parameters.put("birthDate", birthDate);
        }
        if (!nationalCode.equals("")) {
            hqlCommand.append(" nationalId =:nationalCode");
            parameters.put("nationalCode", nationalCode);
        }
        if (parameters.size() > 0) {
            query = session.createQuery("from RealCustomer where " + hqlCommand.toString());
        } else {
            query = session.createQuery("from RealCustomer realCustomer");
        }

        for (String key : parameters.keySet()) {
            String value = parameters.get(key);
            query.setParameter(key, value);
        }
        realCustomers = query.list();

        return (ArrayList<RealCustomer>) realCustomers;
    }

    public static int generateCustomerNumber() {
        int customerNumber ;
        Session session = SessionFactoryGenerator.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            long count = retrieveRealCustomerCount();
            if (count == 0) {
                return 1000;
            }else {
                String maxHql = "select max(realCustomer.customerNumber) from RealCustomer realCustomer";
                Query query = session.createQuery(maxHql);
                customerNumber = ((Integer) query.uniqueResult()) ;
                transaction.commit();
                int newumber = customerNumber+1;
                //customerNumber = (Integer) customerNumbers.get(0);
                return newumber;
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        finally {
            session.close();
        }
        return 0;
    }

    private static long retrieveRealCustomerCount() {
        Session session = SessionFactoryGenerator.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Long count;
        try {
            String hql = "Select count (*) from RealCustomer realCustomer";
            Query query = session.createQuery(hql);
            count = (Long) query.uniqueResult();
            transaction.commit();
        }finally {
            session.close();
        }
        return count;
    }
}