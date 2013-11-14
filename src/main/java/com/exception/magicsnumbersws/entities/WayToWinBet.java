
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
@Table(name = "WAYS_TO_WIN_BETS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WayToWinBet.findAll", query = "SELECT w FROM WayToWinBet w")})
public class WayToWinBet implements Serializable {
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
    @JoinColumn(name = "BET_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Bet betId;

    public WayToWinBet() {
    }

    public WayToWinBet(Integer id) {
        this.id = id;
    }

    public WayToWinBet(Integer id, int playedNumberPosition, int winPosition) {
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

    public Bet getBetId() {
        return betId;
    }

    public void setBetId(Bet betId) {
        this.betId = betId;
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
        if (!(object instanceof WayToWinBet)) {
            return false;
        }
        WayToWinBet other = (WayToWinBet) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.exception.magicsnumbersws.entities.WayToWinBet[ id=" + id + " ]";
    }
    
}
