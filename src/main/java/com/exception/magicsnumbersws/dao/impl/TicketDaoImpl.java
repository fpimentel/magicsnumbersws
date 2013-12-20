package com.exception.magicsnumbersws.dao.impl;

import com.exception.magicsnumbersws.dao.TicketDao;
import com.exception.magicsnumbersws.entities.Ticket;
import com.exception.magicsnumbersws.exception.FindTicketException;
import com.exception.magicsnumbersws.exception.SaveTicketException;
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Query;
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
    public List<Ticket> findTicket(int betBankingId, String fromDate, String toDate) throws FindTicketException {
        try {            
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            Date fDate = formatter.parse(fromDate);
          Date tDate = formatter.parse(toDate);
            List<Ticket> ticketsFromDb;
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(tDate);
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            calendar.add(Calendar.SECOND, -1);
            //String queryString = "from Ticket ti where ti.creationDate >= :fromDate and ti.creationDate <= :toDate and ti.betBanking.id = :betBankingId";
            String queryString = "from Ticket ti where ti.creationDate between :fromDate and :toDate and ti.betBanking.id = :betBankingId";
            Query query = sessionFactory.getCurrentSession().createQuery(queryString);            
            query.setParameter("fromDate", fDate);
            query.setParameter("toDate", calendar.getTime());
            query.setParameter("betBankingId", betBankingId);
            
            ticketsFromDb = query.list();
            return ticketsFromDb;
        } catch (Exception ex) {
            LOG.log(Level.SEVERE,"findTicket-" + ex.getMessage());
            throw new FindTicketException(ex.getMessage());
        }
    }
}
