/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exception.magicsnumbersws.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fpimentel
 */
@Entity
@Table(name = "BETTYPES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BetType.findAll", query = "SELECT b FROM BetType b"),
    @NamedQuery(name = "BetType.findById", query = "SELECT b FROM BetType b WHERE b.id = :id"),
    @NamedQuery(name = "BetType.findByDisplayName", query = "SELECT b FROM BetType b WHERE b.displayName = :displayName"),
    @NamedQuery(name = "BetType.findByDescription", query = "SELECT b FROM BetType b WHERE b.description = :description")})
public class BetType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "DISPLAY_NAME")
    private String displayName;
    @Size(max = 250)
    @Column(name = "DESCRIPTION")
    private String description;
    @JoinColumn(name = "STATUS", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Status status;

    public BetType() {
    }

    public BetType(Integer id) {
        this.id = id;
    }

    public BetType(Integer id, String displayName) {
        this.id = id;
        this.displayName = displayName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        if (!(object instanceof BetType)) {
            return false;
        }
        BetType other = (BetType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.exception.magicsnumbersws.entities.BetType[ id=" + id + " ]";
    }
    
}
