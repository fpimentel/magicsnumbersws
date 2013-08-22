/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exception.magicsnumbersws.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author fpimentel
 */
@Entity
@Table(name = "USERS")
@XmlRootElement(name="User")
public class User implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)	
    @Column(name = "ID")    
    private Integer id;
    
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "FIRT_NAME")
    private String firtName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "LAST_NAME")
    private String lastName;
    @Size(max = 50)
    @Column(name = "CONTACT_NUMBER")
    private String contactNumber;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "USER_NAME")
    private String userName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "PASSWORD")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Column(name = "STATUS_ID")
    private int statusId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Collection<Ticket> ticketCollection;
    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    //private Collection<UserProfile> userProfiles;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private Collection<BetBankingUser> betBankingUserCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private Collection<UserConsortium> userConsortiumCollection;
    
     
    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(name = "USERS_PROFILES", joinColumns = { @JoinColumn(name = "USER_ID") }, inverseJoinColumns = { @JoinColumn(name = "PROFILE_ID") })
    private Set<Profile> profiles = new HashSet<Profile>(0);
  
    @XmlElement
    public Set<Profile> getProfiles() {
        return this.profiles;
    }
    
    public void setProfiles(Set<Profile> profiles) {
        this.profiles = profiles;
    }
    
    public User() {
        
    }

    public User(Integer id) {
        this.id = id;
    }

    public User(Integer id, String firtName, String lastName, String userName, String password, int statusId) {
        this.id = id;
        this.firtName = firtName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.statusId = statusId;
    }
    
    @XmlElement
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    @XmlElement
    public String getFirtName() {
        return firtName;
    }

    public void setFirtName(String firtName) {
        this.firtName = firtName;
    }
    @XmlElement
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    @XmlElement
    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
    @XmlElement
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    @XmlElement
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @XmlElement
    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    @XmlTransient
    public Collection<Ticket> getTicketCollection() {
        return ticketCollection;
    }

    public void setTicketCollection(Collection<Ticket> ticketCollection) {
        this.ticketCollection = ticketCollection;
    }
    /*@XmlTransient
    public Collection<UserProfile> getUserProfiles() {
        return userProfiles;
    }

    public void setUserProfiles(Collection<UserProfile> userProfiles) {
        this.userProfiles = userProfiles;
    }
*/
    @XmlTransient
    public Collection<BetBankingUser> getBetBankingUserCollection() {
        return betBankingUserCollection;
    }

    public void setBetBankingUserCollection(Collection<BetBankingUser> betBankingUserCollection) {
        this.betBankingUserCollection = betBankingUserCollection;
    }

    @XmlTransient
    public Collection<UserConsortium> getUserConsortiumCollection() {
        return userConsortiumCollection;
    }

    public void setUserConsortiumCollection(Collection<UserConsortium> userConsortiumCollection) {
        this.userConsortiumCollection = userConsortiumCollection;
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
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.exception.magicsnumbersws.entities.User[ id=" + id + " ]";
    }
    
}
