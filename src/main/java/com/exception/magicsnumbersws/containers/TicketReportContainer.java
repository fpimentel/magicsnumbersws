package com.exception.magicsnumbersws.containers;

import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fpimentel
 * @since 18-Dic-2013
 */
@XmlRootElement(name = "ticketReportContainer")
public class TicketReportContainer {

    private int betBankingId;
    private Date fromDate;
    private Date toDate;

    public int getBetBankingId() {
        return betBankingId;
    }

    public void setBetBankingId(int betBankingId) {
        this.betBankingId = betBankingId;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }           
}
