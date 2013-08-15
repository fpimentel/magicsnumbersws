/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exception.magicsnumbersws.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "HISTORY_OPERATIONS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HistoryOperation.findAll", query = "SELECT h FROM HistoryOperation h")})
public class HistoryOperation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "CREATION_USER")
    private byte[] creationUser;
    @Basic(optional = false)
    @NotNull
    @Column(name = "OPERATION_ID")
    private int operationId;
    @Size(max = 70)
    @Column(name = "AFECTED_TABLE_NAME")
    private String afectedTableName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_AFECTED")
    private int idAfected;
    @Basic(optional = false)
    @NotNull
    @Column(name = "INSERTION_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date insertionDate;

    public HistoryOperation() {
    }

    public HistoryOperation(Integer id) {
        this.id = id;
    }

    public HistoryOperation(Integer id, byte[] creationUser, int operationId, int idAfected, Date insertionDate) {
        this.id = id;
        this.creationUser = creationUser;
        this.operationId = operationId;
        this.idAfected = idAfected;
        this.insertionDate = insertionDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public byte[] getCreationUser() {
        return creationUser;
    }

    public void setCreationUser(byte[] creationUser) {
        this.creationUser = creationUser;
    }

    public int getOperationId() {
        return operationId;
    }

    public void setOperationId(int operationId) {
        this.operationId = operationId;
    }

    public String getAfectedTableName() {
        return afectedTableName;
    }

    public void setAfectedTableName(String afectedTableName) {
        this.afectedTableName = afectedTableName;
    }

    public int getIdAfected() {
        return idAfected;
    }

    public void setIdAfected(int idAfected) {
        this.idAfected = idAfected;
    }

    public Date getInsertionDate() {
        return insertionDate;
    }

    public void setInsertionDate(Date insertionDate) {
        this.insertionDate = insertionDate;
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
        if (!(object instanceof HistoryOperation)) {
            return false;
        }
        HistoryOperation other = (HistoryOperation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.exception.magicsnumbersws.entities.HistoryOperation[ id=" + id + " ]";
    }
    
}
