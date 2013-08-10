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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author fpimentel
 */
@Entity
@Table(name = "TICKETS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ticket.findAll", query = "SELECT t FROM Ticket t"),
    @NamedQuery(name = "Ticket.findById", query = "SELECT t FROM Ticket t WHERE t.id = :id"),
    @NamedQuery(name = "Ticket.findBySecurityCode", query = "SELECT t FROM Ticket t WHERE t.securityCode = :securityCode"),
    @NamedQuery(name = "Ticket.findByInsertionDate", query = "SELECT t FROM Ticket t WHERE t.insertionDate = :insertionDate"),
    @NamedQuery(name = "Ticket.findByUserId", query = "SELECT t FROM Ticket t WHERE t.userId = :userId")})
public class Ticket implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "CREATION_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    @Column(name = "MODIFICATION_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificationDate;
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private User userId;
    @JoinColumn(name = "MODIFICATION_USER", referencedColumnName = "ID")
    @ManyToOne
    private User modificationUser;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SECURITY_CODE")
    private int securityCode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "INSERTION_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date insertionDate;
    
    @OneToMany(mappedBy = "ticket")
    private Collection<HistoryOperation> historyOperationCollection;
    @JoinColumn(name = "STATUS", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Status status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ticket")
    private Collection<TicketDetail> ticketDetailCollection;

    public Ticket() {
    }

    public Ticket(Integer id) {
        this.id = id;
    }

    public Ticket(Integer id, int securityCode, Date insertionDate, User user) {
        this.id = id;
        this.securityCode = securityCode;
        this.insertionDate = insertionDate;
        this.userId = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(int securityCode) {
        this.securityCode = securityCode;
    }

    public Date getInsertionDate() {
        return insertionDate;
    }

    public void setInsertionDate(Date insertionDate) {
        this.insertionDate = insertionDate;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @XmlTransient
    public Collection<HistoryOperation> getHistoryOperationCollection() {
        return historyOperationCollection;
    }

    public void setHistoryOperationCollection(Collection<HistoryOperation> historyOperationCollection) {
        this.historyOperationCollection = historyOperationCollection;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @XmlTransient
    public Collection<TicketDetail> getTicketDetailCollection() {
        return ticketDetailCollection;
    }

    public void setTicketDetailCollection(Collection<TicketDetail> ticketDetailCollection) {
        this.ticketDetailCollection = ticketDetailCollection;
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
        if (!(object instanceof Ticket)) {
            return false;
        }
        Ticket other = (Ticket) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.exception.magicsnumbersws.entities.Ticket[ id=" + id + " ]";
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

    public User getModificationUser() {
        return modificationUser;
    }

    public void setModificationUser(User modificationUser) {
        this.modificationUser = modificationUser;
    }
    
}
