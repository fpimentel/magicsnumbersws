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
@Table(name = "SYSTEM_OPTIONS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SystemOption.findAll", query = "SELECT s FROM SystemOption s"),
    @NamedQuery(name = "SystemOption.findById", query = "SELECT s FROM SystemOption s WHERE s.id = :id"),
    @NamedQuery(name = "SystemOption.findByName", query = "SELECT s FROM SystemOption s WHERE s.name = :name"),
    @NamedQuery(name = "SystemOption.findByDescription", query = "SELECT s FROM SystemOption s WHERE s.description = :description"),
    @NamedQuery(name = "SystemOption.findByStatus", query = "SELECT s FROM SystemOption s WHERE s.status = :status")})
public class SystemOption implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "systemOption")
    private Collection<Profile> profileCollection;
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
    @Size(max = 150)
    @Column(name = "DESCRIPTION")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "STATUS")
    private int status;
    @JoinColumn(name = "OPTION_CATEGORY", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private OptionCategory optionCategory;

    public SystemOption() {
    }

    public SystemOption(Integer id) {
        this.id = id;
    }

    public SystemOption(Integer id, String name, int status) {
        this.id = id;
        this.name = name;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public OptionCategory getOptionCategory() {
        return optionCategory;
    }

    public void setOptionCategory(OptionCategory optionCategory) {
        this.optionCategory = optionCategory;
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
        if (!(object instanceof SystemOption)) {
            return false;
        }
        SystemOption other = (SystemOption) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.exception.magicsnumbersws.entities.SystemOption[ id=" + id + " ]";
    }

    @XmlTransient
    public Collection<Profile> getProfileCollection() {
        return profileCollection;
    }

    public void setProfileCollection(Collection<Profile> profileCollection) {
        this.profileCollection = profileCollection;
    }
    
}
