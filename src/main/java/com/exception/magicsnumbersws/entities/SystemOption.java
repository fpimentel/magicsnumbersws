package com.exception.magicsnumbersws.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;



/**
 *
 * @author fpimentel
 */
@Entity
@Table(name = "SYSTEM_OPTIONS")
@XmlRootElement
public class SystemOption implements Serializable {      
    
    @Size(max = 150)
    @Column(name = "OUT_COME")
    private String outCome; 
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "VALUE")
    private String value;
    @Size(max = 150)
    @Column(name = "URL")
    private String url;
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "STATUS_ID")
    private int statusId;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "systemOption")
    private Set<CategoryOption> categoriesOptions = new HashSet<CategoryOption>(0);           
    
    public SystemOption() {
    }

    public SystemOption(Integer id) {
        this.id = id;
    }

    public SystemOption(Integer id, String name, int optionCategory, int statusId) {
        this.id = id;
        this.name = name;        
        this.statusId = statusId;
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

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }   

    public Set<CategoryOption> getCategories() {
        return categoriesOptions;
    }

    public void setCategories(Set<CategoryOption> categories) {
        this.categoriesOptions = categories;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final SystemOption other = (SystemOption) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }


    @Override
    public String toString() {
        return "com.exception.magicsnumbersws.entities.SystemOption[ id=" + id + " ]";
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    public String getOutCome() {
        return outCome;
    }

    public void setOutCome(String outCome) {
        this.outCome = outCome;
    }    
    
}
