package com.exception.magicsnumbersws.service.impl;

import com.exception.magicsnumbersws.dao.TicketDao;
import com.exception.magicsnumbersws.entities.Ticket;
import com.exception.magicsnumbersws.exception.SaveTicketException;
import com.exception.magicsnumbersws.service.TicketService;
import java.util.logging.Logger;
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

    @Transactional
    @Override
    public void add(Ticket ticket) throws SaveTicketException {
        this.ticketDao.add(ticket);
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
}
