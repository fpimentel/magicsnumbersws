package com.exception.magicsnumbersws.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
 */
@Entity
@Table(name = "CONSORTIUM_GENERAL_LIMITS")
@XmlRootElement
public class ConsortiumGeneralLimit implements Serializable , Comparable<ConsortiumGeneralLimit>{
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @JoinColumn(name = "CONSORTIUM_ID", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Consortium consortium;
    @JoinColumn(name = "LOTTERY_ID", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Lottery lottery;    
    @JoinColumn(name = "TIME_ID", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Time time;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "CREATION_USER")
    private String creationUser;
    @Basic(optional = false)
    @NotNull
    @Column(name = "AMOUNT")
    private long amount;

    public ConsortiumGeneralLimit() {
    }

    public ConsortiumGeneralLimit(Integer id) {
        this.id = id;
    }

    public ConsortiumGeneralLimit(Integer id, String creationUser, long amount) {
        this.id = id;
        this.creationUser = creationUser;
        this.amount = amount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Consortium getConsortium() {
        return consortium;
    }

    public void setConsortium(Consortium consortium) {
        this.consortium = consortium;
    }

    public Lottery getLottery() {
        return lottery;
    }

    public void setLottery(Lottery lottery) {
        this.lottery = lottery;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }
    
    public String getCreationUser() {
        return creationUser;
    }

    public void setCreationUser(String creationUser) {
        this.creationUser = creationUser;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final ConsortiumGeneralLimit other = (ConsortiumGeneralLimit) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.exception.magicsnumbersws.entities.ConsortiumGeneralLimit[ id=" + id + " ]";
    }

    @Override
    public int compareTo(ConsortiumGeneralLimit that) {
        return this.id - that.id;
    }    
}
