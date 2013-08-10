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
@Table(name = "USER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.findById", query = "SELECT u FROM User u WHERE u.id = :id"),
    @NamedQuery(name = "User.findByFirtName", query = "SELECT u FROM User u WHERE u.firtName = :firtName"),
    @NamedQuery(name = "User.findByLastName", query = "SELECT u FROM User u WHERE u.lastName = :lastName"),
    @NamedQuery(name = "User.findByContactNumber", query = "SELECT u FROM User u WHERE u.contactNumber = :contactNumber"),
    @NamedQuery(name = "User.findByUserName", query = "SELECT u FROM User u WHERE u.userName = :userName"),
    @NamedQuery(name = "User.findByPassword", query = "SELECT u FROM User u WHERE u.password = :password")})

public class User implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "CONSORTIUM")
    private Consortium consortium;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "creationUser")
    private Collection<BetBankingsUser> betBankingsUserCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user1")
    private Collection<BetBankingsUser> betBankingsUserCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user1")
    private Collection<UserProfile> userProfileCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "creationUser")
    private Collection<UserProfile> userProfileCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Collection<HistoryOperation> historyOperationCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "creationUser")
    private Collection<BetBankingBetLimit> betBankingBetLimitCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "creationUser")
    private Collection<Consortium> consortiumCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Collection<Ticket> ticketCollection;
    @OneToMany(mappedBy = "modificationUser")
    private Collection<Ticket> ticketCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "creationUser")
    private Collection<Profile> profileCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user1")
    private Collection<UserProfile> userProfileCollection2;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "creationUser")
    private Collection<UserProfile> userProfileCollection3;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user1")
    private Collection<UserConsortium> userConsortiumCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "creationUser")
    private Collection<UserConsortium> userConsortiumCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "creationUser")
    private Collection<Bet> betCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userCreation")
    private Collection<Lottery> lotteryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "creationUser")
    private Collection<BetBanking> betBankingCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Collection<WinningNumber> winningNumberCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "FIRT_NAME")
    private String firtName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "LAST_NAME")
    private String lastName;
    @Size(max = 50)
    @Column(name = "CONTACT_NUMBER")
    private String contactNumber;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "USER_NAME")
    private String userName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "PASSWORD")
    private String password;
    @JoinColumn(name = "STATUS", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Status status;
    @JoinColumn(name = "PROFILE", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Profile profile;

    public User() {
    }

    public User(Integer id) {
        this.id = id;
    }

    public User(Integer id, String firtName, String lastName, String userName, String password) {
        this.id = id;
        this.firtName = firtName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirtName() {
        return firtName;
    }

    public void setFirtName(String firtName) {
        this.firtName = firtName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Consortium getConsortium() {
        return consortium;
    }

    public void setConsortium(Consortium consortium) {
        this.consortium = consortium;
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
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.exception.magicsnumbersws.entities.User[ id=" + id + " ]";
    }

    @XmlTransient
    public Collection<BetBankingsUser> getBetBankingsUserCollection() {
        return betBankingsUserCollection;
    }

    public void setBetBankingsUserCollection(Collection<BetBankingsUser> betBankingsUserCollection) {
        this.betBankingsUserCollection = betBankingsUserCollection;
    }

    @XmlTransient
    public Collection<BetBankingsUser> getBetBankingsUserCollection1() {
        return betBankingsUserCollection1;
    }

    public void setBetBankingsUserCollection1(Collection<BetBankingsUser> betBankingsUserCollection1) {
        this.betBankingsUserCollection1 = betBankingsUserCollection1;
    }

    @XmlTransient
    public Collection<UserProfile> getUserProfileCollection() {
        return userProfileCollection;
    }

    public void setUserProfileCollection(Collection<UserProfile> userProfileCollection) {
        this.userProfileCollection = userProfileCollection;
    }

    @XmlTransient
    public Collection<UserProfile> getUserProfileCollection1() {
        return userProfileCollection1;
    }

    public void setUserProfileCollection1(Collection<UserProfile> userProfileCollection1) {
        this.userProfileCollection1 = userProfileCollection1;
    }

    @XmlTransient
    public Collection<HistoryOperation> getHistoryOperationCollection() {
        return historyOperationCollection;
    }

    public void setHistoryOperationCollection(Collection<HistoryOperation> historyOperationCollection) {
        this.historyOperationCollection = historyOperationCollection;
    }

    @XmlTransient
    public Collection<BetBankingBetLimit> getBetBankingBetLimitCollection() {
        return betBankingBetLimitCollection;
    }

    public void setBetBankingBetLimitCollection(Collection<BetBankingBetLimit> betBankingBetLimitCollection) {
        this.betBankingBetLimitCollection = betBankingBetLimitCollection;
    }

    @XmlTransient
    public Collection<Consortium> getConsortiumCollection() {
        return consortiumCollection;
    }

    public void setConsortiumCollection(Collection<Consortium> consortiumCollection) {
        this.consortiumCollection = consortiumCollection;
    }

    @XmlTransient
    public Collection<Ticket> getTicketCollection() {
        return ticketCollection;
    }

    public void setTicketCollection(Collection<Ticket> ticketCollection) {
        this.ticketCollection = ticketCollection;
    }

    @XmlTransient
    public Collection<Ticket> getTicketCollection1() {
        return ticketCollection1;
    }

    public void setTicketCollection1(Collection<Ticket> ticketCollection1) {
        this.ticketCollection1 = ticketCollection1;
    }

    @XmlTransient
    public Collection<Profile> getProfileCollection() {
        return profileCollection;
    }

    public void setProfileCollection(Collection<Profile> profileCollection) {
        this.profileCollection = profileCollection;
    }

    @XmlTransient
    public Collection<UserProfile> getUserProfileCollection2() {
        return userProfileCollection2;
    }

    public void setUserProfileCollection2(Collection<UserProfile> userProfileCollection2) {
        this.userProfileCollection2 = userProfileCollection2;
    }

    @XmlTransient
    public Collection<UserProfile> getUserProfileCollection3() {
        return userProfileCollection3;
    }

    public void setUserProfileCollection3(Collection<UserProfile> userProfileCollection3) {
        this.userProfileCollection3 = userProfileCollection3;
    }

    @XmlTransient
    public Collection<UserConsortium> getUserConsortiumCollection() {
        return userConsortiumCollection;
    }

    public void setUserConsortiumCollection(Collection<UserConsortium> userConsortiumCollection) {
        this.userConsortiumCollection = userConsortiumCollection;
    }

    @XmlTransient
    public Collection<UserConsortium> getUserConsortiumCollection1() {
        return userConsortiumCollection1;
    }

    public void setUserConsortiumCollection1(Collection<UserConsortium> userConsortiumCollection1) {
        this.userConsortiumCollection1 = userConsortiumCollection1;
    }

    @XmlTransient
    public Collection<Bet> getBetCollection() {
        return betCollection;
    }

    public void setBetCollection(Collection<Bet> betCollection) {
        this.betCollection = betCollection;
    }

    @XmlTransient
    public Collection<Lottery> getLotteryCollection() {
        return lotteryCollection;
    }

    public void setLotteryCollection(Collection<Lottery> lotteryCollection) {
        this.lotteryCollection = lotteryCollection;
    }

    @XmlTransient
    public Collection<BetBanking> getBetBankingCollection() {
        return betBankingCollection;
    }

    public void setBetBankingCollection(Collection<BetBanking> betBankingCollection) {
        this.betBankingCollection = betBankingCollection;
    }

    @XmlTransient
    public Collection<WinningNumber> getWinningNumberCollection() {
        return winningNumberCollection;
    }

    public void setWinningNumberCollection(Collection<WinningNumber> winningNumberCollection) {
        this.winningNumberCollection = winningNumberCollection;
    }
    
}
