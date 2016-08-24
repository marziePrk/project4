package dataAccessLayer;


import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by Dotin school 6 on 8/20/2016.
 */
@Entity
@Table(name = "GRANT_CONDITION")
public class GrantCondition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GRANT_CONDITION_ID" , unique = true , nullable = false)
    private int id;

    @Column(name = "NAME" ,unique = true , nullable = false)
    private String name;

    @Column(name = "MIN_DURATION" , nullable = false)
    private long minDuration;

    @Column(name = "MAX_DURATION" , nullable = false)
    private long maxDuration;

    @Column(name = "MIN_AMOUNT" , nullable = false)
    private BigDecimal minAmount;

    @Column(name = "MAX_AMOUNT" , nullable = false)
    private BigDecimal maxAmount;

    private int LOAN_TYPE_ID;

    //Constructor-------------------------------------------------------------------------------------------------------
    public GrantCondition(){
    }

    public GrantCondition(String name, long minDuration, long maxDuration, BigDecimal minAmount, BigDecimal maxAmount) {
        this.name = name;
        this.minDuration = minDuration;
        this.maxDuration = maxDuration;
        this.minAmount = minAmount;
        this.maxAmount = maxAmount;
    }

    //getter------------------------------------------------------------------------------------------------------------
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getMinDuration() {
        return minDuration;
    }

    public long getMaxDuration() {
        return maxDuration;
    }

    public BigDecimal getMinAmount() {
        return minAmount;
    }

    public BigDecimal getMaxAmount() {
        return maxAmount;
    }


    //setter------------------------------------------------------------------------------------------------------------
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMinDuration(long minDuration) {
        this.minDuration = minDuration;
    }

    public void setMaxDuration(long maxDuration) {
        this.maxDuration = maxDuration;
    }

    public void setMinAmount(BigDecimal minAmount) {
        this.minAmount = minAmount;
    }

    public void setMaxAmount(BigDecimal maxAmount) {
        this.maxAmount = maxAmount;
    }
}
