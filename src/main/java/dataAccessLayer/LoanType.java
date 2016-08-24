package dataAccessLayer;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dotin school 6 on 8/20/2016.
 */
@Entity
@Table(name = "LOAN_TYPE")
public class LoanType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LOAN_TYPE_ID" , unique = true , nullable = false)
    private int id;

    @Column(name = "NAME", unique = true , nullable = false)
    private String name;

    @Column(name = "INTEREST_RATE"  , nullable = false)
    private int interestRate;

    @OneToMany(mappedBy = "LOAN_TYPE_ID")
    private List<GrantCondition> grantConditions = new ArrayList<GrantCondition>();

    //Constructor-------------------------------------------------------------------------------------------------------
    public LoanType(){

    }

    public LoanType(String name, int interestRate) {
        this.name = name;
        this.interestRate = interestRate;
    }

    public LoanType(String name, int interestRate, List<GrantCondition> grantConditions) {
        this.name = name;
        this.interestRate = interestRate;
        this.grantConditions = grantConditions;
    }

    //getter------------------------------------------------------------------------------------------------------------
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getInterestRate() {
        return interestRate;
    }

    public List<GrantCondition> getGrantConditions() {
        return grantConditions;
    }

    //setter------------------------------------------------------------------------------------------------------------
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setInterestRate(int interestRate) {
        this.interestRate = interestRate;
    }

    public void setGrantConditions(List<GrantCondition> grantConditions) {
        this.grantConditions = grantConditions;
    }
}
