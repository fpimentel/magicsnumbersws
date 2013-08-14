/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exception.magicsnumbersws.entities;

import java.util.Collection;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author fpimentel
 */
@XmlRootElement(name="user2")
public class User2 {
    
    private Consortium consortium;
    
    
    private List<BetBankingsUser> betBankingsUsers;

    
    private List<HistoryOperation> historyOperations;
    
    
    private List<BetBankingBetLimit> betBankingBetLimits;
    
    
    private List<Consortium> consortiumsCreated;
  
    
    private List<Ticket> ticketsCreated;
    
    
    private Collection<Ticket> ticketCollection1;
    
    private Collection<Profile> profileCollection;    
    
    private Collection<UserConsortium> userConsortiumCollection;
    
    private Collection<UserConsortium> userConsortiumCollection1;
    
    private Collection<Bet> betCollection;
    
    private Collection<Lottery> lotteryCollection;
    
    private Collection<BetBanking> betBankingCollection;
    
    private Collection<WinningNumber> winningNumberCollection;
    private static final long serialVersionUID = 1L;
    
    private Integer id;
    
    private String firtName;
    
    private String lastName;
    
    private String contactNumber;
    
    private String userName;
    
    private String password;
    
    private Status status;
    
    private Profile profile;

    public User2() {
    }

    public User2(Integer id) {
        this.id = id;
    }

    public User2(Integer id, String firtName, String lastName, String userName, String password) {
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
        
        return true;
    }

    @Override
    public String toString() {
        return "com.exception.magicsnumbersws.entities.User[ id=" + id + " ]";
    }

    @XmlTransient
    public Collection<BetBankingsUser> getBetBankingsUserCollection() {
        return betBankingsUsers;
    }

    public void setBetBankingsUserCollection(List<BetBankingsUser> betBankingsUserCollection) {
        this.betBankingsUsers = betBankingsUsers;
    }


    @XmlTransient
    public List<HistoryOperation> getHistoryOperations() {
        return historyOperations;
    }

    public void setHistoryOperations(List<HistoryOperation> historyOperations) {
        this.historyOperations = historyOperations;
    }

    @XmlTransient
    public List<BetBankingBetLimit> getBetBankingBetLimits() {
        return betBankingBetLimits;
    }

    public void setBetBankingBetLimits(List<BetBankingBetLimit> betBankingBetLimits) {
        this.betBankingBetLimits = betBankingBetLimits;
    }

    @XmlTransient
    public List<Consortium> getConsortiumsCreated() {
        return consortiumsCreated;
    }

    public void setConsortiumsCreated(List<Consortium> consortiumsCreated) {
        this.consortiumsCreated = consortiumsCreated;
    }

    @XmlTransient
    public List<Ticket> getTicketsCreated() {
        return ticketsCreated;
    }

    public void setTicketsCreated(List<Ticket> ticketsCreated) {
        this.ticketsCreated = ticketsCreated;
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
