/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exception.magicsnumbersws.entities;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fpimentel
 */
@Entity
@Table(name = "BETS_BANKINGS_LOTTERIES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BetBankingLottery.findAll", query = "SELECT b FROM BetBankingLottery b")})
public class BetBankingLottery implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BetBankingLotteryPK betBankingLotteryPK;
    @JoinColumn(name = "BETBANKING_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private BetBanking betBanking;

    public BetBankingLottery() {
    }

    public BetBankingLottery(BetBankingLotteryPK betBankingLotteryPK) {
        this.betBankingLotteryPK = betBankingLotteryPK;
    }

    public BetBankingLottery(int lotteryId, int betbankingId) {
        this.betBankingLotteryPK = new BetBankingLotteryPK(lotteryId, betbankingId);
    }

    public BetBankingLotteryPK getBetBankingLotteryPK() {
        return betBankingLotteryPK;
    }

    public void setBetBankingLotteryPK(BetBankingLotteryPK betBankingLotteryPK) {
        this.betBankingLotteryPK = betBankingLotteryPK;
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
        hash += (betBankingLotteryPK != null ? betBankingLotteryPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BetBankingLottery)) {
            return false;
        }
        BetBankingLottery other = (BetBankingLottery) object;
        if ((this.betBankingLotteryPK == null && other.betBankingLotteryPK != null) || (this.betBankingLotteryPK != null && !this.betBankingLotteryPK.equals(other.betBankingLotteryPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.exception.magicsnumbersws.entities.BetBankingLottery[ betBankingLotteryPK=" + betBankingLotteryPK + " ]";
    }
    
}
