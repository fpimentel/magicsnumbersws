/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exception.magicsnumbersws.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@NamedQueries({
    @NamedQuery(name = "TicketDetail.findAll", query = "SELECT t FROM TicketDetail t"),
    @NamedQuery(name = "TicketDetail.findById", query = "SELECT t FROM TicketDetail t WHERE t.id = :id"),
    @NamedQuery(name = "TicketDetail.findByLottery", query = "SELECT t FROM TicketDetail t WHERE t.lottery = :lottery"),
    @NamedQuery(name = "TicketDetail.findByBet", query = "SELECT t FROM TicketDetail t WHERE t.bet = :bet"),
    @NamedQuery(name = "TicketDetail.findByNumbersPlayed", query = "SELECT t FROM TicketDetail t WHERE t.numbersPlayed = :numbersPlayed"),
    @NamedQuery(name = "TicketDetail.findByAmountToWin", query = "SELECT t FROM TicketDetail t WHERE t.amountToWin = :amountToWin")})
public class TicketDetail implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LOTTERY")
    private int lottery;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BET")
    private int bet;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NUMBERS_PLAYED")
    private String numbersPlayed;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "AMOUNT_TO_WIN")
    private BigDecimal amountToWin;
    @JoinColumn(name = "TICKET", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Ticket ticket;
    @JoinColumn(name = "STATUS", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Status status;

    public TicketDetail() {
    }

    public TicketDetail(Integer id) {
        this.id = id;
    }

    public TicketDetail(Integer id, int lottery, int bet, String numbersPlayed, BigDecimal amountToWin) {
        this.id = id;
        this.lottery = lottery;
        this.bet = bet;
        this.numbersPlayed = numbersPlayed;
        this.amountToWin = amountToWin;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getLottery() {
        return lottery;
    }

    public void setLottery(int lottery) {
        this.lottery = lottery;
    }

    public int getBet() {
        return bet;
    }

    public void setBet(int bet) {
        this.bet = bet;
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

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
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
    
}
