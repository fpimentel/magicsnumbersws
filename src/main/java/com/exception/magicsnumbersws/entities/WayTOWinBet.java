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
@Table(name = "WAYSTOWIN_BETS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WayTOWinBet.findAll", query = "SELECT w FROM WayTOWinBet w"),
    @NamedQuery(name = "WayTOWinBet.findByWayToWin", query = "SELECT w FROM WayTOWinBet w WHERE w.wayTOWinBetPK.wayToWin = :wayToWin"),
    @NamedQuery(name = "WayTOWinBet.findByBet", query = "SELECT w FROM WayTOWinBet w WHERE w.wayTOWinBetPK.bet = :bet"),
    @NamedQuery(name = "WayTOWinBet.findByPlayedNumberPosition", query = "SELECT w FROM WayTOWinBet w WHERE w.wayTOWinBetPK.playedNumberPosition = :playedNumberPosition"),
    @NamedQuery(name = "WayTOWinBet.findByWinPosition", query = "SELECT w FROM WayTOWinBet w WHERE w.winPosition = :winPosition")})
public class WayTOWinBet implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected WayTOWinBetPK wayTOWinBetPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "WIN_POSITION")
    private int winPosition;
    @JoinColumn(name = "WAY_TO_WIN", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private WayToWin wayToWin1;
    @JoinColumn(name = "BET", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Bet bet1;

    public WayTOWinBet() {
    }

    public WayTOWinBet(WayTOWinBetPK wayTOWinBetPK) {
        this.wayTOWinBetPK = wayTOWinBetPK;
    }

    public WayTOWinBet(WayTOWinBetPK wayTOWinBetPK, int winPosition) {
        this.wayTOWinBetPK = wayTOWinBetPK;
        this.winPosition = winPosition;
    }

    public WayTOWinBet(int wayToWin, int bet, int playedNumberPosition) {
        this.wayTOWinBetPK = new WayTOWinBetPK(wayToWin, bet, playedNumberPosition);
    }

    public WayTOWinBetPK getWayTOWinBetPK() {
        return wayTOWinBetPK;
    }

    public void setWayTOWinBetPK(WayTOWinBetPK wayTOWinBetPK) {
        this.wayTOWinBetPK = wayTOWinBetPK;
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

    public Bet getBet1() {
        return bet1;
    }

    public void setBet1(Bet bet1) {
        this.bet1 = bet1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (wayTOWinBetPK != null ? wayTOWinBetPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WayTOWinBet)) {
            return false;
        }
        WayTOWinBet other = (WayTOWinBet) object;
        if ((this.wayTOWinBetPK == null && other.wayTOWinBetPK != null) || (this.wayTOWinBetPK != null && !this.wayTOWinBetPK.equals(other.wayTOWinBetPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.exception.magicsnumbersws.entities.WayTOWinBet[ wayTOWinBetPK=" + wayTOWinBetPK + " ]";
    }
    
}
