/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exception.magicsnumbersws.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author fpimentel
 */
@Entity
@Table(name = "LOTTERIES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lottery.findAll", query = "SELECT l FROM Lottery l"),
    @NamedQuery(name = "Lottery.findById", query = "SELECT l FROM Lottery l WHERE l.id = :id"),
    @NamedQuery(name = "Lottery.findByName", query = "SELECT l FROM Lottery l WHERE l.name = :name"),
    @NamedQuery(name = "Lottery.findByStatus", query = "SELECT l FROM Lottery l WHERE l.status = :status")})
public class Lottery implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "STATUS")
    private int status;
    @ManyToMany(mappedBy = "lotteryCollection")
    private Collection<Bet> betCollection;
    @OneToMany(mappedBy = "lotteryRelated")
    private Collection<WayToWin> wayToWinCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lottery")
    private Collection<WinningNumber> winningNumberCollection;

    public Lottery() {
    }

    public Lottery(Integer id) {
        this.id = id;
    }

    public Lottery(Integer id, String name, int status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @XmlTransient
    public Collection<Bet> getBetCollection() {
        return betCollection;
    }

    public void setBetCollection(Collection<Bet> betCollection) {
        this.betCollection = betCollection;
    }

    @XmlTransient
    public Collection<WayToWin> getWayToWinCollection() {
        return wayToWinCollection;
    }

    public void setWayToWinCollection(Collection<WayToWin> wayToWinCollection) {
        this.wayToWinCollection = wayToWinCollection;
    }

    @XmlTransient
    public Collection<WinningNumber> getWinningNumberCollection() {
        return winningNumberCollection;
    }

    public void setWinningNumberCollection(Collection<WinningNumber> winningNumberCollection) {
        this.winningNumberCollection = winningNumberCollection;
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
        if (!(object instanceof Lottery)) {
            return false;
        }
        Lottery other = (Lottery) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.exception.magicsnumbersws.entities.Lottery[ id=" + id + " ]";
    }
    
}
