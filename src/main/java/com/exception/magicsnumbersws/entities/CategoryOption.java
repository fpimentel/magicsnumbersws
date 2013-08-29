/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exception.magicsnumbersws.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author fpimentel
 */
@Entity
@Table(name = "CATEGORIES_OPTIONS")
@XmlRootElement
public class CategoryOption implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CategoryOptionPK categoryOptionPK;
    @Column(name = "OPTION_ORDER")
    private Integer optionOrder;
    @JoinColumn(name = "OPTION_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private SystemOption systemOption;
    @JoinColumn(name = "CATEGORY_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Category category;

    public CategoryOption() {
    }

    public CategoryOption(CategoryOptionPK categoryOptionPK) {
        this.categoryOptionPK = categoryOptionPK;
    }

    public CategoryOption(int categoryId, int optionId) {
        this.categoryOptionPK = new CategoryOptionPK(categoryId, optionId);
    }

    public CategoryOptionPK getCategoryOptionPK() {
        return categoryOptionPK;
    }

    public void setCategoryOptionPK(CategoryOptionPK categoryOptionPK) {
        this.categoryOptionPK = categoryOptionPK;
    }

    public Integer getOptionOrder() {
        return optionOrder;
    }

    public void setOptionOrder(Integer optionOrder) {
        this.optionOrder = optionOrder;
    }
    
    @XmlTransient
    public SystemOption getSystemOption() {
        return systemOption;
    }

    public void setSystemOption(SystemOption systemOption) {
        this.systemOption = systemOption;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (categoryOptionPK != null ? categoryOptionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CategoryOption)) {
            return false;
        }
        CategoryOption other = (CategoryOption) object;
        if ((this.categoryOptionPK == null && other.categoryOptionPK != null) || (this.categoryOptionPK != null && !this.categoryOptionPK.equals(other.categoryOptionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.exception.magicsnumbersws.entities.CategoryOption[ categoryOptionPK=" + categoryOptionPK + " ]";
    }
    
}