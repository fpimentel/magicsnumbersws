package com.exception.magicsnumbersws.service;
import com.exception.magicsnumbersws.containers.TicketReportContainer;
import com.exception.magicsnumbersws.entities.Ticket;
import com.exception.magicsnumbersws.exception.FindBetLimitException;
import com.exception.magicsnumbersws.exception.FindBlockingNumberException;
import com.exception.magicsnumbersws.exception.FindTicketException;
import com.exception.magicsnumbersws.exception.SaveTicketException;
import java.util.List;

/**
 *
 * @author fpimentel
 * @since 29-oct-2013
 */
public interface TicketService {
    public void add(Ticket ticket) throws SaveTicketException;;
    public void update(Ticket ticket);
    public void delete(int ticketId);  
    public String isNumbersBlocks(int betBankingId, String numbers) throws FindBlockingNumberException;
    public String findBetBankingBetLimitAmount(int betBankingId,int lotteryId,int betId ) throws FindBetLimitException;
    public List<Ticket> findTicket(TicketReportContainer ticketReportContainer) throws FindTicketException;
}
