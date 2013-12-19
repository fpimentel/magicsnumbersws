package com.exception.magicsnumbersws.dao.impl;

import com.exception.magicsnumbersws.containers.TicketReportContainer;
import com.exception.magicsnumbersws.dao.TicketDao;
import com.exception.magicsnumbersws.entities.Ticket;
import com.exception.magicsnumbersws.exception.FindTicketException;
import com.exception.magicsnumbersws.exception.SaveTicketException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author fpimentel
 * @since 31-agosto-2013
 */
@Repository
public class TicketDaoImpl implements TicketDao {

    @Autowired
    private SessionFactory sessionFactory;
    private static final Logger LOG = Logger.getLogger(TicketDaoImpl.class.getName());

    public TicketDaoImpl() {
    }

    public TicketDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(Ticket ticket) throws SaveTicketException {
        sessionFactory.getCurrentSession().save(ticket);
    }

    @Override
    public void update(Ticket ticket) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int ticket) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Ticket> findTicket(TicketReportContainer ticketReportContainer) throws FindTicketException {
        try {
            List<Ticket> ticketsFromDb;
            StringBuilder queryString = new StringBuilder("from Ticket ti");
            queryString.append("where creationDate >= " + ticketReportContainer.getFromDate());
            queryString.append("and creationDate <= " + ticketReportContainer.getToDate());
            queryString.append("and betBanking.id = " + ticketReportContainer.getBetBankingId());
            Query query = sessionFactory.getCurrentSession().createQuery(queryString.toString());
            
            ticketsFromDb = query.list();
            return ticketsFromDb;
        } catch (Exception ex) {
            LOG.log(Level.SEVERE,"findTicket-" + ex.getMessage());
            throw new FindTicketException(ex.getMessage());
        }
    }
}
