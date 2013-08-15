/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exception.magicsnumbersws.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author fpimentel
 */
@Embeddable
public class BetBankingUserPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "BETBANKING_ID")
    private int betbankingId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "USER_ID")
    private int userId;

    public BetBankingUserPK() {
    }

    public BetBankingUserPK(int betbankingId, int userId) {
        this.betbankingId = betbankingId;
        this.userId = userId;
    }

    public int getBetbankingId() {
        return betbankingId;
    }

    public void setBetbankingId(int betbankingId) {
        this.betbankingId = betbankingId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) betbankingId;
        hash += (int) userId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BetBankingUserPK)) {
            return false;
        }
        BetBankingUserPK other = (BetBankingUserPK) object;
        if (this.betbankingId != other.betbankingId) {
            return false;
        }
        if (this.userId != other.userId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.exception.magicsnumbersws.entities.BetBankingUserPK[ betbankingId=" + betbankingId + ", userId=" + userId + " ]";
    }
    
}
