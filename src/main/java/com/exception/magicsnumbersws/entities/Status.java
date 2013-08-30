/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exception.magicsnumbersws.entities;

import java.io.Serializable;
import java.util.Collection;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author fpimentel
 */
@Entity
@Table(name = "STATUS")
@XmlRootElement
public class Status implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "statusId")
    private Collection<Category> categoryCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NAME")
    private String name;
    @JoinColumn(name = "STATUS_TYPE_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private StatusType statusTypeId;

   
    

    public Status() {
    }

    public Status(Integer id) {
        this.id = id;
    }

    public Status(Integer id, String name) {
        this.id = id;
        this.name = name;
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

    public StatusType getStatusTypeId() {
        return statusTypeId;
    }

    public void setStatusTypeId(StatusType statusTypeId) {
        this.statusTypeId = statusTypeId;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + (this.categoryCollection != null ? this.categoryCollection.hashCode() : 0);
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
        final Status other = (Status) obj;
        if (this.categoryCollection != other.categoryCollection && (this.categoryCollection == null || !this.categoryCollection.equals(other.categoryCollection))) {
            return false;
        }
        return true;
    }



    @Override
    public String toString() {
        return "com.exception.magicsnumbersws.entities.Status[ id=" + id + " ]";
    }

    @XmlTransient
    public Collection<Category> getCategoryCollection() {
        return categoryCollection;
    }

    public void setCategoryCollection(Collection<Category> categoryCollection) {
        this.categoryCollection = categoryCollection;
    }
    
}
