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
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@NamedQueries({
    @NamedQuery(name = "Bet.findAll", query = "SELECT b FROM Bet b"),
    @NamedQuery(name = "Bet.findById", query = "SELECT b FROM Bet b WHERE b.id = :id"),
    @NamedQuery(name = "Bet.findByLotteryNumberQty", query = "SELECT b FROM Bet b WHERE b.lotteryNumberQty = :lotteryNumberQty"),
    @NamedQuery(name = "Bet.findByNumbersQty", query = "SELECT b FROM Bet b WHERE b.numbersQty = :numbersQty"),
    @NamedQuery(name = "Bet.findByMinimumBetAmount", query = "SELECT b FROM Bet b WHERE b.minimumBetAmount = :minimumBetAmount"),
    @NamedQuery(name = "Bet.findByUnitMultiplier", query = "SELECT b FROM Bet b WHERE b.unitMultiplier = :unitMultiplier"),
    @NamedQuery(name = "Bet.findByNumberQtyToPlay", query = "SELECT b FROM Bet b WHERE b.numberQtyToPlay = :numberQtyToPlay"),
    @NamedQuery(name = "Bet.findByNumberOfWayToWin", query = "SELECT b FROM Bet b WHERE b.numberOfWayToWin = :numberOfWayToWin")})
public class Bet implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CREATION_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    @OneToMany(cascade = CascadeType.ALL)
    private Collection<BetBankingBetLimit> betBankingBetLimitCollection;
    @OneToMany(cascade = CascadeType.ALL)
    private Collection<WayTOWinBet> wayTOWinBetCollection;
    @JoinColumn(name = "CREATION_USER", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private User creationUser;    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LOTTERY_NUMBER_QTY")
    private int lotteryNumberQty;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUMBERS_QTY")
    private int numbersQty;
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
    @JoinTable(name = "WAYSTOWIN_BETS", joinColumns = {
        @JoinColumn(name = "BET", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "WAY_TO_WIN", referencedColumnName = "ID")})
    @ManyToMany
    private Collection<WayToWin> wayToWinCollection;
    @JoinTable(name = "LOTTERIES_BETS", joinColumns = {
        @JoinColumn(name = "BET", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "LOTTERY", referencedColumnName = "ID")})
    @ManyToMany
    private Collection<Lottery> lotteryCollection;
    @JoinColumn(name = "STATUS", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Status status;
    @JoinColumn(name = "BETTYPE", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private BetTypes bettype;
    @OneToMany(mappedBy = "betRelated")
    private Collection<WayToWin> wayToWinCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bet")
    private Collection<WinningNumber> winningNumberCollection;

    public Bet() {
    }

    public Bet(Integer id) {
        this.id = id;
    }

    public Bet(Integer id, String name, int lotteryNumberQty, int numbersQty, BigDecimal minimumBetAmount, int unitMultiplier, int numberQtyToPlay, int numberOfWayToWin) {
        this.id = id;
        this.name = name;
        this.lotteryNumberQty = lotteryNumberQty;
        this.numbersQty = numbersQty;
        this.minimumBetAmount = minimumBetAmount;
        this.unitMultiplier = unitMultiplier;
        this.numberQtyToPlay = numberQtyToPlay;
        this.numberOfWayToWin = numberOfWayToWin;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getLotteryNumberQty() {
        return lotteryNumberQty;
    }

    public void setLotteryNumberQty(int lotteryNumberQty) {
        this.lotteryNumberQty = lotteryNumberQty;
    }

    public int getNumbersQty() {
        return numbersQty;
    }

    public void setNumbersQty(int numbersQty) {
        this.numbersQty = numbersQty;
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

    @XmlTransient
    public Collection<WayToWin> getWayToWinCollection() {
        return wayToWinCollection;
    }

    public void setWayToWinCollection(Collection<WayToWin> wayToWinCollection) {
        this.wayToWinCollection = wayToWinCollection;
    }

    @XmlTransient
    public Collection<Lottery> getLotteryCollection() {
        return lotteryCollection;
    }

    public void setLotteryCollection(Collection<Lottery> lotteryCollection) {
        this.lotteryCollection = lotteryCollection;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public BetTypes getBettype() {
        return bettype;
    }

    public void setBettype(BetTypes bettype) {
        this.bettype = bettype;
    }

    @XmlTransient
    public Collection<WayToWin> getWayToWinCollection1() {
        return wayToWinCollection1;
    }

    public void setWayToWinCollection1(Collection<WayToWin> wayToWinCollection1) {
        this.wayToWinCollection1 = wayToWinCollection1;
    }

    @XmlTransient
    public Collection<WinningNumber> getWinningNumberCollection() {
        return winningNumberCollection;
    }

    public void setWinningNumberCollection(Collection<WinningNumber> winningNumberCollection) {
        this.winningNumberCollection = winningNumberCollection;
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
        Bet other = (Bet) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.exception.magicsnumbersws.entities.Bet[ id=" + id + " ]";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @XmlTransient
    public Collection<BetBankingBetLimit> getBetBankingBetLimitCollection() {
        return betBankingBetLimitCollection;
    }

    public void setBetBankingBetLimitCollection(Collection<BetBankingBetLimit> betBankingBetLimitCollection) {
        this.betBankingBetLimitCollection = betBankingBetLimitCollection;
    }

    @XmlTransient
    public Collection<WayTOWinBet> getWayTOWinBetCollection() {
        return wayTOWinBetCollection;
    }

    public void setWayTOWinBetCollection(Collection<WayTOWinBet> wayTOWinBetCollection) {
        this.wayTOWinBetCollection = wayTOWinBetCollection;
    }

    public User getCreationUser() {
        return creationUser;
    }

    public void setCreationUser(User creationUser) {
        this.creationUser = creationUser;
    }
    
}
