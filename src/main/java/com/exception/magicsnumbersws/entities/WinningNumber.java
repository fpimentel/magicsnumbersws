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
@Table(name = "WINNING_NUMBERS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WinningNumber.findAll", query = "SELECT w FROM WinningNumber w")})
public class WinningNumber implements Serializable {
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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "CREATION_USER")
    private String creationUser;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "CREATION_DATE")
    private String creationDate;
    @JoinColumn(name = "LOTTERY_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Lottery lotteryId;
    @JoinColumn(name = "BET_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Bet betId;

    public WinningNumber() {
    }

    public WinningNumber(Integer id) {
        this.id = id;
    }

    public WinningNumber(Integer id, String numbers, String creationUser, String creationDate) {
        this.id = id;
        this.numbers = numbers;
        this.creationUser = creationUser;
        this.creationDate = creationDate;
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

    public String getCreationUser() {
        return creationUser;
    }

    public void setCreationUser(String creationUser) {
        this.creationUser = creationUser;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public Lottery getLotteryId() {
        return lotteryId;
    }

    public void setLotteryId(Lottery lotteryId) {
        this.lotteryId = lotteryId;
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
    
}
