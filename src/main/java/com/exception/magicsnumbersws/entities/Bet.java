/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exception.magicsnumbersws.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author fpimentel
 */
@Entity
@Table(name = "BET")
@XmlRootElement
public class Bet implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LOTTERY_NUMBER_QTY")
    private int lotteryNumberQty;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "MINIMUM_BET_AMOUNT")
    private BigDecimal minimumBetAmount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "UNIT_MULTIPLIER")
    private int unitMultiplier;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUMBER_QTY_TO_PLAY")
    private int numberQtyToPlay;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUMBER_OF_WAY_TO_WIN")
    private int numberOfWayToWin;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "CREATION_USER")
    private String creationUser;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CREATION_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    @JoinTable(name = "LOTTERIES_BETS", joinColumns = {
        @JoinColumn(name = "BET_ID", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "LOTTERY_ID", referencedColumnName = "ID")})
    @ManyToMany
    private Collection<Lottery> lotteryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bet")
    private Collection<BetBankingBetLimit> betBankingBetLimitCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "betId")
    private Collection<WayToWinBet> wayToWinBetCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "betId")
    private Collection<WinningNumber> winningNumberCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "betId")
    private Collection<TicketDetail> ticketDetailCollection;

    @JoinColumn(name = "BETTYPE_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private BetType bettypeId;

    public Bet() {
    }

    public Bet(Integer id) {
        this.id = id;
    }

    public Bet(Integer id, String name, int lotteryNumberQty, BigDecimal minimumBetAmount, int unitMultiplier, int numberQtyToPlay, int numberOfWayToWin, String creationUser, Date creationDate) {
        this.id = id;
        this.name = name;
        this.lotteryNumberQty = lotteryNumberQty;
        this.minimumBetAmount = minimumBetAmount;
        this.unitMultiplier = unitMultiplier;
        this.numberQtyToPlay = numberQtyToPlay;
        this.numberOfWayToWin = numberOfWayToWin;
        this.creationUser = creationUser;
        this.creationDate = creationDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLotteryNumberQty() {
        return lotteryNumberQty;
    }

    public void setLotteryNumberQty(int lotteryNumberQty) {
        this.lotteryNumberQty = lotteryNumberQty;
    }

    public BigDecimal getMinimumBetAmount() {
        return minimumBetAmount;
    }

    public void setMinimumBetAmount(BigDecimal minimumBetAmount) {
        this.minimumBetAmount = minimumBetAmount;
    }

    public int getUnitMultiplier() {
        return unitMultiplier;
    }

    public void setUnitMultiplier(int unitMultiplier) {
        this.unitMultiplier = unitMultiplier;
    }

    public int getNumberQtyToPlay() {
        return numberQtyToPlay;
    }

    public void setNumberQtyToPlay(int numberQtyToPlay) {
        this.numberQtyToPlay = numberQtyToPlay;
    }

    public int getNumberOfWayToWin() {
        return numberOfWayToWin;
    }

    public void setNumberOfWayToWin(int numberOfWayToWin) {
        this.numberOfWayToWin = numberOfWayToWin;
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

    @XmlTransient
    public Collection<Lottery> getLotteryCollection() {
        return lotteryCollection;
    }

    public void setLotteryCollection(Collection<Lottery> lotteryCollection) {
        this.lotteryCollection = lotteryCollection;
    }

    @XmlTransient
    public Collection<BetBankingBetLimit> getBetBankingBetLimitCollection() {
        return betBankingBetLimitCollection;
    }

    public void setBetBankingBetLimitCollection(Collection<BetBankingBetLimit> betBankingBetLimitCollection) {
        this.betBankingBetLimitCollection = betBankingBetLimitCollection;
    }

    @XmlTransient
    public Collection<WayToWinBet> getWayToWinBetCollection() {
        return wayToWinBetCollection;
    }

    public void setWayToWinBetCollection(Collection<WayToWinBet> wayToWinBetCollection) {
        this.wayToWinBetCollection = wayToWinBetCollection;
    }

    @XmlTransient
    public Collection<WinningNumber> getWinningNumberCollection() {
        return winningNumberCollection;
    }

    public void setWinningNumberCollection(Collection<WinningNumber> winningNumberCollection) {
        this.winningNumberCollection = winningNumberCollection;
    }

    @XmlTransient
    public Collection<TicketDetail> getTicketDetailCollection() {
        return ticketDetailCollection;
    }

    public void setTicketDetailCollection(Collection<TicketDetail> ticketDetailCollection) {
        this.ticketDetailCollection = ticketDetailCollection;
    }


    public BetType getBettypeId() {
        return bettypeId;
    }

    public void setBettypeId(BetType bettypeId) {
        this.bettypeId = bettypeId;
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
        if (!(object instanceof Bet)) {
            return false;
        }
    
        return true;
    }

    @Override
    public String toString() {
        return "com.exception.magicsnumbersws.entities.Bet[ id=" + id + " ]";
    }
    
}
