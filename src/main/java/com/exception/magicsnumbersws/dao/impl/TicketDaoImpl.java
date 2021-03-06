package com.exception.magicsnumbersws.dao.impl;

import com.exception.magicsnumbersws.dao.TicketDao;
import com.exception.magicsnumbersws.entities.Ticket;
import com.exception.magicsnumbersws.exception.FindTicketException;
import com.exception.magicsnumbersws.exception.SaveTicketException;
import java.text.ParseException;
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
            String queryString = "from Ticket ti where ti.creationDate between :fromDate and :toDate and ti.betBanking.id = :betBankingId";
            Query query = sessionFactory.getCurrentSession().createQuery(queryString);
            query.setParameter("fromDate", fDate);
            query.setParameter("toDate", calendar.getTime());
            query.setParameter("betBankingId", betBankingId);

            ticketsFromDb = query.list();
            sessionFactory.getCurrentSession().flush();
            return ticketsFromDb;
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "findTicket-" + ex.getMessage());
            throw new FindTicketException(ex.getMessage());
        }
    }

    @Override
    public List<Ticket> findTodayTicketByUserName(String userName) throws FindTicketException {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        String dateString = formatter.format(calendar.getTime());
        try {
            Date fromDate = formatter.parse(dateString);
            calendar.setTime(formatter.parse(dateString));
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            calendar.add(Calendar.SECOND, -1);
            List<Ticket> tickets;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("from Ticket ti");
            stringBuilder.append(" where ti.creationDate between :fromDate and :toDate");
            stringBuilder.append(" and lower(ti.creationUser) = lower(:userName)");
            Query query = sessionFactory.getCurrentSession().createQuery(stringBuilder.toString());
            query.setParameter("fromDate", fromDate);
            query.setParameter("toDate", calendar.getTime());
            query.setParameter("userName", userName);
            tickets = query.list();
            return tickets;

        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "findTodayTicketByUserName-" + ex.getMessage());
            throw new FindTicketException(ex.getMessage());
       
        }
    }
}
