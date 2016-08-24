package dataAccessLayer;

import javax.persistence.*;

/**
 * Created by Dotin school 6 on 8/20/2016.
 */
@Entity
@Table(name = "REAL_CUSTOMER")
public class RealCustomer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "REAL_CUSTOMER_ID" )
    private long id;

    @Column(name = "CUSTOMER_NUMBER"  )
    private int customerNumber;

    @Column(name = "FIRST_NAME" , nullable = false)
    private String firstName;

    @Column(name = "LAST_NAME" , nullable = false)
    private String lastName;

    @Column(name = "FATHER_NAME" , nullable = false)
    private String fatherName;

    @Column(name = "BIRTH_DATE" , nullable = false)
    private String birthDate;

    @Column(name = "NATIONAL_ID" ,unique = true , nullable = false)
    private String nationalId;

    //Constructor-------------------------------------------------------------------------------------------------------
    public RealCustomer(){
    }

    public RealCustomer(String firstName, String lastName, String fatherName, String birthDate, String nationalId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.fatherName = fatherName;
        this.birthDate = birthDate;
        this.nationalId = nationalId;
    }

    public RealCustomer(long id, String firstName, String lastName, String fatherName, String birthDate, String nationalId) {
        this.id= id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fatherName = fatherName;
        this.birthDate = birthDate;
        this.nationalId = nationalId;
    }

    //getter------------------------------------------------------------------------------------------------------------
    public long getId() {
        return id;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getNationalId() {
        return nationalId;
    }


    //setter------------------------------------------------------------------------------------------------------------
    public void setId(long id) {
        this.id = id;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }
}
