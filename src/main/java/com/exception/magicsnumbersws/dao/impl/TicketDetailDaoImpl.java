package com.exception.magicsnumbersws.dao.impl;

import com.exception.magicsnumbersws.dao.TicketDetailDao;
import com.exception.magicsnumbersws.entities.TicketDetail;
import com.exception.magicsnumbersws.exception.SaveTicketException;
import java.util.logging.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author fpimentel
 * @since 30-Oct-2013
 */
@Repository
public class TicketDetailDaoImpl implements TicketDetailDao {

    @Autowired
    private SessionFactory sessionFactory;
    private static final Logger LOG = Logger.getLogger(TicketDetailDaoImpl.class.getName());

    public TicketDetailDaoImpl() {
    }

    public TicketDetailDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }        

    @Override
    public void add(TicketDetail ticketDetail) throws SaveTicketException {
        sessionFactory.getCurrentSession().save(ticketDetail);
    }

    @Override
    public void update(TicketDetail ticketDetail) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int ticketDetailId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
