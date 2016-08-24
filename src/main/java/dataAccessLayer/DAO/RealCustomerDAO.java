package dataAccessLayer.DAO;

import dataAccessLayer.RealCustomer;
import exception.HibernateExceptions;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.resource.transaction.spi.TransactionCoordinatorBuilder;
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
        Transaction transaction = session.beginTransaction();
        List<RealCustomer> realCustomers = null;
        Query query;
        try {
            if (customerNumber.equals("")) {
                String hql = "from RealCustomer ";
                query = session.createQuery(hql);
                realCustomers = query.list();
            }
            if(!customerNumber.equals("")){
                String hql = "from RealCustomer realCustomer where customerNumber = :customerNumber";
                query = session.createQuery(hql);
                query.setParameter("customerNumber", customerNumber);
                realCustomers = query.list();
            }
            transaction.commit();
        }finally {
            session.close();
        }

        return realCustomers;
    }

    //retrieveRealCustomerByNationalId----------------------------------------------------------------------------------
    public static ArrayList<RealCustomer> retrieveRealCustomerByNationalId(String nationalId) {
        Session session = SessionFactoryGenerator.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<RealCustomer> realCustomers;
        try {
            String hql = "from RealCustomer realCustomer where nationalId = :nationalId";
            Query query = session.createQuery(hql);
            query.setParameter("nationalId" , nationalId);
            realCustomers = query.list();
            transaction.commit();
        } finally {
            session.close();
        }
        return (ArrayList<RealCustomer>) realCustomers;
    }

    //retrieveRealCustomer----------------------------------------------------------------------------------------------
    public static ArrayList<RealCustomer> retrieveRealCustomer(String firstName, String lastName, String nationalCode) {
        Session session = SessionFactoryGenerator.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<RealCustomer> realCustomers = null;
        Query query = null;

        if (!firstName.equals("") && !lastName.equals("") &&! nationalCode.equals("") ) {
            String hql = "from RealCustomer realCustomer where firstName = :firstName and lastName = :lastName and nationalId = :nationalCode";
            query = session.createQuery(hql);
            query.setParameter("firstName", firstName);
            query.setParameter("lastName", lastName);
            query.setParameter("nationalCode", nationalCode);
            realCustomers = query.list();
            transaction.commit();
            session.close();
            return (ArrayList<RealCustomer>) realCustomers;
        }else
        if (!firstName.equals("") && !lastName.equals("")) {
            String hql = "from RealCustomer realCustomer where firstName = :firstName and lastName = :lastName";
            query = session.createQuery(hql);
            query.setParameter("firstName", firstName);
            query.setParameter("lastName", lastName);
            realCustomers = query.list();
            transaction.commit();
            session.close();
            return (ArrayList<RealCustomer>) realCustomers;
        }else
        if (!firstName.equals("") && !nationalCode.equals("")) {
            String hql = "from RealCustomer realCustomer where firstName = :firstName and nationalId = :nationalId";
            query = session.createQuery(hql);
            query.setParameter("firstName", firstName);
            query.setParameter("nationalId", nationalCode);
            realCustomers = query.list();
            transaction.commit();
            session.close();
            return (ArrayList<RealCustomer>) realCustomers;
        }else
        if (!lastName.equals("") && !nationalCode.equals("")) {
            String hql = "from RealCustomer realCustomer where lastName = :lastName and nationalId = :nationalId";
            query = session.createQuery(hql);
            query.setParameter("lastName", lastName);
            query.setParameter("nationalId", nationalCode);
            realCustomers = query.list();
            transaction.commit();
            session.close();
            return (ArrayList<RealCustomer>) realCustomers;
        }else
        if (!nationalCode.equals("")) {
            String hql = "from RealCustomer realCustomer where nationalId = :nationalCode";
            query = session.createQuery(hql);
            query.setParameter("nationalCode", nationalCode);
            realCustomers = query.list();
            transaction.commit();
            session.close();
            return (ArrayList<RealCustomer>) realCustomers;
        }else
        if (firstName.equals("") && lastName.equals("") && nationalCode.equals("")) {
            String hql = "from RealCustomer realCustomer";
            query = session.createQuery(hql);
            realCustomers = query.list();
            transaction.commit();
            session.close();
            return (ArrayList<RealCustomer>) realCustomers;
        }else
        if (!firstName.equals("")) {
            String hql = "from RealCustomer realCustomer where firstName = :firstName ";
            query = session.createQuery(hql);
            query.setParameter("firstName", firstName);
            realCustomers = query.list();
            transaction.commit();
            session.close();
            return (ArrayList<RealCustomer>) realCustomers;
        }else
        if (!lastName.equals("")) {
            String hql = "from RealCustomer realCustomer where lastName = :lastName ";
            query = session.createQuery(hql);
            query.setParameter("lastName", lastName);
            realCustomers = query.list();
            transaction.commit();
            session.close();
            return (ArrayList<RealCustomer>) realCustomers;
        }
           /* realCustomers = query.list();
            transaction.commit();*/

        return null;
    }

    public static int generateCustomerNumber() {
        int customerNumber;
        Session session = SessionFactoryGenerator.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            long count = retrieveRealCustomerCount();
            if (count == 0) {
                return 1000;
            } else {
                String maxHql = "select max(realCustomer.customerNumber) from RealCustomer realCustomer";
                Query query = session.createQuery(maxHql);
                customerNumber = ((Integer) query.uniqueResult());
                transaction.commit();
                int newNumber = customerNumber + 1;
                return newNumber;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
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
        } finally {
            session.close();
        }
        return count;
    }
}