package com.exception.magicsnumbersws.dao.impl;

import com.exception.magicsnumbersws.dao.TicketDao;
import com.exception.magicsnumbersws.entities.Ticket;
import com.exception.magicsnumbersws.exception.SaveTicketException;
import java.util.logging.Logger;
import org.hibernate.SessionFactory;
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
    public void add(Ticket ticket) throws SaveTicketException{
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
    
}
