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
    @Column(name = "USER_ID")
    private int userId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CONSORTIUM_ID")
    private int consortiumId;

    public UserConsortiumPK() {
    }

    public UserConsortiumPK(int userId, int consortiumId) {
        this.userId = userId;
        this.consortiumId = consortiumId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getConsortiumId() {
        return consortiumId;
    }

    public void setConsortiumId(int consortiumId) {
        this.consortiumId = consortiumId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) userId;
        hash += (int) consortiumId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserConsortiumPK)) {
            return false;
        }
        UserConsortiumPK other = (UserConsortiumPK) object;
        if (this.userId != other.userId) {
            return false;
        }
        if (this.consortiumId != other.consortiumId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.exception.magicsnumbersws.entities.UserConsortiumPK[ userId=" + userId + ", consortiumId=" + consortiumId + " ]";
    }
    
}
