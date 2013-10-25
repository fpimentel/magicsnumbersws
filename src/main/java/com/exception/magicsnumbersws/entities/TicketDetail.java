package com.exception.magicsnumbersws.entities;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fpimentel
 */
@Entity
@Table(name = "TICKET_DETAILS")
@XmlRootElement
public class TicketDetail implements Serializable, Comparable<TicketDetail> {        
    private static final long serialVersionUID = 1L;
    @JoinColumn(name = "TIME_ID", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Time time;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NUMBERS_PLAYED")
    private String numbersPlayed;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "AMOUNT_TO_WIN")
    private BigDecimal amountToWin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BET_AMOUNT")
    private BigDecimal betAmount;
    @JoinColumn(name = "TICKET_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Ticket ticket;
    @JoinColumn(name = "LOTTERY_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Lottery lottery;
    @JoinColumn(name = "BET_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Bet bet;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STATUS_ID", nullable = false)
    private Status status;

    public TicketDetail() {
    }

    public TicketDetail(Integer id) {
        this.id = id;
    }

    public TicketDetail(Integer id, String numbersPlayed, BigDecimal amountToWin, Status status) {
        this.id = id;
        this.numbersPlayed = numbersPlayed;
        this.amountToWin = amountToWin;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumbersPlayed() {
        return numbersPlayed;
    }

    public void setNumbersPlayed(String numbersPlayed) {
        this.numbersPlayed = numbersPlayed;
    }

    public BigDecimal getAmountToWin() {
        return amountToWin;
    }

    public void setAmountToWin(BigDecimal amountToWin) {
        this.amountToWin = amountToWin;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Lottery getLottery() {
        return lottery;
    }

    public void setLottery(Lottery lottery) {
        this.lottery = lottery;
    }

    public Bet getBet() {
        return bet;
    }

    public void setBet(Bet bet) {
        this.bet = bet;
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
        if (!(object instanceof TicketDetail)) {
            return false;
        }
        TicketDetail other = (TicketDetail) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.exception.magicsnumbersws.entities.TicketDetail[ id=" + id + " ]";
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public BigDecimal getBetAmount() {
        return betAmount;
    }

    public void setBetAmount(BigDecimal betAmount) {
        this.betAmount = betAmount;
    }   

    @Override
    public int compareTo(TicketDetail that) {
        return this.id - that.id;
    }
}
