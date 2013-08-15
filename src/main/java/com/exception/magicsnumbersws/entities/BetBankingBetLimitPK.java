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
public class BetBankingBetLimitPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "BET_ID")
    private int betId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BETBANKING_ID")
    private int betbankingId;

    public BetBankingBetLimitPK() {
    }

    public BetBankingBetLimitPK(int betId, int betbankingId) {
        this.betId = betId;
        this.betbankingId = betbankingId;
    }

    public int getBetId() {
        return betId;
    }

    public void setBetId(int betId) {
        this.betId = betId;
    }

    public int getBetbankingId() {
        return betbankingId;
    }

    public void setBetbankingId(int betbankingId) {
        this.betbankingId = betbankingId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) betId;
        hash += (int) betbankingId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BetBankingBetLimitPK)) {
            return false;
        }
        BetBankingBetLimitPK other = (BetBankingBetLimitPK) object;
        if (this.betId != other.betId) {
            return false;
        }
        if (this.betbankingId != other.betbankingId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.exception.magicsnumbersws.entities.BetBankingBetLimitPK[ betId=" + betId + ", betbankingId=" + betbankingId + " ]";
    }
    
}
