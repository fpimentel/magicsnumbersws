
package com.exception.magicsnumbersws.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fpimentel
 */
@Entity
@Table(name = "BLOCKING_NUMBERS_BET_BANKINGS")
@XmlRootElement
public class BlockingNumberBetBanking implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "CREATION_USER")
    private String creationUser;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LOTTERY_ID")
    private int lotteryId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BET_DAY")
    private int betDay;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NUMBERS")
    private String numbers;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "AMOUNT_LIMIT")
    private BigDecimal amountLimit;
    @Basic(optional = false)
    @NotNull
    @Column(name = "INSERTION_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date insertionDate;

    public BlockingNumberBetBanking() {
    }

    public BlockingNumberBetBanking(Integer id) {
        this.id = id;
    }

    public BlockingNumberBetBanking(Integer id, String creationUser, int lotteryId, int betDay, String numbers, BigDecimal amountLimit, Date insertionDate) {
        this.id = id;
        this.creationUser = creationUser;
        this.lotteryId = lotteryId;
        this.betDay = betDay;
        this.numbers = numbers;
        this.amountLimit = amountLimit;
        this.insertionDate = insertionDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCreationUser() {
        return creationUser;
    }

    public void setCreationUser(String creationUser) {
        this.creationUser = creationUser;
    }

    public int getLotteryId() {
        return lotteryId;
    }

    public void setLotteryId(int lotteryId) {
        this.lotteryId = lotteryId;
    }

    public int getBetDay() {
        return betDay;
    }

    public void setBetDay(int betDay) {
        this.betDay = betDay;
    }

    public String getNumbers() {
        return numbers;
    }

    public void setNumbers(String numbers) {
        this.numbers = numbers;
    }

    public BigDecimal getAmountLimit() {
        return amountLimit;
    }

    public void setAmountLimit(BigDecimal amountLimit) {
        this.amountLimit = amountLimit;
    }

    public Date getInsertionDate() {
        return insertionDate;
    }

    public void setInsertionDate(Date insertionDate) {
        this.insertionDate = insertionDate;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final BlockingNumberBetBanking other = (BlockingNumberBetBanking) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }



    @Override
    public String toString() {
        return "com.exception.magicsnumbersws.entities.BlockingNumberBetBanking[ id=" + id + " ]";
    }
    
}
