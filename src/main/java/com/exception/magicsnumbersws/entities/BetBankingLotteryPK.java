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
    @Column(name = "LOTTERY")
    private int lottery;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BETBANKING")
    private int betbanking;

    public BetBankingLotteryPK() {
    }

    public BetBankingLotteryPK(int lottery, int betbanking) {
        this.lottery = lottery;
        this.betbanking = betbanking;
    }

    public int getLottery() {
        return lottery;
    }

    public void setLottery(int lottery) {
        this.lottery = lottery;
    }

    public int getBetbanking() {
        return betbanking;
    }

    public void setBetbanking(int betbanking) {
        this.betbanking = betbanking;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) lottery;
        hash += (int) betbanking;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BetBankingLotteryPK)) {
            return false;
        }
        BetBankingLotteryPK other = (BetBankingLotteryPK) object;
        if (this.lottery != other.lottery) {
            return false;
        }
        if (this.betbanking != other.betbanking) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.exception.magicsnumbersws.entities.BetBankingLotteryPK[ lottery=" + lottery + ", betbanking=" + betbanking + " ]";
    }
    
}
