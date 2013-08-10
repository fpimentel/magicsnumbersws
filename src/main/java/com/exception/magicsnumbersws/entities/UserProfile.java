/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exception.magicsnumbersws.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fpimentel
 */
@Entity
@Table(name = "USER_PROFILE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserProfile.findAll", query = "SELECT u FROM UserProfile u"),
    @NamedQuery(name = "UserProfile.findByUser", query = "SELECT u FROM UserProfile u WHERE u.userProfilePK.user = :user"),
    @NamedQuery(name = "UserProfile.findByProfile", query = "SELECT u FROM UserProfile u WHERE u.userProfilePK.profile = :profile"),
    @NamedQuery(name = "UserProfile.findByCreationDate", query = "SELECT u FROM UserProfile u WHERE u.creationDate = :creationDate")})
@Entity
@Table(name = "USERS_PROFILES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserProfile.findAll", query = "SELECT u FROM UserProfile u"),
    @NamedQuery(name = "UserProfile.findByUser", query = "SELECT u FROM UserProfile u WHERE u.userProfilePK.user = :user"),
    @NamedQuery(name = "UserProfile.findByProfile", query = "SELECT u FROM UserProfile u WHERE u.userProfilePK.profile = :profile"),
    @NamedQuery(name = "UserProfile.findByCreationDate", query = "SELECT u FROM UserProfile u WHERE u.creationDate = :creationDate")})
public class UserProfile implements Serializable, Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UserProfilePK userProfilePK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CREATION_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    @JoinColumn(name = "USER", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private User user1;
    @JoinColumn(name = "CREATION_USER", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private User creationUser;
    @JoinColumn(name = "PROFILE", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Profile profile1;
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UserProfilePK userProfilePK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CREATION_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    @JoinColumn(name = "USER", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private User user1;
    @JoinColumn(name = "CREATION_USER", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private User creationUser;
    @JoinColumn(name = "PROFILE", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Profile profile1;

    public UserProfile() {
    }

    public UserProfile(UserProfilePK userProfilePK) {
        this.userProfilePK = userProfilePK;
    }

    public UserProfile(UserProfilePK userProfilePK, Date creationDate) {
        this.userProfilePK = userProfilePK;
        this.creationDate = creationDate;
    }

    public UserProfile(int user, int profile) {
        this.userProfilePK = new UserProfilePK(user, profile);
    }

    public UserProfilePK getUserProfilePK() {
        return userProfilePK;
    }

    public void setUserProfilePK(UserProfilePK userProfilePK) {
        this.userProfilePK = userProfilePK;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public User getUser1() {
        return user1;
    }

    public void setUser1(User user1) {
        this.user1 = user1;
    }

    public User getCreationUser() {
        return creationUser;
    }

    public void setCreationUser(User creationUser) {
        this.creationUser = creationUser;
    }

    public Profile getProfile1() {
        return profile1;
    }

    public void setProfile1(Profile profile1) {
        this.profile1 = profile1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userProfilePK != null ? userProfilePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserProfile)) {
            return false;
        }
        UserProfile other = (UserProfile) object;
        if ((this.userProfilePK == null && other.userProfilePK != null) || (this.userProfilePK != null && !this.userProfilePK.equals(other.userProfilePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.exception.magicsnumbersws.entities.UserProfile[ userProfilePK=" + userProfilePK + " ]";
    }

    public UserProfile(UserProfilePK userProfilePK) {
        this.userProfilePK = userProfilePK;
    }

    public UserProfile(UserProfilePK userProfilePK, Date creationDate) {
        this.userProfilePK = userProfilePK;
        this.creationDate = creationDate;
    }

    public UserProfile(int user, int profile) {
        this.userProfilePK = new UserProfilePK(user, profile);
    }

    public UserProfilePK getUserProfilePK() {
        return userProfilePK;
    }

    public void setUserProfilePK(UserProfilePK userProfilePK) {
        this.userProfilePK = userProfilePK;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public User getUser1() {
        return user1;
    }

    public void setUser1(User user1) {
        this.user1 = user1;
    }

    public User getCreationUser() {
        return creationUser;
    }

    public void setCreationUser(User creationUser) {
        this.creationUser = creationUser;
    }

    public Profile getProfile1() {
        return profile1;
    }

    public void setProfile1(Profile profile1) {
        this.profile1 = profile1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userProfilePK != null ? userProfilePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserProfile)) {
            return false;
        }
        UserProfile other = (UserProfile) object;
        if ((this.userProfilePK == null && other.userProfilePK != null) || (this.userProfilePK != null && !this.userProfilePK.equals(other.userProfilePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.exception.magicsnumbersws.entities.UserProfile[ userProfilePK=" + userProfilePK + " ]";
    }
    
}
