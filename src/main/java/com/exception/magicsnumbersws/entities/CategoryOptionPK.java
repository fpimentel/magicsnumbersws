/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exception.magicsnumbersws.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author fpimentel
 */
@Embeddable
public class CategoryOptionPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "CATEGORY_ID")
    private int categoryId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "OPTION_ID")
    private int optionId;

    public CategoryOptionPK() {
    }

    public CategoryOptionPK(int categoryId, int optionId) {
        this.categoryId = categoryId;
        this.optionId = optionId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getOptionId() {
        return optionId;
    }

    public void setOptionId(int optionId) {
        this.optionId = optionId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) categoryId;
        hash += (int) optionId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CategoryOptionPK)) {
            return false;
        }
        CategoryOptionPK other = (CategoryOptionPK) object;
        if (this.categoryId != other.categoryId) {
            return false;
        }
        if (this.optionId != other.optionId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.exception.magicsnumbersws.entities.CategoryOptionPK[ categoryId=" + categoryId + ", optionId=" + optionId + " ]";
    }
    
}
