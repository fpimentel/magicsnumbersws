/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exception.magicsnumbersws.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "BLOCKING_NUMBERS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BlockingNumber.findAll", query = "SELECT b FROM BlockingNumber b"),
    @NamedQuery(name = "BlockingNumber.findById", query = "SELECT b FROM BlockingNumber b WHERE b.id = :id"),
    @NamedQuery(name = "BlockingNumber.findByUserId", query = "SELECT b FROM BlockingNumber b WHERE b.userId = :userId"),
    @NamedQuery(name = "BlockingNumber.findByLottery", query = "SELECT b FROM BlockingNumber b WHERE b.lottery = :lottery"),
    @NamedQuery(name = "BlockingNumber.findByBetDay", query = "SELECT b FROM BlockingNumber b WHERE b.betDay = :betDay"),
    @NamedQuery(name = "BlockingNumber.findByAmountLimit", query = "SELECT b FROM BlockingNumber b WHERE b.amountLimit = :amountLimit"),
    @NamedQuery(name = "BlockingNumber.findByInsertionDate", query = "SELECT b FROM BlockingNumber b WHERE b.insertionDate = :insertionDate")})
public class BlockingNumber implements Serializable {
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
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "USER_ID")
    private int userId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LOTTERY")
    private int lottery;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BET_DAY")
    private int betDay;

    public BlockingNumber() {
    }

    public BlockingNumber(Integer id) {
        this.id = id;
    }

    public BlockingNumber(Integer id, int userId, int lottery, int betDay, String numbers, BigDecimal amountLimit, Date insertionDate) {
        this.id = id;
        this.userId = userId;
        this.lottery = lottery;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getLottery() {
        return lottery;
    }

    public void setLottery(int lottery) {
        this.lottery = lottery;
    }

    public int getBetDay() {
        return betDay;
    }

    public void setBetDay(int betDay) {
        this.betDay = betDay;
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
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BlockingNumber)) {
            return false;
        }
        BlockingNumber other = (BlockingNumber) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.exception.magicsnumbersws.entities.BlockingNumber[ id=" + id + " ]";
    }

    public String getNumbers() {
        return numbers;
    }

    public void setNumbers(String numbers) {
        this.numbers = numbers;
    }   
}
