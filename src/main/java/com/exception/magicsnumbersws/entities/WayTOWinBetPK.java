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
public class WayTOWinBetPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "WAY_TO_WIN")
    private int wayToWin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BET")
    private int bet;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PLAYED_NUMBER_POSITION")
    private int playedNumberPosition;

    public WayTOWinBetPK() {
    }

    public WayTOWinBetPK(int wayToWin, int bet, int playedNumberPosition) {
        this.wayToWin = wayToWin;
        this.bet = bet;
        this.playedNumberPosition = playedNumberPosition;
    }

    public int getWayToWin() {
        return wayToWin;
    }

    public void setWayToWin(int wayToWin) {
        this.wayToWin = wayToWin;
    }

    public int getBet() {
        return bet;
    }

    public void setBet(int bet) {
        this.bet = bet;
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
        hash += (int) bet;
        hash += (int) playedNumberPosition;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WayTOWinBetPK)) {
            return false;
        }
        WayTOWinBetPK other = (WayTOWinBetPK) object;
        if (this.wayToWin != other.wayToWin) {
            return false;
        }
        if (this.bet != other.bet) {
            return false;
        }
        if (this.playedNumberPosition != other.playedNumberPosition) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.exception.magicsnumbersws.entities.WayTOWinBetPK[ wayToWin=" + wayToWin + ", bet=" + bet + ", playedNumberPosition=" + playedNumberPosition + " ]";
    }
    
}
