package com.exception.magicsnumbersws.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fpimentel
 */
@Entity
@Table(name = "BET_BANKING_BET_LIMIT")
@XmlRootElement
public class BetBankingBetLimit implements Serializable, Comparable<BetBankingBetLimit> {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "AMOUNT_LIMIT")
    private double amountLimit;
    @Basic(optional = false)
    @Column(name = "COMMISSION")
    private int commission;
    //@EmbeddedId
    //protected BetBankingBetLimitPK betBankingBetLimitPK;
    @Basic(optional = false)
    @Size(min = 1, max = 50)
    @Column(name = "CREATION_USER")
    private String creationUser;
    @Basic(optional = false)
    @Column(name = "CREATION_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    @JoinColumn(name = "BETBANKING_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private BetBanking betBanking;
    @JoinColumn(name = "BET_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Bet bet;

    @JoinColumn(name = "LOTTERY_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false )
    private Lottery lottery;
    
    public BetBankingBetLimit() {
    }

    public BetBankingBetLimit(BetBankingBetLimitPK betBankingBetLimitPK, double amountLimit, String creationUser, Date creationDate) {
        // this.betBankingBetLimitPK = betBankingBetLimitPK;
        this.amountLimit = amountLimit;
        this.creationUser = creationUser;
        this.creationDate = creationDate;
    }

    /*public BetBankingBetLimit(int betId, int betbankingId) {
     this.betBankingBetLimitPK = new BetBankingBetLimitPK(betId, betbankingId);
     }

     public BetBankingBetLimitPK getBetBankingBetLimitPK() {
     return betBankingBetLimitPK;
     }

     public void setBetBankingBetLimitPK(BetBankingBetLimitPK betBankingBetLimitPK) {
     this.betBankingBetLimitPK = betBankingBetLimitPK;
     }*/
    public double getAmountLimit() {
        return amountLimit;
    }

    public void setAmountLimit(double amountLimit) {
        this.amountLimit = amountLimit;
    }

    public String getCreationUser() {
        return creationUser;
    }

    public void setCreationUser(String creationUser) {
        this.creationUser = creationUser;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public BetBanking getBetBanking() {
        return betBanking;
    }

    public void setBetBanking(BetBanking betBanking) {
        this.betBanking = betBanking;
    }

    public Bet getBet() {
        return bet;
    }

    public void setBet(Bet bet) {
        this.bet = bet;
    }

    @Override
    public String toString() {
        return "com.exception.magicsnumbersws.entities.BetBankingBetLimit[ betBankingBetLimitPK=" + " ]";
    }

    public BetBankingBetLimit(Integer id) {
        this.id = id;
    }

    public BetBankingBetLimit(Integer id, double amountLimit) {
        this.id = id;
        this.amountLimit = amountLimit;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCommission() {
        return commission;
    }

    public void setCommission(int commission) {
        this.commission = commission;
    }

    public Lottery getLottery() {
        return lottery;
    }

    public void setLottery(Lottery lottery) {
        this.lottery = lottery;
    }

    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BetBankingBetLimit)) {
            return false;
        }
        BetBankingBetLimit other = (BetBankingBetLimit) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(BetBankingBetLimit that) {
        return this.id - that.id;
    }
}
