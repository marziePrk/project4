package dataAccessLayer;

import javax.persistence.*;

/**
 * Created by Dotin school 6 on 8/20/2016.
 */
@Entity
@Table(name = "LOAN_FILE")
public class LoanFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LOAN_FILE_ID", unique = true, nullable = false)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "REAL_CUSTOMER_ID", nullable = false)
    private RealCustomer realCustomer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "LOAN_TYPE_ID", nullable = false)
    private LoanType loanType;

    @Column(name = "DURATION", nullable = false)
    private String duration;

    @Column(name = "AMOUNT", nullable = false)
    private String amount;

    //Constructor-------------------------------------------------------------------------------------------------------
    public LoanFile() {
    }

    public LoanFile(RealCustomer realCustomer, LoanType loanType, String duration, String amount) {
        this.realCustomer = realCustomer;
        this.loanType = loanType;
        this.duration = duration;
        this.amount = amount;
    }

    //getter------------------------------------------------------------------------------------------------------------
    public int getId() {
        return id;
    }

    public RealCustomer getRealCustomer() {
        return realCustomer;
    }

    public LoanType getLoanType() {
        return loanType;
    }

    public String getDuration() {
        return duration;
    }

    public String getAmount() {
        return amount;
    }

    //setter------------------------------------------------------------------------------------------------------------
    public void setId(int id) {
        this.id = id;
    }

    public void setRealCustomer(RealCustomer realCustomer) {
        this.realCustomer = realCustomer;
    }

    public void setLoanType(LoanType loanType) {
        this.loanType = loanType;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
