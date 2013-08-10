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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
@Table(name = "BETBANKING")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BetBanking.findAll", query = "SELECT b FROM BetBanking b"),
    @NamedQuery(name = "BetBanking.findById", query = "SELECT b FROM BetBanking b WHERE b.id = :id"),
    @NamedQuery(name = "BetBanking.findByAddress", query = "SELECT b FROM BetBanking b WHERE b.address = :address")})
public class BetBanking implements Serializable {
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "betBanking")
    private Collection<BetBankingsUser> betBankingsUserCollection;
    @JoinColumn(name = "CREATION_USER", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private User creationUser;
    @JoinColumn(name = "CONSORTIUM", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Consortium consortium;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 200)
    @Column(name = "ADDRESS")
    private String address;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "betBanking")
    private Collection<BetBankingLottery> betBankingLotteryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "betbanking")
    private Collection<BetBankingBetLimit> betBankingBetLimitCollection;
    @JoinColumn(name = "STATUS", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Status status;

    public BetBanking() {
    }

    public BetBanking(Integer id) {
        this.id = id;
    }

    public BetBanking(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @XmlTransient
    public Collection<BetBankingLottery> getBetBankingLotteryCollection() {
        return betBankingLotteryCollection;
    }

    public void setBetBankingLotteryCollection(Collection<BetBankingLottery> betBankingLotteryCollection) {
        this.betBankingLotteryCollection = betBankingLotteryCollection;
    }

    @XmlTransient
    public Collection<BetBankingBetLimit> getBetBankingBetLimitCollection() {
        return betBankingBetLimitCollection;
    }

    public void setBetBankingBetLimitCollection(Collection<BetBankingBetLimit> betBankingBetLimitCollection) {
        this.betBankingBetLimitCollection = betBankingBetLimitCollection;
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
        if (!(object instanceof BetBanking)) {
            return false;
        }
        BetBanking other = (BetBanking) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.exception.magicsnumbersws.entities.BetBanking[ id=" + id + " ]";
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
    public Collection<BetBankingsUser> getBetBankingsUserCollection() {
        return betBankingsUserCollection;
    }

    public void setBetBankingsUserCollection(Collection<BetBankingsUser> betBankingsUserCollection) {
        this.betBankingsUserCollection = betBankingsUserCollection;
    }

    public User getCreationUser() {
        return creationUser;
    }

    public void setCreationUser(User creationUser) {
        this.creationUser = creationUser;
    }

    public Consortium getConsortium() {
        return consortium;
    }

    public void setConsortium(Consortium consortium) {
        this.consortium = consortium;
    }
    
}
