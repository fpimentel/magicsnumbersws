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
public class WaysTOWinLotteryPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "WAY_TO_WIN")
    private int wayToWin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LOTTERY")
    private int lottery;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PLAYED_NUMBER_POSITION")
    private int playedNumberPosition;

    public WaysTOWinLotteryPK() {
    }

    public WaysTOWinLotteryPK(int wayToWin, int lottery, int playedNumberPosition) {
        this.wayToWin = wayToWin;
        this.lottery = lottery;
        this.playedNumberPosition = playedNumberPosition;
    }

    public int getWayToWin() {
        return wayToWin;
    }

    public void setWayToWin(int wayToWin) {
        this.wayToWin = wayToWin;
    }

    public int getLottery() {
        return lottery;
    }

    public void setLottery(int lottery) {
        this.lottery = lottery;
    }

    public int getPlayedNumberPosition() {
        return playedNumberPosition;
    }

    public void setPlayedNumberPosition(int playedNumberPosition) {
        this.playedNumberPosition = playedNumberPosition;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) wayToWin;
        hash += (int) lottery;
        hash += (int) playedNumberPosition;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WaysTOWinLotteryPK)) {
            return false;
        }
        WaysTOWinLotteryPK other = (WaysTOWinLotteryPK) object;
        if (this.wayToWin != other.wayToWin) {
            return false;
        }
        if (this.lottery != other.lottery) {
            return false;
        }
        if (this.playedNumberPosition != other.playedNumberPosition) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.exception.magicsnumbersws.entities.WaysTOWinLotteryPK[ wayToWin=" + wayToWin + ", lottery=" + lottery + ", playedNumberPosition=" + playedNumberPosition + " ]";
    }
    
}
