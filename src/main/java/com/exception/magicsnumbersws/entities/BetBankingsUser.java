/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exception.magicsnumbersws.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "BETBANKINGS_USERS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BetBankingsUser.findAll", query = "SELECT b FROM BetBankingsUser b"),
    @NamedQuery(name = "BetBankingsUser.findByBetbanking", query = "SELECT b FROM BetBankingsUser b WHERE b.betBankingsUserPK.betbanking = :betbanking"),
    @NamedQuery(name = "BetBankingsUser.findByUser", query = "SELECT b FROM BetBankingsUser b WHERE b.betBankingsUserPK.user = :user"),
    @NamedQuery(name = "BetBankingsUser.findByCreationDate", query = "SELECT b FROM BetBankingsUser b WHERE b.creationDate = :creationDate")})
public class BetBankingsUser implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BetBankingsUserPK betBankingsUserPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CREATION_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    @JoinColumn(name = "CREATION_USER", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private User creationUser;
    @JoinColumn(name = "USER", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private User user;
    @JoinColumn(name = "BETBANKING", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private BetBanking betBanking;

    public BetBankingsUser() {
    }

    public BetBankingsUser(BetBankingsUserPK betBankingsUserPK) {
        this.betBankingsUserPK = betBankingsUserPK;
    }

    public BetBankingsUser(BetBankingsUserPK betBankingsUserPK, Date creationDate) {
        this.betBankingsUserPK = betBankingsUserPK;
        this.creationDate = creationDate;
    }

    public BetBankingsUser(int betbanking, int user) {
        this.betBankingsUserPK = new BetBankingsUserPK(betbanking, user);
    }

    public BetBankingsUserPK getBetBankingsUserPK() {
        return betBankingsUserPK;
    }

    public void setBetBankingsUserPK(BetBankingsUserPK betBankingsUserPK) {
        this.betBankingsUserPK = betBankingsUserPK;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user1) {
        this.user = user1;
    }

    public BetBanking getBetBanking() {
        return betBanking;
    }

    public void setBetBanking(BetBanking betBanking) {
        this.betBanking = betBanking;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (betBankingsUserPK != null ? betBankingsUserPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BetBankingsUser)) {
            return false;
        }
        BetBankingsUser other = (BetBankingsUser) object;
        if ((this.betBankingsUserPK == null && other.betBankingsUserPK != null) || (this.betBankingsUserPK != null && !this.betBankingsUserPK.equals(other.betBankingsUserPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.exception.magicsnumbersws.entities.BetBankingsUser[ betBankingsUserPK=" + betBankingsUserPK + " ]";
    }
    
}
