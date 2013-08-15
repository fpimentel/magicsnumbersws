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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fpimentel
 */
@Entity
@Table(name = "BET_BANKINGS_USERS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BetBankingUser.findAll", query = "SELECT b FROM BetBankingUser b")})
public class BetBankingUser implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BetBankingUserPK betBankingUserPK;
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
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private User user;
    @JoinColumn(name = "BETBANKING_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private BetBanking betBanking;

    public BetBankingUser() {
    }

    public BetBankingUser(BetBankingUserPK betBankingUserPK) {
        this.betBankingUserPK = betBankingUserPK;
    }

    public BetBankingUser(BetBankingUserPK betBankingUserPK, String creationUser, Date creationDate) {
        this.betBankingUserPK = betBankingUserPK;
        this.creationUser = creationUser;
        this.creationDate = creationDate;
    }

    public BetBankingUser(int betbankingId, int userId) {
        this.betBankingUserPK = new BetBankingUserPK(betbankingId, userId);
    }

    public BetBankingUserPK getBetBankingUserPK() {
        return betBankingUserPK;
    }

    public void setBetBankingUserPK(BetBankingUserPK betBankingUserPK) {
        this.betBankingUserPK = betBankingUserPK;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
        hash += (betBankingUserPK != null ? betBankingUserPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BetBankingUser)) {
            return false;
        }
        BetBankingUser other = (BetBankingUser) object;
        if ((this.betBankingUserPK == null && other.betBankingUserPK != null) || (this.betBankingUserPK != null && !this.betBankingUserPK.equals(other.betBankingUserPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.exception.magicsnumbersws.entities.BetBankingUser[ betBankingUserPK=" + betBankingUserPK + " ]";
    }
    
}
