/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exception.magicsnumbersws.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
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
@Table(name = "LOTTERIES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lottery.findAll", query = "SELECT l FROM Lottery l")})
public class Lottery implements Serializable {
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
    @Lob
    @Column(name = "USER_CREATION")
    private byte[] userCreation;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CREATION_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "STATUS_ID")
    private int statusId;
    @ManyToMany(mappedBy = "lotteryCollection")
    private Collection<Bet> betCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lotteryId")
    private Collection<WinningNumber> winningNumberCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lotteryId")
    private Collection<TicketDetail> ticketDetailCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lotteryId")
    private Collection<WayToWinLottery> wayToWinLotteryCollection;

    public Lottery() {
    }

    public Lottery(Integer id) {
        this.id = id;
    }

    public Lottery(Integer id, String name, byte[] userCreation, Date creationDate, int statusId) {
        this.id = id;
        this.name = name;
        this.userCreation = userCreation;
        this.creationDate = creationDate;
        this.statusId = statusId;
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

    public byte[] getUserCreation() {
        return userCreation;
    }

    public void setUserCreation(byte[] userCreation) {
        this.userCreation = userCreation;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    @XmlTransient
    public Collection<Bet> getBetCollection() {
        return betCollection;
    }

    public void setBetCollection(Collection<Bet> betCollection) {
        this.betCollection = betCollection;
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

    @XmlTransient
    public Collection<WayToWinLottery> getWayToWinLotteryCollection() {
        return wayToWinLotteryCollection;
    }

    public void setWayToWinLotteryCollection(Collection<WayToWinLottery> wayToWinLotteryCollection) {
        this.wayToWinLotteryCollection = wayToWinLotteryCollection;
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
        if (!(object instanceof Lottery)) {
            return false;
        }
        Lottery other = (Lottery) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.exception.magicsnumbersws.entities.Lottery[ id=" + id + " ]";
    }
    
}
