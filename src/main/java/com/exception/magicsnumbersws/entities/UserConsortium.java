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
@Table(name = "USERS_CONSORTIUMS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserConsortium.findAll", query = "SELECT u FROM UserConsortium u"),
    @NamedQuery(name = "UserConsortium.findByUser", query = "SELECT u FROM UserConsortium u WHERE u.userConsortiumPK.user = :user"),
    @NamedQuery(name = "UserConsortium.findByConsortium", query = "SELECT u FROM UserConsortium u WHERE u.userConsortiumPK.consortium = :consortium"),
    @NamedQuery(name = "UserConsortium.findByCreationDate", query = "SELECT u FROM UserConsortium u WHERE u.creationDate = :creationDate")})
public class UserConsortium implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UserConsortiumPK userConsortiumPK;
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
    @JoinColumn(name = "CONSORTIUM", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Consortium consortium1;

    public UserConsortium() {
    }

    public UserConsortium(UserConsortiumPK userConsortiumPK) {
        this.userConsortiumPK = userConsortiumPK;
    }

    public UserConsortium(UserConsortiumPK userConsortiumPK, Date creationDate) {
        this.userConsortiumPK = userConsortiumPK;
        this.creationDate = creationDate;
    }

    public UserConsortium(int user, int consortium) {
        this.userConsortiumPK = new UserConsortiumPK(user, consortium);
    }

    public UserConsortiumPK getUserConsortiumPK() {
        return userConsortiumPK;
    }

    public void setUserConsortiumPK(UserConsortiumPK userConsortiumPK) {
        this.userConsortiumPK = userConsortiumPK;
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

    public Consortium getConsortium1() {
        return consortium1;
    }

    public void setConsortium1(Consortium consortium1) {
        this.consortium1 = consortium1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userConsortiumPK != null ? userConsortiumPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserConsortium)) {
            return false;
        }
        UserConsortium other = (UserConsortium) object;
        if ((this.userConsortiumPK == null && other.userConsortiumPK != null) || (this.userConsortiumPK != null && !this.userConsortiumPK.equals(other.userConsortiumPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.exception.magicsnumbersws.entities.UserConsortium[ userConsortiumPK=" + userConsortiumPK + " ]";
    }
    
}
