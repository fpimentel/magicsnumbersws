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
public class BetBankingsUserPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "BETBANKING")
    private int betbanking;
    @Basic(optional = false)
    @NotNull
    @Column(name = "USER")
    private int user;

    public BetBankingsUserPK() {
    }

    public BetBankingsUserPK(int betbanking, int user) {
        this.betbanking = betbanking;
        this.user = user;
    }

    public int getBetbanking() {
        return betbanking;
    }

    public void setBetbanking(int betbanking) {
        this.betbanking = betbanking;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) betbanking;
        hash += (int) user;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BetBankingsUserPK)) {
            return false;
        }
        BetBankingsUserPK other = (BetBankingsUserPK) object;
        if (this.betbanking != other.betbanking) {
            return false;
        }
        if (this.user != other.user) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.exception.magicsnumbersws.entities.BetBankingsUserPK[ betbanking=" + betbanking + ", user=" + user + " ]";
    }
    
}
