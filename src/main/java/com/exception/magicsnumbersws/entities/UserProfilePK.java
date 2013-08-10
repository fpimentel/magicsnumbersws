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
public class UserProfilePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "USER")
    private int user;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PROFILE")
    private int profile;


    public UserProfilePK() {
    }

    public UserProfilePK(int user, int profile) {
        this.user = user;
        this.profile = profile;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public int getProfile() {
        return profile;
    }

    public void setProfile(int profile) {
        this.profile = profile;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) user;
        hash += (int) profile;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserProfilePK)) {
            return false;
        }
        UserProfilePK other = (UserProfilePK) object;
        if (this.user != other.user) {
            return false;
        }
        if (this.profile != other.profile) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.exception.magicsnumbersws.entities.UserProfilePK[ user=" + user + ", profile=" + profile + " ]";
    }
    
}
