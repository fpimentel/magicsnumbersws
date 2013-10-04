package com.exception.magicsnumbersws.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fpimentel
 * @since 01-Sept-2013
 */
@Entity
@Table(name = "BLOCKING_NUMBERS_BET_BANKINGS")
@XmlRootElement
public class BlockingNumberBetBanking implements Serializable, Comparable<BlockingNumberBetBanking>{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @JoinColumn(name = "BET_BANKING_ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    private BetBanking betBanking;
    @Basic(optional = false)
    @NotNull    
    @Column(name = "NUMBER")
    private int number;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "CREATION_USER")
    private String creationUser;

    public BlockingNumberBetBanking() {
    }

    public BlockingNumberBetBanking(Integer id) {
        this.id = id;
    }

    public BlockingNumberBetBanking(Integer id, BetBanking betBanking, int number, String creationUser) {
        this.id = id;
        this.betBanking = betBanking;
        this.number = number;
        this.creationUser = creationUser;
    }
  

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BetBanking getBetBanking() {
        return betBanking;
    }

    public void setBetBanking(BetBanking betBanking) {
        this.betBanking = betBanking;
    }

    public String getCreationUser() {
        return creationUser;
    }

    public void setCreationUser(String creationUser) {
        this.creationUser = creationUser;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }


    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final BlockingNumberBetBanking other = (BlockingNumberBetBanking) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.exception.magicsnumbersws.entities.BlockingNumberBetBanking[ id=" + id + " ]";
    }

    @Override
    public int compareTo(BlockingNumberBetBanking that) {
        return this.id - that.id;
    }
}
