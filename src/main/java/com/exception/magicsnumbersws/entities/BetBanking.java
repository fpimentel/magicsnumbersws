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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "BET_BANKING")
@XmlRootElement
public class BetBanking implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "ADDRESS")
    private String address;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CREATION_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "CREATION_USER")
    private String creationUser;
   
    @JoinColumn(name = "CONSORTIUM_ID", referencedColumnName = "ID")
    @ManyToOne(optional = true)
    private Consortium consortium;
    
    /*@OneToMany(cascade = CascadeType.ALL, mappedBy = "betBanking")
    private Collection<BetBankingBetLimit> betBankingBetLimitCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "betBanking")
    private Collection<BetBankingLottery> betBankingLotteryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "betBanking")
    private Collection<BetBankingUser> betBankingUserCollection;*/

    public BetBanking() {
    }

    public BetBanking(Integer id) {
        this.id = id;
    }

    public BetBanking(Integer id, String name, String address, Date creationDate, String creationUser) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.creationDate = creationDate;
        this.creationUser = creationUser;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getCreationUser() {
        return creationUser;
    }

    public void setCreationUser(String creationUser) {
        this.creationUser = creationUser;
    }



    public Consortium getConsortium() {
        return consortium;
    }

    public void setConsortium(Consortium consortium) {
        this.consortium = consortium;
    }

   /* @XmlTransient
    public Collection<BetBankingBetLimit> getBetBankingBetLimitCollection() {
        return betBankingBetLimitCollection;
    }

    public void setBetBankingBetLimitCollection(Collection<BetBankingBetLimit> betBankingBetLimitCollection) {
        this.betBankingBetLimitCollection = betBankingBetLimitCollection;
    }

    @XmlTransient
    public Collection<BetBankingLottery> getBetBankingLotteryCollection() {
        return betBankingLotteryCollection;
    }

    public void setBetBankingLotteryCollection(Collection<BetBankingLottery> betBankingLotteryCollection) {
        this.betBankingLotteryCollection = betBankingLotteryCollection;
    }

    @XmlTransient
    public Collection<BetBankingUser> getBetBankingUserCollection() {
        return betBankingUserCollection;
    }

    public void setBetBankingUserCollection(Collection<BetBankingUser> betBankingUserCollection) {
        this.betBankingUserCollection = betBankingUserCollection;
    }
*/
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final BetBanking other = (BetBanking) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

 

    @Override
    public String toString() {
        return "com.exception.magicsnumbersws.entities.BetBanking[ id=" + id + " ]";
    }
    
}
