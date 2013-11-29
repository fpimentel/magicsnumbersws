package com.exception.magicsnumbersws.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
 */
@Entity
@Table(name = "LOTTERIES_CLOSE_HOUR")
@XmlRootElement
public class LotteryCloseHour implements Serializable, Comparable<LotteryCloseHour> {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "HOUR")
    private String hour;
    @JoinColumn(name = "ID_TIME", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Time time;
    @JoinColumn(name = "ID_LOTTERY", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Lottery lottery;
    @JoinColumn(name = "ID_DAY", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Day day;

    public LotteryCloseHour() {
    }

    public LotteryCloseHour(Integer id) {
        this.id = id;
    }

    public LotteryCloseHour(Integer id, String hour) {
        this.id = id;
        this.hour = hour;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Lottery getLottery() {
        return lottery;
    }

    public void setLottery(Lottery lottery) {
        this.lottery = lottery;
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
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
        if (!(object instanceof LotteryCloseHour)) {
            return false;
        }
        LotteryCloseHour other = (LotteryCloseHour) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.exception.magicsnumbersws.entities.LotteryCloseHour[ id=" + id + " ]";
    }

    @Override
    public int compareTo(LotteryCloseHour that) {
        return this.id - that.getId();
    }
}
