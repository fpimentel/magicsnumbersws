
package com.exception.magicsnumbersws.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "WAYS_TO_WIN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WayToWin.findAll", query = "SELECT w FROM WayToWin w")})
public class WayToWin implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "DISPLAY_NAME")
    private String displayName;
    @Size(max = 250)
    @Column(name = "DESCRIPTION")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "WINNING_POSITIONS")
    private String winningPositions;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IS_COMBINED")
    private boolean isCombined;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "PAYABLE_AMOUNT")
    private BigDecimal payableAmount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "QTY_U_HAVE_TO_HIT")
    private int qtyUHaveToHit;
    @Basic(optional = false)
    @NotNull
    @Column(name = "AMOUNT_TO_WIN")
    private BigDecimal amountToWin;
    @Column(name = "ROLOVER_AMOUNT")
    private Boolean roloverAmount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "STATUS_ID")
    private int statusId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "wayToWinId")
    private Collection<WayToWinBet> wayToWinBetCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "wayToWinId")
    private Collection<WayToWinLottery> wayToWinLotteryCollection;

    public WayToWin() {
    }

    public WayToWin(Integer id) {
        this.id = id;
    }

    public WayToWin(Integer id, String displayName, String winningPositions, boolean isCombined, BigDecimal payableAmount, int qtyUHaveToHit, BigDecimal amountToWin, int statusId) {
        this.id = id;
        this.displayName = displayName;
        this.winningPositions = winningPositions;
        this.isCombined = isCombined;
        this.payableAmount = payableAmount;
        this.qtyUHaveToHit = qtyUHaveToHit;
        this.amountToWin = amountToWin;
        this.statusId = statusId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWinningPositions() {
        return winningPositions;
    }

    public void setWinningPositions(String winningPositions) {
        this.winningPositions = winningPositions;
    }

    public boolean getIsCombined() {
        return isCombined;
    }

    public void setIsCombined(boolean isCombined) {
        this.isCombined = isCombined;
    }

    public BigDecimal getPayableAmount() {
        return payableAmount;
    }

    public void setPayableAmount(BigDecimal payableAmount) {
        this.payableAmount = payableAmount;
    }

    public int getQtyUHaveToHit() {
        return qtyUHaveToHit;
    }

    public void setQtyUHaveToHit(int qtyUHaveToHit) {
        this.qtyUHaveToHit = qtyUHaveToHit;
    }

    public BigDecimal getAmountToWin() {
        return amountToWin;
    }

    public void setAmountToWin(BigDecimal amountToWin) {
        this.amountToWin = amountToWin;
    }

    public Boolean getRoloverAmount() {
        return roloverAmount;
    }

    public void setRoloverAmount(Boolean roloverAmount) {
        this.roloverAmount = roloverAmount;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    @XmlTransient
    public Collection<WayToWinBet> getWayToWinBetCollection() {
        return wayToWinBetCollection;
    }

    public void setWayToWinBetCollection(Collection<WayToWinBet> wayToWinBetCollection) {
        this.wayToWinBetCollection = wayToWinBetCollection;
    }

    @XmlTransient
    public Collection<WayToWinLottery> getWayToWinLotteryCollection() {
        return wayToWinLotteryCollection;
    }

    public void setWayToWinLotteryCollection(Collection<WayToWinLottery> wayToWinLotteryCollection) {
        this.wayToWinLotteryCollection = wayToWinLotteryCollection;
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
        if (!(object instanceof WayToWin)) {
            return false;
        }
        WayToWin other = (WayToWin) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.exception.magicsnumbersws.entities.WayToWin[ id=" + id + " ]";
    }
    
}
