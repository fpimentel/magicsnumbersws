package com.exception.magicsnumbersws.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fpimentel
 */
@Entity
@Table(name = "CONSORTIUMS")
@XmlRootElement
public class Consortium implements Serializable, Comparable<Consortium>{    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "DESCRIPTION")
    private String description;        
    @Size(min = 1, max = 50)
    @Column(name = "CREATION_USER")
    private String creationUser;    
    @Column(nullable = true, name = "CREATION_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;      
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STATUS_ID", nullable = true)
    private Status status;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "USERS_CONSORTIUMS", joinColumns = { @JoinColumn(name = "CONSORTIUM_ID") }, inverseJoinColumns = { @JoinColumn(name = "USER_ID") })
    private Set<User> users = new HashSet<User>(0);        
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "consortium")
    private Set<BetBanking> betBankings = new HashSet<BetBanking>(0);        
    
    
    public Consortium() {
    }

    public Consortium(Integer id) {
        this.id = id;
    }

    public Consortium(Integer id, String name, String description, String creationUser, Date creationDate, Status status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.creationUser = creationUser;
        this.creationDate = creationDate;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreationUser() {
        return creationUser;
    }

    public void setCreationUser(String creationUser) {
        this.creationUser = creationUser;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
    
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Set<BetBanking> getBetBankings() {
        return betBankings;
    }

    public void setBetBankings(Set<BetBanking> betBankings) {
        this.betBankings = betBankings;
    }

 

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Consortium other = (Consortium) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }


    @Override
    public String toString() {
        return "com.exception.magicsnumbersws.entities.Consortium[ id=" + id + " ]";
    }

    @Override
    public int compareTo(Consortium that) {
        return this.id - that.id;
    }
    
}
