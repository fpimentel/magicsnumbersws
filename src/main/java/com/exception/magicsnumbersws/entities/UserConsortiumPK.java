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
public class UserConsortiumPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "USER")
    private int user;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CONSORTIUM")
    private int consortium;

    public UserConsortiumPK() {
    }

    public UserConsortiumPK(int user, int consortium) {
        this.user = user;
        this.consortium = consortium;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public int getConsortium() {
        return consortium;
    }

    public void setConsortium(int consortium) {
        this.consortium = consortium;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) user;
        hash += (int) consortium;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserConsortiumPK)) {
            return false;
        }
        UserConsortiumPK other = (UserConsortiumPK) object;
        if (this.user != other.user) {
            return false;
        }
        if (this.consortium != other.consortium) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.exception.magicsnumbersws.entities.UserConsortiumPK[ user=" + user + ", consortium=" + consortium + " ]";
    }
    
}
