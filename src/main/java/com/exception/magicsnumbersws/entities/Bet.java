package com.exception.magicsnumbersws.entities;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "BET")
@XmlRootElement
public class Bet implements Serializable, Comparable<Bet> {              
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ID")
    private Integer id;
    @Size(min = 1, max = 100)
    @Column(name = "NAME")
    private String name;
    @Column(name = "LOTTERY_NUMBER_QTY")
    private int lotteryNumberQty;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "MINIMUM_BET_AMOUNT")
    private BigDecimal minimumBetAmount;
    @Column(name = "UNIT_MULTIPLIER")
    private int unitMultiplier;
    @Column(name = "NUMBER_QTY_TO_PLAY")
    private int numberQtyToPlay;
    @Column(name = "NUMBER_OF_WAY_TO_WIN")
    private int numberOfWayToWin;
    @Size(min = 1, max = 50)
    @Column(name = "CREATION_USER")
    private String creationUser;
    @Column(name = "CREATION_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    @JoinColumn( name = "BETTYPE_ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private BetType betType;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STATUS_ID", nullable = false)
    private Status status;

    public Bet() {
        super();
    }

    public Bet(Integer id) {
        super();
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

    public BetType getBetType() {
        return betType;
    }

    public void setBetType(BetType betType) {
        this.betType = betType;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final Bet other = (Bet) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Bet that) {
        return this.id - that.id;
    }    
}
