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
public class UserConsortium implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UserConsortiumPK userConsortiumPK;    
    @Basic(optional = false)
    @NotNull
    @Column(name = "CREATION_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private User user;
    @JoinColumn(name = "CONSORTIUM_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Consortium consortium;

    public UserConsortium() {
    }

    public UserConsortium(UserConsortiumPK userConsortiumPK) {
        this.userConsortiumPK = userConsortiumPK;
    }

    public UserConsortium(UserConsortiumPK userConsortiumPK, String creationUser, Date creationDate) {
        this.userConsortiumPK = userConsortiumPK;        
        this.creationDate = creationDate;
    }

    public UserConsortium(int userId, int consortiumId) {
        this.userConsortiumPK = new UserConsortiumPK(userId, consortiumId);
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Consortium getConsortium() {
        return consortium;
    }

    public void setConsortium(Consortium consortium) {
        this.consortium = consortium;
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
