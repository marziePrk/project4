package bussinessLogicLayer;

import dataAccessLayer.DAO.RealCustomerDAO;
import dataAccessLayer.RealCustomer;
import exception.DuplicateCodeException;
import exception.EmptyFieldException;
import exception.HibernateExceptions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dotin school 6 on 8/22/2016.
 */
public class RealCustomerLogic {

    public static boolean checkValidation(String firstName, String lastName, String fatherName, String birthDate, String nationalId) throws EmptyFieldException, DuplicateCodeException {
        if (firstName.equals("")) {
            throw new EmptyFieldException("لطفا فیلد نام  را وارد کنید. ");
        }
        if (lastName.equals("")) {
            throw new EmptyFieldException("لطفا فیلد نام خانوادگی  را وارد کنید. ");
        }
        if (fatherName.equals("")) {
            throw new EmptyFieldException("لطفا فیلد نام پدر  را وارد کنید.");
        }
        if (birthDate.equals("")) {
            throw new EmptyFieldException("لطفا فیلد تاریخ تولد   را وارد کنید.");
        }
        if (nationalId.equals("")) {
            throw new EmptyFieldException("لطفا فیلد شماره ملی   را وارد کنید.");
        }
        if (RealCustomerDAO.retrieveRealCustomerByNationalId(nationalId).size() > 0) {
            throw new DuplicateCodeException("کد ملی وارد شده تکراری است.");
        }
        return true;
    }

    public static boolean checkValidation(Long id, String firstName, String lastName, String fatherName, String birthDate, String nationalId) throws EmptyFieldException, DuplicateCodeException {
        if (firstName.equals("")) {
            throw new EmptyFieldException("لطفا فیلد نام  را وارد کنید. ");
        }
        if (lastName.equals("")) {
            throw new EmptyFieldException("لطفا فیلد نام خانوادگی  را وارد کنید. ");
        }
        if (fatherName.equals("")) {
            throw new EmptyFieldException("لطفا فیلد نام پدر  را وارد کنید.");
        }
        if (fatherName.equals("")) {
            throw new EmptyFieldException("لطفا فیلد نام پدر  را وارد کنید.");
        }
        if (birthDate.equals("")) {
            throw new EmptyFieldException("لطفا فیلد تاریخ تولد   را وارد کنید.");
        }
        if (nationalId.equals("")) {
            throw new EmptyFieldException("لطفا فیلد شماره ملی   را وارد کنید.");
        }
        ArrayList<RealCustomer> realCustomers = RealCustomerDAO.retrieveRealCustomerByNationalId(nationalId);
        int realCustomersSize = realCustomers.size();

        if (realCustomersSize > 0) {
            RealCustomer realCustomer = realCustomers.get(0);
            if (realCustomersSize > 1) {
                throw new DuplicateCodeException("کد ملی وارد شده تکراری است.");
            } else if (realCustomer.getId() != id) {
                throw new DuplicateCodeException("کد ملی وارد شده تکراری است.");
            }
        }
        return true;
    }

    public static RealCustomer createRealCustomer(String firstName, String lastName, String fatherName, String birthDate, String nationalId) throws HibernateExceptions {
        RealCustomer realCustomer = new RealCustomer();
        realCustomer.setFirstName(firstName);
        realCustomer.setLastName(lastName);
        realCustomer.setFatherName(fatherName);
        realCustomer.setBirthDate(birthDate);
        realCustomer.setNationalId(nationalId);
        realCustomer.setCustomerNumber(RealCustomerDAO.generateCustomerNumber());
        RealCustomerDAO.createRealCustomer(realCustomer);
        return realCustomer;
    }

    public static ArrayList<RealCustomer> retrieveRealCustomer(String firstName, String lastName, String nationalCode) {
        ArrayList<RealCustomer> realCustomers = RealCustomerDAO.retrieveRealCustomer(firstName, lastName, nationalCode);
        return realCustomers;
    }

    public static List<RealCustomer> retrieveRealCustomerByCustomerNumber(String customerNumber) {
        List<RealCustomer> realCustomers = RealCustomerDAO.retrieveRealCustomerByCustomerNumber(customerNumber);
        return realCustomers;
    }

    public static void deleteRealCustomer(long id) throws HibernateExceptions {
        RealCustomerDAO.deleteRealCustomer(id);
    }

    public static void updateRealCustomer(long id, String firstName, String lastName, String fatherName, String birthDate, String nationalCode) throws HibernateExceptions {
        RealCustomerDAO.updateRealCustomer(id, firstName, lastName, fatherName, birthDate, nationalCode);
    }
}
