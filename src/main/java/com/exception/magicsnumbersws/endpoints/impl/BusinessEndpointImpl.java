package com.exception.magicsnumbersws.endpoints.impl;

import com.exception.magicsnumbersws.endpoints.BusinessEndpoint;
import com.exception.magicsnumbersws.entities.Ticket;
import com.exception.magicsnumbersws.entities.WinningNumber;
import com.exception.magicsnumbersws.exception.FindBetLimitException;
import com.exception.magicsnumbersws.exception.FindBlockingNumberException;
import com.exception.magicsnumbersws.exception.FindTicketException;
import com.exception.magicsnumbersws.exception.SaveTicketException;
import com.exception.magicsnumbersws.exception.SaveWinningNumberDataException;
import com.exception.magicsnumbersws.exception.SearchWinningNumbersException;
import com.exception.magicsnumbersws.service.TicketService;
import com.exception.magicsnumbersws.service.WinningNumberService;
import java.util.List;
import java.util.logging.Level;
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
    @Autowired
    private WinningNumberService winningService;

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

    @Override
    public List<WinningNumber> findWinningNumbers(String fromDate, String ToDate) throws SearchWinningNumbersException {
        return this.winningService.findWinningNumber(fromDate, ToDate);
    }

    @Override
    public List<Ticket> findTodayTicketByUserName(String userName) throws FindTicketException {
        return this.ticketService.findTodayTicketByUserName(userName);
    }

    @Override
    public void saveWinningNumberInfo(WinningNumber winningNumber) throws SaveWinningNumberDataException {
        try {
            this.winningService.saveWinningNumberInfo(winningNumber);
        } catch (SaveWinningNumberDataException ex) {
            this.logger.log(Level.SEVERE, ex.getMessage(), ex);
            throw new SaveWinningNumberDataException(ex.getMessage(), ex);
        } catch (Exception ex) {
            this.logger.log(Level.SEVERE, ex.getMessage(), ex);
            throw new SaveWinningNumberDataException(ex.getMessage(), ex);
        }
    }

    @Override
    public WinningNumber findWinningNumbers(int lotteryId, int timeId, String drawingDate) throws SearchWinningNumbersException {
        return this.winningService.findWinningNumber(lotteryId, timeId, drawingDate);
    }
}
