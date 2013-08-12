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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fpimentel
 */
@Entity
@Table(name = "BETBANKING_BETLIMIT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BetBankingBetLimit.findAll", query = "SELECT b FROM BetBankingBetLimit b"),
    @NamedQuery(name = "BetBankingBetLimit.findById", query = "SELECT b FROM BetBankingBetLimit b WHERE b.id = :id"),
    @NamedQuery(name = "BetBankingBetLimit.findByBet", query = "SELECT b FROM BetBankingBetLimit b WHERE b.bet = :bet"),
    @NamedQuery(name = "BetBankingBetLimit.findByAmountLimit", query = "SELECT b FROM BetBankingBetLimit b WHERE b.amountLimit = :amountLimit")})
public class BetBankingBetLimit implements Serializable {
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "CREATION_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    @JoinColumn(name = "CREATION_USER", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private User creationUser;
    @JoinColumn(name = "BET", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Bet bet1;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BET")
    private int bet;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "AMOUNT_LIMIT")
    private BigDecimal amountLimit;
    @JoinColumn(name = "BETBANKING", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private BetBanking betbanking;

    public BetBankingBetLimit() {
    }

    public BetBankingBetLimit(Integer id) {
        this.id = id;
    }

    public BetBankingBetLimit(Integer id, int bet, BigDecimal amountLimit) {
        this.id = id;
        this.bet = bet;
        this.amountLimit = amountLimit;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getBet() {
        return bet;
    }

    public void setBet(int bet) {
        this.bet = bet;
    }

    public BigDecimal getAmountLimit() {
        return amountLimit;
    }

    public void setAmountLimit(BigDecimal amountLimit) {
        this.amountLimit = amountLimit;
    }

    public BetBanking getBetbanking() {
        return betbanking;
    }

    public void setBetbanking(BetBanking betbanking) {
        this.betbanking = betbanking;
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
    public String toString() {
        return "com.exception.magicsnumbersws.entities.BetBankingBetLimit[ id=" + id + " ]";
    }


    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public User getCreationUser() {
        return creationUser;
    }

    public void setCreationUser(User creationUser) {
        this.creationUser = creationUser;
    }

    public Bet getBet1() {
        return bet1;
    }

    public void setBet1(Bet bet1) {
        this.bet1 = bet1;
    }
    
}
