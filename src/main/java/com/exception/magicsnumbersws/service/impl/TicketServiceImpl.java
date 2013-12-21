package com.exception.magicsnumbersws.service.impl;
import com.exception.magicsnumbersws.dao.BetBankingBetLimitDao;
import com.exception.magicsnumbersws.dao.BlockingNumberBetBankingDao;
import com.exception.magicsnumbersws.dao.TicketDao;
import com.exception.magicsnumbersws.dao.TicketDetailDao;
import com.exception.magicsnumbersws.entities.Status;
import com.exception.magicsnumbersws.entities.Ticket;
import com.exception.magicsnumbersws.entities.TicketDetail;
import com.exception.magicsnumbersws.exception.FindBetLimitException;
import com.exception.magicsnumbersws.exception.FindBlockingNumberException;
import com.exception.magicsnumbersws.exception.FindTicketException;
import com.exception.magicsnumbersws.exception.SaveTicketException;
import com.exception.magicsnumbersws.service.TicketService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author fpimentel
 * @since 29-Oct-2013
 */
@Service
public class TicketServiceImpl implements TicketService {

    private static final Logger LOG = Logger.getLogger(TicketServiceImpl.class.getName());
    @Autowired
    private TicketDao ticketDao;
    @Autowired
    private BetBankingBetLimitDao betBankingBetLimitDao;
    @Autowired
    private TicketDetailDao ticketDetailDao;
    @Autowired
    private BlockingNumberBetBankingDao blockingNumberBetBankingDao;

    public TicketServiceImpl() {
    }

    public TicketServiceImpl(TicketDao ticketDao) {
        this.ticketDao = ticketDao;
    }

    public TicketDao getTicketDao() {
        return ticketDao;
    }

    public void setTicketDao(TicketDao ticketDao) {
        this.ticketDao = ticketDao;
    }

    public void aggregateAmounts(Ticket ticket){
        float totalBetAmount=0.0f;
        for(TicketDetail currTicketDetail : ticket.getTicketDetails()){
            totalBetAmount += Float.parseFloat(currTicketDetail.getBetAmount().toString());           
        }
        ticket.setTotalBetAmount(totalBetAmount);
    }
    
    @Transactional
    @Override
    public void add(Ticket ticket) throws SaveTicketException {
        LOG.info("INIT- TicketServiceImpl.add");
        com.exception.magicsnumbersws.entities.Status pendingStatus = new com.exception.magicsnumbersws.entities.Status();
        pendingStatus.setId(com.exception.magicsnumbersws.constants.Status.VENDIDO.getId());
        ticket.setCreationDate(new Date());
        ticket.setStatus(pendingStatus);
        ticket.setSecurityCode(ticket.getRandomSecurityCode());
        aggregateAmounts(ticket);
        LOG.info("INSERTING TICKETHEADER- TicketServiceImpl.add");
        this.ticketDao.add(ticket);
        LOG.info("INSERTING TICKETDETAIL");
        for (TicketDetail currTicketDetail : ticket.getTicketDetails()) {
            currTicketDetail.setTicket(ticket);
            currTicketDetail.setAmountToWin(0.0f);
            currTicketDetail.setStatus(pendingStatus);
            ticketDetailDao.add(currTicketDetail);
        }
        LOG.info("FINISH- TicketServiceImpl.add");
    }

    @Transactional
    @Override
    public void update(Ticket ticket) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Transactional
    @Override
    public void delete(int ticketId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Transactional
    @Override
    public String isNumbersBlocks(int betBankingId, String numbers) throws FindBlockingNumberException {
        LOG.info("INIT- TicketServiceImpl.isNumbersBlocks( " + betBankingId + ", " + numbers + ")");
        String blockNumbers = "";
        String[] numbersArray = numbers.split("-");

        for (String currNumber : numbersArray) {
            boolean isNumberBlock = blockingNumberBetBankingDao.isNumberBlock(betBankingId, Integer.parseInt(currNumber));
            if (isNumberBlock) {
                blockNumbers += currNumber + "-";
            }
        }
        if (!blockNumbers.isEmpty()) {
            //Cutting the last "-" character.
            int beginIndex = 0;
            int endIndex = blockNumbers.length() - 1;
            blockNumbers = blockNumbers.substring(beginIndex, endIndex);
        }
        LOG.info("End - TicketServiceImpl.isNumbersBlocks( " + betBankingId + ", " + numbers + ")");
        return blockNumbers;
    }
    @Transactional
    @Override
    public String findBetBankingBetLimitAmount(int betBankingId, int lotteryId, int betId) throws FindBetLimitException{        
        return this.betBankingBetLimitDao.findBetBankingBetLimitAmount(betBankingId, lotteryId, betId);
    }

    @Transactional
    @Override
    public List<Ticket> findTicket(int betBankingId, String fromDate, String toDate) throws FindTicketException {
        final String[] TICKET_IGNORED_PROPERTIES = {"status","ticketDetails","betBanking"};
        final String[] STATUS_IGNORED_PROPERTIES = {"statusType"};
        List<Ticket> ticketsFromDb = ticketDao.findTicket(betBankingId, fromDate, toDate);        
        List<Ticket> ticketsResult = new ArrayList<Ticket>();
        for(Ticket currTicket : ticketsFromDb){
            Ticket ticketCopy = new Ticket();
            Status statusCopy = new Status();
            BeanUtils.copyProperties(currTicket, ticketCopy, TICKET_IGNORED_PROPERTIES);
            BeanUtils.copyProperties(currTicket.getStatus(), statusCopy, STATUS_IGNORED_PROPERTIES);
            ticketCopy.setStatus(statusCopy);
            ticketsResult.add(ticketCopy);
        }        
        return ticketsResult;
    }
}
