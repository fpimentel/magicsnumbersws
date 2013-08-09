/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exception.magicsnumbersws.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author fpimentel
 */
@Entity
@Table(name = "CONSORTIUMS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Consortium.findAll", query = "SELECT c FROM Consortium c"),
    @NamedQuery(name = "Consortium.findById", query = "SELECT c FROM Consortium c WHERE c.id = :id"),
    @NamedQuery(name = "Consortium.findByName", query = "SELECT c FROM Consortium c WHERE c.name = :name"),
    @NamedQuery(name = "Consortium.findByDescription", query = "SELECT c FROM Consortium c WHERE c.description = :description"),
    @NamedQuery(name = "Consortium.findByUserCreation", query = "SELECT c FROM Consortium c WHERE c.userCreation = :userCreation"),
    @NamedQuery(name = "Consortium.findByCreationDate", query = "SELECT c FROM Consortium c WHERE c.creationDate = :creationDate"),
    @NamedQuery(name = "Consortium.findByModificationDate", query = "SELECT c FROM Consortium c WHERE c.modificationDate = :modificationDate")})
public class Consortium implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NAME")
    private String name;
    @Size(max = 10)
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "USER_CREATION")
    private Integer userCreation;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CREATION_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MODIFICATION_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificationDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "consortium")
    private Collection<User> userCollection;
    @JoinColumn(name = "STATUS", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Status status;

    public Consortium() {
    }

    public Consortium(Integer id) {
        this.id = id;
    }

    public Consortium(Integer id, String name, Date creationDate, Date modificationDate) {
        this.id = id;
        this.name = name;
        this.creationDate = creationDate;
        this.modificationDate = modificationDate;
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

    public Integer getUserCreation() {
        return userCreation;
    }

    public void setUserCreation(Integer userCreation) {
        this.userCreation = userCreation;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(Date modificationDate) {
        this.modificationDate = modificationDate;
    }

    @XmlTransient
    public Collection<User> getUserCollection() {
        return userCollection;
    }

    public void setUserCollection(Collection<User> userCollection) {
        this.userCollection = userCollection;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
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
        if (!(object instanceof Consortium)) {
            return false;
        }
        Consortium other = (Consortium) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.exception.magicsnumbersws.entities.Consortium[ id=" + id + " ]";
    }
    
}
