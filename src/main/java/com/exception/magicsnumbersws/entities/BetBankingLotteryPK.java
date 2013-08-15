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
public class BetBankingLotteryPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "LOTTERY_ID")
    private int lotteryId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BETBANKING_ID")
    private int betbankingId;

    public BetBankingLotteryPK() {
    }

    public BetBankingLotteryPK(int lotteryId, int betbankingId) {
        this.lotteryId = lotteryId;
        this.betbankingId = betbankingId;
    }

    public int getLotteryId() {
        return lotteryId;
    }

    public void setLotteryId(int lotteryId) {
        this.lotteryId = lotteryId;
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
        hash += (int) lotteryId;
        hash += (int) betbankingId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BetBankingLotteryPK)) {
            return false;
        }
        BetBankingLotteryPK other = (BetBankingLotteryPK) object;
        if (this.lotteryId != other.lotteryId) {
            return false;
        }
        if (this.betbankingId != other.betbankingId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.exception.magicsnumbersws.entities.BetBankingLotteryPK[ lotteryId=" + lotteryId + ", betbankingId=" + betbankingId + " ]";
    }
    
}
