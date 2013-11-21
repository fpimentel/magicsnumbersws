package com.exception.magicsnumbersws.endpoints.impl;
import com.exception.magicsnumbersws.endpoints.BusinessEndpoint;
import com.exception.magicsnumbersws.entities.Ticket;
import com.exception.magicsnumbersws.exception.FindBetLimitException;
import com.exception.magicsnumbersws.exception.FindBlockingNumberException;
import com.exception.magicsnumbersws.exception.SaveTicketException;
import com.exception.magicsnumbersws.service.TicketService;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author fpimentel
 * @since 29-oct-13
 * @version 0.1
 */
@Component
public class BusinessEndpointImpl implements BusinessEndpoint {

    private static final Logger logger = Logger.getLogger(BusinessEndpointImpl.class.getName());
    @Autowired
    private TicketService ticketService;

    @Override
    public void saveTicket(Ticket ticket) throws SaveTicketException {
        logger.info("INIT- BusinessEndpointImpl.saveTicket");
        ticketService.add(ticket);
    }

    @Override
    public String isNumbersBlocks(int betBankingId, String numbers) throws FindBlockingNumberException {
        return ticketService.isNumbersBlocks(betBankingId, numbers);                
    }

    @Override
    public String findBetBankingBetLimitAmount(int betBankingId, int lotteryId, int betId) throws FindBetLimitException {
        return ticketService.findBetBankingBetLimitAmount(betBankingId, lotteryId, betId);
    }   
}