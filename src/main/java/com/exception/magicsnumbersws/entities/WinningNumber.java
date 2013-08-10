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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fpimentel
 */
@Entity
@Table(name = "WINNINGNUMBERS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WinningNumber.findAll", query = "SELECT w FROM WinningNumber w"),
    @NamedQuery(name = "WinningNumber.findById", query = "SELECT w FROM WinningNumber w WHERE w.id = :id"),
    @NamedQuery(name = "WinningNumber.findByNumbers", query = "SELECT w FROM WinningNumber w WHERE w.numbers = :numbers"),
    @NamedQuery(name = "WinningNumber.findByUserId", query = "SELECT w FROM WinningNumber w WHERE w.userId = :userId")})
public class WinningNumber implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "CREATION_DATE")
    private String creationDate;
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private User userId;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NUMBERS")
    private String numbers;
    @JoinColumn(name = "LOTTERY", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Lottery lottery;
    @JoinColumn(name = "BET", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Bet bet;

    public WinningNumber() {
    }

    public WinningNumber(Integer id) {
        this.id = id;
    }

    public WinningNumber(Integer id, String numbers, User user) {
        this.id = id;
        this.numbers = numbers;
        this.userId = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumbers() {
        return numbers;
    }

    public void setNumbers(String numbers) {
        this.numbers = numbers;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Lottery getLottery() {
        return lottery;
    }

    public void setLottery(Lottery lottery) {
        this.lottery = lottery;
    }

    public Bet getBet() {
        return bet;
    }

    public void setBet(Bet bet) {
        this.bet = bet;
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
        if (!(object instanceof WinningNumber)) {
            return false;
        }
        WinningNumber other = (WinningNumber) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.exception.magicsnumbersws.entities.WinningNumber[ id=" + id + " ]";
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }    
    
}
