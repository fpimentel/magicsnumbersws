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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author fpimentel
 */
@Entity
@Table(name = "STATUS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Status.findAll", query = "SELECT s FROM Status s"),
    @NamedQuery(name = "Status.findById", query = "SELECT s FROM Status s WHERE s.id = :id")})
public class Status implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "NAME")
    private byte[] name;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "status")
    private Collection<Bet> betCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "status")
    private Collection<Operation> operationCollection;
    @JoinColumn(name = "STATUS_TYPE", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private StatusType statusType;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "status")
    private Collection<WayToWin> wayToWinCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "status")
    private Collection<OptionCategory> optionCategoryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "status")
    private Collection<User> userCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "status")
    private Collection<BetType> betTypeCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "status")
    private Collection<Consortium> consortiumCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "status")
    private Collection<BetBanking> betBankingCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "status")
    private Collection<Ticket> ticketCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "status")
    private Collection<TicketDetail> ticketDetailCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "status")
    private Collection<BetTypes> betTypesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "status")
    private Collection<Profile> profileCollection;

    public Status() {
    }

    public Status(Integer id) {
        this.id = id;
    }

    public Status(Integer id, byte[] name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @XmlTransient
    public Collection<Bet> getBetCollection() {
        return betCollection;
    }

    public void setBetCollection(Collection<Bet> betCollection) {
        this.betCollection = betCollection;
    }

    @XmlTransient
    public Collection<Operation> getOperationCollection() {
        return operationCollection;
    }

    public void setOperationCollection(Collection<Operation> operationCollection) {
        this.operationCollection = operationCollection;
    }

    public StatusType getStatusType() {
        return statusType;
    }

    public void setStatusType(StatusType statusType) {
        this.statusType = statusType;
    }

    @XmlTransient
    public Collection<WayToWin> getWayToWinCollection() {
        return wayToWinCollection;
    }

    public void setWayToWinCollection(Collection<WayToWin> wayToWinCollection) {
        this.wayToWinCollection = wayToWinCollection;
    }

    @XmlTransient
    public Collection<OptionCategory> getOptionCategoryCollection() {
        return optionCategoryCollection;
    }

    public void setOptionCategoryCollection(Collection<OptionCategory> optionCategoryCollection) {
        this.optionCategoryCollection = optionCategoryCollection;
    }

    @XmlTransient
    public Collection<User> getUserCollection() {
        return userCollection;
    }

    public void setUserCollection(Collection<User> userCollection) {
        this.userCollection = userCollection;
    }

    @XmlTransient
    public Collection<BetType> getBetTypeCollection() {
        return betTypeCollection;
    }

    public void setBetTypeCollection(Collection<BetType> betTypeCollection) {
        this.betTypeCollection = betTypeCollection;
    }

    @XmlTransient
    public Collection<Consortium> getConsortiumCollection() {
        return consortiumCollection;
    }

    public void setConsortiumCollection(Collection<Consortium> consortiumCollection) {
        this.consortiumCollection = consortiumCollection;
    }

    @XmlTransient
    public Collection<BetBanking> getBetBankingCollection() {
        return betBankingCollection;
    }

    public void setBetBankingCollection(Collection<BetBanking> betBankingCollection) {
        this.betBankingCollection = betBankingCollection;
    }

    @XmlTransient
    public Collection<Ticket> getTicketCollection() {
        return ticketCollection;
    }

    public void setTicketCollection(Collection<Ticket> ticketCollection) {
        this.ticketCollection = ticketCollection;
    }

    @XmlTransient
    public Collection<TicketDetail> getTicketDetailCollection() {
        return ticketDetailCollection;
    }

    public void setTicketDetailCollection(Collection<TicketDetail> ticketDetailCollection) {
        this.ticketDetailCollection = ticketDetailCollection;
    }

    @XmlTransient
    public Collection<BetTypes> getBetTypesCollection() {
        return betTypesCollection;
    }

    public void setBetTypesCollection(Collection<BetTypes> betTypesCollection) {
        this.betTypesCollection = betTypesCollection;
    }

    @XmlTransient
    public Collection<Profile> getProfileCollection() {
        return profileCollection;
    }

    public void setProfileCollection(Collection<Profile> profileCollection) {
        this.profileCollection = profileCollection;
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
        if (!(object instanceof Status)) {
            return false;
        }
        Status other = (Status) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.exception.magicsnumbersws.entities.Status[ id=" + id + " ]";
    }

    public byte[] getName() {
        return name;
    }

    public void setName(byte[] name) {
        this.name = name;
    }
    
}
