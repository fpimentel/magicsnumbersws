/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exception.magicsnumbersws.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fpimentel
 */
@Entity
@Table(name = "WAYSTOWINS_LOTTERIES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WaysTOWinLottery.findAll", query = "SELECT w FROM WaysTOWinLottery w"),
    @NamedQuery(name = "WaysTOWinLottery.findByWayToWin", query = "SELECT w FROM WaysTOWinLottery w WHERE w.waysTOWinLotteryPK.wayToWin = :wayToWin"),
    @NamedQuery(name = "WaysTOWinLottery.findByLottery", query = "SELECT w FROM WaysTOWinLottery w WHERE w.waysTOWinLotteryPK.lottery = :lottery"),
    @NamedQuery(name = "WaysTOWinLottery.findByPlayedNumberPosition", query = "SELECT w FROM WaysTOWinLottery w WHERE w.waysTOWinLotteryPK.playedNumberPosition = :playedNumberPosition"),
    @NamedQuery(name = "WaysTOWinLottery.findByWinPosition", query = "SELECT w FROM WaysTOWinLottery w WHERE w.winPosition = :winPosition")})
public class WaysTOWinLottery implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected WaysTOWinLotteryPK waysTOWinLotteryPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "WIN_POSITION")
    private int winPosition;
    @JoinColumn(name = "WAY_TO_WIN", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private WayToWin wayToWin1;
    @JoinColumn(name = "LOTTERY", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Lottery lottery1;

    public WaysTOWinLottery() {
    }

    public WaysTOWinLottery(WaysTOWinLotteryPK waysTOWinLotteryPK) {
        this.waysTOWinLotteryPK = waysTOWinLotteryPK;
    }

    public WaysTOWinLottery(WaysTOWinLotteryPK waysTOWinLotteryPK, int winPosition) {
        this.waysTOWinLotteryPK = waysTOWinLotteryPK;
        this.winPosition = winPosition;
    }

    public WaysTOWinLottery(int wayToWin, int lottery, int playedNumberPosition) {
        this.waysTOWinLotteryPK = new WaysTOWinLotteryPK(wayToWin, lottery, playedNumberPosition);
    }

    public WaysTOWinLotteryPK getWaysTOWinLotteryPK() {
        return waysTOWinLotteryPK;
    }

    public void setWaysTOWinLotteryPK(WaysTOWinLotteryPK waysTOWinLotteryPK) {
        this.waysTOWinLotteryPK = waysTOWinLotteryPK;
    }

    public int getWinPosition() {
        return winPosition;
    }

    public void setWinPosition(int winPosition) {
        this.winPosition = winPosition;
    }

    public WayToWin getWayToWin1() {
        return wayToWin1;
    }

    public void setWayToWin1(WayToWin wayToWin1) {
        this.wayToWin1 = wayToWin1;
    }

    public Lottery getLottery1() {
        return lottery1;
    }

    public void setLottery1(Lottery lottery1) {
        this.lottery1 = lottery1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (waysTOWinLotteryPK != null ? waysTOWinLotteryPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WaysTOWinLottery)) {
            return false;
        }
        WaysTOWinLottery other = (WaysTOWinLottery) object;
        if ((this.waysTOWinLotteryPK == null && other.waysTOWinLotteryPK != null) || (this.waysTOWinLotteryPK != null && !this.waysTOWinLotteryPK.equals(other.waysTOWinLotteryPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.exception.magicsnumbersws.entities.WaysTOWinLottery[ waysTOWinLotteryPK=" + waysTOWinLotteryPK + " ]";
    }
    
}
