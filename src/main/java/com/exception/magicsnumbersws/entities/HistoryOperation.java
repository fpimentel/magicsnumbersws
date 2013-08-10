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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
    @NamedQuery(name = "HistoryOperation.findAll", query = "SELECT h FROM HistoryOperation h"),
    @NamedQuery(name = "HistoryOperation.findById", query = "SELECT h FROM HistoryOperation h WHERE h.id = :id"),
    @NamedQuery(name = "HistoryOperation.findByUserId", query = "SELECT h FROM HistoryOperation h WHERE h.userId = :userId"),
    @NamedQuery(name = "HistoryOperation.findByOperation", query = "SELECT h FROM HistoryOperation h WHERE h.operation = :operation"),
    @NamedQuery(name = "HistoryOperation.findByAfectedTableName", query = "SELECT h FROM HistoryOperation h WHERE h.afectedTableName = :afectedTableName"),
    @NamedQuery(name = "HistoryOperation.findByInsertionDate", query = "SELECT h FROM HistoryOperation h WHERE h.insertionDate = :insertionDate")})
public class HistoryOperation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_AFECTED")
    private int idAfected;
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private User userId;    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "OPERATION")
    private int operation;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    @Column(name = "AFECTED_TABLE_NAME")
    private String afectedTableName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "INSERTION_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date insertionDate;
    @JoinColumn(name = "TICKET", referencedColumnName = "ID")
    @ManyToOne
    private Ticket ticket;

    public HistoryOperation() {
    }

    public HistoryOperation(Integer id) {
        this.id = id;
    }

    public HistoryOperation(Integer id, User userId, int operation, String afectedTableName, Date insertionDate) {
        this.id = id;
        this.userId = userId;
        this.operation = operation;
        this.afectedTableName = afectedTableName;
        this.insertionDate = insertionDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public int getOperation() {
        return operation;
    }

    public void setOperation(int operation) {
        this.operation = operation;
    }

    public String getAfectedTableName() {
        return afectedTableName;
    }

    public void setAfectedTableName(String afectedTableName) {
        this.afectedTableName = afectedTableName;
    }

    public Date getInsertionDate() {
        return insertionDate;
    }

    public void setInsertionDate(Date insertionDate) {
        this.insertionDate = insertionDate;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
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

    public int getIdAfected() {
        return idAfected;
    }

    public void setIdAfected(int idAfected) {
        this.idAfected = idAfected;
    }
    
}
