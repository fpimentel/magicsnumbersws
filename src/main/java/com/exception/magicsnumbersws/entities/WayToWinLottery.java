/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exception.magicsnumbersws.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "WAYS_TO_WINS_LOTTERIES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WayToWinLottery.findAll", query = "SELECT w FROM WayToWinLottery w")})
public class WayToWinLottery implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PLAYED_NUMBER_POSITION")
    private int playedNumberPosition;
    @Basic(optional = false)
    @NotNull
    @Column(name = "WIN_POSITION")
    private int winPosition;
    @JoinColumn(name = "WAY_TO_WIN_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private WayToWin wayToWinId;
    @JoinColumn(name = "LOTTERY_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Lottery lotteryId;

    public WayToWinLottery() {
    }

    public WayToWinLottery(Integer id) {
        this.id = id;
    }

    public WayToWinLottery(Integer id, int playedNumberPosition, int winPosition) {
        this.id = id;
        this.playedNumberPosition = playedNumberPosition;
        this.winPosition = winPosition;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getPlayedNumberPosition() {
        return playedNumberPosition;
    }

    public void setPlayedNumberPosition(int playedNumberPosition) {
        this.playedNumberPosition = playedNumberPosition;
    }

    public int getWinPosition() {
        return winPosition;
    }

    public void setWinPosition(int winPosition) {
        this.winPosition = winPosition;
    }

    public WayToWin getWayToWinId() {
        return wayToWinId;
    }

    public void setWayToWinId(WayToWin wayToWinId) {
        this.wayToWinId = wayToWinId;
    }

    public Lottery getLotteryId() {
        return lotteryId;
    }

    public void setLotteryId(Lottery lotteryId) {
        this.lotteryId = lotteryId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WayToWinLottery)) {
            return false;
        }
        WayToWinLottery other = (WayToWinLottery) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.exception.magicsnumbersws.entities.WayToWinLottery[ id=" + id + " ]";
    }
    
}
